package art;

/**
 * @author: Aleksandra Rumińska 179953
 * @version: 2
 */

/**
 * Painting class that extends the PieceOfArt abstract class and implements the Comparable interface and Cloneable interface
 */

public class Painting extends PieceOfArt implements Comparable<Painting>, Cloneable {
    private String artStyle;
    private PaintType typeOfPaint;
    private String pathToPainting;
    private MuseumRoom room;


    public enum PaintType{
        OIL,
        ACRYLIC,
        WATERCOLOR,
        GOAUCHE,
        ENCAUSTIC,
        PASTEL,
        MIXED;
    }


    /**
     * Constructor of the Painting class with parameters:
     * @param title - title of the painting
     * @param century - the century in which the painting was created
     * @param typeOfPaint - paint used to create the painting
     * @param artist - artist that created the painting
     * @param artStyle - style in which the painting was created
     * @param price - price of the painting
     * @param pathToPainting - path to load the photo of a painting
     * @param room - room in the museum when the painting is located
     */
    public Painting(String title, String century, PaintType typeOfPaint, String artist, String artStyle, double price, String pathToPainting, MuseumRoom room) {
        super(title, century, artist, price);
        this.artStyle = artStyle;
        this.typeOfPaint = typeOfPaint;
        this.pathToPainting = pathToPainting;
        this.room = room;
    }

    /**
     * Constructor of the Painting class with parameters:
     *
     * @param artStyle - style in which the painting was created
     * @param typeOfPaint - paint used to create the painting
     * @param price - price of the painting
     * @param pathToPainting - path to load the photo of a painting
     * @param room - room in the museum when the painting is located
     */
    public Painting(String artStyle, PaintType typeOfPaint, double price, String pathToPainting, MuseumRoom room) {
        super(price);
        this.artStyle = artStyle;
        this.typeOfPaint = typeOfPaint;
        this.pathToPainting = pathToPainting;
        this.room = room;

    }

    /**
     * Constructor of the Painting class with parameters:
     *
     * @param title - title of the painting
     * @param artist - artist that created the painting
     * @param artStyle - style in which the painting was created
     * @param typeOfPaint - paint used to create the painting
     * @param price - price of the painting
     * @param pathToPainting - path to load the photo of a painting
     * @param room - room in the museum when the painting is located
     */
    public Painting(String title, String artist, String artStyle, PaintType typeOfPaint, double price, String pathToPainting, MuseumRoom room) {
        super(title, artist, price);
        this.artStyle = artStyle;
        this.typeOfPaint = typeOfPaint;
        this.pathToPainting = pathToPainting;
        this.room = room;
    }

    /**
     * Getter retrieving the value of the title
     *
     * @return - returns title of the painting as a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter retrieving the value of the style of the art of the painting
     *
     * @return - returns the style of the art as a String
     */
    public String getArtStyle() {
        return artStyle;
    }

    /**
     * Setter setting the value of the painting's title
     *
     * @param title - string value of title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter setting the value of the painting's style
     *
     * @param artStyle - value of the art style to be set
     */
    public void setArtStyle(String artStyle) {
        this.artStyle = artStyle;
    }

    /**
     * Getter retrieving the value of the paint's type
     *
     * @return - returns the type of paint as a PaintType enum value
     */
    public PaintType getTypeOfPaint() {
        return typeOfPaint;
    }

    /**
     * Setter setting the value of the type of the paint of the painting
     *
     * @param typeOfPaint - value of the paint type to be set
     */
    public void setTypeOfPaint(PaintType typeOfPaint) {
        this.typeOfPaint = typeOfPaint;
    }

    /**
     * Method setting the value to be in restoration - overriden from the abstract class PiecePfArt
     *
     */
    @Override
    public void restoration() {
        this.setInRestoration(true);
    }

    /**
     * Method setting the value to not be in restoration and printing the information - overriden from the abstract class PiecePfArt
     *
     */
    @Override
    public void returnRestored(){
        if(this.isInRestoration()){
            this.setInRestoration(false);
            System.out.println("Come see the restored painting: " + this.getTitle() + " by: " +this.getArtist() + "\n");
        }
    }

    /**
     * Getter retrieving the path to the picture of a painting
     *
     * @return - returns the path to the painting's photo as a String
     */
    public String getPathToPainting() {
        return pathToPainting;
    }

    /**
     * Setter setting the value of the path to the painting's picture
     *
     * @param pathToPainting - path to be set as a path to the picture of the painting
     */
    public void setPathToPainting(String pathToPainting) {
        this.pathToPainting = pathToPainting;
    }

    /**
     * Getter retrieving the value of room in which the painting is located
     *
     * @return - returns the room as a MuseumRoom object
     */
    public MuseumRoom getRoom() {
        return room;
    }

    /**
     *
     *
     * @param room
     */
    public void setRoom(MuseumRoom room) {
        this.room = room;
    }


    /**
     * Method to compare two Painting objects by their authors - overriden from Comparable interface
     *
     * @param o1 - the Painting object to which the current object is to be compared
     * @return - returns
     */
    @Override
    public int compareTo(Painting o1) {
        return this.getArtist().compareTo(o1.getArtist());
    }

    /**
     * Method makiing deep cloning of the object - overriden from Object class
     *
     * @return - returns cloned Object
     * @throws CloneNotSupportedException - exception of failed cloning
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Painting cloned = (Painting) super.clone();
        cloned.setRoom((MuseumRoom) cloned.getRoom().clone());
        return cloned;
    }

}
