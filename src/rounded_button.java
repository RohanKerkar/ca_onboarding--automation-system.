package CA_project_2;

import javax.swing.*;
import java.awt.*;

class rounded_button extends JButton {
    private int radius;

    public rounded_button(String text, int radius) {
        super(text);
        this.radius = radius;
        setOpaque(false); // Needed to paint custom background
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Draw the button text
        super.paintComponent(g);
        g2.dispose();
    }
}
