package calculators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//adds 736 days to the date passed in the constructor
public class TwoYear {

	//set up a date and SimpleDateFormat
	Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	
	//constructor accepts a date
	public TwoYear(String inputDate) {
		try {
			date = sdf.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//using SimpleDateFormat sets a calendar date to the TwoYear object's
	//date, adds 736 and returns it as a String
	public String plus2y(TwoYear n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(n.date);
		cal.add(Calendar.DATE, 736);
		return sdf.format(cal.getTime());
	}
}
