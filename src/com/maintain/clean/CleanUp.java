package com.maintain.clean;

import java.io.File;
import java.util.TimerTask;

/****************************************************************************************************
 *  CleanUp class deletes all the files that gets downloaded in download folder
 *  But Files downloaded in Movies folder will be copied to other folder.
 *  Reads downolad path and movies path from config file

 *  @author: Ravi Sankar Karuturi
 *  @createddate: 01/11/2015 
 *****************************************************************************************************/

public class CleanUp extends TimerTask {


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			PropertyFileReader propload =new PropertyFileReader();
			File currentDirFile = new File(".");
	 		 String helper = currentDirFile.getAbsolutePath().replace("\\.", "");
			String cleanuplocation = helper+"/"+propload.getProperty("CleanUpPlace");
			String moviesPath= helper+"/"+propload.getProperty("MyMoviesPath");
			System.out.println("Starting Clean the path "+cleanuplocation);
			cleanDirectory(new File(cleanuplocation),moviesPath); 
			System.out.println("Done cleaning");
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	public  void cleanDirectory(File dir,String moviespath) {
		for (File file: dir.listFiles()) {
		    if (file.isDirectory()) {
		    	cleanDirectory(file,moviespath);
		    }else{
		    	if(file.getAbsolutePath().contains("Movies")){
					try{
					   if(file.renameTo(new File(moviespath+file.getName()))){
						System.out.println("File is moved successful to "+moviespath);
					   }else{
						System.out.println("Movie file "+file.getName() +" failed to move!");
					   }    
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{
					file.delete();
				}
		    }
		    if(!file.getName().equals("Movies"))file.delete();
		    
		}
	}

}
