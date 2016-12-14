import java.util.HashSet;


public class DedupTest {
    
    /* Deduppere */
    private static final Dedup hDedup = Dedup.newHashSetDedup();
    private static final Dedup tDedup = Dedup.newTreeSetDedup();
    private static final Dedup aDedup = Dedup.newArrayListDedup();
    private static final Dedup bDedup = Dedup.newBasicDedup();
    private static final Dedup sDedup = Dedup.newSortDedup();

    private static final Dedup[] dedups = new Dedup[]{hDedup};

    private Utils.Sampler sampler;
    private Utils.Stopwatch timer;
    
    public DedupTest(){
        this("shakespeare.txt");
    }

    public DedupTest(String dataFilePath){
        sampler = new Utils.Sampler(dataFilePath);
        timer = new Utils.Stopwatch();
    }
    
    
    /** 
     * Method for running the tests associated with the object.
     * When solving lab1, a good start may be to edit this
     * method.
     */
    public void run(){
        System.out.printf("Start of %s%n",this);



       /* Skrive ut resultater */

     for (Dedup dup: dedups) {


         Utils.Output out = new Utils.Output(dup.getClass().toString() +  ".csv");
         int size = 5000;
         for (int i = 100; i<= 4000; i += 100){

             size = i * 100;
             String[] words = sampler.get(size);
             Utils.Stopwatch timer = new Utils.Stopwatch();

             String[] unique = dup.dedup(words);

             out.addMeasurement(size, timer.elapsedTime(),unique.length);

             System.out.println("\nmåling -> " + timer.elapsedTime());
             System.out.printf("End of %s%n", this);

         }


     }


    }
    
 

    /**
     * Example of a method for testing the 
     * performance of a <tt>Dedup</tt>-object
     *
     * TODO: Finish this
     */
    public void test(Dedup dedup){
        Utils.Output output = new Utils.Output(dedup.getClass().getSimpleName().toLowerCase()+".csv");  // Output to Classname.csv

        // Set up range of experiments 
        int lo = 1;
        int hi = 10000;
        int numberOfLevels = 100;

        // Calculation of step size
        int step = (hi-lo) < numberOfLevels ? 1 : (hi-lo)/(numberOfLevels-1);

        // Main loop 
        for (int size = lo; size <= hi ; size+=step){
            String[] sample = sampler.get(size);
            /* Do test while measuring the time */
            /* Write measurement to output */
        }
    }


    /** 
     * Used for validation of dedup results
     *  Checks if <tt>dedup</tt> is a correct deduplication of <tt>original</tt>.
     */
    private static boolean isCorrectDedup(Object[] original, Object[] dedup){
        HashSet<Object> hs = new HashSet<>();
        for(Object o: original)
            hs.add(o);

        if (hs.size()!=dedup.length)
            return false;

        for(Object o: dedup)
            if(!hs.contains(o))
                return false;
        return true;
    }
    
    /**
     * Practical method for printing arrays
     */
    private static void print(Object[] array){
        System.out.println("\n");
        int n = 0;
        for(Object o : array){
            System.out.printf("%s ",o);
            if (++n >= 4){
                n = 0; 
                System.out.println();
            }
        }
        System.out.println("\n");
    }
    
    /**
     * Main method.
     * Constructs new <tt>DedupTest</tt> object and calls the associated run-method.
     */
    public static void main(String[] args) { new DedupTest().run();}
}
