package tourist;
import art.Museum;
import art.Painting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: Aleksandra Rumińska 179953
 * @version: 2
 */

/**
 * Buyer class that extends the Tourist class
 */

public class Buyer extends Tourist{
    protected double money;
    private ArrayList<Painting> boughtPaintings;

    /**
     * Constructor for Buyer class with fullName, nationality, age and money arguments
     *
     * @param fullName - full name of the buyer
     * @param nationality - nationality of the buyer
     * @param age - age of the buyer
     * @param money - budget of the buyer
     */
    public Buyer(String fullName, String nationality, int age, double money) {
        super(fullName, nationality, age);
        this.money = money;
    }

    /**
     * Method checking if buyer can afford to buy a piece of art
     *
     * @param price - value of the price of a piece of art
     * @return - returns if the price is smaller than the buyer's budget
     */
    public boolean checkEnoughMoney(double price){
        return this.money > price;
    }

    /**
     * Method that adds the bought painting to buyer's collection and removing it from museum
     *
     * @param painting - painting that the buyer wants to buy
     * @param museum - museum from which the buyer wants to buy a painting
     */
    public void buyPainting(Painting painting, Museum museum){
        if(!painting.isInRestoration()) {
            if (checkEnoughMoney(painting.getPrice())) {
                if (this.boughtPaintings == null) {
                    this.boughtPaintings = new ArrayList<Painting>();
                }
                this.boughtPaintings.add(painting);
                Collections.sort(this.boughtPaintings);
                museum.sellPaintings(painting);
                System.out.println("You successfully bought the painting called: " + painting.getTitle() + " by: " + painting.getArtist() +"\n");
            } else {
                System.out.println("You don't have enough money to buy the painting!\n");
            }
        } else {
            System.out.println("You can't buy this painting! It's currently in restoration.\n");
        }
    }

    /**
     * Method to search for the painting in buyer's collection
     *
     * @param painting - painting which is to be searched in buyer's paintings
     * @return - returns the found painting or null if it wasn't found
     */
    public Painting findPainting(Painting painting){
        for(Painting p : this.boughtPaintings){
            if(p == painting){
                return p;
            }
        }
        return null;
    }

    /**
     * Method to remove the painting from buyer's collection and add it to the museum
     *
     * @param painting - painting that the buyer wants to return
     * @param museum - museum to which the buyer wants to return the painting
     */
    public void returnPainting(Painting painting, Museum museum){
       if(findPainting(painting) != null){
           museum.showPaintings(painting);
           this.boughtPaintings.remove(painting);
       } else {
           throw new Error("You don't have such a painting, so you can't return it");
       }
    }

}
