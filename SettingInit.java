package mian;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class SettingInit {
	
	private static String filePath = "source/setting.properties";
	
	public static String getProperty(String ropertyName){
		
		Properties prop = getProperties();
		
		String pm = prop.getProperty(ropertyName);
		String mode = "3";
		if(pm != null){
			mode = pm;
		}
		return mode;
		
	}
	
	public static void setProperty(String ropertyName, String value){
		
		
		try {
			Properties prop = getProperties();
			
			OutputStream fos = new FileOutputStream(filePath);
			prop.setProperty(ropertyName, value+"");
			prop.store(fos, "Update "+ropertyName+" value");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Properties getProperties(){
		Properties prop = new Properties();
		InputStream in;
		try {
			
			in = new BufferedInputStream (new FileInputStream(filePath));
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(SetInit.currPlayMode());
		//SetInit.setPlayMode(3);
	}

}
