//import edu.princeton.cs.algs4.StdRandom;

public class SelectorClient {

    /**
     *
     */
    public static double averageNumberOfGets(){
        int NUMBER_OF_TRIALS = 500;
        int SAMPLE_SIZE = 500;
        
        double accumulator = 0;

        for(int i = 0; i < NUMBER_OF_TRIALS; i++){
            int size = SAMPLE_SIZE;
            int k = StdRandom.uniform(size);
            Sample sample = new Sample(size);

            double selectedValue = Selector.select(sample,k);


            accumulator += 1.0*sample.getCount()/size;

            if(sample.rank(selectedValue) != k)
                throw new RuntimeException("Illegal result of select(k)");
        }

        return (accumulator/NUMBER_OF_TRIALS);

    }

    public static void main(String[] args){
        for(int i = 0; i < 10; i++)
            System.out.println(averageNumberOfGets());
    }

}
