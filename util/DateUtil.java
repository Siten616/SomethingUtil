package com.gem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
* �ṩ����ת�ַ������� dateToString(Date date)
* �ṩ�ַ���ת���ڷ��� stringToDate(String sdate)
*
*/
public class DateUtil {
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static Date stringToDate(String sdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
