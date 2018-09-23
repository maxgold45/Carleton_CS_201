/**
 * Interface for the List ADT.
 */
public interface List<E>{
    public E get(int index);
    public E set(int index, E anEntry);
    public int size();
    public boolean add(E anEntry);
    public void add(int index, E anEntry);
    public E remove(int index);
}