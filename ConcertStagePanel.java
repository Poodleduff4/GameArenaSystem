import javax.swing.*;
import java.awt.*;

public class ConcertStagePanel extends JPanel {
    JLabel concert_stage_label;



    ConcertStagePanel(){
        this.setBounds(80, 600, 600, 50);
        this.setVisible(false);
        this.setBackground(Color.yellow);
        this.setOpaque(true);
        concert_stage_label = new JLabel("STAGE");
        concert_stage_label.setBounds(290, 0, 600, 50);
        this.add(concert_stage_label);
        this.setLayout(null);
    }
}

