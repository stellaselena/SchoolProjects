import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FileSystem {
    
    public static FileSystem.Dir getCurrentDir(){return FileSystem.getDir(System.getProperty("user.dir"));}
    public static FileSystem.Dir getHomeDir(){return FileSystem.getDir(System.getProperty("user.home"));}
    public static FileSystem.Dir getDir(String path){return getDir(new java.io.File(path));}

    

    /*
     * Object pool.
     * The only reason for using this pattern is that we avoid
     * massive recalculation of the sizes of files and directories.
     */
    private static HashMap<java.io.File,Node> nodePool = new HashMap<>();

    public static FileSystem.Node getNode(java.io.File file){
        Node node = nodePool.get(file);
        if (node == null){
            node = new Node(file);
            nodePool.put(file,node);
        }
        return node;
    }

    public static FileSystem.Dir getDir(java.io.File file){return getNode(file).asDir();}
    public static FileSystem.File getFile(java.io.File file){return getNode(file).asFile();}


    /**
     * Base class for File and Dir
     */
    public static class Node {

        protected java.io.File file;
        protected long size = -1;

        public Node(java.io.File file){
            this.file = file;
        }

        public Node(String path){this(new java.io.File(path));}

        public String name(){return file.getName();}

        public long size(){
            if (size == -1){
                if (isFile())
                    size = file.length();
                if (isDir())
                    size = asDir().size();
            }
            return size;
        }
        
        public boolean hasParent(){return this.file.getAbsoluteFile().getParent() != null;}

        public boolean isFile(){return !this.file.isDirectory();}

        public boolean isDir(){return this.file.isDirectory();}

        public long timestamp(){return this.file.lastModified();}

        public Dir getParent(){
            if(!this.hasParent())
                return null;
            return new Dir(this.file.getAbsoluteFile().getParentFile());
        }

        public File asFile(){
            if (!isFile())
                throw new RuntimeException("Cannot convert directory to ordinary file");
            return new File(this.file);
        }

        public Dir asDir(){
            if(!isDir())
                throw new RuntimeException("Cannot convert ordinary file to directory");
            return new Dir(this.file);
        }
        
        public String toString(){return file.toString();}
    }





    /**
     * A `File`-object represents a normal file in the file system.
     */
    public static class File extends Node {
        protected File(java.io.File file){
            super(file);
            if (!isFile()) throw new RuntimeException("Invalid file given in initialization of FileSystem.File");
        }

        Iterable<String> readLines(){
            try {
                return java.nio.file.Files.readAllLines(this.file.toPath(),java.nio.charset.Charset.defaultCharset());
            } catch(java.io.IOException e) {
                System.err.printf("WARNING (FileSystem.File.readLines()): %s%n",e);
                return new ArrayList<>();
            }
        }
    }




    /**
     * A `Dir`-object represents a directory in the file system.
     */
    public static class Dir extends Node {
        List<File> files = null;
        List<Dir> dirs = null;
        long size = -1;
        
        protected Dir(java.io.File file){
            super(file);
            if (!isDir()) throw new RuntimeException("Invalid directory given in initialization of FileSystem.Dir");
        }

        /**
         * Returns the number of bytes of all the files that are
         * accessible under the directory.
         *
         * Note that this metod uses caching of the file
         * sizes. Hence, if the size of one of the files 
         * is changed after the first call of size(), the
         * result will no longer be correct.
         */
        public long size(){
            if (size != -1)
                return size;

            size = file.length();
            getFiles().forEach(f -> size+=f.size());
            getDirs().forEach(d -> size+=d.size());
            return size;
        }

        /**
         * Lists all the files contained in the directory.
         */
        public List<File> getFiles(){
            if (files == null){
                java.io.File[] fileList = file.listFiles();
                if (fileList == null) // because of lack of access.
                    files = new ArrayList<>(); // Empty list
                else 
                    files = Arrays.stream(fileList).filter(f -> f.isFile()).map(f -> getFile(f)).collect(Collectors.toList());
            }
            return files;
        }

        /**
         * Lists all the subdirectories of the directory.
         */
        public List<Dir> getDirs(){
            if (dirs == null){
                java.io.File[] fileList = file.listFiles();
                if (fileList == null) // because of lack of access
                    dirs = new ArrayList<>();
                else
                    dirs = Arrays.stream(fileList).filter(f -> f.isDirectory()).map(f -> getDir(f)).collect(Collectors.toList());
            }

            return dirs;
        }
    }

    /*
     * Test code & Example of usage
     */
    public static void main(String[] args){
        FileSystem.Dir current = getCurrentDir(); //
        
        System.out.printf("%n### Files in %s: ###%n",current);

        for(File f : current.getFiles()){
            System.out.println(f);
            System.out.println(f.readLines());
        }
        
        System.out.printf("%n### Subdirectories in %s: ###%n",current);
        for(Dir d: current.getDirs())
            System.out.println(d);

        System.out.printf("%n### sub-subdirectories in %s: ###%n",current);
        for(Dir d: current.getDirs())
            for(Dir dd: d.getDirs())
                System.out.println(dd);

        System.out.println("\n### Parents and Grandparents et.c.");
        while(current.hasParent()){
            current = current.getParent();
            System.out.println(current);
        }

        System.out.printf("Size of all contents of current directory = %d bytes.%n",getCurrentDir().size());
    }
}
