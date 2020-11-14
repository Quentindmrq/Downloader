package downloader.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Main extends JFrame{
	
	Main(String title, String[] expressions) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pan = new JPanel(new BorderLayout());
		
		
		this.add(pan);
		this.pack();
		
		}

}
