package calculators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//adds 1104 days to the date passed in the constructor
public class ThreeYear {

	//set up a date and SimpleDateFormat
	Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	
	//constructor accepts a date
	public ThreeYear(String inputDate) {
		try {
			date = sdf.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//using SimpleDateFormat sets a calendar date to the ThreeYear object's
	//date, adds 1104 and returns it as a String
	public String plus3y(ThreeYear n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(n.date);
		cal.add(Calendar.DATE, 1104);
		return sdf.format(cal.getTime());
	}
}
