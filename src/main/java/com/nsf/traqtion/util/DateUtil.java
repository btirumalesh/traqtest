package com.nsf.traqtion.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {

	

	public static Timestamp getCurrentTimeStamp(){
		return new Timestamp(new Date().getTime());
	}
}
