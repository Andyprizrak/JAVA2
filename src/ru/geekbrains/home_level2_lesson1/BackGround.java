package ru.geekbrains.home_level2_lesson1;

public class BackGround {
    protected int Red = 123,
                  Green = 130,
                  Blue = 150,
                  // Минимальный интервал времени, через которое обновиться цвет
                  timeChangesColor = 3;
    private long lastFrameTime = System.nanoTime();

    public void changesColor () {
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        if (deltaTime > timeChangesColor ) {
            lastFrameTime = currentTime;
            Red   = (int) (Math.random() * 255);
            Green = (int) (Math.random() * 255);
            Blue  = (int) (Math.random() * 255);
        }
    }
}
