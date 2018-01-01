package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringCode {

	public static String getDateTime(){
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}
