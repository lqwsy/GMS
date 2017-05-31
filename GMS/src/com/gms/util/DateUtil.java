package com.gms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	public static void main(String[] args) {  
        Date date = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String specifiedDay = sdf.format(date);  
        System.out.println(getSpecifiedDayBefore(specifiedDay));  
        System.out.println(getSpecifiedDayAfter(specifiedDay));  
        System.out.println(getSpecifiedDayAfter(new Date()));
        System.out.println(getSpecifiedDay(new Date()));
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
    
    public static String getSpecifiedDay(Date date) {
    	return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    
    //获取下一天的字符串形式
    public static String getSpecifiedDayAfter(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int day = calendar.get(Calendar.DATE);
    	calendar.set(Calendar.DATE, day+1);
    	String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    	return dayAfter;
    }
}
