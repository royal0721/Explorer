import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JFrame{
	private JTextField textField;
	public MainPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(10, 10, 10, 0));
		getContentPane().add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_6.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(MainPanel.class.getResource("/image/Map_巴東蜀味.png")).getImage().getScaledInstance(350, 130, Image.SCALE_DEFAULT));
		//ImageIcon imageIcon = new ImageIcon(new ImageIcon(MainPanel.class.getResource("/image/FotoJet.jpg")).getImage().getScaledInstance(350, 130, Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(imageIcon);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel_3.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel.add(horizontalStrut);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		JButton btnNewButton = new JButton("搜尋");
		panel.add(btnNewButton);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);
		
		JLabel lblNewLabel = new JLabel("目標鎖定");
		panel.add(lblNewLabel);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2);
		
		JCheckBox checkBox = new JCheckBox("日式");
		panel_2.add(checkBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("美式");
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox checkBox_1 = new JCheckBox("台式");
		panel_2.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("甜點");
		panel_2.add(checkBox_2);
		
		JLabel label = new JLabel("價格範圍");
		panel_2.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "$100以下", "$100-200", "$200-300", "$300以上"}));
		comboBox.setToolTipText("");
		
		panel_2.add(comboBox);
		
		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(350, 200));
		panel_5.add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JPanel panel_7 = new JPanel();
		getContentPane().add(panel_7, BorderLayout.EAST);
	}
	

}
