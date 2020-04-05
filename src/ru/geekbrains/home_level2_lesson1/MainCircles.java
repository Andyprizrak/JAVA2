package ru.geekbrains.home_level2_lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame  {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int BALL_QUANTITY = 20; // Определяем максимальное колисчество шариков
    private static       int BALL_VISIBLE = 5;   // Количество шариков отображаемых на панели

    Sprite [] sprites = new Sprite[BALL_QUANTITY];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private  MainCircles () {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (BALL_VISIBLE < BALL_QUANTITY) BALL_VISIBLE ++;
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if (BALL_VISIBLE > 0) BALL_VISIBLE --;
                }
            }
        });
        setTitle("Circles");
        initApplication();
        setVisible(true);
    }
    private void initApplication() {
        for (int i = 0; i < BALL_QUANTITY; i++) {
            sprites[i] = new Ball();
        }
    }
    void onCanvasRepainted (GameCanvas canvas, Graphics g, float deltaTime) {
       update(canvas, deltaTime);
       render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
       for (int i = 0; i < BALL_VISIBLE; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < BALL_VISIBLE; i++) {
            sprites[i].render(canvas, g);
        }
    }

}
