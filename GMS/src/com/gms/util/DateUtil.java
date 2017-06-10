package com.gms.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	public static void main(String[] args) {  
        Date date = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    }  
      
    /** 
     * 获得指定日期的前一天 
     *  
     * @param specifiedDay 
     * @return 
     * @throws Exception 
     */  
    public static String getSpecifiedDayBefore(String specifiedDay) {//可以用new Date().toLocalString()传递参数  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day - 1);  
  
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c  
                .getTime());  
        return dayBefore;  
    }  
  
    /** 
     * 获得指定日期的后一天 
     *  
     * @param specifiedDay 
     * @return 
     */  
    public static String getSpecifiedDayAfter(String specifiedDay) {  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day + 1);  
  
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")  
                .format(c.getTime());  
        return dayAfter;  
    }  
    
    public static String getStringFromDate(Date date) {
    	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
    
    public static Date getDateFromString(String date) {
    	try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    //获取后n天的字符串形式
    public static String getSpecifiedDayAfter(Date date,int afterDay) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int day = calendar.get(Calendar.DATE);
    	calendar.set(Calendar.DATE, day + afterDay);
    	String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    	return dayAfter;
    }

    //获取前n天的字符串形式
    public static String getSpecifiedDayBefore(Date date, int beforeDay) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int day = calendar.get(Calendar.DATE);
    	calendar.set(Calendar.DATE, day - beforeDay);
    	String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    	return dayBefore;
    }
    
    public static Date setHms0(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	return calendar.getTime();
    }
    
}
