
/**
 * An implementation of the List ADT using
 * a linked list.  Specifically, this implementation
 * only allows a List to contain Comparable items.
 * ADD A DESCRIPTION HERE ABOUT THE ADDED METHODS.
 *
 * @author Layla Oesper
 * @author YOUR NAME HERE
 */

/* Note <E extends Comparable<E> means this container
 * can only old objects of type E that are Comparable.
 */
public class RecursiveLinkedList<E extends Comparable<E>> implements List<E> {

    /* Internal Node class used for creating linked objects.
     */
    private class Node<E> {

        private E data;
        private Node<E> next;

        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> nextNode) {
            data = dataItem;
            next = nextNode;
        }

    } // End Node class

    //Instance variables for RecursiveLinkedList
    private Node head;
    private int numItems; //Total number items stored in List.

    /**
     * Creates an empty RecursiveLinkedList
     */
    public RecursiveLinkedList() {
        head = null;
        numItems = 0;
    }

    /**
     * Returns the data stored at positon index.
     *
     * @param index
     * @return The data stored at position index.
     */
    public E get(int index) {
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /*
     * Helper method that retrives the Node<E> stored at 
     * the specified index.
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Removes and returns the data stored at the specified index.
     *
     * @param index The position of the data to remove.
     * @return The data previously stored at index position.
     */
    public E remove(int index) {
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        if (index == 0) {
            return removeFirst();
        } else {
            Node<E> before = getNode(index - 1);
            return removeAfter(before);
        }
    }

    /*
     * Helper method that removes the Node<E> after the
     * specified Node<E>. Returns the data that was
     * stored in the removed node.
     */
    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            numItems--;
            return temp.data;
        } else {
            return null;
        }
    }

    /*
     * Helper method that removes the first Node<E> in
     * the Linked List.  Returns the data that was
     * stored in the removed node.
     */
    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }

        if (temp != null) {
            numItems--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Adds the data to the list at the specified index.
     *
     * @param index The position to add the data.
     * @param anEntry The particular data to add to the list.
     */
    public void add(int index, E anEntry) {
        if (index < 0 || index > numItems) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(anEntry);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, anEntry);
        }
    }

    /*
     * Helper method that adds anEntry to the first
     * position in the list.
     */
    private void addFirst(E anEntry) {
        head = new Node<>(anEntry, head);
        numItems++;
    }

    /*
     * Helper method that adds anEntry after the
     * specified Node<E> in the linked list.
     */
    private void addAfter(Node<E> before, E anEntry) {
        before.next = new Node<>(anEntry, before.next);
        numItems++;
    }

    /**
     * Add the specified data to the end of the list.
     *
     * @param anEntry The data to add to this list.
     */
    public boolean add(E anEntry) {
        add(numItems, anEntry);
        return true;
    }

    /**
     * Returns the size of the list in terms of items stored.
     *
     * @returns the number of items in the list.
     */
    public int size() {
        return numItems;
    }

    /**
     * Modifies the list so the specified index now contains newValue (overwriting the old data).
     *
     * @param index The position int he list to add data.
     * @param newValue The data to place in the list.
     * @return The previous data value stored at index.
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     * A string representation of the List.
     *
     * @returns A string representation of the list.
     */
    public String toString() {
        String s = "[";
        Node<E> temp = head;
        for (int i = 0; i < numItems; i++) {
            s = s + temp.data.toString();
            if (i < numItems - 1) {
                s = s + ", ";
            }
            temp = temp.next;
        }
        s = s + "]";
        return s;
    }

    //YOUR CODE GOES HERE
    //YOU MADE ADD OTHER HELPER METHODS AS WELL
    
    /**
     * A helper method to solve the max.
     *
     * @param curr The current node we are comparing.
     * @param maxValue The currently largest value.
     * @return the maxValue in the ArrayList
     */
    private E maxHelper(Node<E> curr, E maxValue) {
        if (curr == null) {
            return maxValue;
        } else {
            if (curr.data.compareTo(maxValue) > 0) {
                return maxHelper(curr.next, curr.data);
            } else {
                return maxHelper(curr.next, maxValue);
            }
        }
    }
    /** Removes all elements that match element
    * @param curr The current node
    * @param prev The previous node
    * @param element The element that should be removed
    */
    private void removeHelper(Node<E> curr, Node<E> prev, E element) {
        if (numItems > 0) {
            if (curr.equals(head)) { // At head 
                if (curr.data.equals(element)){ // Remove
                    removeFirst();
                    removeHelper(curr, null, element);
                } else { // Don't remove
                    removeHelper(curr.next, curr, element);
                }
            } else if (curr.next != null) { // At middle
                if (curr.data.equals(element)) { // Remove
                    removeAfter(prev);
                    removeHelper(curr.next, prev, element);
                } else { // Don't remove
                    removeHelper(curr.next, curr, element);
                }
            } else { // At tail
                if (curr.data.equals(element)){ // Remove
                    removeAfter(prev);
                }
            }
        }
    }

    /**
    * Duplicates each element of the list recursively.
    */
    private void duplicateHelper(Node<E> curr) {
        if (numItems > 0){
            if (curr != null){
                addAfter(curr, curr.data);
                duplicateHelper(curr.next.next);
            }
        }
    }
    
    /**
     * Return the maximum element in the list using compareTo() method of Comparable.
     *
     * @return maximum element of the list
     */
    public E max() throws NullPointerException {
        if (head == null) {
            throw new NullPointerException("List is empty");
        }
        return (E) maxHelper(head, (E) head.data);
    }

    /**
     * Remove all elements that match element using the equals() operator to determine a match.
     * (Don't use ==).
     *
     * @param element The element that should be removed
     *
     */
    public void remove(E element) {
        removeHelper(head, null, element);
    }

    /**
     * Duplicate each element of the list
     *
     * For example, the list [ 0 1 2 ] duplicated becomes [ 0 0 1 1 2 2 ]
     *
     */
    public void duplicate() {
        duplicateHelper(head);
    }

    /**
     * Here are a couple short tests. You should should make sure to thoroughly test your code.
     */
    public static void main(String[] args) {
        RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();

        System.out.println("Adding 1-10 to the LinkedList...\n");
        for (int i = 1; i <= 10; i++) {
            list.add((Integer)i);
        }
        System.out.println("Maximum value is: " + list.max());
        System.out.println("List is: " + list);
        
        System.out.println("Duplicating...");
        list.duplicate();
        System.out.println("List is: " + list);

        System.out.println("Removing 10...");
        list.remove((Integer) 10);
        System.out.println("List is: " + list);

        System.out.println("Removing 1...");
        list.remove((Integer) 1);
        System.out.println("List is: " + list);        
        
        System.out.println("Removing 3...");
        list.remove((Integer) 3);
        System.out.println("List is: " + list);
        
        System.out.println("Removing 100...");
        list.remove((Integer) 100);
        System.out.println("List is: " + list);
        
        System.out.println("Maximum value is: " + list.max());
        System.out.println("List is: " + list);
    }

}
