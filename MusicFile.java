package mian;

import java.io.File;

public class MusicFile {

	public static String[] listMusic(){
		File file = new File(SystemConstant.path);
		String[] files = file.list();
		return files;
	}
	
	public static void deleteMusic(String musicName){
		File file = new File(SystemConstant.path+musicName);
		if(file.exists()){
			file.deleteOnExit();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MusicFile.listMusic();
	}

}
