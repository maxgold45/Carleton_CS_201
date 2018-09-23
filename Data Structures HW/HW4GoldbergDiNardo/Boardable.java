package vetclinic;

/**
 * Allows something to be Boardable.
 *
 * @author Max Goldberg
 * @author Zach DiNardo
 */
public interface Boardable {

    /**
     * Sets the start of when an object is boarding.
     *
     * @param month
     * @param day
     * @param year
     */
    public void setBoardStart(int month, int day, int year);

    /**
     * Sets the end of when an object is boarding.
     *
     * @param month
     * @param day
     * @param year
     */
    public void setBoardEnd(int month, int day, int year);

    /**
     * Checks if the object is currently boarding
     *
     * @param month
     * @param day
     * @param year
     * @return a boolean if the pet is boarding.
     */
    public boolean boarding(int month, int day, int year);
}
