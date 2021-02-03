import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PointDraw extends JFrame
{
    private final CanvasPanel drawingPanel = new CanvasPanel();
    private final JPanel mainPanel = new JPanel();


    public PointDraw()
    {
        setTitle("Point Draw");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,700);
        setLocationRelativeTo(null);
    }
    private void init()
    {

        drawingPanel.AllowClick();

        add(drawingPanel);
        setVisible(true);

    }

    class CanvasPanel extends JPanel implements MouseListener
    {
        int[][] dotPos = new int[16][2];
        int dotCount = 0;

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
            if (dotCount == 16)
                dotCount = 0;


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

            for (int i = 0; i < dotCount; i++)
            {
                g2d.setPaint(Color.CYAN);
                g2d.fillOval(dotPos[i][0] - 5,dotPos[i][1] - 5,10,10);

                if(dotCount > 1)
                {
                    g2d.setPaint(Color.GREEN);

                    for (int j = 1; j < dotCount; j++)
                    {
                        g2d.drawLine(dotPos[j][0],dotPos[j][1],dotPos[j-1][0],dotPos[j-1][1]);
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
