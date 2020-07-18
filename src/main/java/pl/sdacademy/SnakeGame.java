package pl.sdacademy;

import java.util.Random;

public class SnakeGame {
    private int xBound;
    private int yBound;
    private Snake snake;
    private Point apple;
    private int points;

    public SnakeGame(int xBound, int yBound, Snake snake) {
        this.xBound = xBound;
        this.yBound = yBound;
        this.snake = snake;
    }


    public SnakeGame(int xBound, int yBound) {
        this(xBound,yBound, new Snake());
    }

    public void start() {
        randomizeApple();
        points = 0;
        while (isSnakeInBound()) {
            System.out.println(this);
            snake.expend();
            if (apple.equals(snake.getHead())) {
                points++;
                randomizeApple();
            } else {
                snake.cutTail();
            }

        }
    }

    private boolean isSnakeInBound() {
        Point head = snake.getHead();
        int headX = head.getX();
        int headY = head.getY();
        return headX >= 0 && headX < xBound &&
                headY >= 0 && headY < yBound;
    }

    private void randomizeApple() {
        Random random = new Random();
        do {
            int appleX = random.nextInt(xBound);
            int appleY = random.nextInt(yBound);
            apple = new Point(appleX, appleY);
        } while (snake.contains(apple));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < yBound; y++) {
            for (int x = 0; x < xBound; x++) {
                Point point = new Point(x, y);
                if (point.equals(apple)) {
                    stringBuilder.append('A');
                } else if (point.equals(snake.getHead())) {
                    stringBuilder.append('H');
                } else if (snake.getBody().contains(point)) {
                    stringBuilder.append('B');
                } else {
                    stringBuilder.append("*");
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
