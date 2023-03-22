import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class UI {
    static boolean sectionSelected = false;
    static Section selectedSection;
    static ArrayList<EventSeat> selectedSeats;
    int numSections;
    int seatsPerSection;
    int seatsPerRow;
    int labelSize = 25;
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

        JMenuBar menuBar = new JMenuBar();

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

        for (int i = 0; i < numSections; i++) {
            Section section = new Section(seatsPerSection, seatsPerRow, labelSize, gapBetween, i);
            section.setLayout(null);
            section.setBackground(Color.white);
            sections[i] = section;
            if (i == 0) {
                sections[i].setBounds(0, 0, seatsPerRow * labelSize + ((seatsPerRow - 1) * gapBetween), ((int) Math.ceil((double)seatsPerSection / seatsPerRow) * (labelSize + gapBetween) - gapBetween));
            } else
                sections[i].setBounds(0, sections[i - 1].getY() + sections[i-1].getHeight() + 100, seatsPerRow * labelSize + ((seatsPerRow - 1) * gapBetween), ((int) Math.ceil((double)seatsPerSection / seatsPerRow) * (labelSize + gapBetween) - gapBetween));
            f.add(section);
        }
        f.add(addToCartButton);

        f.setSize((int) size.getWidth(), (int) size.getHeight());
        f.setLayout(null);
        f.setVisible(true);




        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void hideAllComponents(){
        for (Component component:
        f.getComponents()){
            component.setVisible(false);
        }
    }

    // Display homepage components
    public static void homepage(){
        hideAllComponents();
        
    }
}