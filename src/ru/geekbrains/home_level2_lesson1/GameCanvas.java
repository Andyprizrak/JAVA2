package ru.geekbrains.home_level2_lesson1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    MainCircles listener;
    long lastFrameTime;

    BackGround bGC = new BackGround();

    GameCanvas(MainCircles listener) {
        this.listener =listener;
        lastFrameTime = System.nanoTime();
        setBackground(new Color(bGC.Red, bGC.Green,bGC.Blue));
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        bGC.changesColor();
        setBackground(new Color(bGC.Red, bGC.Green,bGC.Blue));
        listener.onCanvasRepainted(this, g,deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }


}
