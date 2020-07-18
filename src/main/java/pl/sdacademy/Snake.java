package pl.sdacademy;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Snake {
    private List<Point> body;
    private Point head;
    private Dir dir;

    public Snake() {
        this(Collections.<Point>emptyList(), new Point(0, 0), Dir.RIGHT);
    }

    public List<Point> getBody() {
        return body;
    }

    public Point getHead() {
        return head;
    }

    public Snake(List<Point> body, Point head, Dir dir) {
        this.body = body;
        this.head = head;
        this.dir = dir;
    }


    public void cutTail() {
        body.remove(body.size() - 1);
    }

    public void expend() {
        body.add(0, head);
        switch (dir) {
            case UP:
                head = new Point(head.getX(), head.getY() - 1);
                break;
            case DOWN:
                head = new Point(head.getX(), head.getY() + 1);
                break;
            case LEFT:
                head = new Point(head.getX() - 1, head.getY());
                break;
            case RIGHT:
                head = new Point(head.getX() + 1, head.getY());
                break;
        }

    }

    @Override
    public String toString() {
        return "Snake{" +
                "body=" + body +
                ", head=" + head +
                '}';
    }

    public boolean contains(Point apple) {
        return head.equals(apple) || body.contains(apple);
    }
}
