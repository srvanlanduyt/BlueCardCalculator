package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import calculators.Custom;
import calculators.FourYear;
import calculators.NinentyTwoDay;
import calculators.OneEightyFourDay;
import calculators.OneYear;
import calculators.ThreeYear;
import calculators.TwoYear;

//Button listener for the GUI
public class ButtonListener implements ActionListener {
	
	//set up the calculator and comparer
	public BlueCardCalc calc;
	public Compare compare;
	public SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	//listener constructor calls the compare constructor
	public ButtonListener(BlueCardCalc calc) {
		this.calc = calc;
		compare = new Compare();
	}

	//method that calls events based on key presses
	public void actionPerformed(ActionEvent e) {
		//click "exit" in the menu bar
		if (e.getActionCommand().contentEquals("Exit")){
			System.exit(0);
		
		//click clear in the menu bar when available
		} else if (e.getActionCommand().contentEquals("Clear")) {
			calc.clear();
		
		//click back to calculator in the menu bar when available
		} else if (e.getActionCommand().contentEquals("Back to Calculator")) {
			calc.clearJFrame();
			calc.newMenuBar();
			calc.newCalculator();
			
		//click to call the custom calculator method
		} else if (e.getActionCommand().contentEquals("Custom Calculator")) {
			calc.clearJFrame();
			calc.newMenuBar();
			calc.customCalc();
		
		//click more info on the menu bar when available
		} else if (e.getActionCommand().contentEquals("More Info")) {
			calc.clearJFrame();
			calc.moreInfoSelected();
		
		//click contact us on the menu bar when available
		} else if (e.getActionCommand().contentEquals("Contact Us")) {
			calc.clearJFrame();
			calc.contactSelected();
		
		//checks the date in the 92d box when clicked
		//if valid creates new NinentyTwoDay object
		//and calls its methods
		} else if (e.getActionCommand().contentEquals("button92d")) {
			if (compare.doesMatch(calc.getPrevPMDate92d())) {
				NinentyTwoDay n = new NinentyTwoDay(calc.getPrevPMDate92d());
				calc.setNextPMDate92d(n.plus92d(n));
			} else {
				calc.setNextPMDate92d("Incorrect format");
			}
		
		//checks the date in the 184d box when clicked
		//if valid creates a new OneEightyFourDay object
		//and calls its methods
		} else if (e.getActionCommand().contentEquals("button184d")) {
			if (compare.doesMatch(calc.getPrevPMDate184d())) {			
				OneEightyFourDay n = new OneEightyFourDay(calc.getPrevPMDate184d());
				calc.setNextPMDate184d(n.plus184d(n));
			} else {
				calc.setNextPMDate184d("Incorrect format");
			}
		
		//checks the date in the 1y box when clicked
		//if valid creates a new OneYear object
		//and calls its methods
		} else if (e.getActionCommand().contentEquals("button1y")) {
			if (compare.doesMatch(calc.getPrevPMDate1y())) {
				OneYear n = new OneYear(calc.getPrevPMDate1y());
				calc.setNextPMDate1y(n.plus1y(n));
			} else {
				calc.setNextPMDate1y("Incorrect format");
			}
		
		//checks the date in the 2y box when clicked
		//if valid creates a new TwoYear object
		//and calls its methods
		} else if (e.getActionCommand().contentEquals("button2y")) {
			if (compare.doesMatch(calc.getPrevPMDate2y())) {
				TwoYear n = new TwoYear(calc.getPrevPMDate2y());
				calc.setNextPMDate2y(n.plus2y(n));
			} else {
				calc.setNextPMDate2y("Incorrect format");
			}
		
		//checks the date in the 3y box when clicked
		//if valid creates a new ThreeYear object
		//and calls its methods
		} else if (e.getActionCommand().contentEquals("button3y")) {
			if (compare.doesMatch(calc.getPrevPMDate3y())) {
				ThreeYear n = new ThreeYear(calc.getPrevPMDate3y());
				calc.setNextPMDate3y(n.plus3y(n));
			} else {
				calc.setNextPMDate3y("Incorrect format");
			}
		
		//checks the date in the 4y box when clicked
		//if valid creates a new FourYear object
		//and calls its methods
		} else if (e.getActionCommand().contentEquals("button4y")) {
			if (compare.doesMatch(calc.getPrevPMDate4y())) {
				FourYear n = new FourYear(calc.getPrevPMDate4y());
				calc.setNextPMDate4y(n.plus4y(n));
			} else {
				calc.setNextPMDate4y("Incorrect format");
			}
		
		//checks the date in the customDate box and the numDays 
		//when clicked if valid creates a new FourYear object
		//and calls its methods	
		} else if (e.getActionCommand().contentEquals("buttonCustom")) {
			if (compare.doesMatch(calc.getPrevPMDateCustom()) && 
				compare.numDaysMatch(calc.getSelectedDays())) {
				Custom n = new Custom(calc.getPrevPMDateCustom(), calc.getSelectedDays());
				calc.setNextPMDateCustom(n.plusCustom(n));
			} else {
				calc.setNextPMDateCustom("Incorrect format");
			}
			
			
		}
	}
}
