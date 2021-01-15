package view;

import dao.NewUserDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * 
 * @author ��ķ���Ϲ�
 *ע��Ľ���
 */
public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField newuserField;
	private JPasswordField newpassField;
	private JPasswordField surepassField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewUser() {
		setTitle("\u6B22\u8FCE\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel newuserlabel = new JLabel("\u8F93\u5165\u8D26\u53F7\uFF1A");
		newuserlabel.setFont(new Font("����", Font.BOLD, 15));
		newuserlabel.setBounds(30, 10, 80, 30);
		contentPane.add(newuserlabel);
		
		JLabel newpasslabel = new JLabel("\u8F93\u5165\u5BC6\u7801\uFF1A");
		newpasslabel.setFont(new Font("����", Font.BOLD, 15));
		newpasslabel.setBounds(30, 50, 80, 30);
		contentPane.add(newpasslabel);
		
		JLabel surepasslabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		surepasslabel.setFont(new Font("����", Font.BOLD, 15));
		surepasslabel.setBounds(30, 100, 80, 30);
		contentPane.add(surepasslabel);
		
		JLabel newusererrorlabel = new JLabel("");
		newusererrorlabel.setForeground(Color.RED);
		newusererrorlabel.setFont(new Font("����", Font.BOLD, 15));
		newusererrorlabel.setBounds(300, 10, 125, 30);
		contentPane.add(newusererrorlabel);
		
		JLabel newpasserrorlabel = new JLabel("");
		newpasserrorlabel.setForeground(Color.RED);
		newpasserrorlabel.setFont(new Font("����", Font.BOLD, 15));
		newpasserrorlabel.setBounds(300, 50, 125, 30);
		contentPane.add(newpasserrorlabel);
		
		JLabel surepasserrorlabel = new JLabel("");
		surepasserrorlabel.setForeground(Color.RED);
		surepasserrorlabel.setFont(new Font("����", Font.BOLD, 15));
		surepasserrorlabel.setBounds(300, 100, 125, 30);
		contentPane.add(surepasserrorlabel);
		
		newuserField = new JTextField();
		newuserField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				//���˻������ʧȥ����ʱ����ô˷���
//				System.out.println("�˻������ʧȥ����");
				String username = newuserField.getText();
				if (username== null || username.trim().length() == 0) {
//		 			System.out.println("�˻��������6λ");
					newusererrorlabel.setText("�˻�����Ϊ�գ�");
				}else{
					newusererrorlabel.setText("");
				}
			}
		});
		newuserField.setBounds(130, 10, 150, 30);
		contentPane.add(newuserField);
		newuserField.setColumns(10);
		
		newpassField = new JPasswordField();
		newpassField.setBounds(130, 50, 150, 30);
		contentPane.add(newpassField);
		newpassField.setColumns(10);
		
		surepassField = new JPasswordField();
		surepassField.setBounds(130, 100, 150, 30);
		contentPane.add(surepassField);
		surepassField.setColumns(10);
		
		JLabel newerrorlabel = new JLabel("");
		newerrorlabel.setForeground(Color.RED);
		newerrorlabel.setFont(new Font("����", Font.BOLD, 15));
		newerrorlabel.setBounds(90, 150, 300, 30);
		contentPane.add(newerrorlabel);
		
		JButton newbutton = new JButton("\u6CE8\u518C");
		newbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newpasslabel.getText().equals(surepasslabel.getText())) {
					NewUserDao n=new NewUserDao();
					boolean b=n.Create(newuserlabel.getText(),newpasslabel.getText());
					if(b){//ע��ʧ��
						JOptionPane.showMessageDialog(null, "ע��ʧ��!");
					}else{//ע��ɹ�,��תҳ��
					    JOptionPane.showMessageDialog(null, "ע��ɹ�!");
					    MainMenu m=new MainMenu();//ע��ɹ���ת����¼����
					}
				}else {
					newerrorlabel.setText("������������벻��ͬ��");
				}
				}
		});
		newbutton.setFont(new Font("����", Font.BOLD, 15));
		newbutton.setBounds(50, 200, 100, 30);
		contentPane.add(newbutton);
		
		JButton backbutton = new JButton("\u8FD4\u56DE");
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu m=new MainMenu();
				m.show();//��ת����¼����
				dispose();//�رձ�����
			}
		});
		backbutton.setFont(new Font("����", Font.BOLD, 15));
		backbutton.setBounds(175, 200, 100, 30);
		contentPane.add(backbutton);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newuserField.setText("");
				newpassField.setText("");
				surepassField.setText("");
			}
		});
		button.setFont(new Font("����", Font.BOLD, 15));
		button.setBounds(300, 200, 100, 30);
		contentPane.add(button);
	}

}
