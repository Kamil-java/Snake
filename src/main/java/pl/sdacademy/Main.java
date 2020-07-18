package pl.sdacademy;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point head = new Point(3,3);
        List<Point> body = Arrays.asList(
                new Point(3,2),
                new Point(3,1),
                new Point(2,1)
        );
        Snake snake = new Snake(body, head, Dir.UP);
        SnakeGame snakeGame = new SnakeGame(10,10, snake);
        snakeGame.start();
    }
}
