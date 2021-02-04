import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class ShapeMover extends JFrame implements Mover
{
    MoverCanvas moverCanvas = new MoverCanvas();
    JPanel mainPanel = new JPanel();
    JPanel westButtons = new JPanel();
    JPanel eastButtons = new JPanel();

    ActionListener listener = new ClickListener();

    //Shape choice
    JButton circleButton,rectangleButton;
    //Color choice
    JButton redButton, blueButton, yellowButton;

    JButton reset;


    Shape currentShape;
    Shape defaultShape;
    Color currentColor;

    int posx;
    int posy;
    int shapeChosen;
    Border blackLine = BorderFactory.createLineBorder(Color.black,5);

    public ShapeMover()
    {
        setTitle("Shape Mover");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setLocationRelativeTo(null);
        mainPanel.setLayout(new BorderLayout());
        westButtons.setLayout(new BoxLayout(westButtons, BoxLayout.Y_AXIS));
        eastButtons.setLayout(new BoxLayout(eastButtons, BoxLayout.Y_AXIS));

        CreateButtons();
    }
    public void init()
    {
        defaultShape = new Rectangle(posx,posy,200,100);
        currentShape = defaultShape;
        currentColor = defaultColor;
        circleButton.addActionListener(listener);
        rectangleButton.addActionListener(listener);

        redButton.addActionListener(listener);
        blueButton.addActionListener(listener);
        yellowButton.addActionListener(listener);

        reset.addActionListener(listener);

        westButtons.add(circleButton,BorderLayout.CENTER);
        westButtons.add(rectangleButton,BorderLayout.CENTER);

        eastButtons.add(redButton);
        eastButtons.add(blueButton);
        eastButtons.add(yellowButton);

        mainPanel.add(westButtons,BorderLayout.WEST);
        mainPanel.add(eastButtons,BorderLayout.EAST);
        mainPanel.add(moverCanvas, BorderLayout.CENTER);
        mainPanel.add(reset,BorderLayout.SOUTH);

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

        reset = new JButton("Reset");
    }



    public class MoverCanvas extends JPanel implements MouseListener
    {
        public MoverCanvas() { addMouseListener(this);}

        private ArrayList<Shape> shapes = new ArrayList<>();

        private ArrayList<Color> colors = new ArrayList<>();

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            drawShapes(g);
        }

        private void drawShapes(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;

            for (int i = 0; i < shapes.size(); i++)
            {
                Shape shape = shapes.get(i);
                Color color = colors.get(i);

                g2d.setPaint(color);
                g2d.fill(shape);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {
            posx = e.getX();
            posy = e.getY();


            if (shapeChosen == 1)
            {
                rectangleSelect();
            }
            else if (shapeChosen == 2)
            {
                circleSelect();
            }
            shapes.add(currentShape);
            colors.add(currentColor);
            repaint();
        }

        void rectangleSelect()
        {
            currentShape = new Rectangle(posx - 100,posy - 50,200,100);

        }

        void circleSelect()
        {
            currentShape = new Ellipse2D.Double(posx - 50,posy -25,100,50);
        }

        void clear()
        {
            shapes.clear();
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

        public void redSelect()
        {
            currentColor = Color.red;
        }

        public void blueSelect()
        {
            currentColor = Color.BLUE;
        }

        public void yellowSelect()
        {
            currentColor = Color.YELLOW;
        }
    }
    class ClickListener implements ActionListener
    {

        MoverCanvas moverCanvas = new MoverCanvas();
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == circleButton)
            {
                shapeChosen = 2;
            }
            else if(e.getSource() == rectangleButton)
            {
                shapeChosen = 1;
            }
            else if(e.getSource() == redButton)
            {
                moverCanvas.redSelect();
            }
            else if(e.getSource() == blueButton)
            {
                moverCanvas.blueSelect();
            }
            else if (e.getSource() == yellowButton)
            {
                moverCanvas.yellowSelect();
            }
            else if(e.getSource() == reset)
            {
                moverCanvas.clear();
            }

        }
    }

    public static void main(String[] args)
    {
        new ShapeMover().init();
    }
}
