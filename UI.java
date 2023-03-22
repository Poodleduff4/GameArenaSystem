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
    static JMenuBar menuBar;


    UI(int numSections, int seatsPerSection, int seatsPerRow) {
        this.numSections = numSections;
        this.seatsPerSection = seatsPerSection;
        this.seatsPerRow = seatsPerRow;
        sections = new JPanel[4];
        selectedSeats = new ArrayList<>();
        menuBar  = new JMenuBar();

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
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameArenaSystem.cart.addItemsToCart(selectedSeats);
                selectedSeats.clear();
            }
        });

        f = new JFrame("Game Arena System");

        f.setJMenuBar(menuBar);

        JMenu homeMenu = new JMenu("Home");
        menuBar.add(homeMenu);
        JMenuItem homeItem = new JMenuItem("Homepage");
        homeMenu.add(homeItem);
        homeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepage();
            }
        });

        JMenu cartMenu = new JMenu("Cart");
        JMenuItem viewCartMenuItem = new JMenuItem("View Cart");
        JMenuItem checkoutMenuItem = new JMenuItem("Checkout");
        cartMenu.add(viewCartMenuItem);
        cartMenu.add(checkoutMenuItem);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(cartMenu);

        viewCartMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCart();
            }
        });

        checkoutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cartFrame = new JFrame("Cart");

                JPanel cartPanel = new JPanel(new GridLayout(selectedSeats.size() + 1, 2));

                JLabel cartHeader = new JLabel("Cart Contents:");

                cartPanel.add(cartHeader);

                for (Ticket seat : GameArenaSystem.cart.getCartItems()) {
                    JLabel seatLabel = new JLabel("" + seat.seatID);
                    cartPanel.add(seatLabel);
                }

                JButton finishPurchaseButton = new JButton("Finish Purchase");

                finishPurchaseButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //This doesn't lead anywhere just finishes
                        JOptionPane.showMessageDialog(cartFrame, "Thank you for your purchase!");
                        cartFrame.dispose();
                    }
                });

                cartPanel.add(finishPurchaseButton);

                cartFrame.add(cartPanel);

                cartFrame.setSize(400, 400);
                cartFrame.setVisible(true);
            }
        });

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
        f.repaint();
    }

    public static void eventPage(Event event){
        UI.event = event;
        System.out.println("Event Page");
        hideAllComponents();
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
        }
        f.revalidate();
        f.repaint();
    }

    public void viewCart(){
        hideAllComponents();
        f.add(GameArenaSystem.cart);


        f.revalidate();
        f.repaint();
        Component[] comps = f.getContentPane().getComponents();
        for(int i = 0;i < comps.length;i++)
        {
            System.out.println(comps[i]);
            Component[] childs = ((Cart)comps[i]).getComponents();
            for (int j = 0; j < childs.length; j++) {
                System.out.println(childs[j]);
            }
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