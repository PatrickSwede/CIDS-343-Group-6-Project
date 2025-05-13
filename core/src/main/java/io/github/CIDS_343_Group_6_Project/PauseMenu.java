package io.github.CIDS_343_Group_6_Project;

import javax.swing.*;

public class PauseMenu {
    private static JFrame frame;

    public static void show() {
        if (frame != null && frame.isVisible()) return;

        frame = new JFrame("Game Paused");
        JLabel label = new JLabel("Game is Paused", SwingConstants.CENTER);
        frame.add(label);
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }

    public static void hide() {
        if (frame != null) {
            frame.setVisible(false);
            frame.dispose();
        }
    }
}
