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
import javax.swing.DefaultListModel;
import javax.security.auth.PrivateCredentialPermission;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JFrame {
	private JTextField textField;
	private JLabel lblNewLabel;
	private JList list;
	private JScrollPane scrollPane;
	public static sqliteloading sqliteloading;
	private JPanel panel_7;
	private JCheckBox checkBox;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private DefaultListModel<String> listModel;
	private JComboBox comboBox;

	public MainPanel() throws Exception {
		sqliteloading = new sqliteloading();
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
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(MainPanel.class.getResource("/image/FotoJet.jpg")).getImage()
				.getScaledInstance(540, 200, Image.SCALE_DEFAULT));
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("目標鎖定:" + textField.getText());
				try {
					ArrayList<String> ab = sqliteloading.selectName(textField.getText());

					listModel.removeAllElements();
					for (String s : ab) {
						listModel.addElement(s);
					}

					list.setModel(listModel);

					revalidate();
					repaint();

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		panel.add(btnNewButton);

		JButton button = new JButton("清除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				lblNewLabel.setText("目標鎖定");
				listModel.removeAllElements();
				list.setModel(listModel);
				revalidate();
				repaint();
				checkBox.setSelected(false);
				chckbxNewCheckBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				comboBox.setSelectedIndex(0);
				panel_7.removeAll();
				pack();
			}
		});
		panel.add(button);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);

		lblNewLabel = new JLabel("目標鎖定");
		panel.add(lblNewLabel);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);

		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2);

		checkBox = new JCheckBox("日式");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ArrayList<String> jp = sqliteloading.selectName("日式");

					listModel = (DefaultListModel<String>) list.getModel();

					if (checkBox.isSelected()) {
						for (String s : jp) {

							listModel.addElement(s);

						}
					} else {
						for (String s : jp) {

							listModel.removeElement(s);

						}
					}
					list.setModel(listModel);
					revalidate();
					repaint();

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}

			}
		});
		panel_2.add(checkBox);

		chckbxNewCheckBox = new JCheckBox("西式");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ArrayList<String> jp = sqliteloading.selectName("西式");

					listModel = (DefaultListModel<String>) list.getModel();

					if (chckbxNewCheckBox.isSelected()) {
						for (String s : jp) {

							listModel.addElement(s);

						}
					} else {
						for (String s : jp) {

							listModel.removeElement(s);

						}
					}
					list.setModel(listModel);
					revalidate();
					repaint();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		panel_2.add(chckbxNewCheckBox);

		checkBox_1 = new JCheckBox("台式");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<String> jp = sqliteloading.selectName("台式");

					listModel = (DefaultListModel<String>) list.getModel();

					if (checkBox_1.isSelected()) {
						for (String s : jp) {

							listModel.addElement(s);

						}
					} else {
						for (String s : jp) {

							listModel.removeElement(s);

						}
					}
					list.setModel(listModel);
					revalidate();
					repaint();

				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		panel_2.add(checkBox_1);

		checkBox_2 = new JCheckBox("下午茶");
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<String> jp = sqliteloading.selectName("下午茶");

					listModel = (DefaultListModel<String>) list.getModel();

					if (checkBox_2.isSelected()) {
						for (String s : jp) {

							listModel.addElement(s);

						}
					} else {
						for (String s : jp) {

							listModel.removeElement(s);

						}
					}
					list.setModel(listModel);
					revalidate();
					repaint();

				} catch (Exception ex) {
					// TODO: handle exception
				}
			}

		});
		panel_2.add(checkBox_2);

		JLabel label = new JLabel("價格範圍");
		panel_2.add(label);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String combo = (String) comboBox.getSelectedItem();
				if (combo.equals("$100以下")) {
					try {
						ArrayList<String> ab = sqliteloading.selectPrice(1, 100);
						listModel.removeAllElements();
						for (String s : ab) {
							listModel.addElement(s);
						}
						list.setModel(listModel);
						revalidate();
						repaint();

					} catch (Exception excep) {
						// TODO: handle exception
					}
				} else if (combo.equals("$100-200")) {
					try {
						ArrayList<String> ab = sqliteloading.selectPrice(100, 200);
						listModel.removeAllElements();
						for (String s : ab) {
							listModel.addElement(s);
						}
						list.setModel(listModel);
						revalidate();
						repaint();

					} catch (Exception excep) {
						// TODO: handle exception
					}

				} else if (combo.equals("$200-300")) {
					try {
						ArrayList<String> ab = sqliteloading.selectPrice(200, 300);
						listModel.removeAllElements();
						for (String s : ab) {
							listModel.addElement(s);
						}
						list.setModel(listModel);
						revalidate();
						repaint();

					} catch (Exception excep) {
						// TODO: handle exception
					}

				} else if (combo.equals("$300以上")) {
					try {
						ArrayList<String> ab = sqliteloading.selectPrice(300, 100000);
						listModel.removeAllElements();
						for (String s : ab) {
							listModel.addElement(s);
						}
						list.setModel(listModel);
						revalidate();
						repaint();

					} catch (Exception excep) {
						// TODO: handle exception
					}

				} else {
					listModel.removeAllElements();
					list.setModel(listModel);
					revalidate();
					repaint();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { " ", "$100以下", "$100-200", "$200-300", "$300以上" }));
		comboBox.setToolTipText("");

		panel_2.add(comboBox);

		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(350, 200));
		panel_5.add(scrollPane);

		listModel = new DefaultListModel<String>();

		list = new JList<String>(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_7.removeAll();

				JScrollPane scrollPane_1 = new JScrollPane();
				panel_7.add(scrollPane_1);

				JTextArea textArea = new JTextArea();
				scrollPane_1.setViewportView(textArea);

				JLabel lblNewLabel_2 = new JLabel();
				panel_7.add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel();
				panel_7.add(lblNewLabel_3);

				getContentPane().add(panel_7, BorderLayout.EAST);
				panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
				if (e.getClickCount() == 1) {
					String selectedItem = (String) list.getSelectedValue();
					int listNum = list.getSelectedIndex();
					System.out.println(listNum);
					System.out.println(selectedItem);
					try {
						ArrayList<String> listInfo = sqliteloading.selectList(selectedItem);
						String st = "";
						for (String str : listInfo) {
							st = st + str;
						}
						textArea.setText(st);
					} catch (Exception ex) {
						// TODO: handle exception
					}
					String img = "/image/" + selectedItem + ".jpg";
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(MainPanel.class.getResource(img)).getImage());
					lblNewLabel_2.setIcon(imageIcon);
					String map = "/image/Map_" + selectedItem + ".png";
					ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(MainPanel.class.getResource(map)).getImage()
							.getScaledInstance(729, 400, Image.SCALE_DEFAULT));
					lblNewLabel_3.setIcon(imageIcon1);
					repaint();
					pack();

				}
			}
		});

		scrollPane.setViewportView(list);

		panel_7 = new JPanel();
		getContentPane().add(panel_7, BorderLayout.EAST);

	}

}
