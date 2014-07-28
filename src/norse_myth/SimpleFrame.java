package norse_myth;

import javax.swing.*;
import java.awt.*;

public class SimpleFrame {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				SFrame frame = new SFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});

	}

}

@SuppressWarnings("serial")
class SFrame extends JFrame
{
	//private static final int DEFAULT_WIDTH = 600;
	//private static final int DEFAULT_HEIGHT = 200;
	
	public SFrame()
	{	
		setTitle("this is a new frame for midgard");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);
		//setLocationByPlatform(true);
	}
}