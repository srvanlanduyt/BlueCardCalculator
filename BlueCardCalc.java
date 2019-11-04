package main;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlueCardCalc extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//setting up the frame and listener
	private JFrame frame;
	private ButtonListener listener;
	
	//setting up the menu bar and items
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu file = new JMenu("File");
	private JMenu about = new JMenu("About");
	
	private JMenuItem clear = new JMenuItem("Clear");
	private JMenuItem exit = new JMenuItem("Exit");
	private JMenuItem backToCalc = new JMenuItem("Back to Calculator");
	private JMenuItem customCalc = new JMenuItem("Custom Calculator");
	private JMenuItem moreInfo = new JMenuItem("More Info");
	private JMenuItem contact = new JMenuItem("Contact Us");
	
	//enter buttons for each field
	private JButton button92d = new JButton("Enter");
	private JButton button184d = new JButton("Enter");
	private JButton button1y = new JButton("Enter");
	private JButton button2y = new JButton("Enter");
	private JButton button3y = new JButton("Enter");
	private JButton button4y = new JButton("Enter");
	private JButton buttonCustom = new JButton("Enter");
	
	//text fields for date input
	private JTextField prevPMDate92d = new JTextField();
	private JTextField prevPMDate184d = new JTextField();
	private JTextField prevPMDate1y = new JTextField();
	private JTextField prevPMDate2y = new JTextField();
	private JTextField prevPMDate3y = new JTextField();
	private JTextField prevPMDate4y = new JTextField();
	private JTextField prevPMDateCustom = new JTextField();
	private JTextField selectedDays = new JTextField();
	
	//misc text items
	private JLabel header1 = new JLabel("Blue Card Calculator");
	private JLabel header2 = new JLabel("Enter Last Maintenance Type Below to Calculate Next Due Date");
	private JLabel last92d = new JLabel("Last 92d: ");
	private JLabel last184d = new JLabel("Last 184d: ");
	private JLabel last1y = new JLabel("Last 1y: ");
	private JLabel last2y = new JLabel("Last 2y: ");
	private JLabel last3y = new JLabel("Last 3y: ");
	private JLabel last4y = new JLabel("Last 4y: ");
	private JLabel lastCustom = new JLabel("Last PM Date: ");
	private JLabel numberOfDays = new JLabel("Number of Days: ");
	
	//contact page text
	private JLabel contactStatement = new JLabel("<html> <center> <br/> <br/> Written by Steven Van Landuyt </center> <br/>"
										+ 									  "<br/> "
										+ 									  "This is freeware, please distribute this to anyone that <br/>"
										+ 									  "would find it useful.  For any questions, comments, requests, <br/>"
										+ 									  "or bug reports contact us at srvanlanduyt@gmail.com </center> </html>");
	
	//more info page text
	private JLabel moreInfoStatement = new JLabel("<html> <center> <br/> <br/> This calculator is based on the Locomotive 92d <br/>"
										+									  "inspection system.  The locomotive will be due <br/>"
										+								 	  "maintenance at midnight on the date shown to the <br/>"
										+                                     "right of the enter button. <br/><br/>"
										+ 									  " 		92d:	Adds 92 days <br/>"
										+ 									  " 		184d:	Adds 184 days <br/>"
										+ 									  " 		1y:		Adds 368 days <br/>"
										+ 									  " 		2y: 	Adds 736 days <br/>"
										+ 									  "	   		3y: 	Adds 1104 days <br/>"
										+ 									  "			4y: 	Adds 1472 days </center> </html>");
	
	//custom calculation text
	private JLabel customCalcStatement = new JLabel("<html> <center> <br/> <br/> Set the last PM date and set the number <br/> "
										+  									  "of days to throw out the next PM. </center> </html>");
	
	//fields for calculated date output
	private JLabel nextPMDate92d = new JLabel("          ");
	private JLabel nextPMDate184d = new JLabel("          ");
	private JLabel nextPMDate1y = new JLabel("          ");
	private JLabel nextPMDate2y = new JLabel("          ");
	private JLabel nextPMDate3y = new JLabel("          ");
	private JLabel nextPMDate4y = new JLabel("          ");
	private JLabel nextPMDateCustom = new JLabel("          ");
	
	
	//calculator constructor, sets the JFrame
	public BlueCardCalc() {
		Dimension minimum = new Dimension(550, 500);
		frame = new JFrame("Blue Card Calculator");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		Box.createVerticalGlue();
		frame.setMinimumSize(minimum);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listener = new ButtonListener(this);
	}
	
	//menu bar reset, clears the menu bar and adds the settings for the calculator page back into it
	void newMenuBar() {
		menuBar.removeAll();
		file.removeAll();
		about.removeAll();
		
		file.add(clear);
		clear.addActionListener(listener);
		file.add(customCalc);
		customCalc.addActionListener(listener);
		file.add(exit);
		exit.addActionListener(listener);
		about.add(moreInfo);
		moreInfo.addActionListener(listener);
		about.add(contact);
		contact.addActionListener(listener);
		menuBar.add(file);
		menuBar.add(about);
		frame.setJMenuBar(menuBar);
	}
	
	//constructs panels for each calculator and adds them to the JFrame
	void newCalculator() {
		JPanel panel1 = new JPanel();
		header1.setFont(new Font("Sans Serif", Font.BOLD, 40));
		panel1.add(header1);
		frame.add(panel1);
		
		JPanel panel2 = new JPanel();
		header2.setFont(new Font("Sans Serif", Font.BOLD, 16));
		panel2.add(header2);
		frame.add(panel2);
		
		//92d
		JPanel panel3 = new JPanel();
		panel3.add(last92d);
		prevPMDate92d.setColumns(10);
		prevPMDate92d.setText("mm/dd/yy");
		panel3.add(prevPMDate92d);
		panel3.add(button92d);
		button92d.setActionCommand("button92d");
		button92d.addActionListener(listener);
		panel3.add(nextPMDate92d);
		frame.add(panel3);
		
		//184d
		JPanel panel4 = new JPanel();
		panel4.add(last184d);
		prevPMDate184d.setColumns(10);
		prevPMDate184d.setText("mm/dd/yy");
		panel4.add(prevPMDate184d);
		panel4.add(button184d);
		button184d.setActionCommand("button184d");
		button184d.addActionListener(listener);
		panel4.add(nextPMDate184d);
		frame.add(panel4);
		
		//1y
		JPanel panel5 = new JPanel();
		panel5.add(last1y);
		prevPMDate1y.setColumns(10);
		prevPMDate1y.setText("mm/dd/yy");
		panel5.add(prevPMDate1y);
		panel5.add(button1y);
		button1y.setActionCommand("button1y");
		button1y.addActionListener(listener);;
		panel5.add(nextPMDate1y);
		frame.add(panel5);

		//2y
		JPanel panel6 = new JPanel();
		panel6.add(last2y);
		prevPMDate2y.setColumns(10);
		prevPMDate2y.setText("mm/dd/yy");
		panel6.add(prevPMDate2y);
		panel6.add(button2y);
		button2y.setActionCommand("button2y");
		button2y.addActionListener(listener);
		panel6.add(nextPMDate2y);
		frame.add(panel6);
		
		//3y
		JPanel panel7 = new JPanel();
		panel7.add(last3y);
		prevPMDate3y.setColumns(10);
		prevPMDate3y.setText("mm/dd/yy");
		panel7.add(prevPMDate3y);
		panel7.add(button3y);
		button3y.setActionCommand("button3y");
		button3y.addActionListener(listener);
		panel7.add(nextPMDate3y);
		frame.add(panel7);
		
		//4y
		JPanel panel8 = new JPanel();
		panel8.add(last4y);
		prevPMDate4y.setColumns(10);
		prevPMDate4y.setText("mm/dd/yy");
		panel8.add(prevPMDate4y);
		panel8.add(button4y);
		button4y.setActionCommand("button4y");
		button4y.addActionListener(listener);
		panel8.add(nextPMDate4y);
		frame.add(panel8);
		
		//set, pack and make the frame visible
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
	}

		//method to clear the inputed dates and calculated dates
		public void clear() {
			prevPMDate92d.setText("");
			prevPMDate184d.setText("");
			prevPMDate1y.setText("");
			prevPMDate2y.setText("");
			prevPMDate3y.setText("");
			prevPMDate4y.setText("");
			prevPMDateCustom.setText("");
			
			nextPMDate92d.setText("          ");
			nextPMDate184d.setText("          ");
			nextPMDate1y.setText("          ");
			nextPMDate2y.setText("          ");
			nextPMDate3y.setText("          ");
			nextPMDate4y.setText("          ");
			prevPMDateCustom.setText("          ");
		}
		
		//method run when moreInfo is selected from the menu bar
		public void moreInfoSelected() {
			about.remove(moreInfo);
			file.remove(clear);
			file.add(backToCalc, 0);
			backToCalc.addActionListener(listener);
			frame.setJMenuBar(menuBar);
			moreInfoStatement.setFont(new Font("Sans Serif", Font.PLAIN, 16));
			JPanel panelMoreInfo1 = new JPanel();
			panelMoreInfo1.add(moreInfoStatement);
			frame.add(panelMoreInfo1);
			frame.pack();
			
		}
		
		//method run when CustomCalc is selected from the menu bar
		public void customCalc() {
			file.remove(customCalc);
			file.add(backToCalc, 0);
			backToCalc.addActionListener(listener);
			frame.setJMenuBar(menuBar);
			customCalcStatement.setFont(new Font("Sans Serif", Font.PLAIN, 16));
			JPanel panelCustomCalc1 = new JPanel();
			JPanel panelCustomCalc2 = new JPanel();
			JPanel panelCustomCalc3 = new JPanel();
			panelCustomCalc1.add(customCalcStatement);
			panelCustomCalc2.add(lastCustom);
			prevPMDateCustom.setColumns(10);
			panelCustomCalc2.add(prevPMDateCustom);
			panelCustomCalc2.add(numberOfDays);
			selectedDays.setColumns(5);
			panelCustomCalc2.add(selectedDays);
			panelCustomCalc3.add(buttonCustom);
			buttonCustom.addActionListener(listener);
			buttonCustom.setActionCommand("buttonCustom");
			panelCustomCalc3.add(nextPMDateCustom);
			frame.add(panelCustomCalc1);
			frame.add(panelCustomCalc2);
			frame.add(panelCustomCalc3);
			frame.pack();
			
		}
		
		//method run when contact is selected from the menu bar
		public void contactSelected() {
			about.remove(contact);
			file.remove(clear);
			file.add(backToCalc, 0);
			backToCalc.addActionListener(listener);
			frame.setJMenuBar(menuBar);
			contactStatement.setFont(new Font("Sans Serif", Font.PLAIN, 16));
			JPanel panelContact1 = new JPanel();
			panelContact1.add(contactStatement);
			frame.add(panelContact1);
			frame.pack();
		}
		
		//method to clear the contents of the JFrame
		public void clearJFrame() {
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.repaint();
		}
	
		
		//setters and getters
		public String getSelectedDays() {
			return selectedDays.getText();
		}
		
		public String getPrevPMDate92d() {
			return prevPMDate92d.getText();
		}
		
		public String getPrevPMDate184d() {
			return prevPMDate184d.getText();
		}
		
		public String getPrevPMDate1y() {
			return prevPMDate1y.getText();
		}
		
		public String getPrevPMDate2y() {
			return prevPMDate2y.getText();
		}
		
		public String getPrevPMDate3y() {
			return prevPMDate3y.getText();
		}
		
		public String getPrevPMDate4y() {
			return prevPMDate4y.getText();
		}
		
		public String getPrevPMDateCustom() {
			return prevPMDateCustom.getText();
		}
		
		public void setNextPMDate92d(String newDate) {
			nextPMDate92d.setText(newDate);
		}
		
		public void setNextPMDate184d(String newDate) {
			nextPMDate184d.setText(newDate);
		}
		
		public void setNextPMDate1y(String newDate) {
			nextPMDate1y.setText(newDate);
		}
		
		public void setNextPMDate2y(String newDate) {
			nextPMDate2y.setText(newDate);
		}
		
		public void setNextPMDate3y(String newDate) {
			nextPMDate3y.setText(newDate);
		}
		
		public void setNextPMDate4y(String newDate) {
			nextPMDate4y.setText(newDate);
		}	
		
		public void setNextPMDateCustom(String newDate) {
			nextPMDateCustom.setText(newDate);
		}
}
