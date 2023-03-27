import javax.swing.*;
import java.awt.*;

public class KendrickStagePanel extends JPanel{
    JLabel kendrick_stage_label;

    KendrickStagePanel() {
        this.setBounds(60, 625, 600, 30);
        this.setVisible(false);
        this.setBackground(Color.yellow);
        this.setOpaque(true);
        kendrick_stage_label = new JLabel("STAGE");
        kendrick_stage_label.setBounds(290, 0, 900, 30);
        this.add(kendrick_stage_label);
        this.setLayout(null);
    }
}
