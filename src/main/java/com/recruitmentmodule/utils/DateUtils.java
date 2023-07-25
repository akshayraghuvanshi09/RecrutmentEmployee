package com.recruitmentmodule.utils;

/**
 * @author AKSHAY
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;

public class DateUtils {

	public static String getEndTimestamp(int month, int year) {
		YearMonth yearMonth = YearMonth.of(year, month + Constants.ONE_AS_INTEGER);
		LocalDate lastDate = yearMonth.atEndOfMonth();
		return lastDate.toString();
	}

	public static Date stringToDateFormat(String date, String datePattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		return sdf.parse(date);
	}

	public static String dateToStringFormat(Date date, String datePattern) {
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		return format.format(date);

	}

	public static String timeStamp(String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());

	}

	public static Date timeStampInDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		return sdf.parse(sdf.format(new Date()));
	}

	private DateUtils() {

	}
}
