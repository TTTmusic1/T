package mian;

import view.MainMenu;

import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;

/**
 *
 * @author gehouse
 */
public class Canvas extends javax.swing.JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4326713179502782838L;
	/**
     * 创建新窗体
     */
	
	private static String[] musics;
	private ActionEvent evt;

	public Canvas() {
    	musics = MusicFile.listMusic();
    	labels = new JLabel[musics.length];
    	this.playMode = Integer.parseInt(SettingInit.getProperty("play.mode"));
    	if(playMode == SystemConstant.Random_Play){
    		if(musics != null && musics.length > 0){
    			curr_music_num = randomNum();
    		}else{
    			curr_music_num = 0;
    		}
    	}
        initComponents();
    }

    private int randomNum(){
		Random ran = new Random();
		return ran.nextInt(musics.length-1==0?1:musics.length-1);
	}
    
	/**
     * 从构造函数中调用此方法来初始化窗体。
	 * *警告：请勿修改此代码。此方法的内容总是
	 * *由窗体编辑器重新生成。
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        
        mouseInColor = Color.decode("#5F9EA0");
        mouseOutColor = Color.decode("#FFEFD5");
        selectColor  = Color.decode("#DEB887");
        
        jMenu = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem("播  放");
        jMenuItem1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jMenuItem2 = new javax.swing.JMenuItem("移  除");
        jMenuItem2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMenuItem3 = new javax.swing.JMenuItem("评  论");
		jMenuItem3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
		jMenu.add(jMenuItem3);
        
        initBackGroupColor();
        bindMenuEvent();
       
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("音乐播放器");
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dim = tool.getScreenSize();
        this.setBounds(dim.width-500, (dim.height-200)/6, 400, 200);
        this.setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

       
        jRadioButton1.setText("O-cycle");
        jRadioButton1.setMnemonic(SystemConstant.Order_Cycle);
        jRadioButton1.setToolTipText("顺序循环");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("S-cycle");
        jRadioButton2.setMnemonic(SystemConstant.Single_Cycle);
        jRadioButton2.setToolTipText("单曲循环");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("R-play");
        jRadioButton3.setToolTipText("随机播放");
        jRadioButton3.setMnemonic(SystemConstant.Random_Play);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        if(this.playMode == SystemConstant.Order_Cycle){
        	 jRadioButton1.setSelected(true);
        }
        if(this.playMode == SystemConstant.Random_Play){
        	jRadioButton3.setSelected(true);
	    }
        if(this.playMode == SystemConstant.Single_Cycle){
        	jRadioButton2.setSelected(true);
	    }
        jButton1.setText("PLAY");
        jButton1.setToolTipText("播放");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2.setEnabled(true);
				jButton1.setEnabled(false);
				jm.start();
				 
            }
        });

        jButton2.setText("STOP");
        jButton2.setToolTipText("暂停");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButton1.setEnabled(true);
            	jButton2.setEnabled(false);
            	jm.stop();
            }
        });

        jButton3.setText("PREV");
        jButton3.setToolTipText("上一首");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jm.stop();
            	labels[curr_music_num].setBackground(mouseOutColor);
            	labels[curr_music_num].setOpaque(true);
            	if(curr_music_num == 0){
            		curr_music_num = musics.length-1;
            	}else{
            		curr_music_num--;
            	}
            	labels[curr_music_num].setBackground(selectColor);
            	labels[curr_music_num].setOpaque(true);
            	currLabel = labels[curr_music_num];
            	jm.start();
            }
        });

        jButton4.setText("NEXT");
        jButton4.setToolTipText("下一首");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jm.stop();
            	labels[curr_music_num].setBackground(mouseOutColor);
            	labels[curr_music_num].setOpaque(true);
            	if(curr_music_num == musics.length-1){
            		curr_music_num = 0;
            	}else{
            		curr_music_num++;
            	}
            	labels[curr_music_num].setBackground(selectColor);
            	labels[curr_music_num].setOpaque(true);
            	currLabel = labels[curr_music_num];
            	jm.start();
            }
        });

        jButton6.setText("登录");

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	new MainMenu().setVisible(true);
            }
        });
        
        jButton5.setText("A-M");
        jButton5.setToolTipText("添加歌曲");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	addMusicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setAutoscrolls(true);
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        ParallelGroup hGroup = jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        SequentialGroup sGroup = jPanel4Layout.createSequentialGroup();
        for(int i=0;i<musics.length;i++){
        	JLabel label = new JLabel(musics[i]);
        	labels[i] = label;
        	label.setDisplayedMnemonic(i);
        	
        	if(i == curr_music_num){
        		this.currLabel = label;
        		label.setBackground(this.selectColor);
        		label.setOpaque(true);
        	}
        	hGroup.addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        	sGroup.addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE);
            if(i+1 == musics.length){
           	 	sGroup.addGap(0, 400, Short.MAX_VALUE);
            }else{
           	 	sGroup.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            }
            label.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseExited(MouseEvent e) {
					JLabel label = (JLabel) e.getComponent();
					
					setCursor(Cursor.getDefaultCursor());
					if(label != currLabel){
						label.setBackground(mouseOutColor);
						label.setOpaque(true);
					}
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
					JLabel label = (JLabel) e.getComponent();
					if(label != currLabel){
						label.setBackground(mouseInColor);
						label.setOpaque(true);
					}
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2){
						JLabel label = (JLabel) e.getComponent();
						currLabel.setBackground(mouseOutColor);
						label.setBackground(selectColor);
						label.setOpaque(true);
						currLabel = label;
						jm.stop();
						curr_music_num = label.getDisplayedMnemonic();
						jm.start();
					}
					
					if(e.isMetaDown()){
						JLabel label = (JLabel) e.getComponent();
						jMenu.show(label, e.getX(), e.getY());
						menuLabel = label;
					}
					
				}
			});
        }
        jPanel4Layout.setHorizontalGroup(hGroup);
        ParallelGroup vGroup = jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        vGroup.addGroup(sGroup);
        
        jPanel4Layout.setVerticalGroup(vGroup);
       
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
       
        pack();
        musicListH = jPanel4.getHeight();
    }// </editor-fold>

    private void initBackGroupColor(){
    	Color backColor = Color.decode("#808000");
    	
    	jPanel1.setBackground(backColor);
        jPanel2.setBackground(backColor);
        jPanel3.setBackground(backColor);
        jPanel4.setBackground(mouseOutColor);
        
        jButton1.setBackground(backColor);
        jButton2.setBackground(backColor);
        jButton3.setBackground(backColor);
        jButton4.setBackground(backColor);
        jButton5.setBackground(backColor);
        jButton6.setBackground(backColor);
    }
    private void bindMenuEvent(){
    	
    	jMenuItem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jMenuItem1ActionPerformed();
				
			}
		});
    	
    	jMenuItem2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jMenuItem2ActionPerformed();
			}
		});

    	jMenuItem3.addActionListener(new ActionListener(){

    		public void actionPerformed(ActionEvent arg0)
			{
				jMenuItem3ActionPerformed();
			}
		});
    	
    }

	private void jMenuItem3ActionPerformed() {
		currLabel.setBackground(mouseOutColor);
		currLabel.setOpaque(true);
		menuLabel.setBackground(selectColor);
		menuLabel.setOpaque(true);
		currLabel = menuLabel;
		curr_music_num = menuLabel.getDisplayedMnemonic();
		comment comment = new comment();

	}


	private void jMenuItem1ActionPerformed(){


    }
    
    private void cleanMusicAndLabel(int index){
    	MusicFile.deleteMusic(musics[index]);
    	musics[index] = null;
    	String[] newMusics = new String[musics.length-1];
    	int pos = 0;
    	for(int i=0;i<musics.length;i++){
    		if(musics[i] == null){
    			continue;
    		}
    		newMusics[pos] = musics[i];
    		pos++;
    	}
    	musics = newMusics;
    	
    	labels[index] = null;
    	JLabel[] newLabels = new JLabel[labels.length-1];
    	int flag = 0;
    	for(int i=0;i<labels.length;i++){
    		if(labels[i] == null){
    			continue;
    		}
    		newLabels[flag] = labels[i];
    		flag++;
    	}
    	labels = newLabels;
    }
    
    private void jMenuItem2ActionPerformed(){
    	jPanel4.remove(menuLabel);
    	int index = menuLabel.getDisplayedMnemonic();

		this.cleanMusicAndLabel(index);
		
		this.rePaintMusicList(null);
		
		if(menuLabel == currLabel){
			
			if(index == musics.length){
				index = 0;
			}else{
				index++;
			}
			
			
			labels[index].setBackground(selectColor);
			labels[index].setOpaque(true);
			jm.stop();
			if(curr_music_num == musics.length){
	    		curr_music_num = 0;
	    	}else{
	    		curr_music_num++;
	    	}
			currLabel = labels[curr_music_num];
			jm.start();
		}
		
    }
	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	jRadioButton2.setSelected(false);
    	jRadioButton3.setSelected(false);
    	SettingInit.setProperty("play.mode", jRadioButton1.getMnemonic()+"");
    	this.setPlayMode(jRadioButton1.getMnemonic());
    }                                             

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	jRadioButton1.setSelected(false);
    	jRadioButton3.setSelected(false);
    	SettingInit.setProperty("play.mode", jRadioButton2.getMnemonic()+"");
    	this.setPlayMode(jRadioButton2.getMnemonic());
    }                                             

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	jRadioButton2.setSelected(false);
    	jRadioButton1.setSelected(false);
    	SettingInit.setProperty("play.mode", jRadioButton3.getMnemonic()+"");
    	this.setPlayMode(jRadioButton3.getMnemonic());
    }
    

    
    private void addMusicActionPerformed(java.awt.event.ActionEvent evt) {  
    	JFileChooser fc = new JFileChooser();
    	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	fc.setMultiSelectionEnabled(true);
    	fc.setFileFilter(new MyFileFilter());
    	FileSystemView fsv = FileSystemView.getFileSystemView();
    	String historyVisitDirectory = SettingInit.getProperty("history.file.chooser.directory");
    	if(historyVisitDirectory == null || "".equalsIgnoreCase(historyVisitDirectory)){
    		historyVisitDirectory = fsv.getHomeDirectory().getPath();
    	}
    	
    	fc.setCurrentDirectory(new File(historyVisitDirectory));
    	fc.setDialogTitle("选择音乐文件");
        int intRetVal = fc.showOpenDialog(this);
        if( intRetVal == JFileChooser.APPROVE_OPTION){
        	File[] files = fc.getSelectedFiles();
        	this.addMusic(files);
        	this.rePaintMusicList(files);
        	String currentDirectory = fc.getCurrentDirectory().getPath();
        	SettingInit.setProperty("history.file.chooser.directory", currentDirectory);
        	AddMusicThread addMusciThread = new AddMusicThread(files);
        	addMusciThread.start();
        }
    	
    }
    
    private void addMusic(File[] files){
    	int musicsLenth = musics.length;
    	String[] newMusics = new String[musicsLenth+files.length];
    	for(int i=0;i<musicsLenth;i++){
    		newMusics[i] = musics[i];
    	}
    	for(int j=0;j<files.length;j++){
    		newMusics[j+musicsLenth] = files[j].getName();
    	}
    	musics = newMusics;
    }
    
	private void rePaintMusicList(File[] files){
		if(files != null){
			JLabel[] newLbaes = new JLabel[labels.length+files.length];
			for(int i=0;i<labels.length;i++){
				newLbaes[i] = labels[i];
			}
			
			for(int j=0;j<files.length;j++){
	    		JLabel label = new JLabel(files[j].getName());
	    		if(currLabel == null && j == 0){
	    			currLabel = label;
	    		}
	    		label.addMouseListener(new MouseAdapter() {
	 				
	 				@Override
	 				public void mouseExited(MouseEvent e) {
	 					JLabel label = (JLabel) e.getComponent();
	 					labels[label.getDisplayedMnemonic()].setCursor(new Cursor(Cursor.HAND_CURSOR));
	 				}
	 				
	 				@Override
	 				public void mouseEntered(MouseEvent e) {
	 					JLabel label = (JLabel) e.getComponent();
	 					labels[label.getDisplayedMnemonic()].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	 				}
	 				
	 				@Override
	 				public void mouseClicked(MouseEvent e) {
	 					if(e.getClickCount() == 2){
	 						JLabel label = (JLabel) e.getComponent();
	 						currLabel.setBackground(mouseOutColor);
	 						label.setBackground(selectColor);
	 						label.setOpaque(true);
	 						currLabel = label;
	 						jm.stop();
	 						curr_music_num = label.getDisplayedMnemonic();
	 						jm.start();
	 					}
	 					
	 					if(e.isMetaDown()){
	 						JLabel label = (JLabel) e.getComponent();
	 						jMenu.show(label, e.getX(), e.getY());
	 						menuLabel = label;
	 					}
	 					
	 				}
	 			});
	    		newLbaes[j+labels.length] = label;
	    		
	    	}
			labels = newLbaes;
		}
		
		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        ParallelGroup hGroup = jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        SequentialGroup sGroup = jPanel4Layout.createSequentialGroup();
        
        currLabel.setBackground(this.selectColor);
		currLabel.setOpaque(true);
        for(int i=0;i<labels.length;i++){
        	JLabel label = labels[i];
        	label.setDisplayedMnemonic(i);
       
        	hGroup.addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        	sGroup.addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE);
            if(i+1 == labels.length){
           	 	sGroup.addGap(0, 400, Short.MAX_VALUE);
            }else{
           	 	sGroup.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            }
        }
        jPanel4Layout.setHorizontalGroup(hGroup);
        ParallelGroup vGroup = jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        vGroup.addGroup(sGroup);
        
        jPanel4Layout.setVerticalGroup(vGroup);
    }
    

    /**
     *
	 * @param args 命令行参数
     */
    public static void main(String args[]) {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /**
         * 创建和显示窗体
         */
    	Canvas can = new Canvas();
    	can.setVisible(true);
    	if(musics != null && musics.length > 0){
    		  jm = new JavaMusic(musics, can);
    	      jm.run();
    	}
      
    }
    
    public void setLabelText(String text){
    	this.jLabel1.setText(text);
    }
    // Variables declaration - do not modify
    static JavaMusic jm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JPopupMenu jMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel currLabel;
    private javax.swing.JLabel menuLabel;
    private java.awt.Color mouseInColor;
    private java.awt.Color mouseOutColor;
    private java.awt.Color selectColor;
    
    private JLabel[] labels;
    
    private int musicListH = 0;
    
    private int playMode = 3;
    
    private int curr_music_num;
    // End of variables declaration

    
	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}


	public int getCurr_music_num() {
		return curr_music_num;
	}


	public void setCurr_music_num(int curr_music_num) {
		this.curr_music_num = curr_music_num;
	}


	public int getPlayMode() {
		return playMode;
	}


	public void setPlayMode(int playMode) {
		this.playMode = playMode;
	}


	public void setjLabel1(javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}


	public javax.swing.JProgressBar getjProgressBar1() {
		return jProgressBar1;
	}


	public void setjProgressBar1(javax.swing.JProgressBar jProgressBar1) {
		this.jProgressBar1 = jProgressBar1;
	}


	public javax.swing.JPanel getjPanel2() {
		return jPanel2;
	}


	public void setjPanel2(javax.swing.JPanel jPanel2) {
		this.jPanel2 = jPanel2;
	}


	public static String[] getMusics() {
		return musics;
	}


	public static void setMusics(String[] musics) {
		Canvas.musics = musics;
	}
    
    
}

