package mian;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Random;


public class JavaMusic implements Runnable {
	
	private Canvas canvas;
	
	private String currMusic;

	private Player player;
	
	private boolean start = true;
	
	private BarThread bar;
	
	public JavaMusic(String[] musics, Canvas canvas){
		this.canvas = canvas;
	}
	
	private void play(){
		@SuppressWarnings("static-access")
		String name = canvas.getMusics()[canvas.getCurr_music_num()];
		currMusic = SystemConstant.path + name;
		canvas.setLabelText("正在播放："+name);
		try {
			BufferedInputStream buffer = new BufferedInputStream(
					new FileInputStream(currMusic));
			player = new Player(buffer)  ;
			bar=new BarThread(currMusic);
			player.play();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	private int randomNum(){
		Random ran = new Random();
		return ran.nextInt(canvas.getMusics().length-1);
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while(true){
			if(start){
				if(player != null && player.isComplete()){
					int playMode = canvas.getPlayMode();
					int curr_music_num = canvas.getCurr_music_num();
					if(playMode == SystemConstant.Order_Cycle){
						if(curr_music_num < canvas.getMusics().length){
							canvas.setCurr_music_num(curr_music_num++);
						}else{
							canvas.setCurr_music_num(0);
						}
					}
					
					if(playMode == SystemConstant.Random_Play){
						canvas.setCurr_music_num(randomNum());
					}
					
					if(playMode == SystemConstant.Single_Cycle){
						
					}
					canvas.getjProgressBar1().setValue(0);
				}
				play();
			}
			
		}
	}
	
	public void start() {
		this.start = true;
		canvas.getjProgressBar1().setValue(0);
		try {
			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
		bar.setIng(true);
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		this.start = false;
		player.close();
		bar.setIng(false);
		bar.stop();
	}
	
}
