package com.order.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.order.GUI.Impl.RobotInterface;
import com.order.menu.GreetMenu;

/**
 * ����
 */
public class RobotGUI extends JFrame implements RobotInterface{
	
	/**
	 * ��ʼ������
	 */
	public RobotGUI(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * ��ӭ����
	 */
	@Override
	public void welcome() {
		// TODO Auto-generated method stub
		Font font = new Font("����",Font.PLAIN,40);      //����
		
		JPanel jp = new JPanel();                       //�������
		jp.setLayout(null);
		jp.setBackground(new Color(197,228,251));       //������ɫ
		
		String[] greets = GreetMenu.greet;                            //�����ʺ���
		String greet = greets[new Random().nextInt(greets.length)];
		JTextArea ar = new JTextArea(greet);
		ar.setFont(font);
		ar.setBackground(new Color(197,228,251));
		ar.setEditable(false);
		ar.setBounds(100, 150, 800, 200);
		
		JButton jb = new JButton("����ѡ��");
		jb.setBounds(100, 400, 150, 50);
		jb.setFont(new Font("����",Font.PLAIN,26));
		jb.addActionListener(new ActionListener() {             //��������¼������ʳƷ����б����
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				orderList();
			}
		});
		
		jp.add(ar);
		jp.add(jb);
		
		this.add(jp);
		this.setTitle("��ӭ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * ʳƷ�������
	 */
	@Override
	public void orderList() {
		// TODO Auto-generated method stub
		this.setVisible(false);       //���ô��ڲ��ɼ�
		this.removeAll();             //�Ƴ��������
		
		//���²���
		//code
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		RobotGUI gui = new RobotGUI();
		gui.welcome();
	}
}
