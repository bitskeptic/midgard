package norse_myth;

import java.awt.*;

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

	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g)
	{
		g.drawString("Not a Hello, Thor program", MESSAGE_X, MESSAGE_Y);
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