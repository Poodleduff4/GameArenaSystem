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
    static EsportsStagePanel esportsStagePanel;
    static ConcertStagePanel concertStagePanel;
    static KendrickStagePanel kendrickStagePanel;
    static DrakeStagePanel drakeStagePanel;
    static Dimension size;
    static JMenuBar menuBar;
    static CheckoutWindow checkoutWindow;


    UI(int numSections, int seatsPerSection, int seatsPerRow) {
        this.numSections = numSections;
        this.seatsPerSection = seatsPerSection;
        this.seatsPerRow = seatsPerRow;
        sections = new JPanel[4];
        selectedSeats = new ArrayList<>();
        menuBar  = new JMenuBar();

        // variable for screen size
        size = Toolkit.getDefaultToolkit().getScreenSize();

        // panels to represent the stages for the events
        drakeStagePanel = new DrakeStagePanel();
        kendrickStagePanel = new KendrickStagePanel();
        esportsStagePanel = new EsportsStagePanel();
        concertStagePanel = new ConcertStagePanel();
        seatInformationPanel = new SeatInformationPanel();

        // button for adding items to the cart
        addToCartButton = new JButton("Add To Cart");
        addToCartButton.setBounds(700, 700, 200, 100);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add all the selected seats to the cart
                GameArenaSystem.cart.addItemsToCart(selectedSeats);
                for (EventSeat seat :
                        selectedSeats) {
                    seat.selected = false;
                }
                selectedSeats.clear();

            }
        });

        //Gives our homepage a name at the top
        f = new JFrame("Game Arena System");

        //Makes a menu bar for the homepage, checkout and view cart
        f.setJMenuBar(menuBar);

        //Creates the homepage button
        JMenu homeMenu = new JMenu("Home");
        menuBar.add(homeMenu);
        JMenuItem homeItem = new JMenuItem("Homepage");
        homeMenu.add(homeItem);
        //Adds an action listener when clicking on the homepage button and sends you back to the homepage
        homeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepage();
            }
        });

        //Creates a cart menu option offering a view of your cart and your checkout window
        JMenu cartMenu = new JMenu("Cart");
        JMenuItem viewCartMenuItem = new JMenuItem("View Cart");
        JMenuItem checkoutMenuItem = new JMenuItem("Checkout");
        cartMenu.add(viewCartMenuItem);
        cartMenu.add(checkoutMenuItem);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(cartMenu);

        //Adds an action listener to the view cart option and calls the method necessary
        viewCartMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCart();
            }

        });

        //If checkout is clicked this will lead to the checkout window method
        checkoutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkoutWindow = new CheckoutWindow();
            }
        });

        f.setSize((int) size.getWidth(), (int) size.getHeight());
        f.setLayout(null);
        f.setVisible(true);

        //Closes the window
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Removes all the components on the homepage, does not delete them but gets rid of their view
    public static void hideAllComponents(){
        // get all components on the screen
        Component[] comps = f.getContentPane().getComponents();
        for(int i = 0;i < comps.length;i++)
        {
            // remove component from the screen
            f.remove(comps[i]);
        }
        f.revalidate();
        f.repaint();
    }

    // Display homepage components
    public static void homepage(){
        System.out.println("Homepage");
        // clear screen before adding homepage components
        hideAllComponents();
        f.add(GameArenaSystem.eventList);
        for (EventSeat seat :
                selectedSeats) {
            seat.selected = false;
            seat.setBackground(Color.black);
        }
        selectedSeats.clear();

        //STADIUM MINI (BOTTOM-LEFT)
        Component[] comps = f.getContentPane().getComponents();
        ImageIcon topIcon = new ImageIcon("TD-Allianz-Arena-Cropped2.jpg");
        JLabel topLabel = new JLabel(topIcon);
        topLabel.setBounds(0, 450, 500, 300);
        f.getContentPane().add(topLabel);

        //Ticket Sensei Logo
        ImageIcon topSensei = new ImageIcon("TicketSensei.jpg");
        JLabel topLabelSensei = new JLabel(topSensei);
        topLabelSensei.setBounds(550, -200, 800, 800);
        f.getContentPane().add(topLabelSensei);

        //Concert Pic
        ImageIcon topConcert = new ImageIcon("Concert2.jpeg");
        JLabel topLabelConcert = new JLabel(topConcert);
        topLabelConcert.setBounds(490, 480, 500, 250);
        f.getContentPane().add(topLabelConcert);

        //Esports Pic
        ImageIcon topEsport = new ImageIcon("OWLan2.jpg");
        JLabel topLabelEsport = new JLabel(topEsport);
        topLabelEsport.setBounds(1000, 480, 500, 250);
        f.getContentPane().add(topLabelEsport);

        // Create the black panel for the bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.black);
        bottomPanel.setBounds(0, (int)f.getSize().getHeight()-200, (int)f.getSize().getWidth(), 300);
        f.getContentPane().add(bottomPanel);

        f.revalidate();
        f.repaint();
    }

    public static void eventPage(Event event){
        UI.event = event;
        System.out.println("Event Page");
        hideAllComponents();

        // add the stages
        if (event.eventID == 3){
            f.add(drakeStagePanel);
        }
        if (event.eventID == 2){
            f.add(kendrickStagePanel);
        }
        if (event.eventID == 1){
            f.add(esportsStagePanel);
        }
        if (event.eventID == 0){
            f.add(concertStagePanel);
        }
        f.add(seatInformationPanel);
        f.add(addToCartButton);

        drakeStagePanel.setVisible(true);
        kendrickStagePanel.setVisible(true);
        esportsStagePanel.setVisible(true);
        concertStagePanel.setVisible(true);
        seatInformationPanel.setVisible(true);
        addToCartButton.setVisible(true);
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
    }

    public void checkout(){

    }

    public static void updateSeatInformationPanel(EventSeat seat){
        // update information for hovered seat
        seatInformationPanel.seatID = seat.getSeatID();
        seatInformationPanel.sectionID = seat.sectionID;
        seatInformationPanel.seatID_label.setText("Section Number: " + seatInformationPanel.sectionID + "   Seat Number: " + seatInformationPanel.seatID);
        seatInformationPanel.price = seat.getPrice();
        seatInformationPanel.price_label.setText("Price: " + seatInformationPanel.price + "0");
        seatInformationPanel.rowNum = seat.rowNum;
        seatInformationPanel.rowNum_label.setText("Row Number: " + seatInformationPanel.rowNum);
    }
}
