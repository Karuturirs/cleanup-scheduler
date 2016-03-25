package com.maintain.clean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/****************************************************************************************************
 *  MyScheduler class triggers the scheduler job at the time specified.
 *  @ args[0]: TIMESTAMP format ex: yyyy-MM-dd HH:mm:ss 
 *  			Note:if an older time is passed the task executes immediate
 *  @ args[1]: 1 or 2 (1 = triggers CleanUp Action, 2= triggers DummyTask)

 *  @author: Ravi Sankar Karuturi
 *  @createddate: 01/11/2015 
 *****************************************************************************************************/


public class MyScheduler {

	public static void main(String[] args) {
		
		try{
			
			String execTime = "2015-11-02 04:10:02"; //args[0]+" "+args[1]; //if passing from cmd, Make sure escaping space for TIMESTAMP depending on OS.
			String doaction ="1";     //args[2];
			
			Date execdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(execTime);
			System.out.println("Started the schedule....");
			Timer timer =new Timer();
			switch(Integer.parseInt(doaction)){
			case 1: timer.schedule(new CleanUp(), execdate);
						break;
			case 2: timer.schedule(new DummyTask(), execdate);
						break;
			default:timer.schedule(new CleanUp(), execdate);
						break;
			}
		}catch(ParseException e){
			System.out.println("May be, Not a proper date format. Please check the timestamp argument. ");
		}catch(Exception e){
			System.out.println("Please check the below error.");
			e.printStackTrace();
		}
		
	}

}
