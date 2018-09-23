package vetclinic;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This is a subclass of Pet.java
 * It creates a Dog object and implements Boardable.
 * 
 * @author Zach DiNardo
 * @author Max Goldberg
 */
public class Dog extends Pet implements Boardable {

    private String size;
    private Date start;
    private Date end;

    /**
     * Constructor
     *
     * @param name
     * @param ownerName
     * @param color
     * @param hairLength
     */
    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;

        // We are instantiating start and end.
        this.setBoardStart(0, 0, 0);
        this.setBoardEnd(0, 0, 0);
    }

    /**
     * Accessor method for the Dog's hair length.
     *
     * @return hairLength
     */
    public String getSize() {
        return size;
    }

    /**
     * Overriding the Pet toString method.
     *
     * @return string representation of the object.
     */
    @Override
    public String toString() {
        return "DOG\n" + super.toString() + "\nSize: " + size + "\n";
    }

    /**
     * Sets the start of when the pet is boarding.
     *
     * @param month
     * @param day
     * @param year
     */
    @Override
    public void setBoardStart(int month, int day, int year) {
        start = new GregorianCalendar(year, month - 1, day).getTime();
    }

    /**
     * Sets the end of when the pet is boarding.
     *
     * @param month
     * @param day
     * @param year
     */
    @Override
    public void setBoardEnd(int month, int day, int year) {
        end = new GregorianCalendar(year, month - 1, day).getTime();
    }

    /**
     * Checks if the pet is currently boarding
     *
     * @param month
     * @param day
     * @param year
     * @return a boolean if the pet is boarding.
     */
    @Override
    public boolean boarding(int month, int day, int year) {
        Date currTime = new GregorianCalendar(year, month - 1, day).getTime();
        return start.compareTo(currTime) < 0 && end.compareTo(currTime) > 0;
    }

}
