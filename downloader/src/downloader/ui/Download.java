package downloader.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

import downloader.fc.Downloader;

public class Download extends JProgressBar implements PropertyChangeListener{
	private Downloader dl;

	public Download(Downloader dl) {
		//super(0, dl.getContent_length());
		super();
		this.dl = dl;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equals(evt.getPropertyName())) {
            this.setValue((Integer)evt.getNewValue());
        }
		//this.setString(evt.getNewValue().toString() + "%");
	}
	
	
	//this.setValue(0);
	//this.setStringPainted(true);
	
}
