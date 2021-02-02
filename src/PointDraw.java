import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PointDraw extends JFrame
{
    private CanvasPanel drawingPanel = new CanvasPanel();

    public PointDraw()
    {
        setTitle("Point Draw");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,700);
        setLocationRelativeTo(null);
    }
    private void init()
    {
        add(drawingPanel);
        drawingPanel.AllowClick();
        setVisible(true);
    }


    class CanvasPanel extends JPanel implements MouseListener
    {
        int xpos, ypos;
        int[][] dotPos = new int[6][2];
        int dotCount = 1;

        public CanvasPanel() {

        }

        public void AllowClick()
        {
            drawingPanel.addMouseListener(this);
        }


        @Override
        public void mouseClicked(MouseEvent e)
        {

            dotPos[dotCount][0] = e.getX();
            dotPos[dotCount][1] = e.getY();

            dotCount++;
            if (dotCount > 5)
                dotCount = 1;

            repaint();

        }


        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            drawDot(g);

        }

        public void drawDot(Graphics g)
        {
            Graphics2D g2d =  (Graphics2D) g;

            for (int i = 0; i < dotCount-1; i++)
            {

                g2d.setPaint(Color.RED);
                g2d.fillOval(dotPos[i][0] - 10,dotPos[i][1] - 10,20,20);

                if(dotCount >= 10)
                {
                    g2d.setPaint(Color.black);
                    for (int j = 0; j < dotCount; j++)
                    {
                        g2d.drawLine(dotPos[j][0],dotPos[i][1],dotPos[j+1][0],dotPos[j+1][1]);
                    }
                }

            }

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
        new PointDraw().init();

    }
}
