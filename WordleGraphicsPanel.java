package Wordle;

import java.awt.*;
import javax.swing.*;

public class WordleGraphicsPanel extends JPanel {
    private int darkGreenCount;
    private int lightGreenCount;

    public WordleGraphicsPanel() {
        setPreferredSize(new Dimension(400, 100));
        darkGreenCount = 0;
        lightGreenCount = 0;
    }

    public void updateGraphics(int result) {
        darkGreenCount = result / 10;
        lightGreenCount = result % 10;
        repaint();
    }

    public void reset() {
        darkGreenCount = 0;
        lightGreenCount = 0;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        int darkGreenBoxSize = (int) (width / 5.0) - 10;
        int lightGreenBoxSize = darkGreenBoxSize;

        g.setColor(Color.GREEN.darker());
        for (int i = 0; i < darkGreenCount; i++) {
            int x = i * (darkGreenBoxSize + 10);
            int y = height / 2 - darkGreenBoxSize / 2;
            g.fillRect(x, y, darkGreenBoxSize, darkGreenBoxSize);
        }

        g.setColor(Color.GREEN);
        for (int i = 0; i < lightGreenCount; i++) {
            int x = i * (lightGreenBoxSize + 10);
            int y = height / 2 + darkGreenBoxSize / 2 + 10;
            g.drawRect(x, y, lightGreenBoxSize, lightGreenBoxSize);
        }

        if (darkGreenCount == 5) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            String winMessage = "GEWONNEN!";
            FontMetrics fm = g.getFontMetrics();
            int winMessageWidth = fm.stringWidth(winMessage);
            int winMessageHeight = fm.getHeight();
            int winMessageX = width / 2 - winMessageWidth / 2;
            int winMessageY = height / 2 + lightGreenBoxSize + winMessageHeight + 20;
            g.drawString(winMessage, winMessageX, winMessageY);
        }
    }
}

