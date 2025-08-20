package Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GetDate {
	
	 public static String getdateAfter(){

	Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式2014-12-26 09:10:33
	Calendar c= Calendar.getInstance();
	c.setTime(dt);
	int day=c.get(Calendar.DATE);
	c.set(Calendar.DATE, day+1);
		String nowTime= df.format(c.getTime());//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
	return nowTime;
	 }
	public static String getdate2DaysBefore(){

		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式2014-12-26 09:10:33
		Calendar c= Calendar.getInstance();
		c.setTime(dt);
		int day=c.get(Calendar.DATE);
		c.set(Calendar.DATE, day-2);
		String nowTime= df.format(c.getTime());//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		return nowTime;
	}
	 public static String getdateNow(){
		 
		 Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式2014-12-26 09:10:33
				String nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
			return nowTime;
		 		 
	 }
 	public static String getdate(){
		 
	 	Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间

	 	//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式2014-12-26 09:10:33
	    DateFormat df = new SimpleDateFormat("ddHHmmss");
	 	String nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
			return nowTime;
		 		 
	 }
	public static String getdateAppend(int month, int day){

		String nowTime="2018-"+month+"-"+day+" 11:31:26";
		return nowTime;

	}
	public static String getdate1(){

		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式2014-12-26 09:10:33
		//DateFormat df = new SimpleDateFormat("ddHHmm");
		String nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		return nowTime;

	}
	public static String getdateDD(){

		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式2014-12-26 09:10:33
		//DateFormat df = new SimpleDateFormat("dd");
		String nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		return nowTime;

	}
	public static String getdateYMD(){

		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间

		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式2014-12-26 09:10:33
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		return nowTime;

	}
 public static String getdateAfter5Min(){

		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式2014-12-26 09:10:33
		Calendar c= Calendar.getInstance();
		c.setTime(dt);
		int minute=c.get(Calendar.MINUTE);
		c.set(Calendar.MINUTE, minute+1);
			String after5min= df.format(c.getTime());//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		return after5min;
		 }
	public static String getdateMMSS(){

		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("mm:ss");//设置显示格式2014-12-26 09:10:33
		Calendar c= Calendar.getInstance();
		c.setTime(dt);
		int minute=c.get(Calendar.MINUTE);
		c.set(Calendar.MINUTE, minute+1);
		String after5min= df.format(c.getTime());//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		return after5min;
	}
	public static long getTimestamp() throws ParseException {

		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式2014-12-26 09:10:33
		Calendar c= Calendar.getInstance();
		c.setTime(dt);
		int minute=c.get(Calendar.MINUTE);
		c.set(Calendar.MINUTE, minute+1);
		String after5min= df.format(c.getTime());//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示

		String dateString = "2022-01-01 12:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(dateString);
		long timestamp = date.getTime() / 1000;
		System.out.println(timestamp);
		return timestamp;
	}
	//得到本月的第一天
	public static String getMonthFirstDay() {
		Calendar calendar = Calendar.getInstance();
		//获得月份:上一个月
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);

		//获得日期:第一天
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat firstDay= new SimpleDateFormat("yyyy-MM-dd");
		return   firstDay.format(calendar.getTime());
	}

	// 得到本月的最后一天
	public static String getMonthLastDay() {
		Calendar calendar = Calendar.getInstance();
		//获得月份:上一个月
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);

		//获得日期:最后一天
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat lastDay= new SimpleDateFormat( "yyyy-MM-dd");
		return   lastDay.format(calendar.getTime());
	}
	/**
	 * date2比date1多的天数
	 * @return
	 */
	public static int differentDays() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = format.parse(getdate2DaysBefore());
		Date date1 = format.parse(getMonthLastDay());
		//SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1= cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);
		System.out.println("day1: "+day1);
		System.out.println("day2: "+day2);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if(year1 != year2) //不是同一年
		{
			int timeDistance = 0 ;
			for(int i = year1 ; i < year2 ; i ++)
			{
				if(i%4==0 && i%100!=0 || i%400==0) //闰年
				{
					timeDistance += 366;
				}
				else //不是闰年
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2-day1) ;
		}
		else //不同年
		{
			System.out.println("判断day2 - day1 : " + (day2-day1));
			return day2-day1;
		}
	}
	public static long get2DaysBefore()  {

		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd 08:00:00");//设置显示格式2014-12-26 09:10:33
		Calendar c= Calendar.getInstance();
		c.setTime(dt);
		int day=c.get(Calendar.DATE);
		c.set(Calendar.DATE, day-2);
		String nowTime= df.format(c.getTime());//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示


		//String dateString = "2022-01-01 12:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(nowTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long timestamp = date.getTime() / 1000;
		return timestamp;
	}
	public static long get1DaysBefore()  {

		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd 07:59:59");//设置显示格式2014-12-26 09:10:33
		Calendar c= Calendar.getInstance();
		c.setTime(dt);
		int day=c.get(Calendar.DATE);
		c.set(Calendar.DATE, day-1);
		String nowTime= df.format(c.getTime());//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示


		//String dateString = "2022-01-01 12:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(nowTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long timestamp = date.getTime() / 1000;
		return timestamp;
	}
	public static List<String> getTimeStampList(String startTime, String endTime, String format) {
		List<String> timeStampList = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat(format);


		/*Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式2014-12-26 09:10:33
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime= df.format(dt);*/

		try {
			Date startDate = sdf.parse(startTime);
			Date endDate = sdf.parse(endTime);
			long startTimeMillis = startDate.getTime();
			long endTimeMillis = endDate.getTime();

			while (startTimeMillis <= endTimeMillis) {
				//timeStampList.add(String.valueOf(startTimeMillis));
				timeStampList.add(sdf.format(startTimeMillis));
				startTimeMillis += 24 * 60 * 60 * 1000; // 每天的毫秒数
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStampList;
	}
 public static void main(String args[]) throws ParseException {
	/* String startTime = "2023-01-01 00:00:00";
	 String endTime = "2023-01-03 00:00:00";
	 List<String> timeStampList = getTimeStampList(startTime, endTime, "yyyy-MM-dd HH:mm:ss");*/
	/* String startTime = "20230101";
	 String endTime = "20230203";
	 List<String> timeStampList = getTimeStampList(startTime, endTime, "yyyyMMdd");
	 System.out.println(timeStampList);*/
	/*System.out.println( GetDate.getdateNow());
	 System.out.println(GetDate.getdate1());
	 System.out.println(GetDate.getdateDD());
	System.out.println(  GetDate.getdateMMSS());
	 System.out.println(GetDate.getdateS());*/

	 /*System.out.println(GetDate.getMonthFirstDay());
	 System.out.println(GetDate.getMonthLastDay());
	 System.out.println(GetDate.getdate2DaysBefore());
	 int days=GetDate.differentDays();
	 System.out.println(days);*/
	 System.out.println(GetDate.getdateDD());
	/* System.out.println(GetDate.get1DaysBefore());
	 System.out.println(GetDate.get2DaysBefore());*/
 }


}
