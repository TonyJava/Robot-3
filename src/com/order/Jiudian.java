package com.order;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public  class Jiudian implements ActionListener,ItemListener{
	 static JFrame f=null;  //��ΪҪ��main��̬�����б����ã����Ա�����Ϊstatic����
	  ButtonGroup bg;      //��ť�飬��������ɵ�ѡ��ť
	  JRadioButton r1,r2,r3,r4,r5;  //��ѡ��ť
	  JRadioButton c1,c2,c3,c4;  //��ѡ��ť
	  int op=0;static int i=0;
	  public Jiudian()
	  {   // Dialog = new JDialog(f,"ѡ������Ҫ�����ź���ϲ���Ĳ�",true);
	  	 f=new JFrame("ѡ������Ҫ�����ź���ϲ���Ĳ�");
		Container dialogPane=f.getContentPane();
	   dialogPane.setLayout(new GridLayout(3,1));
	    JPanel p1=new JPanel();            //�½�һ��Panel
	    p1.setLayout(new GridLayout(1,5));//���ñ߿�
	    p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
	     Color.green,4),"ѡ������",TitledBorder.CENTER,TitledBorder.TOP));//��ѡ��ť
	    r1=new JRadioButton("one");
	    r2=new JRadioButton("two");
	    r3=new JRadioButton("three");
	    r4=new JRadioButton("four");
	    r5=new JRadioButton("five");
	    p1.add(r1);p1.add(r2);
	    p1.add(r3); p1.add(r4);  p1.add(r5);
	    bg=new ButtonGroup();  //��ť�飬���5����ѡ��ť��ʹһ��ֻ��ѡ��һ��
	    bg.add(r1);bg.add(r2);
	    bg.add(r3);bg.add(r4);bg.add(r5);
	    r1.addItemListener(this);  //Ϊ��ѡ��ť����ItemListener�¼�������
	    r2.addItemListener(this);
	    r3.addItemListener(this);
	    r4.addItemListener(this);
	    r5.addItemListener(this);
	    JPanel p2=new JPanel();   //�½�һ��Pane1
	    p2.setLayout(new GridLayout(4,1));//���ñ߿�
	    p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green,4),"ѡ����ϲ���Ĳ�",TitledBorder.CENTER,TitledBorder.TOP));//��ѡť
	    c1=new JRadioButton("  С����Ģ�����۸�Ϊ��25Ԫ/��");
	    c2=new JRadioButton("   �ཷ���⣬ �۸�Ϊ��18Ԫ/��");
	    c3=new JRadioButton("   ��������� �۸�Ϊ��36Ԫ/��");
	    c4=new JRadioButton("  ��������ͷ���۸�Ϊ��36Ԫ/��");
	    p2.add(c1);p2.add(c2);
	    p2.add(c3); p2.add(c4);
	    c1.addItemListener(this);  //Ϊ��ѡ��ť����ItemListener�¼�������
	    c2.addItemListener(this);
	    c3.addItemListener(this);
	    c4.addItemListener(this);
	    JPanel p3=new JPanel();  //����һ���µ�Panel
	    p3.setLayout (new GridLayout(1,2));
	    JButton button1=new JButton("ȷ ��");
	    JButton button2=new JButton("�� ��");
	    p3.add(button1); p3.add(button2);
	    button1.addActionListener (this);
	    button2.addActionListener (this);      //������Panel�������������
	    dialogPane.add(p1,BorderLayout.NORTH);
	    dialogPane.add(p2,BorderLayout.CENTER);
	    dialogPane.add(p3,BorderLayout.SOUTH);
	    f.getRootPane ().setDefaultButton (button1); //���ô���س���Ӧ��ť
	     f.pack(); //�Ű�
	    f.setBounds(250,250,400,400);
	     f.addWindowListener(new WindowAdapter() {
	       public void windowClosing(WindowEvent evt) {System.exit(0);}});
	  }
	  public void itemStateChanged(ItemEvent e)  //��ѡť�����ʱ����
	  { if(e.getSource()==r1) op=1; if(e.getSource()==r2) op=2;
	    if(e.getSource()==r3) op=3; if(e.getSource()==r4) op=4;
	    if(e.getSource()==r5) op=5; if(e.getSource()==c1) i=1;
	    if(e.getSource()==c2) i=2;if(e.getSource()==c3) i=3;
	    if(e.getSource()==c4) i=4;
	  }
	  public void actionPerformed(ActionEvent e)  //��ѡ��ť�����ʱ����
	  {   String cmd = e.getActionCommand();
	    if (cmd.equals("ȷ ��"))
	    {    	 try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:jiudian","test","1234");
					 Statement stmt=con.createStatement();
	         int m=0,val=0;String str=null;String SQLOrder;
	          switch (op)
	          {    	 case 1:{
	              switch(i)
	                 {   case 1: m=1;val=25;str="С����Ģ��";
	                  SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	            case 2: m=1;val=18;str="�ཷ����";
	                  SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					 stmt.executeUpdate(SQLOrder);
	             case 3: m=1;val=36;str="�������";
	                  SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
				      stmt.executeUpdate(SQLOrder);
	            case 4:m=1;val=36;str="��������ͷ";
	           SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder); }
	            break;}
	        case 2:
	         switch(i)
	          {   case 1:m=2;val=25;str="С����Ģ��";
	           SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	            case 2:m=2;val=18;str="�ཷ����";
	          SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	            case 3: m=2;val=36;str="�������";
	          SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	               case 4:m=2;val=36;str="��������ͷ";
	           SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					 stmt.executeUpdate(SQLOrder); }
	        case 3:
	          switch(i)
	          {  case 1: m=3;val=25;str="С����Ģ��";
	           SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					 stmt.executeUpdate(SQLOrder);
	            case 2: m=3;val=18;str="�ཷ����";
	           SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	            case 3: m=3;val=36;str="�������";
	          SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	            case 4:m=3;val=36;str="��������ͷ";
	           SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder); }
	             break;
	        case 4:
	          switch(i)
	          {  case 1:m=4;val=25;str="С����Ģ��";
	                  SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	            case 2:m=4;val=18;str="�ཷ����";
	                  SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					 stmt.executeUpdate(SQLOrder);
	            case 3:m=4;val=36;str="�������";
	                  SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	            case 4: m=4;val=36;str="��������ͷ";
	                  SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					 stmt.executeUpdate(SQLOrder);  }
	            break;

	case 5: switch(i)
	                 {   case 1:
	                 m=5;val=25;str="С����Ģ��";
	                  SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	                 case 2:
	                 m=5;val=18;str="�ཷ����";
	                 SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	                  case 3:
	                 m=5;val=36;str="�������";
	                  SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					 stmt.executeUpdate(SQLOrder);
	                  case 4:
	                 m=5;val=36;str="��������ͷ";
	           SQLOrder="Insert Into jiudian Values ("+m+",'"+str+"',"+val+")";
					stmt.executeUpdate(SQLOrder);
	                    }
	            break;}
	          }
	    catch(Exception em){}
	  }
	  if(cmd.equals("�� ��")) {new jiezhang(f);
	  	}
	 }
	 public static void main(String args[])throws Exception
	  {   new Jiudian();
	      new jiudian1(f);             }
	}
	class jiudian1 implements ActionListener {
			JFrame f; //������
			    JDialog Dialog;
			public jiudian1(JFrame f)              //���췽��
			{  Dialog=new JDialog();  //�½�һ�Ի���
			  Dialog.setTitle ("�Ƶ����ϵͳ");  //���ñ���
				//f=new JFrame("�Ƶ����ϵͳ"); //����һ����������
			Container contentPane=Dialog.getContentPane(); //������������
				JPanel buttonPanel = new JPanel(); //����һ�м�����JPanel
			JButton b=new JButton("����ϵͳ");//����һԭ�����������ť
				b.addActionListener(this);//Ϊ��ť����¼�����������
				buttonPanel.add(b);	//���˰�ť��ӵ��м�����
			  b=new JButton("�˳�ϵͳ"); //�ٴ���һ��ť
				b.addActionListener(this);//Ϊ��ť�����¼�������
				buttonPanel.add(b);//����ť��ӵ��м�����

				buttonPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.green,2),"��ӭ����",
				TitledBorder.CENTER,TitledBorder.TOP));
				contentPane.add(buttonPanel,BorderLayout.CENTER);//���м�������ӵ��������
				Dialog.setBounds(250,250,200,200);
				Dialog.setVisible (true);
	      this.f=f;

	  }
	   public void actionPerformed(ActionEvent e)
	      {
	        String cmd = e.getActionCommand();
	         if (cmd.equals("����ϵͳ"))
	             { Dialog.dispose(); f.setVisible (true); } //��ʾ������
	         if(cmd.equals("�˳�ϵͳ"))  System.exit(0);
	     }
	}

	/////////////////////////
	class jiezhang implements ActionListener{
	      	   JDialog Dialog;
	     	   JLabel L1,L2,L3,L4,L5;
				JTextField F1=new JTextField();
				jiezhang(JFrame f){
				Dialog = new JDialog(f,"����",true);
				Container dialogPane=Dialog.getContentPane();
				dialogPane.setLayout(new GridLayout(4,2));
				  L1=new JLabel("��������������",SwingConstants.CENTER);
				  L2=new JLabel("���ܹ������ˣ�",SwingConstants.CENTER);
				  L4=new JLabel("���ܹ����ˣ�",SwingConstants.CENTER);
				  L3=new JLabel("",SwingConstants.CENTER);
				  L5=new JLabel("",SwingConstants.CENTER);
				  dialogPane.add(L1);
				  dialogPane.add(F1);
				  dialogPane.add(L2);
				  dialogPane.add(L3);
				  dialogPane.add(L4);
				  dialogPane.add(L5);
				  JButton b1=new JButton("ȷ��");
					dialogPane.add(b1);
					JButton b2=new JButton("ȡ��");
					dialogPane.add(b2);
					b1.addActionListener(this);
					b2.addActionListener(this);
					Dialog.setBounds(400,400,300,300);
					Dialog.show();
				}
				public void actionPerformed(ActionEvent e){
						String cmd=e.getActionCommand();
						if(cmd.equals("ȷ��")){
							try{
									Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:jiudian","test","1234");
					 Statement stmt=con.createStatement();
					 int sa=Integer.parseInt(F1.getText());
	  	     ResultSet rs=stmt.executeQuery("select sum(values) from jiudian where id="+sa+"");
	  	     while(rs.next()){
	         L3.setText(""+rs.getInt(1)+"Ԫ");
	  	          }
	  	       ResultSet rr=stmt.executeQuery("select * from jiudian");
									int j=0;
									while(rr.next()) j=j+1;
									L5.setText(""+j+" �ݲ�");
						stmt.executeUpdate("delete from jiudian where id="+sa+"");
								JOptionPane.showMessageDialog (Dialog,"лл�ݹˣ�","",JOptionPane.WARNING_MESSAGE);
									F1.setText("");
									stmt.close();
									con.close();
								}catch(Exception em){}
						}
			if(cmd.equals("ȡ��")){Dialog.dispose();}
		}
	}
