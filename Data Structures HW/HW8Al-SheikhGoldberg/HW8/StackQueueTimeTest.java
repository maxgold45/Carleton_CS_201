/**
 * This class will test out an ArrayQueue and StackLL
 * implementations and print information about their
 * runtime in terms of clock time.
 * @author Layla Oesper.
 */
public class StackQueueTimeTest {

    /**
     * @param stack -  an empty stack
     * @param numOperations - the number of operations to test with.
     * @return double - the time in seconds that
     * numOperations of push and pop took on the provided stacks.
     */
    public static double stackTimeTest(Stack stack, int numOperations) {
        int minOps = 10000;
        long t1 = System.currentTimeMillis();
        if (numOperations < minOps) {
            for (int i=0; i<numOperations/2; i++) {
                stack.push(i);
            }
            for (int i=0; i<numOperations/2; i++) {
                stack.push(i);
                stack.pop();
            }
            for (int i=0; i<numOperations/2; i++) {
                stack.pop();
            }
        } else {
            for (int i=0; i<minOps; i++) {
                stack.push(i);
            }
            for (int j=0; j<numOperations-minOps; j++) {
                stack.push(j);
                stack.pop();
            }
            for (int i=0; i<minOps; i++) {
                stack.pop();
            }
        } //end else
        
        long t2 = System.currentTimeMillis();
        return (t2 - t1) / 1000.0;
    }
    
    /**
     * @param queue -  an empty queue
     * @param numOperations - the number of operations to test with.
     * @return double - the time in seconds that
     * numOperations of enqueue and dequeue took on the provided queue.
     */
    public static double queueTimeTest(Queue queue, int numOperations) {
        int minOps = 10000;
        long t1 = System.currentTimeMillis();
        if (numOperations < minOps) {
            for (int i=0; i<numOperations/2; i++) {
                queue.enqueue(i);
            }
            for (int i=0; i<numOperations/2; i++) {
                queue.enqueue(i);
                queue.dequeue();
            }
            for (int i=0; i<numOperations/2; i++) {
                queue.dequeue();
            }
        } else {
            for (int i=0; i<minOps; i++) {
                queue.enqueue(i);
            }
            for (int j=0; j<numOperations-minOps; j++) {
                queue.enqueue(j);
                queue.dequeue();
            }
            for (int i=0; i<minOps; i++) {
                queue.dequeue();
            }
        } //end else
        
        long t2 = System.currentTimeMillis();
        return (t2 - t1) / 1000.0;
    }
    
    /**
     * Tests out a Stack and Queue implementations
     * with a range of opertions and reports the running
     * time in seconds for each.
     */
    public static void main(String[] args) {
        
        int tenMillion = 10000000;
        
        System.out.println("Testing LLStack:");
        Stack LLS = new LLStack();
        for (int i = 1; i <= 10; i++) {
            int numOps = i * tenMillion;
            double LLtime = stackTimeTest(LLS, numOps);
            System.out.format("Num Ops: %d\t Time:  %.2f seconds\n", numOps, LLtime);
        }
        
        System.out.println("\nTesting ArrayQueue:");
        Queue arrayQ = new ArrayQueue();
        for (int i = 1; i <= 10; i++) {
            int numOps = i * tenMillion;
            double arrayTime = queueTimeTest(arrayQ, numOps);
            System.out.format("Num Ops: %d\t Time:  %.2f seconds\n", numOps, arrayTime);
        }
    }// end main
}// end class