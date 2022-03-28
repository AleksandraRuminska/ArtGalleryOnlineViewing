package tourist;

import art.Museum;
import art.MuseumRoom;
import art.Painting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * @author: Aleksandra Rumińska 179953
 * @version: 2
 */

/**
 *
 */
public class Tourist {
    private String fullName;
    private String nationality;
    private int age;

    /**
     *
     * @param fullName
     * @param nationality
     * @param age
     */
    public Tourist(String fullName, String nationality, int age) {
        this.fullName = fullName;
        this.nationality = nationality;
        this.age = age;
    }

    /**
     *
     * @return
     */
    public String getFullName() {
        return fullName;
    }

    /**
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     *
     * @return
     */
    public String getNationality() {
        return nationality;
    }

    /**
     *
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @param museum
     * @param i
     * @param button
     * @param buyerButton
     */
    public void lookAtPaintings(Museum museum, int[]i, JButton button, JButton buyerButton){
        museum.getFrame().setVisible(false);
        museum.getFrame().dispose();
        JFrame frame = new JFrame();
        museum.setFrame(frame);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        JTextArea txtArea = new JTextArea("Title: " + museum.getCollection().get(i[0]).getTitle() + "\n Author: " + museum.getCollection().get(i[0]).getArtist() + "\n Style: " + museum.getCollection().get(i[0]).getArtStyle() + "\n Paint: " + museum.getCollection().get(i[0]).getTypeOfPaint()+ "\n Price: " + museum.getCollection().get(i[0]).getPrice());

        JLabel image = new JLabel(new ImageIcon(museum.getCollection().get(i[0]).getPathToPainting()));
        museum.getFrame().add(image, BorderLayout.CENTER);
        museum.getFrame().add(txtArea, BorderLayout.EAST);
        museum.getFrame().setSize(1000, 800);
        museum.getFrame().setVisible(true);
        museum.getFrame().add(button, BorderLayout.AFTER_LAST_LINE);
        if(buyerButton != null){
            JPanel subBottom = new JPanel();
            subBottom.add(button);
            subBottom.add(buyerButton);
            museum.getFrame().add(subBottom, BorderLayout.PAGE_END);
        }


    }

