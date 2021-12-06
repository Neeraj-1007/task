package com.task.poc1.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.task.poc1.dto.UserDTO;

public class Util {

	public static Date getDate(String date) {

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = null;
		try {
			if (date != null) {
				date1 = formatter.parse(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date1;
	}

	public static String getDate(Date indate) {
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("MM/dd/yyyy");
		try {
			dateString = sdfr.format(indate);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return dateString;
	}

}
