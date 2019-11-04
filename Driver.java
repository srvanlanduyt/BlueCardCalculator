
/*
 * 	This is a locomotive blue card date calculator.  It takes in a date
 * 	and returns when the engine is due maintenance again by midnight on 
 * 	the date shown.  
 * 
 * 	Written by Steven Van Landuyt in 2019 
 * 	Intended for free distribution to anyone that can use it
 * 	Contact srvanlanduyt@gmail.com to report bugs, suggestions, or improvements. 
 */

package main;


public class Driver {
	
	//main method, creates a new calculator and calls the items to fill the JFrame
	public static void main(String[] args) {
		BlueCardCalc bcc = new BlueCardCalc();
		bcc.newMenuBar();
		bcc.newCalculator();
	}
}
