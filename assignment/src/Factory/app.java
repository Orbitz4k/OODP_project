package Factory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class app extends JPanel {

    private List<Object> shapes = new ArrayList<>();
    private Random random = new Random();

    public app(int i, String shape) {
        setBackground(Color.black);
        setPreferredSize(new Dimension(400, 400));

        switch (shape) {
            case "Circles":
                for (int j = 0; j < i; j++) {
                    addCircle(390, 390);
                }
                break;
            case "Stars":
                for (int j = 0; j < i; j++) {
                    addStar(380, 380);
                }
                break;
            case "Square":
                for (int j = 0; j < i; j++) {
                    addSquare(380, 380);
                }
                break;
            case "Both":
                int mid = i / 2;
                for (int j = 0; j < mid; j++) {
                    addCircle(390, 390);
                }
                for (int j = mid; j < i; j++) {
                    addStar(380, 380);
                }
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            if (s instanceof Circle) {
                ((Circle) s).draw(g);
            } else if (s instanceof Star) {
                ((Star) s).draw(g);
            } else if (s instanceof Square){
                ((Square) s).draw(g);
            }
        }
    }

    public void addCircle(int maxX, int maxY) {
        shapes.add(new Circle(random.nextInt(maxX), random.nextInt(maxY)));
        repaint();
    }

    public void addStar(int maxX, int maxY) {
        shapes.add(new Star(random.nextInt(maxX), random.nextInt(maxY)));
        repaint();
    }
    public void addSquare(int maxX, int maxY) {
        shapes.add(new Square(random.nextInt(maxX), random.nextInt(maxY)));
        repaint();
    }
}