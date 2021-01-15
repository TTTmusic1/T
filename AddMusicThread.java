package mian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddMusicThread extends Thread {

	private File[] files;
	
	public AddMusicThread(File[] files){
		this.files = files;
	}
	
	private void addMusic(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		for(File f : files){
			try {
				fis = new FileInputStream(f);
				fos = new FileOutputStream(new File(SystemConstant.path+f.getName()));
				byte[] buf = new byte[1024];
				
				int len = 0;
				while((len = fis.read(buf)) != -1){
					fos.write(buf, 0, len);
					fos.flush();
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		try {
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		addMusic();
	}
	
	

}
