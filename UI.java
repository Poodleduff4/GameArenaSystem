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
    static JButton addToCartButton;
    static JFrame f;
    static SeatInformationPanel seatInformationPanel;
    static JButton homepageButton;
    static Dimension size;


    UI(int numSections, int seatsPerSection, int seatsPerRow) {
        this.numSections = numSections;
        this.seatsPerSection = seatsPerSection;
        this.seatsPerRow = seatsPerRow;
        sections = new JPanel[4];
        selectedSeats = new ArrayList<>();

        size = Toolkit.getDefaultToolkit().getScreenSize();

        seatInformationPanel = new SeatInformationPanel();
        homepageButton = new JButton("Homepage");
        homepageButton.setBounds((int)(size.getWidth()-100), (int)(size.getHeight()-200), 100, 100);
        homepageButton.setBackground(Color.pink);
//        homepageButton.setVisible(false);
        homepageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepage();
            }
        });

        addToCartButton = new JButton("Add To Cart");
        addToCartButton.setBounds(700, 700, 100, 100);
        addToCartButton.setBackground(Color.orange);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cart.setCartItems(selectedSeats);
                selectedSeats.clear();
                System.out.println(Cart.getCartItems());
            }
        });


        f = new JFrame("Game Arena System");

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
            f.remove(comps[i]);
        }
        f.revalidate();
        f.repaint();
    }

    // Display homepage components
    public static void homepage(){
        System.out.println("Homepage");
        hideAllComponents();
        f.add(GameArenaSystem.eventList);
        Component[] comps = f.getContentPane().getComponents();
        f.revalidate();
    }

    public static void eventPage(Event event){
        UI.event = event;
        System.out.println("Event Page");
        hideAllComponents();
//        f.remove(GameArenaSystem.eventList);
        f.add(seatInformationPanel);
        f.add(addToCartButton);
        f.add(homepageButton);
        seatInformationPanel.setVisible(true);
        addToCartButton.setVisible(true);
        homepageButton.setVisible(true);
        UI.event.initiateSeats(event.numSections);
        for (Section section: event.getSectionsForEvent()) {
            section.setSeatsVisible(true);
            section.revalidate();
            section.repaint();
            f.add(section);
            f.revalidate();
            f.repaint();
        }
    }

    public static void updateSeatInformationPanel(EventSeat seat){
        seatInformationPanel.seatID = seat.getSeatID();
        seatInformationPanel.sectionID = seat.sectionID;
        seatInformationPanel.seatID_label.setText("Section Number: " + seatInformationPanel.sectionID + "   Seat Number: " + seatInformationPanel.seatID);
        seatInformationPanel.price = seat.getPrice();
        seatInformationPanel.price_label.setText("Price: " + seatInformationPanel.price);
        seatInformationPanel.rowNum = seat.rowNum;
        seatInformationPanel.rowNum_label.setText("Row Number: " + seatInformationPanel.rowNum);
    }
}