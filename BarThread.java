package mian;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class BarThread extends Thread {
	
	 private static int DELAY = 950;   

	private JProgressBar bar;
	
	private String fileName;
	
	private boolean ing = true;

	public BarThread(JProgressBar bar, String fileName) {
		this.bar = bar;
		this.fileName = fileName;
		
		parseFile();
	}

    public BarThread(String currMusic) {
    }

    private void parseFile(){
		File file = new File(SystemConstant.path+fileName);
		
		try {
			FileInputStream fis = new FileInputStream(file);
			int b = fis.available();

			Bitstream bt = new Bitstream(fis);

			Header h = bt.readFrame();

			if(h == null){
				System.out.println("Header");
			}
			int time = (int) h.total_ms(b) / 1000;
			
		    bar.setMinimum(0);
		    bar.setMaximum(time);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (BitstreamException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		
		int minimum = bar.getMinimum();
		int maximum = bar.getMaximum();
		
		for (int i = minimum; i < maximum; i++) {
			if(ing){
				try {
					int value = bar.getValue();
					bar.setValue(value + 1);

					Thread.sleep(DELAY);
				} catch (InterruptedException ignoredException) {
				}
			}
		}
	}
	
	
	public boolean isIng() {
		return ing;
	}

	public void setIng(boolean ing) {
		this.ing = ing;
	}
}
