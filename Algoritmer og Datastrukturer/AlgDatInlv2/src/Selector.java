//import edu.princeton.cs.algs4.Selection;

import java.util.ArrayList;

public class Selector {
    /****
     * Using a new Class, we store the value, it's rank and the index it has in the Sample list
     * An Arraylist of class "Position"
     *
     */
    public static double select(Sample sample, int rank){
        ArrayList<Position> list = new ArrayList<>();
        if( list.size() == 0){
            copyToArray(sample,list);
            int indexInSamlpe = getItemUsingRank(sample,list,rank).indexInSample;
            return sample.get(indexInSamlpe);
        }

        return -1.0;// "ERROR CODE"
    }

    public static void copyToArray(Sample sample, ArrayList<Position> list){
        for(int i = 0; i< sample.size(); i++){
            Position item = new Position();
            double temp = sample.get(i);
            item.sampleValue = temp;
            item.indexInSample = i;
            item.rank = sample.rank(temp);
            list.add(item);
        }
    }
    public static Position getItemUsingRank (Sample sample,ArrayList<Position> list, int rank){
        Position returnValue = new Position();
        for(int i = 0; i< list.size(); i++){

            if (sample.rank(list.get(i).sampleValue) == rank){
                returnValue = list.get(i);
                return returnValue;
            }
        }
        return returnValue;
    }

    /*
     * Example of a brute force-solution.
     */
    public static double selectBruteForce(Sample sample, int rank){
        for(int i = 0; i < sample.size(); i++)
            if(rank(sample,sample.get(i)) == rank)
                return sample.get(i);
        return -1.0;// "ERROR CODE"
    }
    public static int rank(Sample sample, double selectedValue){
        int rank = 0;
        for(int i = 0; i < sample.size() ; i++)
            if (sample.get(i) < selectedValue) rank++;
        return rank;
    }
    /***
     * Using selection sort we sort the elements until we reach the rank needed,
     * This way we avoid sorting the entire list each and everytime
     *
     * */
    public static double selectSelectionSort(Sample sample, int rank){

        for(int i = 0; i < sample.size()  ; i++) {
            int index = i;
            for (int j = i + 1; j < sample.size() ; j++) {
                if (sample.get(j) < sample.get(index))
                    index = j;
            }
            sample.exch(index,i);
            if(i == rank){
                return sample.get(rank);
            }
        }
        return -1.0;// "ERROR CODE"
    }

    /*
     * Client code
     */
    public static void main(String[] args){

        Sample sample = new Sample(10);
        System.out.println(sample);
        for(int rank = 0; rank < sample.size(); rank++){
            double selected = select(sample,rank);
            String judgement = sample.rank(selected) == rank ? "Acceptable choice" : "Unaccaptable choice";
            System.out.printf("Select(sample,%d) = %f, %s %n",rank,selected,judgement);
        }
        System.out.println(sample);
    }
}
