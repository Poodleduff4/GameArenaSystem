import javax.swing.*;
import java.awt.*;

public class ConcertStagePanel extends JPanel {
    JLabel concert_stage_label;



    ConcertStagePanel(){
        this.setBounds(380, 25, 50, 530);
        this.setVisible(false);
        this.setBackground(Color.yellow);
        this.setOpaque(true);
        concert_stage_label = new JLabel("STAGE");
        concert_stage_label.setBounds(5, 0, 800, 530);
        this.add(concert_stage_label);
        this.setLayout(null);
    }
}

