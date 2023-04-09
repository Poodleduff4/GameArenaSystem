import javax.swing.*;
import java.awt.*;

public class EsportsStagePanel extends JPanel {
    JLabel esports_stage_label;
    int width = 750;
    int height = 50;

    EsportsStagePanel() {
        this.setBounds(80, 425, width, height);
        this.setVisible(false);
        this.setBackground(Color.yellow);
        this.setOpaque(true);
        esports_stage_label = new JLabel("STAGE");
        esports_stage_label.setBounds(360, 0, 800, 50);
        this.add(esports_stage_label);
        this.setLayout(null);
    }
}
