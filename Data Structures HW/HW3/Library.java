/**
 * This class creates a library for holding books.
 *
 * @author Max
 */
public class Library {

    /**
     * This method is static because it looks at all books, not just the current library.
     *
     * @param lib is the current Library.
     * @return This returns the oldest book in the library.
     */
    public static Book oldestBook(Book[] lib) {
        // I create a placeholder variable with the youngest age possible.
        Book oldest = new Book(null, null, Book.getCUR_YEAR());
        for (Book i: lib) {
            if (oldest.getAge() < i.getAge()) {
                oldest = i;
            }
        }
        return oldest;
    }

    public static void main(String[] args) {
        Book[] lib = new Book[3];
        lib[0] = new Book("Emma", "Jane Austen", 1815);
        lib[1] = new Book("Pride and Prejudice", "Jane Austen", 1813);
        lib[2] = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, 341);

        // Loop through the books to print them out.
        System.out.println("My library contains the following books:");
        for (Book i: lib) {
            System.out.println(i);
        }

        System.out.println("\nThe oldest book in the library is: " + oldestBook(lib).getTitle() + ".");
    }

}