    /**
     *
     * @param museum
     * @param buyer
     */
    public void sightsee(Museum museum, Buyer buyer) {
        System.out.println("Welcome " + this.getFullName() + " on our tour over " + museum.getName() +"! Let's start!\n");

        final int[] i = {0};
        if (museum.getCollection().get(i[0]).isInRestoration()) {
            System.out.println("Painting " + museum.getCollection().get(i[0]).getTitle() + " is in restoration!\n");
        } else {
            JButton buyerButton = new JButton("Buy");
            JButton button = new JButton("Next");

            button.addActionListener(new ActionListener() {

                /**
                 *
                 * @param e
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    i[0]++;

                    if (i[0] >= museum.getCollection().size()) {
                        museum.getFrame().dispose();
                        System.exit(0);
                    } else {
                        if (museum.getCollection().get(i[0]).isInRestoration()) {
                            System.out.println("Painting " + museum.getCollection().get(i[0]).getTitle() + " is in restoration!\n");
                        } else {
                            if(buyer != null) {
                                lookAtPaintings(museum, i, button, buyerButton);
                            } else {
                                lookAtPaintings(museum, i, button, null);
                            }
                        }

                    }

                }
            });

            if(buyer != null){
                buyerButton.addActionListener(new ActionListener() {
                    /**
                     *
                     * @param e
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        i[0]++;
                        if (museum.getCollection().get(i[0]).isInRestoration()) {
                            System.out.println("Painting " + museum.getCollection().get(i[0]).getTitle() + " is in restoration!\n");
                        } else {
                            buyer.buyPainting(museum.getCollection().get(i[0]), museum);
                            lookAtPaintings(museum, i, button, buyerButton);
                        }

                    }
                });

                lookAtPaintings(museum, i, button, buyerButton);

            } else{
                lookAtPaintings(museum, i, button, null);

            }

        }
    }

    /**
     *
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String [] args) throws CloneNotSupportedException {
        Museum museum = new Museum("Sample Name");
        MuseumRoom galleryA = new MuseumRoom("GalleryA", 1);
        MuseumRoom galleryB = new MuseumRoom("GalleryB", 2);
        MuseumRoom galleryC = new MuseumRoom("GalleryC", 3);

        ArrayList<Painting> paintingCollection = new ArrayList<Painting>();
        Painting painting = new Painting("Title1", "J.S. Vender","surrealism", Painting.PaintType.OIL, 25000, "./src/main/resources/painting2.jpg", galleryA);
        Painting painting1 = new Painting("Title2", "A.M. Guill","surrealism", Painting.PaintType.OIL, 70000, "./src/main/resources/painting3.jpg", galleryA);
        Painting painting2 = new Painting("Title3", "El Greco","surrealism", Painting.PaintType.OIL, 300000, "./src/main/resources/painting2.jpg", galleryC);
        Painting painting3 = new Painting("Title4", "Unknown","surrealism", Painting.PaintType.OIL, 1200098, "./src/main/resources/painting3.jpg", galleryB);
        paintingCollection.add(painting);
        paintingCollection.add(painting1);
        paintingCollection.add(painting2);
        paintingCollection.add(painting3);


//        Painting p1Cloned = (Painting) painting.clone();
//        p1Cloned.getRoom().setNameAndNumber("Gift Shop", 18);
//
//        System.out.println(painting.getRoom().getName());
//        System.out.println(p1Cloned.getRoom().getName());

        museum.setCollection(paintingCollection);

        Collections.sort(museum.getCollection());
        museum.getCollection().get(3).restoration();

        System.out.println("Welcome to the " + museum.getName() +"! What's your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("How old are you?");
        while(!scanner.hasNextInt()) {
            scanner.next();
        }

        int age = scanner.nextInt();


        System.out.println("What's your nationality?");
        String nationality = scanner.next();

        String visitorType;
        if (age > 18) {
            System.out.println("Are you a regular visitor interested in buying a painting? If a visitor, write - visitor, if buyer, write - buyer");
            visitorType = scanner.next();
        } else {
            visitorType = "visitor";

        }

        Buyer buy1 = null;
        switch(visitorType) {
            case "visitor":
                Tourist t1 = new Tourist(name, nationality, age);
                museum.getVisitors().add(t1);
                museum.addVisitors();
                break;
            case "buyer":
                System.out.println("What is your budget?");
                while(!scanner.hasNextDouble()) {
                    scanner.next();
                }
                double budget = scanner.nextDouble();
                buy1 = new Buyer(name, nationality, age, budget);
                museum.getVisitors().add(buy1);
                museum.addVisitors();
                if(museum.getBuyers() == null){
                    ArrayList<Buyer> buyers= new ArrayList<>();
                    buyers.add(buy1);
                    museum.setBuyers(buyers);
                } else{
                    museum.getBuyers().add(buy1);
                }
                break;
            default:
                System.out.println("You entered incorrect value. You are considered as regular visitor.");
                Tourist t2 = new Tourist(name, nationality, age);
                museum.getVisitors().add(t2);
                museum.addVisitors();
                break;
        }

        if(museum.getVisitorsNumber() < Museum.getLimit()) {
            for(int i = 0; i < museum.getVisitors().size(); i++){
                if(museum.getVisitors().get(i).getFullName().equals(name) && museum.getVisitors().get(i).getNationality().equals(nationality)
                && museum.getVisitors().get(i).getAge() == age){

                    if(visitorType.equals("buyer")){
                        museum.getVisitors().get(i).sightsee(museum, buy1);
                    } else {
                        museum.getVisitors().get(i).sightsee(museum, null);
                    }
                    
                    //museum.setVisitorsNumber(museum.getVisitorsNumber() - 1);
                }
            }

        } else {
            System.out.println("You can't visit museum now. The limit of visitors is achieved.");
        }

    }

}


// collection types?
// one more enum?
// comparator?
// javadoc