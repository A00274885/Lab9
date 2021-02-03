import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class ShapeDraw extends JFrame
{
    ShapeCanvas shapeCanvas = new ShapeCanvas();
    public ShapeDraw()
    {
        setTitle("Shape Drawer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
    }
    public void init()
    {
        shapeCanvas.AllowClick();
        add(shapeCanvas);
        setVisible(true);
    }

    class ShapeCanvas extends JPanel implements MouseListener
    {
        int mouseX;
        int mouseY;

        int height;
        int width;

        Random random = new Random();
        public ShapeCanvas() {

        }

        public void AllowClick()
        {
            shapeCanvas.addMouseListener(this);
        }
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            drawShape(g);
        }

        private void drawShape(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;
            int randomShape = (int)(Math.random() * 4);
            switch (randomShape)
            {
                case 0:
                    g2d.fillRect(mouseX - width/2,mouseY - height/2 ,width,height);
                case 1:
                    g2d.fillOval(mouseX - width/2,mouseY - height/2,width,height);
                case 2:
                    g2d.fillArc(mouseX - width/2,mouseY - height/2,width,height,100,200);
                case 3:
                    g2d.fillRoundRect(mouseX - width/2,mouseY - height/2,width,height,50,50);
            }
        }


        @Override
        public void mouseClicked(MouseEvent e)
        {

            mouseX = e.getX();
            mouseY = e.getY();

            height = (int)(Math.random() * 300);
            width = (int)(Math.random() * 300);
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


    public static void main(String[] args)
    {
        new ShapeDraw().init();

    }
}
