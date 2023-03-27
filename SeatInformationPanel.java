import javax.swing.*;
import java.awt.*;

public class SeatInformationPanel extends JPanel {
    int seatID;
    int sectionID;
    double price;
    int rowNum;
    JLabel seatID_label;
    JLabel price_label;
    JLabel rowNum_label;
    int width = 500;
    int height = 500;
    ImageIcon backgroundImage;

    //This is the big shopping cart information when you click on the concert page shows the row number, seatID label, price label
    SeatInformationPanel(){
        this.setBounds(UI.size.width - width, 0, width, height);
        this.setVisible(false);
        backgroundImage = new ImageIcon("shoppingCart2.png");
        this.setOpaque(true);
        seatID_label = new JLabel("Section Number: " + sectionID + "    Seat Number: " + seatID);
        seatID_label.setBounds(170, 100, 500, 100);
        price_label = new JLabel("Price: " + price);
        price_label.setBounds(170, 150, 500, 100);
        rowNum_label = new JLabel("Row Number: " + rowNum);
        rowNum_label.setBounds(170, 200, 500, 100);
        this.add(seatID_label);
        this.add(price_label);
        this.add(rowNum_label);
        this.setLayout(null);
        this.revalidate();
    }

    //Updates all the necessary information
    public void updateInformation(EventSeat seat){
        this.seatID = seat.getSeatID();
        seatID_label.setText(this.seatID+"");
        this.price = seat.getPrice();
        price_label.setText(this.price+"");
        this.rowNum = seat.rowNum;
        rowNum_label.setText(this.rowNum+"");
    }

    //Here, we have overridden the paintComponent method and drawn the background image with the required size and centered it on the panel. We have also modified the updateInformation method to display the section number, seat number, price, and row number in their respective labels
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int imgWidth = backgroundImage.getIconWidth();
        int imgHeight = backgroundImage.getIconHeight();
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        double widthRatio = (double) panelWidth / imgWidth;
        double heightRatio = (double) panelHeight / imgHeight;

        double ratio = Math.min(widthRatio, heightRatio);

        int newWidth = (int) (imgWidth * ratio);
        int newHeight = (int) (imgHeight * ratio);

        int x = (panelWidth - newWidth) / 2;
        int y = (panelHeight - newHeight) / 2;

        g2d.drawImage(backgroundImage.getImage(), x, y, newWidth, newHeight, null);
    }

}
