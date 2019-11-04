package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *	class to compare the input to what is expected.  It will check it vs
 *	a regex set to XX/XX/XXXX and if that passes check the number of days
 *	in the month, leap years, and keep it between 1900 and 2200.  Acceptable
 *	input formats are MM/DD/YY, MM/DD/YYYY, and MM/DD (assumes the current
 *  year in this case. 
 */

public class Compare {

	//set up the regex pattern, matcher, and variables
	private String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
	private Pattern pattern = Pattern.compile(regex);
	private Matcher matcher;
	private boolean matches;
	private int month;
	private int day;
	private int year;
	
	//blank constructor for a Compare object
	public Compare () {
		
	}
	
	public boolean numDaysMatch(String testNum) {
		int numToTest;
		try {
			numToTest = Integer.parseInt(testNum);
		} catch (NumberFormatException e) {
			return false;
		}
		
		if (1 <= numToTest && numToTest <= 9999) {
			return true;
		}
		return false;
	}
	
	//sets the matcher to look for the regex pattern
	//if it matches parse is called on the string
	//otherwise it returns false and returns a reject
	public boolean doesMatch(String test) {
		matcher = pattern.matcher(test);
		matches = false;
		if (matcher.matches()) {
			matches = parse(test);
		}
		return matches;
	}
	
	//Makes sure the input has the char "/" as a delimiter
	//and then splits it on those.  If the result is 3 units
	//it moves to the next phase
	public boolean parse(String input) {
		String[] parts;
		if (input.contains("/")) {
			parts = input.split("/");
			if (parts.length != 3) { 
				return false;
			}
			
			//month and day are assigned 
			month = Integer.parseInt(parts[0]);
			day = Integer.parseInt(parts[1]);
			//if a 2 digit year is added, 2000 is added
			if (parts[2].length() == 2) {
				year = Integer.parseInt(parts[2]) + 2000;
			} else {
				year = Integer.parseInt(parts[2]);
			}
		}
		//if the input hasn't failed yet, check for 4/31/19 and 7/32/19 cases
		return isValidDate(day, month, year);
	}
	
	//returns true if the year inputed is a leap year
	public boolean isLeapYear (int testYear) {
		if ((year % 4 == 0 && year % 100 != 0 || (year % 400 == 0))) {
			return true;
		} else {
			return false;
		}
	}
	
	//returns true if the date is real
	public boolean isValidDate(int testDay, int testMonth, int testYear) {
		//checks year range to be between 1900 and 2200
		//dates outside of this are valid, but not needed
		if (testYear < 1900 || testYear > 2200) {
			return false;
		}
		//checks month range from 1 - 12
		if (testMonth < 1 || testMonth > 12) {
			return false;
		}
		//checks day range from 1 - 31
		if (testDay < 1 || testDay > 31) {
			return false;
		}
		
		//call isLeapYear if Feb is the year called
		if (testMonth == 2) {
			if (isLeapYear(testYear)) {
				return (testDay <=29);
			} else {
				return (testDay <=28);
			}
		}
		
		//apr, june, sept, and nov only have 30 days
		if (testMonth == 4 || testMonth == 6 || testMonth == 9 || testMonth == 11) {
			return (testDay <= 30);
		}
		//any date that didn't fail by here is a valid date
		return true;
	}
	
	
	
}
