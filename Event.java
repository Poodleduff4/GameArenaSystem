import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Event extends JLabel {
    int eventID;
    String eventName;
    String eventDesc;
    String eventDate;
    String eventType;
    Section[] sections;
    int numSeats;
    int numSections;
    int seatsPerRow;
//    DateTimeFormatter dateTimeFormatter; = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    Event(String eventName, String eventDesc, String eventDate, String eventType, int numSections, int numSeats, int seatsPerRow, int eventID){
//        dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.numSections = numSections;
        this.numSeats = numSeats;
        this.seatsPerRow = seatsPerRow;
        this.sections = new Section[numSections];
        this.eventID = eventID;
        this.setPreferredSize(new Dimension(500, 200));

        //Setting all the tickets to a background image
        ImageIcon icon = new ImageIcon("EventTickets.png");
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(500, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        this.setIcon(resizedIcon);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setText("<html><center><font color='black'>" + eventName + "<br>" + eventDate + "<br>" + eventDesc + "</font></center></html>");
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVisible(true);

        this.setOpaque(true);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UI.eventPage(Event.this);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void initiateSeats(int numSections){
        if (this.sections[0] == null){
            for (int i = 0; i < numSections; i++) {
                Section section = new Section(numSeats, seatsPerRow, UI.labelSize, (int)(.5*UI.labelSize), i, eventID);
                section.setLayout(null);
                section.setBackground(Color.white);
                sections[i] = section;
            }
        }
    }
    public String getEventByType(){
        return "";
    }

    public String getEventDetails(){
        return eventDesc + '\n' + eventDate + '\n' + eventType;
    }

    public Section[] getSectionsForEvent(){
        return sections;
    }


}
