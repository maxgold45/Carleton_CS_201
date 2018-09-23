import java.util.NoSuchElementException;

/**
 * @author Max Goldberg and Amir Al-Sheikh
 * An implementation of a Queue with a circular array.
 */
public class ArrayQueue<E> implements Queue<E> {
	private E[] dataArray;
	private int front;  // index of first item to remove
	private int rear;   // index of next available position
	private int numElements; // for convenience
   private int capacity; // current capacity of array
    
   private static final int DEFAULT_CAPACITY = 1000;

    /**
     * Creates an empty ArrayQueue.
     */
	public ArrayQueue() {
        dataArray = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        numElements = 0;
        capacity = DEFAULT_CAPACITY;
	}
	
   /**
   *returns true of array is empty
   */
	public boolean isEmpty(){
      if(numElements == 0){
         return true; 
      }
      return false;
   }

   /**
   * Returns the number of elements in the queue
   */   
   public int size(){
      return numElements;
   }
   
   /**
   * Add item to the rear of the Queue.
   */   
   public void enqueue (E item){
      if(numElements == capacity){
         resizeArray();
      }
      dataArray[rear] = item;
      rear = (rear + 1) % capacity;
      numElements++;
   }

   /**
   * Removes and returns the item on the front of the queue.
   */  
   public E dequeue() throws NoSuchElementException{
      if (numElements != 0){
         E ret = dataArray[front];
         front = (front + 1) % capacity;
         numElements--;
         return ret;
      }
      else{
       throw new NoSuchElementException();
      } 
  
   }
  
   /**
   * Returns the item at the front of the queue. Does not modify the queue.
   */  
   public E peek() throws NoSuchElementException{
      if (numElements != 0){
         return dataArray[front];      
      }
      else{
       throw new NoSuchElementException();
      }
   }
  
   /**
   * Returns a String representation of the queue.
   */
   public String toString(){
      String ret = "front: " + front + " back: " + rear + "\nfront [ ";
      int index = front;
      for(int x = 0; x < numElements; x++){
         ret += dataArray[index] + " ";
         index = (index + 1) % capacity;
      }
      return ret + "] back";
   }  
  
   /**
   * Doubles the size of the underlying circular array.
   */  
   private void resizeArray(){
      E[] temp = (E[]) new Object[capacity * 2];
      int index = front;
      for(int x = 0; x < numElements; x++){
         temp[x] = dataArray[index];
         index = (index + 1) % capacity;
      }
      capacity *= 2;
      front = 0;
      rear = numElements;
      dataArray = temp;
   }
}
