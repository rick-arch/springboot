package com.example.springboot.utils;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.example.springboot.constant.Constant.*;

@Component
@Slf4j
public final class DateUtil {

	private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern(DATE_FORMAT);
	private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	private static final String[] WEEK_ARRAY_CN = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	private static final String[] WEEK_ARRAY_EN = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	/**
	 * 时间转字符串
	 */
	public static String format() {
		return FORMATTER.print(DateTime.now());
	}


	/**
	 * 时间转字符串
	 */
	public static String format(Date date) {
		return sdf.format(date);
	}

	/**
	 * 解析字符串
	 */
	public static Date parse(String string) {
		try {
			return sdf.parse(string);
		} catch (ParseException e) {
			log.info("parse exception:", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取中文星期
	 */
	public static String getWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK) - NUM_ONE;
		return week < NUM_ZERO ? WEEK_ARRAY_CN[NUM_ZERO] : WEEK_ARRAY_CN[week];
	}

	/**
	 * 获取英文星期
	 */
	public static String getEnWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK) - NUM_ONE;
		return week < NUM_ZERO ? WEEK_ARRAY_EN[NUM_ZERO] : WEEK_ARRAY_EN[week];
	}

	/**
	 * 获取过去或者未来 任意天内的日期数组
	 *
	 * @param intervals intervals天内
	 * @return 日期数组
	 */
	public static ArrayList<String> test(int intervals) {
		ArrayList<String> pastDaysList = new ArrayList<>();
		for (int i = 0; i < intervals; i++) {
			pastDaysList.add(getPastDate(i));
		}
		return pastDaysList;
	}

	/**
	 * 获取过去第几天的日期
	 *
	 * @param past
	 * @return
	 */
	public static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(today);
	}

	/**
	 * 获取未来 第 past 天的日期
	 *
	 * @param past
	 * @return
	 */
	public static String getFutureDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(today);
	}
}
