package io.github.CIDS_343_Group_6_Project;

public class PauseManager {
    private static boolean paused = false;

    public static boolean isPaused() {
        return paused;
    }

    public static void togglePause() {
        paused = !paused;
        if (paused) {
            PauseMenu.show();
        } else {
            PauseMenu.hide();
        }
        System.out.println(paused ? "Game Paused" : "Game Resumed");
    }

    public static void setPaused(boolean state) {
        paused = state;
    }
}
