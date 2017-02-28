import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class reports extends JFrame implements ActionListener
{
        JLabel l,l1,l2,l3;
        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
        Font f1,f2;
        ResultSet rs1,rs2;
        Connection cn1;
        Statement st1,st2;
        PreparedStatement ps;
        Icon customer = new ImageIcon("customer.png");
        Icon agent = new ImageIcon("agent.png");
        Icon employee = new ImageIcon("employee.png");
        Icon supplier = new ImageIcon("supplier.png");
        Icon bill = new ImageIcon("bill.png");
        Icon delete = new ImageIcon("delete.jpg");
        Icon addnew = new ImageIcon("addnew.jpg");
        Icon exit = new ImageIcon("exit.jpg");
        Icon modify = new ImageIcon("modify.jpg");
        Icon cancel = new ImageIcon("cancel.jpg");
        Icon search = new ImageIcon("search.jpg");
        Icon home = new ImageIcon("home.jpg");
        Icon report = new ImageIcon("report.png");
        
	reports()
	{
	  super("CABLE OPERATING SYSTEM");
      setSize(980,720);
      setResizable(false);
	  Container p=getContentPane();
     p.setLayout(null);
     p.setBackground(Color.gray);
	 f1=new Font("Constantia",Font.BOLD,14);
	 f2=new Font("Timer New Roman",Font.BOLD,30);
        
                l=new JLabel("OVERALL REPORTS");
                l.setFont(f2);
                l.setForeground(Color.white);
                l.setBounds(280,10,800,50);
        p.add(l);//l.setIcon(customer);        
                
                
               

                l1=new JLabel("DATE:");//system date
                l1.setFont(f1);
                l1.setForeground(Color.white);
                l1.setBounds(660,15,60,40);
          p.add(l1);
          		
          		l2=new JLabel();
                l2.setBounds(710,20,70,30);
          p.add(l2);l2.setForeground(Color.white);               
          		
          		Date date2 = new Date(); 
	   			SimpleDateFormat sdf= new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy");
	   			String s= sdf.format(date2);
                l2.setText(s); 
                
                b1=new JButton("CUSTOMER");
                b1.setFont(f1);
                b1.setBackground(Color.darkGray);
                b1.setForeground(Color.white);
                b1.setBounds(170,140,120,50);
                b1.setMnemonic('C');
                b1.setToolTipText("Shows CUSTOMER REPORTS");
                b1.addActionListener(this);
        p.add(b1);//b1.setIcon();

                b2=new JButton("AGENTS");
                b2.setFont(f1);
                b2.setBackground(Color.darkGray);
                b2.setForeground(Color.white);
                b2.setBounds(390,140,120,50);
                b2.setMnemonic('A');
                b2.setToolTipText("Shows AGENT REPORTS");
                b2.addActionListener(this);
	p.add(b2);//b2.setIcon();

                b3=new JButton("EMPLOYEE");
                b3.setFont(f1);
                b3.setBackground(Color.darkGray);
                b3.setForeground(Color.white);
                b3.setBounds(630,140,120,50);
                b3.setMnemonic('E');
                b3.setToolTipText("Shows EMPLOYEE REPORTS");
                b3.addActionListener(this);
	p.add(b3);//b3.setIcon();

                b4=new JButton("MANAGER");
                b4.setFont(f1);
                b4.setBackground(Color.darkGray);
                b4.setForeground(Color.white);
                b4.setBounds(690,410,220,50);
                b4.setMnemonic('M');
                b4.setToolTipText("Shows MAnager reports");
                b4.addActionListener(this);
	p.add(b4);//b4.setIcon();

                b5=new JButton("SUPPLIER");
                b5.setFont(f1);
                b5.setBackground(Color.darkGray);
                b5.setForeground(Color.white);
                b5.setBounds(690,220,120,50);
                b5.setMnemonic('S');
                b5.setToolTipText("Shows SUPPLIER REPORTS");
                b5.addActionListener(this);
        p.add(b5);//b5.setIcon();

                b6=new JButton("SUPPLIER BILL");
                b6.setFont(f1);
                b6.setBackground(Color.darkGray);
                b6.setForeground(Color.white);
                b6.setBounds(690,310,160,50);
                b6.setMnemonic('N');
                b6.setToolTipText("Shows SUPPLIER BILL REPORTS");
                b6.addActionListener(this);
	p.add(b6);//b6.setIcon();

                b7=new JButton("CUSTOMER BILL");
                b7.setFont(f1);
                b7.setBackground(Color.darkGray);
                b7.setForeground(Color.white);
                b7.setBounds(70,310,160,50);
                b7.setMnemonic('B');
                b7.setToolTipText("Shows CUSTOMER BILL REPORTS");
                b7.addActionListener(this);
	p.add(b7);//b7.setIcon();

                b8=new JButton("PURCHASE ORDER");
                b8.setFont(f1);
                b8.setBackground(Color.darkGray);
                b8.setForeground(Color.white);
                b8.setBounds(50,410,180,50);
                b8.setMnemonic('P');
                b8.setToolTipText("Shows PURCHASE ORDER REPORTS");
                b8.addActionListener(this);
	p.add(b8);//b8.setIcon();

                b9=new JButton("PRODUCT");
                b9.setFont(f1);
                b9.setBackground(Color.darkGray);
                b9.setForeground(Color.white);
                b9.setBounds(110,220,120,50);
                b9.setMnemonic('R');
                b9.setToolTipText("Shows PRODUCT REPORTS");
                b9.addActionListener(this);
	p.add(b9);//b9.setIcon();

              
                b11=new JButton("EXIT");
                b11.setFont(f1);
                b11.setBackground(Color.darkGray);
                b11.setForeground(Color.white);
                b11.setBounds(500,500,120,50);
                b11.setMnemonic('E');
                b11.setToolTipText("Closes the window");
                b11.addActionListener(this);
	p.add(b11);b11.setIcon(exit);
	
				b12=new JButton("HOME");
				b12.setFont(f1);
                b12.setBackground(Color.darkGray);
                b12.setForeground(Color.white);
                b12.setBounds(280,500,120,50);
                b12.setMnemonic('H');
                b12.setToolTipText("Goes To HOMESCREEN");
                b12.addActionListener(this);
	p.add(b12);b12.setIcon(home);
	
				ImageIcon report=new ImageIcon("report.png");
        		l3=new JLabel(report);
        		l3.setBounds(320,210,280,260);
        		l3.setToolTipText("REPORTS WINDOW");
        	p.add(l3);

				
	}			
	public void actionPerformed(ActionEvent a1)
         {
         	if(a1.getSource()==b12)//home
        {
        	dispose();
        	new home().show();
        }
        	if(a1.getSource()==b1)//customer
        {
          String reportname="Customer Details";
          String q="select * from customer";
          itreport it=new itreport(reportname,q);         
        }
        	if(a1.getSource()==b2)//agent
        {
          String reportname="Agent Details";
          String q="select * from agent";
          itreport it=new itreport(reportname,q);         

        	
        }
        	if(a1.getSource()==b3)//employee
        {
          String reportname="Employee Details";
          String q="select * from employee";
          itreport it=new itreport(reportname,q);         

        	
        }
        	if(a1.getSource()==b4)//monthly collection
        {
        	String reportname="Manager details";
            String q="select * from manager";
            itreport it=new itreport(reportname,q);         
        }
        	if(a1.getSource()==b5)//supplier
        {
          String reportname="Supplier Details";
          String q="select * from supplier";
          itreport it=new itreport(reportname,q);         
        	
        }
        	if(a1.getSource()==b6)//supplierbill
        {
        	String reportname="Supplier Bill Details";
          String q="select * from supplierbill";
          itreport it=new itreport(reportname,q);         
        	
        }
        if(a1.getSource()==b7)//custbill
        {
          String reportname="Customer Bill Details";
          String q="select * from custbill order by cname";
          itreport it=new itreport(reportname,q);         
        }
        if(a1.getSource()==b8)//porder
        {

          String reportname="Purchase Order Details";
          String q="select * from purchaseorder";
          itreport it=new itreport(reportname,q);         

        }
        
        if(a1.getSource()==b9)//product
        {
          String reportname="Product Details";
          String q="select * from product";
          itreport it=new itreport(reportname,q);         
        }
        
        if(a1.getSource()==b11)//exit
        {
          dispose();
        }
        
         }	 
 public static void main(String args[])
 {
 	reports reports=new reports();
 	reports.show();
 }
}
