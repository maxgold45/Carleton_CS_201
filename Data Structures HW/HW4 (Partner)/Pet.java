package vetclinic;

/**
 * This is a parent class to Cat and Dog.
 * 
 * @author Max Goldberg
 * @author Zach DiNardo
 * 
 */
public class Pet {

    private String petName;
    private String ownerName;
    private String color;
    private int sex;
    
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;
    public static final int OTHER = 4;

    /**
     * Constructor
     * 
     * @param name
     * @param ownerName
     * @param color 
     */
    public Pet(String name, String ownerName, String color) {
        petName = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    /**
     * Accessor method for the pet's name.
     * 
     * @return  petName
     */
    public String getPetName() {
        return petName;
    }

    /**
     * Accessor method for the owner's name.
     * 
     * @return ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Accessor method for the pet's color.
     * 
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the sex to the sexID.
     * 
     * @param sexID 
     */
    public void setSex(int sexID) {
        sex = sexID;
    }

    /**
     * Accessor method for the pet's sex.
     * 
     * @return sex
     */
    public String getSex() {
        switch (sex) {
            case MALE:
                return "male";
            case FEMALE:
                return "female";
            case SPAYED:
                return "spayed";
            case NEUTERED:
                return "neutered";
            default:
                return "other";
        }
    }

    /**
     * Method to return the string.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return petName + " owned by " + ownerName + 
                "\nColor: " + color + 
                "\nSex: " + getSex();
    }
    

}

