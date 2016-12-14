import java.util.Arrays;
import java.util.Comparator;

public class ComparatorsClient {

    private static final FileSystem.Dir[] DIRS = FileSystem.getCurrentDir().getDirs().toArray(new FileSystem.Dir[0]);


    private static final Comparator<FileSystem.Dir>[] COMPARATORS = new Comparator[]{
        Comparators.NAME, 
        Comparators.REVERSED_NAME, 
        Comparators.SIZE, 
        Comparators.REVERSED_SIZE, 
        Comparators.NUMBER_OF_CHILDREN, 
        Comparators.REVERSED_NUMBER_OF_CHILDREN
    };

    private static final String[] NAMES = new String[]{
        "Name",
        "ReversedName", 
        "Size", 
        "ReversedSize", 
        "NumberOfChildren", 
        "ReversedNumberOfChildren"
    };



    /*
     * Test of comparator.
     */
    private static void test(Comparator<FileSystem.Dir> cmp){
        if (cmp == null){
            System.out.println("NOT IMPLEMENTED");
            return;
        }

        FileSystem.Dir[] dirs = Arrays.copyOf(DIRS,DIRS.length);
        System.out.printf("Before sorting: %s%n",Arrays.toString(dirs));
        Arrays.sort(dirs,cmp);
        System.out.printf("After sorting: %s%n",Arrays.toString(dirs));
    }


    /*
     * Main method
     */
    public static void main(String[] args){
        for(int i = 0; i < COMPARATORS.length; i++){
            System.out.printf("%n%nTest of %s-comparator%n",NAMES[i]);
            test(COMPARATORS[i]);
        }   
    }
}
