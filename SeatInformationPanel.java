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

    SeatInformationPanel(){
        this.setBounds(UI.size.width - width, 0, width, height);
        this.setVisible(false);
        this.setBackground(Color.lightGray);
        this.setOpaque(true);
        seatID_label = new JLabel("Section Number: " + sectionID + "    Seat Number: " + seatID);
        seatID_label.setBounds(0, 0, 500, 100);
        price_label = new JLabel("Price: " + price);
        price_label.setBounds(0, 100, 500, 100);
        rowNum_label = new JLabel("Row Number: " + rowNum);
        rowNum_label.setBounds(0, 200, 500, 100);
        this.add(seatID_label);
        this.add(price_label);
        this.add(rowNum_label);
        this.setLayout(null);
        this.revalidate();
    }


    public void updateInformation(EventSeat seat){
        this.seatID = seat.getSeatID();
        seatID_label.setText(this.seatID+"");
        this.price = seat.getPrice();
        price_label.setText(this.price+"");
        this.rowNum = seat.rowNum;
        rowNum_label.setText(this.rowNum+"");
    }
}
