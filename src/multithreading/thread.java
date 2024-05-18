
package multithreading;

/**
 *
 * @author sakib
 */
import java.util.*;
class A implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread2");
        }
    }
} 
class thread {
    
    public static void main(String[] args) {
        A r=new A();
        Thread t= new Thread(r);
        t.start();
        for(int i=0;i<16;i++){
            System.out.println("Main thread");
        }
        
        
    }
}
