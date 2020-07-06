package com.example.gestionbacaire.service.utile;


import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;



public class DateUtile {
	public static int getAnneeFromDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH);
	}
	public static long	Adddays(Date date,Date date1){
		long milis=date.getTime()/24*3600*1000-date.getTime()/24*3600*1000;
		return milis;			
		}
public 	DateFormat date= DateFormat.getDateTimeInstance(
			DateFormat.SHORT,DateFormat.SHORT
			);
/**
 * @return the date
 */
public DateFormat getDate() {
	return date;
}
/**
 * @param date the date to set
 */
public void setDate(DateFormat date) {
	this.date = date;
}


}
