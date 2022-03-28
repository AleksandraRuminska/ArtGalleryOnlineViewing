package art;

/**
 * @author: Aleksandra Rumińska 179953
 * @version: 2
 */

/**
 * Abstract class PieceOfArt
 */

public abstract class PieceOfArt {
    protected String title;
    private String century;
    private String artist;
    private final double price;
    private boolean inRestoration;

    /**
     * Constructor of PieceOfArt class with all parameters.
     *
     * @param title - title of the piece of art
     * @param century - century when the piece of art was created in the form of a String e.g. "XVI"
     * @param artist - artist who created the piece
     * @param price - price of the piece
     */

    public PieceOfArt(String title, String century, String artist, double price) {
        this.title = title;
        this.century = century;
        this.artist = artist;
        this.inRestoration = false;
        this.price = price;
    }

    /**
     * Constructor of PieceOfArt class with parameters price and inRestoration
     *
     * @param price - price of the piece
     */
    public PieceOfArt(double price) {
        this.price = price;
        this.inRestoration = false;

    }

    /**
     * Constructor of PieceOfArt class with parameters title, artist, price and inRestoration
     *
     * @param title - title of the piece of art
     * @param artist - artist who created the piece
     * @param price - price of the piece
     */
    public PieceOfArt(String title, String artist, double price) {
        this.title = title;
        this.artist = artist;
        this.inRestoration = false;
        this.price = price;

    }

    /**
     * Getter retrieving the value of century
     *
     * @return - returns century as a String
     */
    public String getCentury() {
        return century;
    }


    /**
     * Setter setting the value of century
     *
     * @param century - String value of century to be set
     */
    public void setCentury(String century) {
        this.century = century;
    }

    /**
     * Abstract class restoration.
     */
    public abstract void restoration();

    /**
     * Abstract class returnRestored.
     */
    public abstract void returnRestored();


    /**
     * Getter retrieving the value of artist
     *
     * @return - returns artist name as String
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Setter setting the value of artist
     *
     * @param artist - string value of artist name to be set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }


    /**
     * Getter retrieving the value of a price
     *
     * @return - returns price of the piece as a double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter retrieving the value of title
     *
     * @return - returns title of the piece as a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter setting the value of title
     *
     * @param title - string value of title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method checking if piece is being restored
     *
     * @return - returns true if piece is being restored and false if not
     */
    public boolean isInRestoration() {
        return inRestoration;
    }

    /**
     * Setter setting the restoration state of the piece of art
     *
     * @param inRestoration - boolean value of inRestoration to be set
     */
    public void setInRestoration(boolean inRestoration) {
        this.inRestoration = inRestoration;
    }
}
