package norse_myth;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;



public class HelloMidgard {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new HelloMidgardFrame();
				frame.setTitle("Hello Thor");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

@SuppressWarnings("serial")
class HelloMidgardComponent extends JComponent {

	public static final int MESSAGE_X = 60;
	public static final int MESSAGE_Y = 100;
	public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 400;
	private String message = "";
	
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
		Rectangle2D bounds = serifItalic16.getStringBounds(message, context);
		double x = (getWidth() - bounds.getWidth()) / 2;
		double y = (getHeight() - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		g2.drawString(message, (int) x,(int) baseY);
		//setBackground(Color.GREEN);
		
		
		
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public void setMessage(String m)
	{
		message = m;
	}

}

@SuppressWarnings("serial")
class HelloMidgardFrame extends JFrame {

	private JPanel buttonPanel;
	private HelloMidgardComponent aComponent;
	private JButton prev;
	private JButton next;
	public HelloMidgardFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setLocation(screenWidth / 3, screenHeight / 3);
		prev = new JButton("Previous");
		next = new JButton("Next");
		buttonPanel = new JPanel();
		buttonPanel.add(prev);
		buttonPanel.add(next);
		//aComponent = new HelloMidgardComponent();
		NameAction previousName = new NameAction("PREVIOUS",Color.RED);
		NameAction nextName = new NameAction("NEXT",Color.BLUE);
		prev.addActionListener(previousName);
		next.addActionListener(nextName);
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		//imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow")
		add(buttonPanel);
		//add(aComponent);
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		pack();
	}
	
	class NameAction extends AbstractAction
	{
		private String message = "";
		
		public NameAction(String m, Color c)
		{
			message = m;
			putValue(Action.NAME,message);
			putValue("color", c);
			putValue(Action.SHORT_DESCRIPTION,"This button is " + m + " for " + c);
		}
		
		public void actionPerformed(ActionEvent event)
		{
			Color c = (Color) getValue("color");
			buttonPanel.setBackground(c);
			prev.setText(message + "1");
			next.setText(message + "2");
			pack();
		}
	}

}

