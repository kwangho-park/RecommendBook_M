package old.etc;

import java.util.Calendar;

public class IndexCalendar {
	
	private Calendar cal = Calendar.getInstance();
	
	private int year = cal.get(Calendar.YEAR);
	private int month = cal.get(Calendar.MONTH)+1;		// +1을 해줘야 정상 날짜출력 (이유는?)
	private int date = cal.get(Calendar.DATE);
	private int hour = cal.get(Calendar.HOUR);
	private int minute = cal.get(Calendar.MINUTE);
	
	
	public int getYear() {	return this.year; }
	public int getMonth() {	return this.month;	}
	public int getDate() {	return this.date;	}
	public int getHour() {	return this.hour;	}
	public int getMinute() {	return this.minute;	}
}
