package art;

/**
 * @author: Aleksandra Rumińska 179953
 * @version: 1
 */


/**
 * Museum Room class
 */
public class MuseumRoom implements Cloneable {
    private String name;
    private int number;

    /**
     * Constructor of the MuseumRoom class with all parameters
     *
     * @param name - name of the room in the museum
     * @param number - number of the room in the museum
     */
    public MuseumRoom(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /**
     * Constructor of the MuseumRoom class with name parameter
     *
     * @param name - name of the room in the museum
     */
    public MuseumRoom(String name) {
        this.name = name;
    }

    /**
     * Getter retrieving the name of the room
     *
     * @return - returns name of the room as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter setting the value of the original Painting
     *
     * @param name - the value to be set as the room's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter retrieving the number of the room
     *
     * @return - returns the number of the room as an int
     */
    public int getNumber() {
        return number;
    }

    /**
     * Setter setting the value of the MuseumRoom number
     *
     * @param number - the value to be set as the room's number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Method setting the name and number of the room at once
     *
     * @param name - the value to be set as the room's name
     * @param number - the value to be set as the room's number
     */
    public void setNameAndNumber(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /**
     * Method cloning the object - overriden from Object class
     *
     * @return - returns cloned Object
     * @throws CloneNotSupportedException - exception of failed cloning
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
