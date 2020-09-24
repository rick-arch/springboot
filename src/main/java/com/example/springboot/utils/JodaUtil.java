package com.example.springboot.utils;

import org.joda.time.*;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class JodaUtil {

	public static final long SECOND = 1000; // 1秒 java已毫秒为单位

	public static final long MINUTE = SECOND * 60; // 一分钟

	public static final long HOUR = MINUTE * 60; // 一小时

	public static final long DAY = HOUR * 24; // 一天

	public static final long WEEK = DAY * 7; // 一周

	public static final long YEAR = DAY * 365; // 一年

	public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss"; // 默认时间格式

	public static final String FORMAT_TIME_MINUTE = "yyyy-MM-dd HH:mm"; // 默认时间格式

	public static final String FORMAT_DATE = "yyyy-MM-dd"; // 默认日期格式

	private static final Map<Integer, String> WEEK_DAY = new HashMap<>();

	static {
		WEEK_DAY.put(7, "星期六");
		WEEK_DAY.put(1, "星期天");
		WEEK_DAY.put(2, "星期一");
		WEEK_DAY.put(3, "星期二");
		WEEK_DAY.put(4, "星期三");
		WEEK_DAY.put(5, "星期四");
		WEEK_DAY.put(6, "星期五");
	}

	/**
	 * 获取当前系统时间
	 *
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String currentTime() {
		DateTime dt = new DateTime();
		return dt.toString(FORMAT_TIME);
	}

	/**
	 * 获取系统当前时间按照指定格式返回
	 *
	 * @param pattern yyyy/MM/dd hh:mm:a
	 * @return
	 */
	public static String currentTime(String pattern) {
		DateTime dt = new DateTime();
		return dt.toString(pattern);
	}

	/**
	 * 获取当前日期
	 *
	 * @return
	 */
	public static String currentDate() {
		DateTime dt = new DateTime();
		return dt.toString(FORMAT_DATE);
	}

	/**
	 * 获取当前日期按照指定格式
	 *
	 * @param pattern
	 * @return
	 */
	public static String currentDate(String pattern) {
		DateTime dt = new DateTime();
		return dt.toString(pattern);
	}

	/**
	 * 按照时区转换时间
	 *
	 * @param date
	 * @param timeZone 时区
	 * @param pattern
	 * @return
	 */
	@Nullable
	public static String format(Date date, TimeZone timeZone, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(timeZone);
		return sdf.format(date);
	}


	/**
	 * 获取当前是一周星期几
	 *
	 * @return
	 */
	public static String getWeek() {
		DateTime dts = new DateTime();
		String week = null;
		switch (dts.getDayOfWeek()) {
			case DateTimeConstants.SUNDAY:
				week = "星期日";
				break;

			case DateTimeConstants.MONDAY:
				week = "星期一";
				break;

			case DateTimeConstants.TUESDAY:
				week = "星期二";
				break;
			case DateTimeConstants.WEDNESDAY:
				week = "星期三";
				break;
			case DateTimeConstants.THURSDAY:
				week = "星期四";
				break;
			case DateTimeConstants.FRIDAY:
				week = "星期五";
				break;
			case DateTimeConstants.SATURDAY:
				week = "星期六";
			default:
				break;
		}
		return week;
	}

	/**
	 * 获取指定时间是一周的星期几
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static String getWeekPoint(Integer year, Integer month, Integer day) {
		LocalDate dts = new LocalDate(year, month, day);
		String week = null;
		switch (dts.getDayOfWeek()) {
			case DateTimeConstants.SUNDAY:
				week = "星期日";
				break;
			case DateTimeConstants.MONDAY:
				week = "星期一";
				break;
			case DateTimeConstants.TUESDAY:
				week = "星期二";
				break;
			case DateTimeConstants.WEDNESDAY:
				week = "星期三";
				break;
			case DateTimeConstants.THURSDAY:
				week = "星期四";
				break;
			case DateTimeConstants.FRIDAY:
				week = "星期五";
				break;
			case DateTimeConstants.SATURDAY:
				week = "星期六";
				break;

			default:
				break;
		}
		return week;
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	@Nullable
	public static String format(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_TIME);
		return format.format(date);
	}

	/**
	 * 格式化日期字符串
	 *
	 * @param date    日期
	 * @param pattern 日期格式
	 * @return
	 */
	@Nullable
	public static String format(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 解析日期
	 *
	 * @param date    日期字符串
	 * @param pattern 日期格式
	 * @return
	 */
	@Nullable
	public static Date parse(String date, String pattern) {
		if (date == null) {
			return null;
		}
		Date resultDate = null;
		try {
			resultDate = new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {

		}
		return resultDate;
	}

	/**
	 * 解析日期yyyy-MM-dd HH:mm:ss
	 *
	 * @param date 日期字符串
	 * @return
	 */
	@Nullable
	public static Date parse(String date) {
		if (date == null) {
			return null;
		}

		try {
			return new SimpleDateFormat(FORMAT_TIME).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取当前时间前几天时间,按指定格式返回
	 *
	 * @param days
	 * @return
	 */
	public static String forwardDay(Integer days, String format) {
		DateTime dt = new DateTime();
		DateTime y = dt.minusDays(days);
		return y.toString(format);
	}

	/**
	 * 获取当前时间前几天时间
	 *
	 * @param days
	 * @return
	 */
	public static Date forwardDay(Integer days) {
		DateTime dt = new DateTime();
		DateTime y = dt.minusDays(days);
		return y.toDate();
	}

	/**
	 * 计算两个时间相差多少天
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@Nullable
	public static Integer diffDay(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return null;
		}
		DateTime dt1 = new DateTime(startDate);
		DateTime dt2 = new DateTime(endDate);
		int day = Days.daysBetween(dt1, dt2).getDays();
		return Math.abs(day);
	}

	/**
	 * 获取某月之前,之后某一个月最后一天,24:59:59
	 *
	 * @return
	 */
	public static Date lastDay(Date date, Integer month) {
		DateTime dt1;
		if (month == null) {
			month = 0;
		}
		if (date == null) {
			dt1 = new DateTime().minusMonths(month);
		} else {
			dt1 = new DateTime(date).minusMonths(month);
		}
		DateTime lastDay = dt1.dayOfMonth().withMaximumValue().withHourOfDay(23).withMinuteOfHour(59)
				.withSecondOfMinute(59);
		return lastDay.toDate();
	}

	/**
	 * 获取某月月之前,之后某一个月第一天,00:00:00
	 *
	 * @return
	 */
	public static Date firstDay(Date date, Integer month) {
		DateTime dt1;
		if (month == null) {
			month = 0;
		}
		if (date == null) {
			dt1 = new DateTime().minusMonths(month);
		} else {
			dt1 = new DateTime(date).minusMonths(month);
		}
		DateTime lastDay = dt1.dayOfMonth().withMinimumValue().withHourOfDay(0).withMinuteOfHour(0)
				.withSecondOfMinute(0);
		return lastDay.toDate();
	}

	public static Date addDay(Date date, int offset) {
		DateTime dt1;
		if (date == null) {
			dt1 = new DateTime().plusDays(offset);
			return dt1.toDate();
		}
		dt1 = new DateTime(date).plusDays(offset);
		return dt1.toDate();

	}
}

