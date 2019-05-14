

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.javafx.*;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;


import java.awt.Dimension;
import javax.swing.*;

import java.awt.Graphics;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.OsmMercator;
public class MainApp extends JFrame {
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	private JButton search;
	private JTextField findTextField;
	private JLabel searchtext;
	
	public MainApp() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		createPanel();
	}
	public JLabel createlabel() {
		searchtext=new JLabel("目標鎖定: ");
		return searchtext;
	}
	public JButton searchbtn() {
		search=new JButton("狩獵");
		class SearchActionListener implements ActionListener, KeyListener{
			public void actionPerformed(ActionEvent e) {
				searchtext.setText("目標鎖定:"+findTextField.getText());
	
		
			}
			public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	searchtext.setText("目標鎖定:"+findTextField.getText());
			  
			    }

			} 
			@Override
		    public void keyReleased(KeyEvent arg0) {
		        // TODO Auto-generated method stub

		    }

		    @Override
		    public void keyTyped(KeyEvent arg0) {

		    }

			} 
				SearchActionListener listener = new SearchActionListener();
				search.addActionListener(listener);
				findTextField.addActionListener(listener);
			search.addKeyListener(listener);
		return search;
	}
	public void createPanel(){
		JPanel FirstPanel = new JPanel();
		FirstPanel.setLayout(new BoxLayout(FirstPanel, BoxLayout.X_AXIS));
		FirstPanel.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        JLabel findLabel = new JLabel("範圍 owo");
        FirstPanel.add(findLabel);

        FirstPanel.add(Box.createRigidArea(new Dimension(6, 0)));

        findTextField = new JTextField(30);
        FirstPanel.add(findTextField);

        FirstPanel.add(Box.createRigidArea(new Dimension(6, 0)));
        search = searchbtn();
        FirstPanel.add(search);
        createlabel();
        JPanel SecondPanel = new JPanel();

        SecondPanel.add(createlabel());
        
		JPanel controlPanel = new JPanel();
		controlPanel.add(FirstPanel);
		controlPanel.add(SecondPanel);
		controlPanel.setBackground(Color.WHITE);
		add(controlPanel,BorderLayout.NORTH);

		JPanel submitPanel=new JPanel();

		Color bitter = new Color(242, 181, 106);
		submitPanel.setBackground(bitter);   
		NCCUPanel mpa=new NCCUPanel();
		JPanel jp= mpa.create();
		/*MAPPanel mapPanel = new MAPPanel(); 
		MapPanel mp=mapPanel.returnmap();*/
		  
		add(submitPanel,BorderLayout.CENTER);
 
		add(jp,BorderLayout.EAST);
		submitPanel.setPreferredSize(new Dimension(300, 400)); 
	    
	}
	
}

