import javax.swing.*;
import java.awt.*;

public class DrakeStagePanel extends JPanel{
    JLabel drake_stage_label;


    DrakeStagePanel() {
        this.setBounds(65, 355, 600, 40);
        this.setVisible(false);
        this.setBackground(Color.yellow);
        this.setOpaque(true);
        drake_stage_label = new JLabel("STAGE");
        drake_stage_label.setBounds(280, 0, 800, 40);
        this.add(drake_stage_label);
        this.setLayout(null);
    }
}
