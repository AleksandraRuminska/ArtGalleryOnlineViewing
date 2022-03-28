package art;

/**
 * @author: Aleksandra Rumińska 179953
 * @version: 2
 */


/**
 * Reproduction class - class containing the copy of a painting from the museum
 */
public class Reproduction {
    private Painting sourcePainting;
    private String reproductionAuthor;
    private double reproductionPrice;

    /**
     * Constructor for Reproduction class with all arguments
     *
     * @param sourcePainting - the original painting of which reproduction was made
     * @param reproductionAuthor - the full name of the author of the reproduction
     * @param price - price of the reproduction
     */
    public Reproduction(Painting sourcePainting, String reproductionAuthor, double price) {
        this.sourcePainting = sourcePainting;
        this.reproductionAuthor = reproductionAuthor;
        this.reproductionPrice = price;
    }

    /**
     * Getter retrieving the original Painting
     *
     * @return - returns painting as a Painting object
     */
    public Painting getSourcePainting() {
        return sourcePainting;
    }

    /**
     * Setter setting the value of the original Painting
     *
     * @param sourcePainting - the original Painting object to be set as original Painting
     */
    public void setSourcePainting(Painting sourcePainting) {
        this.sourcePainting = sourcePainting;
    }

    /**
     * Getter retrieving the value of the reproduction's author
     *
     * @return - returns full name of the author of the reproduction
     */
    public String getReproductionAuthor() {
        return reproductionAuthor;
    }

    /**
     * Setter setting the value of the reproduction's author
     *
     * @param reproductionAuthor - the value to be set as the reproduction author's
     */
    public void setReproductionAuthor(String reproductionAuthor) {
        this.reproductionAuthor = reproductionAuthor;
    }

    /**
     * Getter retrieving the reproduction's price
     *
     * @return - the price of the reproduction as a double
     */
    public double getReproductionPrice() {
        return reproductionPrice;
    }

    /**
     * Setter setting the value of the reproduction's price
     *
     * @param reproductionPrice - value of the price to be set
     */
    public void setReproductionPrice(double reproductionPrice) {
        this.reproductionPrice = reproductionPrice;
    }

}
