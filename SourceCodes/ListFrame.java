package guiComponent;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListFrame extends JFrame{
	private JList colorList;
	private static final String[] colorNames = {
		"Black", "Blue","Orange","Cyan","Yellow","Red",
		"Magneta","Light Gray","Green","Dark Gray","White","Pink"};
	private static final Color[] colors = {Color.black, Color.BLUE, Color.ORANGE,
		Color.CYAN, Color.YELLOW, Color.RED, Color.MAGENTA, Color.LIGHT_GRAY,
		Color.GREEN, Color.DARK_GRAY, Color.WHITE, Color.PINK};
	
	public ListFrame(){
		super("List Frame");
		
		setLayout(new FlowLayout());
		
		colorList = new JList(colorNames);
		colorList.setVisibleRowCount(5);
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add(new JScrollPane(colorList));
		
		colorList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				getContentPane().setBackground(colors[colorList.getSelectedIndex()]);
			}
		});
	}
	public static void main(String args[]){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JFrame frame = new ListFrame();
		frame.setSize(350, 150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
