import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class UI {
    static boolean sectionSelected = false;
    static Section selectedSection;
    static ArrayList<EventSeat> selectedSeats;
    static Event event;
    static int labelSize = 25;
    int numSections;
    int seatsPerSection;
    int seatsPerRow;
    int gapBetween = (int) (.5 * labelSize);
    JPanel[] sections;
    JButton addToCartButton;
    static JFrame f;

    UI(int numSections, int seatsPerSection, int seatsPerRow) {
        this.numSections = numSections;
        this.seatsPerSection = seatsPerSection;
        this.seatsPerRow = seatsPerRow;
        sections = new JPanel[4];
        selectedSeats = new ArrayList<>();
        addToCartButton = new JButton("Add To Cart");
        addToCartButton.setBounds(700, 700, 100, 100);
        addToCartButton.setBackground(Color.orange);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(selectedSeats);
                Cart.setCartItems(selectedSeats);
                selectedSeats.clear();
                System.out.println(Cart.getCartItems());
            }
        });

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();


        f = new JFrame("Game Arena System");

//        for (int i = 0; i < numSections; i++) {
//            Section section = new Section(seatsPerSection, seatsPerRow, labelSize, gapBetween, i);
//            section.setLayout(null);
//            section.setBackground(Color.white);
//            sections[i] = section;
//            if (i == 0) {
//                sections[i].setBounds(0, 0, seatsPerRow * labelSize + ((seatsPerRow - 1) * gapBetween), ((int) Math.ceil((double)seatsPerSection / seatsPerRow) * (labelSize + gapBetween) - gapBetween));
//            } else
//                sections[i].setBounds(0, sections[i - 1].getY() + sections[i-1].getHeight() + 100, seatsPerRow * labelSize + ((seatsPerRow - 1) * gapBetween), ((int) Math.ceil((double)seatsPerSection / seatsPerRow) * (labelSize + gapBetween) - gapBetween));
//            f.add(section);
//        }
        f.add(addToCartButton);

        f.setSize((int) size.getWidth(), (int) size.getHeight());
        f.setLayout(null);
        f.setVisible(true);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void hideAllComponents(){
        Component[] comps = f.getContentPane().getComponents();
        for(int i = 0;i < comps.length;i++)
        {
            comps[i].setVisible(false);
            System.out.println(comps[i]);
        }
        f.revalidate();
    }

    // Display homepage components
    public static void homepage(){
        hideAllComponents();
        f.add(GameArenaSystem.eventList);
        f.revalidate();
    }

    public static void eventPage(Event event){
        UI.event = event;
        System.out.println("Event Page");
        f.remove(GameArenaSystem.eventList);
//        hideAllComponents();
        UI.event.initiateSeats(event.numSections);
        for (Section section: event.getSectionsForEvent()) {
            System.out.println(section.sectionID);
            section.setSeatsVisible(true);
            f.add(section);
        }
        f.revalidate();
        f.repaint();
    }
}