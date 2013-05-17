/**
 * 
 */
package org.jeverything.stater;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jeverything.dummy.ui.factory.DummyUIFactory;
import org.jeverything.ui.frame.ApplicationFrame;

/**
 * Stater class for application
 * 
 * @author wangyinqing
 *
 */
public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new Starter().startup();
			}
		});
	}
	
	private Starter(){
		
	}
	
	private void startup(){
		ApplicationFrame appFrame = new ApplicationFrame();
		appFrame.setSize(800, 600);
		appFrame.setVisible(true);
		DummyUIFactory.getFactory().construct(appFrame);
		appFrame.setTitle("JEverything");
		appFrame.setLocation(300, 100);
		appFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	

}
