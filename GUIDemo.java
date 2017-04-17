import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;

/**
 * Minimal Java Swing application.
 * 
 * @author Nathan Sprague
 * 
 */
public class GUIDemo extends JFrame
{
    private JPanel panel;
    private JButton biggerButton;
    private JButton smallerButton;
	private JButton randomColorButton;
	private JButton newTitleButton;
    /**
     * Set up the application.
     */
    public GUIDemo()
    {
	// CONSTRUCTOR NEEDS TO BE FINISHED!
		setTitle("Bigger/Smaller");
		setSize(200, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		biggerButton = new JButton("BIGGER");
		smallerButton= new JButton("SMALLER");
		randomColorButton = new JButton("RANDOM COLOR");
		newTitleButton = new JButton("new title");
		biggerButton.addActionListener(new ButtonHandler());
		smallerButton.addActionListener(new ButtonHandler());
		randomColorButton.addActionListener(new ButtonHandler());
		newTitleButton.addActionListener(new ButtonHandler());
		add(panel);
		panel.add(biggerButton);
		panel.add(smallerButton);
		panel.add(randomColorButton);
		panel.add(newTitleButton);
		setVisible(true);
    }

    /**
     * This inner class exists to handle button events. There are other ways
     * this could have been done:
     * 
     * 1. GUIDemo could implement ActionListener itself. 
     * 2. Anonymous inner classes could be used to hand the events.
     */
    private class ButtonHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            Dimension size = getSize();
			Graphics g = getGraphics();
            if (e.getSource().equals(biggerButton))
            {
                setSize(size.width + 10, size.height + 10);
            }
            else if(e.getSource().equals(smallerButton))
            {
                setSize(size.width - 10, size.height - 10);
            }
			else if(e.getSource().equals(newTitleButton))
			{
				setTitle("this is a different title");
			}
			else
			{
				g.setColor(new Color((int)(Math.random()* 255),(int) (Math.random() * 255),(int) (Math.random() * 255)));
				g.fillRect(0, 0,(int)size.getWidth(), (int)size.getHeight());
			}

        }
    }

    /**
     * Start the app by creating a GUIDemo object.
     */
    public static void main(String[] args)
    {
        GUIDemo app = new GUIDemo();
    }
}
