import java.util.NoSuchElementException;
import java.lang.NullPointerException;

/**
 * @author Max Goldberg and Amir Al-Sheikh
 * An implementation of a Stack with a LinkedList.
 */

public class LLStack<E> implements Stack<E> {
    
    //Instance Variables
    private Node<E> head;
    private int numItems;
    
    private class Node<E> {
      private E data;
      private Node<E> next;

      public Node(E item) {
         data = item;
         next = null;
      }
    }//End Node Class
    
    
    /**
    * Creates empty LLStack
    */
    public LLStack(){
      head = null;
      numItems = 0; 
    }
    
    /**
    *returns true if LLStack is empty, false otherwise
    */
    public boolean isEmpty(){
      if(numItems == 0){
         return true;
      }
      return false;
    }
    
    /**
    *returns number of items currently stored in the stack
    */
    public int size(){
      return numItems;
    }
    
    /**
    *adds item to the top of the stack
    */
    public void push(E item){
        Node adding = new Node(item);
        adding.next = head;
        head = adding;
        numItems++;        
    }
    
    /**
    *removes and returns the top item in stack
    */  
    public E pop() throws NoSuchElementException{
      try{
         Node temp = head;
         head = head.next;
         numItems--;
         return (E)(temp.data);
      }
      catch(NullPointerException e){
        throw new NoSuchElementException();
     }
    }  
    
    /**
    *return item at the top of the stack if it exists
    */
    public E peek() throws NoSuchElementException{
        if(numItems != 0){
           return head.data;
        }
        throw new NoSuchElementException();
    }
    
    /**
    *returns a String representation of the LLStack
    */
    public String toString(){
      String ret = "top [ ";
      Node temp = head;
      for (int i = 0; i < numItems; i++) {
         ret += temp.data + " ";
         if (i != numItems - 1){
            temp = temp.next; 
         }
      }
      return ret + "] bottom";
    }
}