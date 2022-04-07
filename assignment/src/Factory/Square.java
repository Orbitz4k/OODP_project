package Factory;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Square {

    int x, y, width, height;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double square = new Ellipse2D.Double(x, y, 10, 10);

        g2d.setColor(Color.red);
        g2d.fill(square);
    }

}
