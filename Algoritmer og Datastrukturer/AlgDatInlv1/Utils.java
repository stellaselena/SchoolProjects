import java.io.File;
import java.io.PrintStream;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Random;
import java.util.function.Function;

import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

import java.time.LocalDateTime;

/**
 * Contains useful tools in Lab 1 in PG4200 
 * @author Lars Sydnes
 */
public class Utils {
    private Utils(){}//Do not instantiate
    
    /**
     * Used for generating random samples of words from a given text file
     */
    public static class Sampler {
        private static final Random RANDOM = new Random();
        private String[] data;
        /**
         * Constructs a sampler object that reads words from <i>fileName</i>
         */
        public Sampler(String fileName){
            try {
                Scanner scanner = new Scanner(new File(fileName),"Utf-8");
                data= Pattern.compile("\\p{javaWhitespace}+").split(scanner.useDelimiter(Pattern.compile("\\A")).next());
            } catch (FileNotFoundException fnfe){
                System.out.println("\n\n#\n#\n# Fant ingen ord!\n# Sannsynlig problem: Filen shakespeare.txt mangler\n#\n#\n");
                data =  new String[]{null};
            }
        }
        /**
         * Returns a random sample of <i>size</> words from the given file.
         */
        public String[] get(int size){
            String[] output = new String[size];
            for(int i = 0; i < size; i ++) output[i] = data[RANDOM.nextInt(data.length)];
            return output;
        }
        
    }
   /**
    * Priovides time measurement functionality
    * This class measures the time in nanoseconds, based on <tt>System.nanotime()</tt>
    */
   public static class Stopwatch {
       private final ThreadMXBean timer;
       private long start;

       public Stopwatch(){
           timer = ManagementFactory.getThreadMXBean();
           start();
       }

       /**
        * Start the timer
        */
       public void start(){start = timer.getCurrentThreadCpuTime();}

       /** 
        * Returns the time in nanoseconds since the last call <tt>start()</tt>.
        */
       public long elapsedTime() {
           long now = timer.getCurrentThreadCpuTime();
           return now-start;
       }
       
       /**
        * Runs the runnable object <tt>r</tt>, and returns the elapsed time
        * measured in nanoseconds.
        */
       public static long elapsedTime(Runnable runnable){
            long start = System.nanoTime();
            runnable.run();
            long stop = System.nanoTime();
            return stop-start;
       }
       
       /**
        * Calls the given function with the given argument, 
        * and returns the elapsed time measured in nanoseconds.
        */
       public static <T,R> long elapsedTime(Function<T,R> fu, T args){return elapsedTime(() -> fu.apply(args));}
       
   }
   
   /**
    * This class provides useful methods for collecting
    * measurements in a csv-file.
    */
   public static class Output {
       /**
        * Default separator, which is "\t", namely <tt>tab</tt>.
        */
        public static final String SEPARATOR = "\t";
        
        private PrintStream out;
        private String sep;     
        private String measurementFormat;
        
        /**
         * Constructs an object for writing to <tt>System.out</tt>
         * with the default separator.
         */
        public Output(){this(System.out,SEPARATOR);}
        /**
         * Constructs an object for writing measurements to
         * the file <tt>fileName</tt> with the default separator.
         * @see SEPARATOR
         */
        public Output(String fileName){this(fileName,SEPARATOR);}
        
        /**
         * Constructs an object for writing measurements to
         * the file <tt>fileName</tt> with the separator <tt>separator</tt>.
         */
        public Output(String fileName,String separator){this(getFile(fileName),separator);}
        
        private Output(PrintStream ostream, String separator){
            out = ostream;
            sep = separator;
            measurementFormat = String.join(sep,"%d","%d","%d%n");
          
            out.printf("# Measurements: %s%n",LocalDateTime.now());
            out.printf("# size%stime(nanoseconds)%stest%n",sep,sep);
        }
        
        private static PrintStream getFile(String fileName){
            try  {return new PrintStream(fileName);}
            catch (FileNotFoundException e) {throw new RuntimeException("ERRO ON OPENING FILE");}
        }

        /**
         * Write a data point to the output file.
         */
        public void addMeasurement(int size, long elapsedTime, int uniqlength){
            out.printf(measurementFormat,size,elapsedTime, uniqlength);

        }
   }
   
   /**
    * Very incomplete unit test. Tests the class <tt>Utils</tt> simply by 
    * calling <tt>DedupTest.main</tt>.
    * @see DedupTest.main
    */
   public static void main(String[] args){DedupTest.main(args);}

}
