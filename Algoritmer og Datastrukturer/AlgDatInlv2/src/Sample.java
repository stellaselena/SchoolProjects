import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;


public class Sample {

    private static Random RANDOM = new Random();

    private static double[] sample(int n){
        double exponent = -Math.log(RANDOM.nextDouble())/Math.log(2.0);
        return sample(n,exponent); 
    }

    private static double[] sample(int n, double exponent){
        double[] out = new double[n];
        for(int i = 0; i < out.length; i++){
            out[i] = Math.pow(RANDOM.nextDouble(),exponent);
        }
        return out;
    }


    private double[] values;
    private int size;
    private int getCount;
    public boolean verbose = false;

    /**
     * Constructs a sample of size n.
     *
     * The sample is an indexed list of double-values
     * such that the probability that a member of
     * the sample is less than a given number x 
     * equals x^a, where a is a positive real number.
     *
     * Note that the value of a is constant for each 
     * Sample-object, but that different Sample-objects
     * can have different values of a.
     *
     * Note that the class is designed for an obligatory
     * assignment in PG4200 at Westerdals. As you can see, 
     * the array `values` is hidden behind the methods 
     * `get(int i)` and `exch(int i, int j)`. The teacher 
     * did this because he wanted to monitor the number
     * of array accesses in the solutions. 
     */
    public Sample(int n){
        size = n;
        getCount = 0;
        values = sample(n);
    }

    /**
     * Returns the value of the element at index i.
     */
    public double get(int i){
        if(verbose) System.out.printf("get(%d) -> %.4f%n",i,values[i]);
        getCount++;
        return values[i];
    }

    /**
     * Swaps two elements in the sample
     */
    public void exch(int i, int j){
        if(verbose) System.out.printf("exch(%d, %d): %.4f <-> %.4f%n",i,j,values[i],values[j]);
        double tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    /**
     * Returns the number of calls of `get` since object creation.
     */
    public int getCount(){return getCount;}

    /**
     * Returns the size of the sample.
     */
    public int size(){return size;}


    /**
     * Prints the sample with some key information.
     */
    public String toString(){
        String LINE = "--------------------------------------------------";
        return String.format("%s%ndata:\t%s%n%s",LINE,Arrays.toString(values),LINE);
    }

    /**
     * Used only for certification!
     * It is not allowed to use this method in the implementation
     * of Selector.select, because it does not update the getCount.
     */
    public int rank(double value){
        int rank = 0;
        for(int i = 0; i < values.length; i++) 
            if (values[i] < value) rank++;
        return rank;
    }

    

    /*
     * Test code.
     */
    public static void main(String[] args){
        System.out.println("Sample unit testing:");

        Sample s = new Sample(10);
        //s.verbose = true;

        System.out.println(s);
        int k = 2;
        double select = Selector.select(s,k);
        System.out.println(select);
        System.out.println(s.rank(select) == k);

        System.out.println(s);
        System.out.printf("getCount = %d%n",s.getCount());
    }
}
