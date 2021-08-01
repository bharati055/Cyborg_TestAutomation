package CommonUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {
	
	public static String getDate(String when) {
		
	    Calendar cal = Calendar.getInstance();
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   
	    switch(when){
	    case "today":
	    	return dateFormat.format(cal.getTime());
	    case "yesterday":
	    	cal.add(Calendar.DATE, -1);
	    	return dateFormat.format(cal.getTime());
	    case "tomorrow":
	    	cal.add(Calendar.DATE, 1);
	    	return dateFormat.format(cal.getTime());
	    case "OutOfRange":
	    	cal.add(Calendar.DATE, 7);
    		return dateFormat.format(cal.getTime());
	    }
		return "";
	}



}
