import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI implements ActionListener {
    static boolean sectionSelected = false;
    int numSections;
    int seatsPerSection;
    int seatsPerRow;
    int labelSize = 25;
    int gapBetween = (int) (.5 * labelSize);
    JPanel[] sections;
    JFrame f;

    UI(int numSections, int seatsPerSection, int seatsPerRow) {
        this.numSections = numSections;
        this.seatsPerSection = seatsPerSection;
        this.seatsPerRow = seatsPerRow;
        sections = new JPanel[4];

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();


        f = new JFrame("Game Arena System");

        for (int i = 0; i < numSections; i++) {
            Section section = new Section(seatsPerSection, seatsPerRow, labelSize, gapBetween);
            section.setLayout(null);
            section.setBackground(Color.white);
            sections[i] = section;
            if (i == 0) {
                sections[i].setBounds(0, 0, seatsPerRow * labelSize + ((seatsPerRow - 1) * gapBetween), ((int) Math.ceil(seatsPerSection / seatsPerRow) * (labelSize + gapBetween) - gapBetween));
            } else
                sections[i].setBounds(0, sections[i - 1].getY() + sections[i-1].getHeight() + 100, seatsPerRow * labelSize + ((seatsPerRow - 1) * gapBetween), ((int) Math.ceil(seatsPerSection / seatsPerRow) * (labelSize + gapBetween) - gapBetween));
            f.add(section);
        }

        f.setSize((int) size.getWidth(), (int) size.getHeight());
        f.setLayout(null);
        f.setVisible(true);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

    }

}