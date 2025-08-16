package CA_project_2;
import java.awt.*;
import javax.swing.*;
class rounded_panel extends JPanel {
    private int cornerRadius;

    public rounded_panel(int radius) {
        this.cornerRadius = radius;
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
    }
}

