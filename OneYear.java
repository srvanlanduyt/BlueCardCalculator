package calculators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//adds 368 days to the date passed in the constructor
public class OneYear {

	//set up a date and SimpleDateFormat
	Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	
	//constructor accepts a date
	public OneYear(String inputDate) {
		try {
			date = sdf.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//sets a calendar date to the OneYear object's
	//date, adds 368 and returns it as a String
	public String plus1y(OneYear n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(n.date);
		cal.add(Calendar.DATE, 368);
		return sdf.format(cal.getTime());
	}
}
