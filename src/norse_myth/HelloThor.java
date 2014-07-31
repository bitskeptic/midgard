package norse_myth;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

import javax.swing.*;

public class HelloThor {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new HelloThorFrame();
				frame.setTitle("Hello Thor");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

@SuppressWarnings("serial")
class HelloThorComponent extends JComponent {

	public static final int MESSAGE_X = 60;
	public static final int MESSAGE_Y = 100;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g)
	{
		
		Graphics2D g2 = (Graphics2D) g;
		//Rectangle2D rect2d = new Rectangle2D.Double(MESSAGE_X, MESSAGE_Y - 25, 170, 30);
		//g2.draw(rect2d);
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(DEFAULT_WIDTH / 2, DEFAULT_HEIGHT / 2, DEFAULT_WIDTH / 8, DEFAULT_HEIGHT / 8);
		g2.setPaint(Color.YELLOW);
		g2.draw(circle);
		g2.fill(circle);
		g2.setPaint(Color.BLACK);
		Font serifItalic16 = new Font("Serif",Font.ITALIC,14);
		g2.setFont(serifItalic16);
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = serifItalic16.getStringBounds("Not a Hello, Thor program", context);
		
		g2.drawString("Not a Hello, Thor program", MESSAGE_X, MESSAGE_Y);
		//setBackground(Color.GREEN);
		
		
		
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

}

@SuppressWarnings("serial")
class HelloThorFrame extends JFrame {

	public HelloThorFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setLocation(screenWidth / 3, screenHeight / 3);
		add(new HelloThorComponent());
		pack();
	}

}