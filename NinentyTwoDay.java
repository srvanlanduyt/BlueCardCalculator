package calculators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//adds 92 days to the date passed in the constructor
public class NinentyTwoDay {
	
	//set up a date and SimpleDateFormat
	Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	
	//constructor accepts a date
	public NinentyTwoDay(String inputDate) {
		try {
			date = sdf.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//sets a calendar date to the NinentyTwoDay object's
	//date, adds 92 and returns it as a String
	public String plus92d(NinentyTwoDay n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(n.date);
		cal.add(Calendar.DATE, 92);
		return sdf.format(cal.getTime());
	}
}
