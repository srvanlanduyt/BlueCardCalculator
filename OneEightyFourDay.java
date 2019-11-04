package calculators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//adds 184 days to the date passed in the constructor
public class OneEightyFourDay {

	//set up a date
	private Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	
	//constructor accepts a date
	public OneEightyFourDay(String inputDate) {
		try {
			date = sdf.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//sets a calendar date to the OneEightyFourDay object's
	//date, adds 184 and returns it as a String
	public String plus184d(OneEightyFourDay n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(n.date);
		cal.add(Calendar.DATE, 184);
		return sdf.format(cal.getTime());
	}
}
