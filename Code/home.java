import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class home extends JFrame implements ActionListener
{
        JLabel l,l0,l1,l2,l3,l4,l5,l8;
	JComboBox c;	
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    Font f2,f1,f3;
    home()
    {
    	super("CABLE OPERATING SYSTEM");
    	setSize(980,720);setLocation(200,50);
    	setResizable(false);
		Container p=getContentPane();
    	p.setLayout(null);
     	p.setBackground(Color.gray);
        f1=new Font("Constantia",Font.BOLD,14);
        f2=new Font("Constantia",Font.BOLD,40);
        f3=new Font("Times New Roman",Font.BOLD,15);
        Icon exit = new ImageIcon("exit.jpg");                      
        	
              l4=new JLabel("DATE:");//system date
          	  l4.setFont(f1);
              l4.setForeground(Color.white);
              l4.setBounds(660,80,60,40);
          p.add(l4);
                l5=new JLabel();l5.setFont(f3);
                l5.setBounds(710,85,85,30);
                l5.setForeground(Color.white);               
   		p.add(l5);       		
          		Date date2 = new Date(); 
	   			SimpleDateFormat sdf= new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy");
	   			String s= sdf.format(date2);
                l5.setText(s); 
              	                 
                b1=new JButton("CUSTOMER");
                b1.setBounds(80,296,120,50);b1.setBackground(Color.darkGray);
                b1.setFont(f1);
                b1.setForeground(Color.white);//b1.setBorderPainted(false);
                b1.setMnemonic('c');
                b1.setToolTipText("Goes To CUSTOMER Window");
                b1.addActionListener(this);
        p.add(b1);
        	 
        			
        		
                b2=new JButton("MANAGER");
                b2.setBounds(400,110,120,50);b2.setBackground(Color.darkGray);
                b1.setFont(f1);
                b2.setForeground(Color.white);
                b2.setMnemonic('m');
                b2.setToolTipText("Goes To MANAGER Window");
                b2.addActionListener(this);
        p.add(b2);
                b3=new JButton("AGENT");
                b3.setBounds(85,195,120,50);b3.setBackground(Color.darkGray);
                b3.setFont(f1);
                b3.setForeground(Color.white);
                b3.setMnemonic('a');
                b3.setToolTipText("Goes To AGENT Window");
                b3.addActionListener(this);
        p.add(b3);
        
                b4=new JButton("EMPLOYEE");
                b4.setBounds(705,185,120,50);b4.setBackground(Color.darkGray);
                b4.setFont(f1);
                b4.setForeground(Color.white);
                b4.setMnemonic('e');
                b4.setToolTipText("Goes To EMPLOYEE Window");
                b4.addActionListener(this);
        p.add(b4);

                b5=new JButton("SUPPLIER");
                b5.setBounds(715,296,120,50);b5.setBackground(Color.darkGray);
                b5.setFont(f1);
                b5.setForeground(Color.white);
                b5.setMnemonic('s');
                b5.setToolTipText("Goes To SUPPLIER Window");
                b5.addActionListener(this);
        p.add(b5);

                b6=new JButton("CUST BILL");
                b6.setBounds(95,400,120,50);b6.setBackground(Color.darkGray);
                b6.setFont(f1);
                b6.setForeground(Color.white);//b6.setBorderPainted(false);
                b6.setMnemonic('u');
                b6.setToolTipText("Goes To CUSTOMER BILL Window");
                b6.addActionListener(this);
        p.add(b6);

                b7=new JButton("SUP BILL");
                b7.setBounds(695,400,120,50);b7.setBackground(Color.darkGray);
                b7.setFont(f1);
                b7.setForeground(Color.white);
                b7.setMnemonic('p');
                b7.setToolTipText("Goes To SUPPLIER BILL Window");
                b7.addActionListener(this);
        p.add(b7);
        
                b8=new JButton("REPORTS");
                b8.setBounds(400,610,120,50);b8.setBackground(Color.darkGray);
                b8.setFont(f1);
                b8.setForeground(Color.white);
                b8.setMnemonic('r');
                b8.setToolTipText("Goes To REPORTS Window");
                b8.addActionListener(this);
        p.add(b8);
        
        		b9=new JButton("ORDER");
                b9.setBounds(670,495,120,50);
                b9.setBackground(Color.darkGray);
                b9.setFont(f1);
                b9.setForeground(Color.white);
                b9.setMnemonic('o');
                b9.setToolTipText("Goes To PURCHASE ORDER Window");
                b9.addActionListener(this);
        p.add(b9);
        
        		b10=new JButton("PRODUCT");
                b10.setBounds(125,495,120,50);
                b10.setBackground(Color.darkGray);
                b10.setFont(f1);
                b10.setForeground(Color.white);
                b10.setMnemonic('P');
                b10.setToolTipText("Goes To PRODUCT INFORMATION Window");
                b10.addActionListener(this);
        p.add(b10);
        		
        		b11=new JButton("EXIT");
                b11.setBounds(805,630,120,50);
                b11.setBackground(Color.darkGray);
                b11.setFont(f1);
                b11.setForeground(Color.white);
                b11.setMnemonic('E');
                b11.setToolTipText("Closes SYSTEM");
                b11.addActionListener(this);
        p.add(b11);b11.setIcon(exit);


				ImageIcon tv=new ImageIcon("tv.png");
        		l8=new JLabel(tv);
        		l8.setBounds(150,20,620,600);
        		               
                l=new JLabel("WELCOME");
                l.setFont(f2);
                l.setForeground(Color.blue);
                l.setBounds(350,230,300,50);
        p.add(l);
        		               
                l0=new JLabel("TO");
                l0.setFont(f2);
                l0.setForeground(Color.blue);
                l0.setBounds(420,280,300,50);
        p.add(l0);


                l1=new JLabel("CABLE");
                l1.setFont(f2);
                l1.setForeground(Color.blue);
                l1.setBounds(380,330,300,50);
        p.add(l1);
                l2=new JLabel("OPERATING");
                l2.setFont(f2);
                l2.setForeground(Color.blue);
                l2.setBounds(330,380,320,50);
        p.add(l2);       


                l3=new JLabel("SYSTEM");
                l3.setFont(f2);
                l3.setForeground(Color.blue);
                l3.setBounds(380,430,220,50);
        p.add(l3);
        		
        	p.add(l8);
             
              
    }	
	public void actionPerformed(ActionEvent ae) 
	{  
		if(ae.getSource()==b1)
		{
			new cust();
		}
		else if(ae.getSource()==b2)
		{
			new Manager();
		}
		else if(ae.getSource()==b3)
		{
			new agent();
		}
		else if(ae.getSource()==b4)
		{
			new employee();
		}
		else if(ae.getSource()==b5)
		{
			new Supplier();
		}
		else if(ae.getSource()==b6)
		{
			new custbill();
		}
		else if(ae.getSource()==b7)
		{
			new supbill().show();
		}
		else if(ae.getSource()==b8)
		{
			new reports().show();
		}
			else if(ae.getSource()==b10)
		{
			new product();
		}
		else if(ae.getSource()==b11)
		{
			dispose();
		}		
		else if(ae.getSource()==b9)
		{
			new porder();
		}dispose();
	}
    	public static void main(String args[])
	{
		home home=new home();
		home.show();
	
	}    
}
