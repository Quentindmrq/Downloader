package downloader.fc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutionException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import downloader.ui.Download;
import downloader.ui.StackLayout;

public class Test {
	
	public static void addURL(JToolBar toolbar, JFrame jf) {
		JTextField textField = new JTextField("enter an URL");

		JButton ecrire = new JButton(new AbstractAction("add") {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ecrire, textField);
		toolbar.add(split);
		toolbar.setVisible(true);
		
	}
	
	public static void main(String argv[]) {
		
		JFrame jf = new JFrame("Downloader");
		jf.setPreferredSize(new Dimension(400, 300));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pan = new JPanel(new StackLayout());
		
		JToolBar toolBar = new JToolBar("options");
		pan.add(toolBar, BorderLayout.NORTH);
		addURL(toolBar, jf);
		
		
		jf.add(pan);
		jf.pack();
		jf.setVisible(true);
		

		
		for(String url: argv) {
			Downloader downloader;
			
			try {
				downloader = new Downloader(url);
			}
			catch(RuntimeException e) {
				System.err.format("skipping %s %s\n", url, e);
				continue;
			}
			Download dl = new Download(downloader);
			
			System.out.format("Downloading %s:", downloader);
			pan.add(dl, BorderLayout.NORTH);
			downloader.addPropertyChangeListener(dl);
			jf.add(pan);
			jf.pack();
			
			String filename = "test";
			
			new Thread(new Runnable() {
			    public void run() {
			        downloader.execute();
			    }
			}).start();

			/*try {
				filename = (String) downloader.get();
			}
			catch(InterruptedException e) {
				System.err.println("failed!");
				continue;
			} catch (ExecutionException e) {
				System.err.println("failed!");
				continue;
			}*/
			System.out.format("into %s\n", filename);
		}
	}
}
