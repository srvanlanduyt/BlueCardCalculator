package calculators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//adds a selected amount of days to the date passed in the constructor
public class Custom {

	//set up a date and SimpleDateFormat
	Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	private int numDays;
	
	//constructor accepts a date and parses selected days to an int
	public Custom(String inputDate, String selectedDays) {
		try {
			date = sdf.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		numDays = Integer.parseInt(selectedDays);
	}
	
	//using SimpleDateFormat sets a calendar date to the Custom object's
	//date, adds numDays and returns it as a String
	public String plusCustom(Custom n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(n.date);
		cal.add(Calendar.DATE, n.numDays);
		return sdf.format(cal.getTime());
	}
}
