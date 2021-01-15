package mian;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {

	private String fileSuffix = "mp3,avi,wav,mid,asf,mpg,tti";
	@Override
	public boolean accept(File f) {
		if(f.isDirectory()){
			return true;
		}
		if(f.isFile()){
			String[] fileType = SystemConstant.fileType;
			String fileName = f.getName();
			
			String suffix = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
			boolean flag = false;
			for(int i=0;i<fileType.length;i++){
				if(suffix.equalsIgnoreCase(fileType[i])){
					flag = true;
					fileSuffix = fileType[i];
					break;
				}
			}
			return flag;
		}
		return false;
	}

	@Override
	public String getDescription() {
		
		return fileSuffix;
	}

}
