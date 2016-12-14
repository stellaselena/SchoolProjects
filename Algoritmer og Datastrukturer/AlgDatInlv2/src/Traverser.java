import java.util.ArrayList;
import java.util.Iterator;


public class Traverser {
    /**
     * Returns an object that allows for iteration over all the files
     * that can be found under the directory `directory`.
     *
     * The returned iterator is required to iterate over the files in
     * breadth first order. (See innlevering2.pdf for more information)
     */
    public static ArrayList<FileSystem.File> getAllFiles(FileSystem.Dir directory){
        // TODO
        ArrayList<FileSystem.File> files = new ArrayList<FileSystem.File> (directory.getFiles());

        return files;
    }

    /**
     * Returns an object that allows for iteration over all the directories
     * that can be found under the directory `directory`.
     *
     * The returned iterator is required to iterate over the files in
     * depth first order. (See innlevering2.pdf for more information)
     */
    public static ArrayList<FileSystem.Dir> getAllDirs(FileSystem.Dir directory){

        ArrayList<FileSystem.Dir> dir = new ArrayList<FileSystem.Dir> (directory.getDirs());

        return dir;
    }


}


/**
 * Starting point for advanced solution.
 * (see innlevering2.pdf for more details)
 */
class DirIterable implements Iterable<FileSystem.Dir> {

    public Iterator<FileSystem.Dir> iterator(){return new Itr();}

    class Itr implements Iterator<FileSystem.Dir> {
        public boolean hasNext(){return false;}
        public FileSystem.Dir next(){return null;}
        public void remove(){throw new UnsupportedOperationException("DFileIterable.Itr.remove()");}
    }
}
