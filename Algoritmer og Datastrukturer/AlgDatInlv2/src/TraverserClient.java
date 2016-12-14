import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverserClient {
    //test
    private static FileSystem.Dir current = FileSystem.getCurrentDir();
    private static Traverser traverser = new Traverser();
    private static DirData data = new DirData();

    public static void main(String[] args){
        System.out.println("TRAVERSER CLIENT");
        System.out.println("\nSubdirectories listed in depth-first order:");
        dfs();
        System.out.println("\nFiles listed in increasing distance from current directory: (i.e. in breadth first order)");
        bfs();
    }

    public  static void dfs(){
        Stack<DirData> dataStack= new Stack();
        data.dir = current;
        data.dirFiles = traverser.getAllFiles(current);
        dataStack.push(data);
        while(!dataStack.isEmpty()){
            DirData temp = dataStack.pop();
            System.out.println("dir = " + temp.dir);
            System.out.println("Files in dir = " + temp.dirFiles);
            for(FileSystem.Dir d   :traverser.getAllDirs(temp.dir)){
                // System.out.println(d);
                DirData input  = new DirData();
                input.dir = d;
                input.dirFiles = traverser.getAllFiles(d);
                dataStack.push(input);
            }
        }

    }
    public static void bfs() {
        Queue<DirData> dataQueue = new LinkedList<>();
        data.dir = current;
        data.dirFiles = traverser.getAllFiles(current);
        dataQueue.add(data);
        while (!dataQueue.isEmpty()) {
            DirData temp = dataQueue.remove();
            System.out.println("Dir: " + temp.dir);
            System.out.println("Files " + temp.dirFiles);
            for (FileSystem.Dir dir : traverser.getAllDirs(temp.dir)) {
                DirData input = new DirData();
                input.dir = dir;
                input.dirFiles = traverser.getAllFiles(dir);
                dataQueue.add(input);
            }
        }
    }
}
