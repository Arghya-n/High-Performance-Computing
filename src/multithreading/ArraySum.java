
package multithreading;

/**
 *
 * @author sakib
 */
import java.util.*;
public class ArraySum {
    public static int log2(int N)
    {
        int result = (int)(Math.log(N) / Math.log(2));
 
        return result;
    }
    
    
    private static int[] sum = new int[1000];
    private static int part = 0;
 
    static class SumArray implements Runnable {
        private int[] arr;
        public SumArray(int[] b){
            this.arr=b;
        }
        @Override
        public void run() {
 
            // Each thread computes sum of 1/4th of array
            int thread_part = part++;
 
            for (int i = thread_part * (arr.length / log2(arr.length)); i < (thread_part + 1) * (arr.length / log2(arr.length)); i++) {
                sum[thread_part] += arr[i];
            }
        }
    }
 
    // Driver Code
    public static void main(String[] args) throws InterruptedException {
        
 
        
        Scanner input =new Scanner(System.in);
        int sz=input.nextInt();
        //sz++;
        int nthreads=log2(sz)+1;
        Thread[] threads = new Thread[nthreads];
        int [] b=new int [1<<nthreads];
        for(int i=0;i<sz;i++){
            b[i]=input.nextInt();
        }
 
        // Creating log2n threads
        for (int i = 0; i < nthreads; i++) {
            threads[i] = new Thread(new SumArray(b));
            threads[i].start();
        }
 
        // Joining threads i.e. waiting for all threads to complete
        for (int i = 0; i < nthreads; i++) {
            threads[i].join();
        }
 
        // Adding sum of all the parts
        int total_sum = 0;
        for (int i = 0; i < nthreads; i++) {
            total_sum += sum[i];
            //System.out.println(sum[i]);
        }
 
        System.out.println("sum is " + total_sum);
    }
}
