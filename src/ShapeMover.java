import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShapeMover extends JFrame
{
    MoverCanvas moverCanvas = new MoverCanvas();
    JPanel mainPanel = new JPanel();
    JPanel westButtons = new JPanel();
    JPanel eastButtons = new JPanel();

    //Shape choice
    JButton circleButton,rectangleButton;
    //Color choice
    JButton redButton, blueButton, yellowButton;
    private Border BevelBorder;

    Border blackLine = BorderFactory.createLineBorder(Color.black,5);

    public ShapeMover()
    {
        setTitle("Shape Mover");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,500);
        setLocationRelativeTo(null);
        mainPanel.setLayout(new BorderLayout());
        westButtons.setLayout(new BoxLayout(westButtons, BoxLayout.Y_AXIS));
        eastButtons.setLayout(new BoxLayout(eastButtons, BoxLayout.Y_AXIS));

        CreateButtons();
    }
    public void init()
    {
        westButtons.add(circleButton,BorderLayout.CENTER);
        westButtons.add(rectangleButton,BorderLayout.CENTER);

        eastButtons.add(redButton);
        eastButtons.add(blueButton);
        eastButtons.add(yellowButton);

        mainPanel.add(westButtons,BorderLayout.WEST);
        mainPanel.add(eastButtons,BorderLayout.EAST);
        mainPanel.add(moverCanvas, BorderLayout.CENTER);

        moverCanvas.setBorder(blackLine);


        add(mainPanel);
        setVisible(true);
    }

    void CreateButtons()
    {
        circleButton = new JButton("Circle");
        rectangleButton = new JButton("Rectangle");

        redButton = new JButton("Red");
        blueButton = new JButton("Blue");
        yellowButton = new JButton("Yellow");
    }

    public class MoverCanvas extends JComponent implements MouseListener
    {
        public MoverCanvas()
        {

        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

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
        new ShapeMover().init();
    }
}
