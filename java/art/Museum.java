package art;

import tourist.Buyer;
import tourist.Tourist;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author: Aleksandra Rumińska 179953
 * @version: 2
 */

/**
 *
 */
public class Museum {
    private final String name;
    private ArrayList<Painting> collection;
    public static final int limit = 1000;
    public int visitorsNumber;
    private ArrayList<Tourist> visitors;
    private JPanel panel= new JPanel();
    private JFrame frame=new JFrame();
    private ArrayList<Buyer> buyers;
    private ArrayList<MuseumRoom> rooms;

    /**
     *
     * @param name
     * @param collection
     */
    public Museum(String name, ArrayList<Painting> collection) {
        this.name = name;
        this.collection = collection;
        JPanel m= new JPanel(new BorderLayout(100, 100));
        JFrame f=new JFrame();
        this.visitors = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    /**
     *
     * @param name
     */
    public Museum(String name) {
        this.name = name;
        this.panel= new JPanel();
        this.frame =new JFrame();
        this.visitors = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public ArrayList<Painting> getCollection() {
        return collection;
    }

    /**
     *
     * @param collection
     */
    public void setCollection(ArrayList<Painting> collection) {
        this.collection = collection;
    }

    /**
     *
     * @param painting
     * @return
     */
    public Painting findPainting(Painting painting){
        for(Painting p : this.collection){
            if(p == painting){
                return p;
            }
        }
        return null;
    }

    /**
     *
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Museum museum = new Museum("Sample Name");
        MuseumRoom galleryA = new MuseumRoom("GalleryA", 1);
        MuseumRoom galleryB = new MuseumRoom("GalleryB", 2);
        MuseumRoom galleryC = new MuseumRoom("GalleryC", 3);

        Painting p1 = new Painting("Title", "Artist", "ArtStyle", Painting.PaintType.OIL, 890000, "./src/main/resources/painting2.jpg", galleryA);
        Painting p2 = new Painting("Title2", "Artist2", "ArtStyle2", Painting.PaintType.OIL, 12000, "./src/main/resources/painting3.jpg", galleryC);
        Painting p3 = new Painting("Title3", "Artist3", "ArtStyle3", Painting.PaintType.OIL, 2300, "./src/main/resources/painting2.jpg", galleryA);
        Painting p4 = new Painting("Title4", "Artist4", "ArtStyle4", Painting.PaintType.OIL, 1234567, "./src/main/resources/painting3.jpg", galleryB);

        Painting p1Cloned = (Painting) p1.clone();
        p1Cloned.getRoom().setNameAndNumber("Gift Shop", 18);

        System.out.println(p1.getRoom().getName());
        System.out.println(p1Cloned.getRoom().getName());

        Reproduction reproductionP1 = new Reproduction(p1Cloned, "John Smith", 54.95);
        // print reproduction or sth

        museum.showPaintings(p1);
        museum.showPaintings(p2);
        museum.showPaintings(p3);
        museum.showPaintings(p4);
        museum.sellPaintings(p4);

    }

    /**
     *
     * @param painting
     */
    public void showPaintings(Painting painting){
        System.out.println("New painting " +painting.getTitle() + " by: "+ painting.getArtist() + " has been added to museum collection");
        if (this.collection == null) {
            this.collection = new ArrayList<>();
        }
        this.collection.add(painting);
    }

    /**
     *
     * @param painting
     */
    public void sellPaintings(Painting painting){
        if(this.findPainting(painting)!= null){
            System.out.println("Painting " +painting.getTitle() + " by: "+ painting.getArtist() + " is no longer available to view in the museum.");
            this.collection.remove(painting);

        }else {
            System.out.println("Painting " +painting.getTitle() + " by: "+ painting.getArtist() + " is not in the museum, so it cannot be sold.");

        }
    }

    /**
     *
     * @return
     */
    public int getVisitorsNumber() {
        return visitorsNumber;
    }

    /**
     *
     * @return
     */
    public static int getLimit() {
        return limit;
    }

    /**
     *
     */
    public void addVisitors() {
        this.visitorsNumber += 1;
    }

    /**
     *
     * @return
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     *
     * @param panel
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     *
     * @param frame
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    /**
     *
     * @param visitors
     */
    public void setVisitors(ArrayList<Tourist> visitors) {
        this.visitors = visitors;
    }

    /**
     *
     * @return
     */
    public ArrayList<Tourist> getVisitors() {
        return visitors;
    }

    /**
     *
     * @param visitorsNumber
     */
    public void setVisitorsNumber(int visitorsNumber) {
        this.visitorsNumber = visitorsNumber;
    }

    /**
     *
     * @return
     */
    public ArrayList<Buyer> getBuyers() {
        return buyers;
    }

    /**
     *
     * @param buyers
     */
    public void setBuyers(ArrayList<Buyer> buyers) {
        this.buyers = buyers;
    }

    /**
     *
     * @return
     */
    public ArrayList<MuseumRoom> getRooms() {
        return rooms;
    }

    /**
     *
     * @param rooms
     */
    public void setRooms(ArrayList<MuseumRoom> rooms) {
        this.rooms = rooms;
    }
}
