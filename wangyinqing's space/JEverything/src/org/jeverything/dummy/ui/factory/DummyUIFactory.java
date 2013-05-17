package org.jeverything.dummy.ui.factory;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jeverything.data.UserHomeDataProvider;
import org.jeverything.dummy.ui.table.DummyFileTable;
import org.jeverything.dummy.ui.table.DummyFileTableModel;

/**
 * @author wangyinqing
 *
 */
public class DummyUIFactory {
	
	/**
	 * @author wangyinqing
	 *
	 */
	private static class Holder{
		static DummyUIFactory instance = new DummyUIFactory();
	}
	
	private DummyUIFactory(){
		
	}
	
	public static DummyUIFactory getFactory(){
		return Holder.instance;
	}
	
	public void construct(JFrame frame){
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout()); 
		JTextField searchInput = new JTextField();
		jPanel.add(searchInput,BorderLayout.NORTH);
		UserHomeDataProvider dp = new UserHomeDataProvider();
		Object rowData[][] = dp.provide();
		Object columnNames[] = { "File","Path" };
		DummyFileTableModel dm = new DummyFileTableModel(rowData,columnNames);
		JTable table = new DummyFileTable(dm);
		JScrollPane js = new JScrollPane(table);
		jPanel.add(js,BorderLayout.CENTER);
		frame.add(jPanel);
	}
}
