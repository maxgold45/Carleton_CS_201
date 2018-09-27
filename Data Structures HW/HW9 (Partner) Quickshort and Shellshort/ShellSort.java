import java.text.*;
import java.io.Writer;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
/**
 * Class for ShellSort Investigation, exploring how changing the gap sequence affects run time.
 * You'll only need to look at the shellSort method. You'll modify main, and you're
 * welcome to add any additional methods you'd like. 
 * 
 * @author Anna Rafferty
 * @author Layla Oesepr
 * @author Max Goldberg
 * @author Amir Al-Sheikh
 */
public class ShellSort {
    
    /**
     * Sorts the specified array in increasing order using shell sort. Uses
     * the gap sequence we discussed in class of dividing by 2 and adding
     * one if even.
     * You're welcome to change this method in any way you like for your
     * investigation, including adding parameters to the method.
     * Helper method incrementalInsertionSort handles the gap sorting
     * of subarrays. 
     */
     
    public static void shellSort(int[] array, double factor) {
        double gap = array.length / 2; //leave this two alone, you always divide in half to get first gap
        while(gap >= 1) {
            for(int start = 0; start < (int) Math.ceil(gap); start++) {
                //We'll "gap sort" starting at index start
                incrementalInsertionSort(array, start, (int)Math.ceil(gap));
            }
            
            gap = gap / factor;  // Changed 2 to factor       
            if (gap <= 1.0){
               break;
            }
            if(gap <= 2) {
                gap = 1;
            }
        }
    }
    
    
    
    /**
     * Helper method for shellSort. Does an insertion sort of the subarray at
     * array[first,first+gap, first+gap*2,...]
     */
    private static void incrementalInsertionSort(int[] array, int first, int gap) {
        for(int i = first+gap; i < array.length; i += gap) {
            int nextToInsert = array[i];
            int j = i;
            while(j >= first+gap && nextToInsert < array[j-gap]) {
                array[j] = array[j-gap];
                j -= gap;
            }
            array[j] = nextToInsert;
        }
    }
    
    /**
     * Generates a pseudo-random permutation of the integers from 0 to
     * a.length - 1.
     * See p. 139 of "Seminumerical Algorithms, 2nd edition," by Donald Knuth.
     */
    public static void fillAndShuffle(int[] a) {
        // Fill the array with the integers from 0 to a.length - 1.
        int k;
        for (k = 0; k < a.length; k++) {
            a[k] = k;
        }

        // Shuffle.
        for (k = a.length - 1; k > 0; k--) {
            int swapIndex = (int)Math.floor(Math.random() * (k + 1));
            int temp = a[k];
            a[k] = a[swapIndex];
            a[swapIndex] = temp;
        }
    }
    
  
    /**
     * Put your investigation code in main! I've included a sample, but you
     * can delete it and replace it with your own.
     */
    public static void main(String[] args) {
      // Investigation 2a
      // See QuickSort for file writing
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Inv. 2a 1,000,000 Array.txt"), "utf-8"))) {                
           DecimalFormat d = new DecimalFormat("#.##");
           for (int k = 0; k < 10; k++){
           // We collected data from 1.5 to 9 incrementing by .25
             for (double i = 1.5; i <= 9; i += .25){
                 int[] shellSortArray = new int[1000000];
                 fillAndShuffle(shellSortArray);
                 long startTime = System.currentTimeMillis();
                 shellSort(shellSortArray, i);
                 long endTime = System.currentTimeMillis();                 
                 writer.write(shellSortArray.length + " " + d.format(i) + " " + (endTime-startTime) + "\n");
              }
            }
           writer.close();
        }
        catch(Exception e){}
    }
}
