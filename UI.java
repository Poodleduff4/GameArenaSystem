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

                JPanel cartPanel = new JPanel();
                cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

                JPanel ticketPanel = new JPanel(new GridLayout(GameArenaSystem.cart.tickets.size() + 1, 1));

                JLabel cartHeader = new JLabel("Cart Contents:");
                ticketPanel.add(cartHeader);

                for (Ticket seat : GameArenaSystem.cart.getCartItems()) {
                    JLabel seatLabel = new JLabel("Seat ID: " + seat.seatID + "\n" + " Row Number: " + seat.rowNum);
                    ticketPanel.add(seatLabel);
                }

                cartPanel.add(ticketPanel);

                JPanel paymentPanel = new JPanel();
                paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));

                JLabel emailLabel = new JLabel("Email:");
                JTextField emailTextField = new JTextField();
                emailTextField.setMaximumSize(new Dimension(200, 20));
                JPanel emailPanel = new JPanel();
                emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
                emailPanel.add(emailLabel);
                emailPanel.add(Box.createRigidArea(new Dimension(10,0)));
                emailPanel.add(emailTextField);
                paymentPanel.add(emailPanel);

                paymentPanel.add(Box.createVerticalStrut(10));

                JLabel paymentLabel = new JLabel("Credit Card Number:");
                JTextField paymentTextField = new JTextField();
                paymentTextField.setMaximumSize(new Dimension(200, 20));
                JPanel payPanel = new JPanel();
                payPanel.setLayout(new BoxLayout(payPanel, BoxLayout.X_AXIS));
                payPanel.add(paymentLabel);
                payPanel.add(Box.createRigidArea(new Dimension(10,0)));
                payPanel.add(paymentTextField);
                paymentPanel.add(payPanel);

                paymentPanel.add(Box.createVerticalStrut(10));

                JLabel securityLabel = new JLabel("CVV:");
                JTextField securityTextField = new JTextField();
                securityTextField.setMaximumSize(new Dimension(200, 20));
                JPanel securityPanel = new JPanel();
                securityPanel.setLayout(new BoxLayout(securityPanel, BoxLayout.X_AXIS));
                securityPanel.add(securityLabel);
                securityPanel.add(Box.createRigidArea(new Dimension(10,0)));
                securityPanel.add(securityTextField);
                paymentPanel.add(securityPanel);

                paymentPanel.add(Box.createVerticalStrut(10));

                JLabel monthLabel = new JLabel("Month (MM):");
                JTextField monthTextField = new JTextField();
                monthTextField.setMaximumSize(new Dimension(200, 20));
                JPanel monthPanel = new JPanel();
                monthPanel.setLayout(new BoxLayout(monthPanel, BoxLayout.X_AXIS));
                monthPanel.add(monthLabel);
                monthPanel.add(Box.createRigidArea(new Dimension(10,0)));
                monthPanel.add(monthTextField);
                paymentPanel.add(monthPanel);

                paymentPanel.add(Box.createVerticalStrut(10));

                JLabel yearLabel = new JLabel("Year (YYYY):");
                JTextField yearTextField = new JTextField();
                yearTextField.setMaximumSize(new Dimension(200, 20));
                JPanel yearPanel = new JPanel();
                yearPanel.setLayout(new BoxLayout(yearPanel, BoxLayout.X_AXIS));
                yearPanel.add(yearLabel);
                yearPanel.add(Box.createRigidArea(new Dimension(10,0)));
                yearPanel.add(yearTextField);
                paymentPanel.add(yearPanel);

                cartPanel.add(paymentPanel);

                JButton finishPurchaseButton = new JButton("Finish Purchase");

                finishPurchaseButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // check if all text fields are not empty
                        Checkout checkout = new Checkout();
                        if (emailTextField.getText().isEmpty() || paymentTextField.getText().isEmpty() ||
                                securityTextField.getText().isEmpty() || monthTextField.getText().isEmpty() ||
                                yearTextField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(cartFrame, "Please fill in all the fields.");
                        } else if (!checkout.verifyEmail(emailTextField.getText())) {
                            JOptionPane.showMessageDialog(cartFrame, "Please enter a valid email address.");
                        } else if (!checkout.verifyPayment((paymentTextField.getText()))) {
                            JOptionPane.showMessageDialog(cartFrame, "Please enter a valid 16-digit card number.");
                        } else if (!checkout.verifyCVV(Integer.parseInt(securityTextField.getText()))) {
                            JOptionPane.showMessageDialog(cartFrame, "Please enter a valid 3-digit security code.");
                        } else if (!checkout.verifyMonth(Integer.parseInt(monthTextField.getText()))) {
                            JOptionPane.showMessageDialog(cartFrame, "Please enter a valid expiration month (MM).");
                        } else if (!checkout.verifyYear(Integer.parseInt(yearTextField.getText()))) {
                            JOptionPane.showMessageDialog(cartFrame, "Please enter a valid expiration year (YYYY).");
                        } else {
                            // complete the purchase
                            JOptionPane.showMessageDialog(cartFrame, "Thank you for your purchase!");
                            cartFrame.dispose();
                            GameArenaSystem.cart.clearCart();
                        }
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
