package vetclinic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A VetClinic object can hold several Boardable objects. These objects can be boarding for a
 * certain amount of time.
 *
 * @author Zach DiNardo
 * @author Max
 */
public class VetClinic {

    private Boardable[] pets;

    /**
     * Constructor
     *
     * @param inputFile
     * @throws FileNotFoundException
     */
    public VetClinic(String inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(inputFile));
        int numOfPets = scanner.nextInt();
        scanner.nextLine();

        // Instantiating pets.
        pets = new Boardable[numOfPets];

        // Loop through file and add objects to pets[].
        for (int i = 0; i < numOfPets; i++) {
            String next = scanner.next();

            // The useDelimiter method parses the String as a regex.
            // This allows it to use 2 delimeters.
            scanner.useDelimiter(",|\\n");
            if (next.equals("CAT")) {
                String name = scanner.next();
                String ownerName = scanner.next();
                String hairColor = scanner.next();
                int sex = scanner.nextInt();
                String hairLength = scanner.next();

                // Create a new Cat with the above parameters.
                pets[i] = new Cat(name, ownerName, hairColor, hairLength);
                ((Cat) pets[i]).setSex(sex);

            } else if (next.equals("DOG")) {
                String name = scanner.next();
                String ownerName = scanner.next();
                String hairColor = scanner.next();
                int sex = scanner.nextInt();
                String size = scanner.next();

                // Create a new Dog with the above parameters.
                pets[i] = new Dog(name, ownerName, hairColor, size);
                ((Dog) pets[i]).setSex(sex);
            }
            // Check to make sure there is another line before calling scanner.nextLine()
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }
    
    /**
     * Returns an array of Boardable[].
     * 
     * @return pets
     */
    public Boardable[] getAllPets() {
        return pets;
    }

    /**
     * Prints out all of the currently boarding Pets to System.out
     * 
     * @param month
     * @param day
     * @param year 
     */
    public void printAllBoarding(int month, int day, int year) {
        for (Boardable pet: pets) {
            if (pet.boarding(month, day, year)) {
                System.out.println(pet.toString());
            }
        }
    }

    /**
     * Prints out all of the Pets currently owned by the parameter owner.
     * 
     * @param owner 
     */
    public void printAllOwnedBy(String owner) {
        for (Boardable pet: pets) {

            if ((((Pet) pet).getOwnerName()).equals(owner)) {
                System.out.println(pet.toString());
            }
        }
    }
}
