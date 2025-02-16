import java.util.List;
import java.util.ArrayList;

public class Photo {

    // Attributes for the photo
    private int length;  // length in pixels
    private int widthInPixels;  // width in pixels
    private int dpi;  // DPI (dots per inch)
    private String description;  // description of the photo
    private List<String> personsOnPicture;  // list of persons on the picture

    // Constructor
    public Photo(int length, int widthInPixels, int dpi, String description) {
        this.length = length;
        this.widthInPixels = widthInPixels;
        this.dpi = dpi;
        this.description = description;
        this.personsOnPicture = new ArrayList<>();  // Initialize the list of persons
    }

    // Method to add a person to the photo
    public void addPersonToPicture(String person) {
        this.personsOnPicture.add(person);
    }

    // Method to check if the photo can be printed
    public boolean canBePrinted() {
        // Check if the DPI is greater than or equal to 150 and the dimensions are at least 585x878 pixels
        if (this.dpi >= 150 && this.length >= 585 && this.widthInPixels >= 878) {
            return true;
        }
        return false;
    }

    // Method to check if the photo is a group photo
    public boolean isGroupPhoto() {
        // A group photo is when there are more than 2 persons on the picture
        return this.personsOnPicture.size() > 2;
    }

    // Method to display the photo information
    public void displayPhotoInfo() {
        System.out.println("Description: " + this.description);
        System.out.println("Dimensions: " + this.length + "x" + this.widthInPixels + " pixels");
        System.out.println("DPI: " + this.dpi);
        System.out.println("Persons on picture: " + this.personsOnPicture);
        System.out.println("Can be printed: " + canBePrinted());
        System.out.println("Is it a group photo? " + (isGroupPhoto() ? "Yes" : "No"));
    }

    // Main method to test the Photo class
    public static void main(String[] args) {
        // Create a photo object
        Photo photo = new Photo(600, 900, 150, "Family vacation at the beach");

        // Add people to the photo
        photo.addPersonToPicture("John");
        photo.addPersonToPicture("Jane");
        photo.addPersonToPicture("Tom");

        // Display the photo info
        photo.displayPhotoInfo();

        // Create another photo object (not a group photo)
        Photo anotherPhoto = new Photo(1000, 1200, 300, "Business conference");

        // Add people to the second photo
        anotherPhoto.addPersonToPicture("Alice");

        // Display the second photo info
        anotherPhoto.displayPhotoInfo();
    }
}
