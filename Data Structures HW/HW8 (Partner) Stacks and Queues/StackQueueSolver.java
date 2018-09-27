/**
 * @author Max Goldberg and Amir Al-Sheikh
 * This is a container for the folowing methods.
 */

public class StackQueueSolver {
   
   /**
   * Returns a new Stack that reverses the original stack.
   */
   public static Stack reverseStack(Stack s) {
      LLStack newS = new LLStack();
      while(!s.isEmpty()){
         newS.push(s.pop());
      }
      return (Stack)newS;
   }
   
   /**
   * Tests the reverseStack method.
   */
   public static void testStackReverse(int m) {
      Stack<Integer> s = new LLStack<Integer>();
      for (int i = 1; i <= m; i++){
         s.push(i);
      }
      System.out.println(s.toString());
      s = reverseStack(s);
      System.out.println(s.toString());
   }
   
   /**
   * Simulates quirky behavior of a food line in only the LDC.
   */
   public static int lastCustomer(int m, int n) {
      ArrayQueue<Integer> q = new ArrayQueue<Integer>();
      for (int i = 1; i <= m; i++){
         q.enqueue(i); 
      }
      
      while (m >= 2){
         for (int x = 0; x < n; x++){
            q.enqueue(q.dequeue());
         }
         
         q.dequeue();   
         m--; 
      }
      
      return q.dequeue();
   }
}