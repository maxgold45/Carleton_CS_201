/**
 * @author Max
 *
 * @class This class will create a book with different properties including the author,
 *        title, year it was published, and it can include a page length.
 */
public class Book {

    private String author;
    private String title;
    private int pubYear;
    private int pageLength;
    // This is static, because the current year is the same regardless of the book.
    private static int CUR_YEAR = 2017;

    /**
     * Creates a new Book.
     *
     * @param aTitle is the tile of the book given by the user.
     * @param anAuthor is the author of the book given by the user.
     * @param aYear is the published year of the book given by the user.
     */
    public Book(String aTitle, String anAuthor, int aYear) {
        title = aTitle;
        author = anAuthor;
        pubYear = aYear;
    }

    /**
     * Creates a new Book.
     *
     * @param aTitle is the tile of the book given by the user.
     * @param anAuthor is the author of the book given by the user.
     * @param aYear is the published year of the book given by the user.
     * @param aPageLength is the amount of pages in the book.
     */
    public Book(String aTitle, String anAuthor, int aYear, int aPageLength) {
        title = aTitle;
        author = anAuthor;
        pubYear = aYear;
        pageLength = aPageLength;
    }

    /**
     * @return Returns the author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return Returns the year the book was published.
     */
    public int getPubYear() {
        return pubYear;
    }

    /**
     * @return Returns the title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return Returns the current year.
     */
    public static int getCUR_YEAR() {
        return CUR_YEAR;
    }

    /**
     * @return Returns the age of the book.
     */
    public int getAge() {
        return CUR_YEAR - pubYear;
    }

    /**
     * Because page length is optional in the constructor, there are two ways
     * to output the text of the Book.
     * @return Returns a description of the book.
     */
    @Override
    public String toString() {
        if (pageLength == 0) {
            return title + " by " + author + " is " + getAge() + " years old.";
        } else {
            return title + " by " + author + " is " + getAge() + " years old and "
                    + pageLength + " pages long.";
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book emma = new Book("Emma", "Jane Austen", 1815);
        Book pride = new Book("Pride and Prejudice", "Jane Austen", 1813);
        Book potter = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, 341);
        System.out.println(emma);
        System.out.println(pride);
        System.out.println(potter);
    }

}
