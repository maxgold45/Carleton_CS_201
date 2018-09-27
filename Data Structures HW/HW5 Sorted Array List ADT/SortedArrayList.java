package sortedarraylist;

/**
 * A Sorted Array List Data Structure.
 *
 * @author Max Goldberg
 */
public class SortedArrayList {

    //Instance Variables
    private int[] data;
    private int size;
    private int capacity;

    /**
     * @param cap The initial capacity of the SortedArraylist.
     * @throws IllegalArgumentException
     */
    public SortedArrayList(int cap) throws IllegalArgumentException {
        if (cap < 0) {
            throw new IllegalArgumentException("Capacity of the Sorted Array List must be positive.");
        }
        data = new int[cap];
        capacity = cap;
        size = 0;
    }

    /**
     * @return A string that describes the SortedArrayList
     */
    public String toString() {
        String val = "[";
        for (int i = 0; i < size; i++) {
            val = val + data[i];

            if (i < size - 1) {
                val = val + ", ";
            }
        }
        val = val + "]";
        return val;
    }

    /**
     * The method checks whether the index is in bounds.
     *
     * @param index
     * @return a boolean of whether or not the index was out of bounds.
     */
    private boolean indexOutOfBounds(int index) {
        return (index < 0 || index >= size);
    }

    /**
     * Finds the minimum value of the array. (The first value)
     *
     * @return the minimum value.
     */
    public int getMin() {
        if (indexOutOfBounds(0)) {
            throw new ArrayIndexOutOfBoundsException("No values in the list.");
        } else {
            return data[0];
        }
    }

    /**
     * Finds the maximum value of the array. (The last value)
     *
     * @return the maximum value.
     */
    public int getMax() {
        if (indexOutOfBounds(size - 1)) {
            throw new ArrayIndexOutOfBoundsException("No values in the list.");
        } else {
            return data[size - 1];
        }
    }

    /**
     * Returns the size of the array. (not the capacity)
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Deletes the minimum value of the array.
     *
     * @return the deleted value
     */
    public int deleteMin() {
        int ret;
        if (indexOutOfBounds(0)) {
            throw new ArrayIndexOutOfBoundsException("No values in the list.");
        } else {
            ret = data[0];
            for (int i = 0; i < size; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }
        return ret;
    }

    /**
     * Deletes the maximum value of the array.
     *
     * @return the deleted value
     */
    public int deleteMax() {
        int ret;
        if (indexOutOfBounds(size - 1)) {
            throw new ArrayIndexOutOfBoundsException("No values in the list.");
        } else {
            ret = data[size - 1];
            size--;
        }
        return ret;
    }

    /**
     * Checks whether the array contains x
     *
     * @param x
     * @return true or false
     */
    public boolean contains(int x) {
        for (int i = 0; i < size; i++) {
            if (data[i] == x) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds x to the correct spot in the array, sorted from smallest to largest.
     *
     * @param x
     */
    public void add(int x) {
        if (capacity <= size + 1) {
            resizeArray();
        }

        // No numbers in the array.
        if (size == 0) {
            data[0] = x;
        } // x is smaller than all numbers.
        else if (x < getMin()) {
            for (int i = size; i > 0; i--) {
                data[i] = data[i - 1];
            }
            data[0] = x;
        } // x is larger than all numbers.
        else if (x > getMax()) {
            data[size] = x;
        } // x is somewhere in the middle.
        else {
            int index = 0;
            for (int i = 0; i < size; i++) {
                if (data[i] > x) {
                    index = i;
                    break;
                }
            }
            for (int i = size; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = x;
        }
        size++;
    }

    /**
     * Increases the capacity of the array by twofold. If the capacity is 0, it sets it to 4.
     */
    private void resizeArray() {
        int[] ret;
        if (capacity != 0) {
            ret = new int[capacity * 2];
            capacity *= 2;
            for (int i = 0; i < size; i++) {
                ret[i] = data[i];
            }
        } else {
            ret = new int[4];
            capacity = 4;
        }
        data = ret;
    }

    public static void main(String[] args) {
        SortedArrayList l = new SortedArrayList(0);

        System.out.println("Adding -5");
        l.add(-5);
        System.out.println("Size should be 1: " + l.getSize());
        System.out.println("List should be [-5]: " + l + "\n");

        System.out.println("Adding 0");
        l.add(0);
        System.out.println("Size should be 2: " + l.getSize());
        System.out.println("List should be [-5, 0]: " + l + "\n");

        System.out.println("Adding -6");
        l.add(-6);
        System.out.println("Size should be 3: " + l.getSize());
        System.out.println("List should be [-6, -5, 0]: " + l + "\n");

        System.out.println("Adding -5");
        l.add(-5);
        System.out.println("Size should be 4: " + l.getSize());
        System.out.println("List should be [-6, -5, -5, 0]: " + l + "\n");

        System.out.println("Adding -2");
        l.add(-2);
        System.out.println("Size should be 5: " + l.getSize());
        System.out.println("List should be [-6, -5, -5, -2, 0]: " + l + "\n");

        System.out.println("Should delete 0: " + l.deleteMax());
        System.out.println("Size should be 4: " + l.getSize());
        System.out.println("List should be [-6, -5, -5, -2]: " + l + "\n");

        System.out.println("Should delete -6: " + l.deleteMin());
        System.out.println("Size should be 3: " + l.getSize());
        System.out.println("List should be [-5, -5, -2]: " + l + "\n");

        System.out.println("Adding 2, 7, and 3");
        l.add(2);
        l.add(7);
        l.add(3);
        System.out.println("Size should be 6: " + l.getSize());
        System.out.println("List should be [-5, -5, -2, 2, 3, 7]: " + l + "\n");

        System.out.println("List should contain -5: " + l.contains(-5));
        System.out.println("List should contain 2: " + l.contains(2));
        System.out.println("List should contain 3: " + l.contains(3));
        System.out.println("List should contain 7: " + l.contains(7));

        System.out.println("List should not contain 4: " + l.contains(4));
        System.out.println("List should not contain 30: " + l.contains(30));
        System.out.println("List should not contain -12: " + l.contains(-12));

        System.out.println("Size should be 6: " + l.getSize());
        for (int i = 0; i < 6; i++) {
            System.out.println("Deleting maximum: " + l.deleteMax());
        }
        
        System.out.println("Should be empty []: " + l);
    }
}
