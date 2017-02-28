import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class custbill extends JFrame implements ActionListener,FocusListener
{
        JLabel l,l1,l2,l3,l4,l5,l6,l7,l9,l8,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
        JTextField t1,t2,t4,t7,t8,t9,t10,t11,t12,t13;
        JTextArea ta;
        JComboBox c,t3,t5,t6;
        Font f1,f2;
        ResultSet rs1,rs2,rs3,rs4,rs5,rs6;
        Connection cn1;
        Statement st1,st2,st3,st4,st5,st6;
        PreparedStatement ps,ps2;
        Icon save = new ImageIcon("save.jpg");
        Icon previous = new ImageIcon("previous.jpg");
        Icon next = new ImageIcon("next.jpg");
        Icon first = new ImageIcon("first.jpg");
        Icon last = new ImageIcon("last.jpg");
        Icon delete = new ImageIcon("delete.jpg");
        Icon addnew = new ImageIcon("addnew.jpg");
        Icon exit = new ImageIcon("exit.jpg");
        Icon modify = new ImageIcon("modify.jpg");
        Icon cancel = new ImageIcon("cancel.jpg");
        Icon search = new ImageIcon("search.jpg");
        Icon home = new ImageIcon("home.jpg");
        
        custbill()
		{
                      super("CABLE OPERATING SYSTEM");
		      setSize(980,720);setLocation(200,50);
		      setResizable(false);
                      Container p=getContentPane();
		      p.setLayout(null);
		      p.setBackground(Color.darkGray);
		      f1=new Font("Arial",Font.BOLD,13);
                      f2=new Font("Timer New Roman",Font.BOLD,30);
			  
                      l=new JLabel("CUSTOMER BILL");
                      l.setFont(f2);
                      l.setForeground(Color.white);
                      l.setBounds(240,5,800,50);
                      p.add(l);
			  
			  l1=new JLabel("Bill ID:");
              l1.setFont(f1);
              l1.setForeground(Color.white);
              l1.setBounds(30,60,70,30);
		p.add(l1);

              t1=new JTextField(5);
              t1.setBounds(120,60,50,25);
		p.add(t1);
        		
              l2=new JLabel("Cust ID:");
              l2.setFont(f1);
              l2.setForeground(Color.white);
              l2.setBounds(260,56,70,30);
		p.add(l2);
			  
			  t2=new JTextField(5);
              t2.setBounds(330,60,50,25);
		p.add(t2);  
			  
			  l3=new JLabel("Name:");
              l3.setFont(f1);
              l3.setForeground(Color.white);
              l3.setBounds(30,105,70,40);
		p.add(l3);
				
              t3=new JComboBox();

              t3.setBounds(120,115,150,30);
              t3.addActionListener(this);
              p.add(t3);     
           	
           	  l4=new JLabel("Address:");
              l4.setFont(f1);
              l4.setForeground(Color.white);
              l4.setBounds(30,165,70,40);
		p.add(l4);
				
			  ta=new JTextArea(90,50);
              ta.setBounds(120,175,150,50);
		p.add(ta);  
			
              l5=new JLabel("Area:");
              l5.setFont(f1);
              l5.setForeground(Color.white);
              l5.setBounds(350,165,70,40);
		p.add(l5);
			
              t4=new JTextField(10);
              t4.setBounds(430,170,100,30);
		p.add(t4); 
           	
           	  l6=new JLabel("From:");
              l6.setFont(f1);
              l6.setForeground(Color.white);
              l6.setBounds(30,252,70,40);
		p.add(l6);
				
              t5=new JComboBox();
              t5.addItem("1.January");
              t5.addItem("2.February");
              t5.addItem("3.March");
              t5.addItem("4.April");
              t5.addItem("5.May");
              t5.addItem("6.June");
              t5.addItem("7.July");
              t5.addItem("8.August");
              t5.addItem("9.September");
              t5.addItem("10.October");
              t5.addItem("11.November");
              t5.addItem("12.December");

              t5.setBounds(120,260,115,30);
              t5.addFocusListener(this);        
		p.add(t5); 

              t12=new JTextField("2013",10);
              t12.setBounds(240,260,60,30);
              t12.addFocusListener(this);
              p.add(t12);

              l8=new JLabel("To:");
              l8.setFont(f1);
              l8.setForeground(Color.white);
              l8.setBounds(350,245,70,40);
		p.add(l8);
				
              t6=new JComboBox();
              t6.addItem("1.January");
              t6.addItem("2.February");
              t6.addItem("3.March");
              t6.addItem("4.April");
              t6.addItem("5.May");
              t6.addItem("6.June");
              t6.addItem("7.July");
              t6.addItem("8.Augest");
              t6.addItem("9.September");
              t6.addItem("10.October");
              t6.addItem("11.November");
              t6.addItem("12.December");
              t6.setBounds(430,255,115,30);
              t6.addFocusListener(this);
		p.add(t6); 

               t13=new JTextField("2013",10);
               t13.setBounds(550,255,60,30);
               t13.addFocusListener(this);
               p.add(t13);
			  l9=new JLabel("Monthly:");
              l9.setFont(f1);
              l9.setForeground(Color.white);
              l9.setBounds(30,308,70,40);
		p.add(l9);
				
			  l10=new JLabel("Charge:");
              l10.setFont(f1);
              l10.setForeground(Color.white);
              l10.setBounds(30,320,70,40);
		p.add(l10);
			
			  t7=new JTextField(10);
              t7.setBounds(120,318,100,30);
		p.add(t7);
			
			  l11=new JLabel("Sub");
              l11.setFont(f1);
              l11.setForeground(Color.white);
              l11.setBounds(350,298,70,40);
		p.add(l11);
			
			  l12=new JLabel("Total:");
              l12.setFont(f1);
              l12.setForeground(Color.white);
              l12.setBounds(350,314,70,40);
		p.add(l12);
				
			  t8=new JTextField(10);
              t8.setBounds(430,310,100,30);
              t8.addActionListener(this);
		p.add(t8); 
				
			  l13=new JLabel("Other");
              l13.setFont(f1);
              l13.setForeground(Color.white);
              l13.setBounds(30,372,70,40);
		p.add(l13);
				
			  l14=new JLabel("Charge:");
              l14.setFont(f1);
              l14.setForeground(Color.white);
              l14.setBounds(30,383,70,40);
		p.add(l14);
				
                          t9=new JTextField("0",10);
              t9.setBounds(120,385,100,30);
             t9.addActionListener(this);
		p.add(t9); 
			
             /*             l15=new JLabel("Previous");
              l15.setFont(f1);
              l15.setForeground(Color.white);
              l15.setBounds(350,372,70,40);
		p.add(l15);
				
			  l16=new JLabel("Balance:");
              l16.setFont(f1);
              l16.setForeground(Color.white);
              l16.setBounds(350,383,70,40);
		p.add(l16);
			  
			  t10=new JTextField(10);
              t10.setBounds(430,385,100,30);
                p.add(t10);*/ 
				
			  l17=new JLabel("Total:");
              l17.setFont(f1);
              l17.setForeground(Color.white);
              l17.setBounds(350,372,70,40);
		p.add(l17);
		
			  t11=new JTextField(10);
              t11.setBounds(430,384,100,30);
              t11.addActionListener(this);
        	p.add(t11);
				
			  l18=new JLabel("Status:");
              l18.setFont(f1);
              l18.setForeground(Color.white);
              l18.setBounds(30,440,70,30);
		p.add(l18);
				
			  c=new JComboBox();
                          c.addItem("cash");
                          c.addItem("cheque");
                          c.setBounds(120,445,100,30);
		p.add(c);
		
			  l19=new JLabel("DATE:");//system date
          	  l19.setFont(f1);
              l19.setForeground(Color.white);
              l19.setBounds(510,50,70,40);
        p.add(l19);
          		
              l20=new JLabel();
              l20.setBounds(547,55,70,30);
          	  l20.setForeground(Color.white);               
        p.add(l20);  		
          		
          	  Date date2 = new Date(); 
	   		  SimpleDateFormat sdf= new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy");
	   		  String s= sdf.format(date2);
              l20.setText(s); 
				
                        
              b1=new JButton("AddNew");
              b1.setBounds(750,30,120,50);
              b1.setMnemonic('A');
              b1.setToolTipText("Adds new record");
              b1.addActionListener(this);
         p.add(b1);b1.setIcon(addnew);      
                
               b2=new JButton("Modify");
               b2.setBounds(750,90,120,50);
               b2.setMnemonic('M');
               b2.setToolTipText("Modifies the record");
               b2.addActionListener(this);
         p.add(b2);b2.setIcon(modify);
      
                
               b3=new JButton("Delete");
               b3.setBounds(750,150,120,50);
               b3.setMnemonic('D');
               b3.setToolTipText("Deletes the record");
               b3.addActionListener(this);
         p.add(b3);b3.setIcon(delete);
      
                
               b4=new JButton("Save");
               b4.setBounds(180,520,120,50);
               b4.setMnemonic('S');
               b4.setToolTipText("Saves the record");
               b4.addActionListener(this);
         p.add(b4); b4.setIcon(save);     
                
               b5=new JButton("Cancel");
               b5.setBounds(750,210,120,50);
               b5.setMnemonic('C');
               b5.setToolTipText("Cancel the record");
               b5.addActionListener(this);
         p.add(b5);b5.setIcon(cancel);      
                
               b6=new JButton("Next");
               b6.setBounds(750,270,120,50);
               b6.setMnemonic('N');
               b6.setToolTipText("Moves to NEXT record");
               b6.addActionListener(this);
         p.add(b6); b6.setIcon(next);     
                
               b7=new JButton("Previous");
               b7.setBounds(750,330,120,50);
               b7.setMnemonic('P');
               b7.setToolTipText("Moves to PREVIOUS record");
               b7.addActionListener(this);
         p.add(b7);b7.setIcon(previous);      
                
               b8=new JButton("First");
               b8.setBounds(750,390,120,50);
               b8.setMnemonic('F');
               b8.setToolTipText("Moves to FIRST record");
               b8.addActionListener(this);
         p.add(b8); b8.setIcon(first);     
                
               b9=new JButton("Last");
               b9.setBounds(750,450,120,50);
               b9.setMnemonic('L');
               b9.setToolTipText("Moves to LAST records");
               b9.addActionListener(this);
          p.add(b9); b9.setIcon(last);
    
                
               b10=new JButton("Search");
               b10.setBounds(750,510,120,50);
               b10.setMnemonic('S');
               b10.setToolTipText("Search the record");
               b10.addActionListener(this); 
          p.add(b10); b10.setIcon(search);    
                
               b11=new JButton("EXIT");
               b11.setBounds(350,520,120,50);
               b11.setMnemonic('E');
               b11.setToolTipText("Closes the window");
               b11.addActionListener(this);
		 p.add(b11);b11.setIcon(exit);
                
               b12=new JButton("HOME");
               b12.setBounds(490,520,120,50);
               b12.setMnemonic('H');
               b12.setToolTipText("Goes To HOMESCREEN");
               b12.addActionListener(this);
		 p.add(b12);b12.setIcon(home);
        
        try
     	{
	       	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	       	cn1=DriverManager.getConnection("jdbc:odbc:mydsn1");
	        st1=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	        rs1=st1.executeQuery("Select * from custbill");
	        st2=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	        rs2=st2.executeQuery("Select * from customer");
            while(rs2.next())
          	{
                  // rs2.getString(rs2.getString(2)+" . "+rs2.getString(3)+"."+rs2.getString(4)+"."+rs2.getString(5)+"."+rs2.getString(8));
                   t3.addItem(rs2.getString(2));
                 } 

        }//try
     	catch(Exception e)
     	{
       		String msg="Connection Failed.";
            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
     	}
      
	 	setVisible(true);
	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
 }//end of constructor
 
 public void actionPerformed(ActionEvent a1)
 {
        if(a1.getSource()==t8 || a1.getSource()==t9)//total
        {
                try
                {
                        int r=Integer.parseInt(t8.getText())+Integer.parseInt(t9.getText());
                        t11.setText(Integer.toString(r));
                }
                catch(Exception e){}
        }
//}  


        if(a1.getSource()==b11)//exit
 	{
		try
        {
        	cn1.close();
            dispose();
        }
        catch(Exception e){}

    }
    else if(a1.getSource()== b6)//next
    {
        try
     	{
        	rs1.next();rs1.refreshRow();
            
            t1.setText(rs1.getString(1));
            t2.setText(rs1.getString(2));
            t3.setSelectedItem(rs1.getString(3));
            ta.setText(rs1.getString(4));
            t4.setText(rs1.getString(5));

            String frm=rs1.getString(6);
            int po=frm.indexOf(' ');

            String f=frm.substring(0,po);
            String y=frm.substring(po+1,frm.length());
            
            
            t5.setSelectedItem(f);
           

            t12.setText(y);
             frm=rs1.getString(7);
             po=frm.indexOf(' ');

             f=frm.substring(0,po);
             y=frm.substring(po+1,frm.length());
           
            t6.setSelectedItem(f);
            t13.setText(y);
            t7.setText(rs1.getString(8));
            t8.setText(rs1.getString(9));
            t9.setText(rs1.getString(10));
          //  t10.setText(rs1.getString(1));
            t11.setText(rs1.getString(11));
            c.setSelectedItem(rs1.getString(12));
         }
         catch(Exception e)
         {      System.out.println(e);
         	String msg="No Record beyond this.";
            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
         }
    }    
         else if(a1.getSource()==b7)//previous
         {
                try
                {
                        rs1.previous();rs1.refreshRow();
            
            
            t1.setText(rs1.getString(1));
            t2.setText(rs1.getString(2));
            t3.setSelectedItem(rs1.getString(3));
            ta.setText(rs1.getString(4));
            t4.setText(rs1.getString(5));

            String frm=rs1.getString(6);
            int po=frm.indexOf(' ');

            String f=frm.substring(0,po);
            String y=frm.substring(po+1,frm.length());
            
            
            t5.setSelectedItem(f);
           

            t12.setText(y);
             frm=rs1.getString(7);
             po=frm.indexOf(' ');

             f=frm.substring(0,po);
             y=frm.substring(po+1,frm.length());
           
            t6.setSelectedItem(f);
            t13.setText(y);
            t7.setText(rs1.getString(8));
            t8.setText(rs1.getString(9));
            t9.setText(rs1.getString(10));
          //  t10.setText(rs1.getString(1));
            t11.setText(rs1.getString(11));
            c.setSelectedItem(rs1.getString(12));
                }
                catch(Exception e)
                {
                        String msg="No Record beyond this,";
                        JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                }
        }
        else if(a1.getSource()==b8)//first
        {
                try
                {
                        rs1.first();
                        rs1.refreshRow();
            
            t1.setText(rs1.getString(1));
            t2.setText(rs1.getString(2));
            t3.setSelectedItem(rs1.getString(3));
            ta.setText(rs1.getString(4));
            t4.setText(rs1.getString(5));

            String frm=rs1.getString(6);
            int po=frm.indexOf(' ');

            String f=frm.substring(0,po);
            String y=frm.substring(po+1,frm.length());
            
            
            t5.setSelectedItem(f);
           

            t12.setText(y);
             frm=rs1.getString(7);
             po=frm.indexOf(' ');

             f=frm.substring(0,po);
             y=frm.substring(po+1,frm.length());
           
            t6.setSelectedItem(f);
            t13.setText(y);
            t7.setText(rs1.getString(8));
            t8.setText(rs1.getString(9));
            t9.setText(rs1.getString(10));
          //  t10.setText(rs1.getString(1));
            t11.setText(rs1.getString(11));
            c.setSelectedItem(rs1.getString(12));
           }
                catch(Exception e)
                {
                        String msg="Displaying First Record Failed.";
                        JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if(a1.getSource()==b9)//last
            {
                try
                {
                       rs1.last();rs1.refreshRow();
            
            t1.setText(rs1.getString(1));
            t2.setText(rs1.getString(2));
            t3.setSelectedItem(rs1.getString(3));
            ta.setText(rs1.getString(4));
            t4.setText(rs1.getString(5));

            String frm=rs1.getString(6);
            int po=frm.indexOf(' ');

            String f=frm.substring(0,po);
            String y=frm.substring(po+1,frm.length());
            
            
            t5.setSelectedItem(f);
           

            t12.setText(y);
             frm=rs1.getString(7);
             po=frm.indexOf(' ');

             f=frm.substring(0,po);
             y=frm.substring(po+1,frm.length());
           
            t6.setSelectedItem(f);
            t13.setText(y);
            t7.setText(rs1.getString(8));
            t8.setText(rs1.getString(9));
            t9.setText(rs1.getString(10));
          //  t10.setText(rs1.getString(1));
            t11.setText(rs1.getString(11));
            c.setSelectedItem(rs1.getString(12));
                }
                catch(Exception e)
                {
                        String msg="Displaying of Last Record Failed.";
                        JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                }
          }
           else if(a1.getSource()==b1)//addnew
                {
                        try
                        {
                                rs1.last();
                                int id=Integer.parseInt(rs1.getString(1));
                                id++;

                                 t1.setText(""+id);
                                 t8.setText("");
                                 t9.setText("");
                                 t11.setText("");
                                 String msg="Enter All Information and Click on SAVE button.";
                                 JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch(Exception e)
                        {
                                System.out.println(e);
                        }
                }
                else if(a1.getSource()==b4)//save
                {
                	try
                   {
                     ps=cn1.prepareStatement("insert into custbill values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                     ps.setInt(1,Integer.parseInt(t1.getText()));
                     ps.setInt(2,Integer.parseInt(t2.getText()));  //customer
                     ps.setString(3,t3.getSelectedItem().toString().toLowerCase());//customer
                     ps.setString(4,ta.getText().toLowerCase());//customer
                     ps.setString(5,t4.getText().toLowerCase());//customer
                     ps.setString(6,t5.getSelectedItem().toString()+" "+t12.getText());
                     ps.setString(7,t6.getSelectedItem().toString()+" "+t13.getText());
                     ps.setString(8,t7.getText());//customer
                     ps.setString(9,t8.getText());
                     ps.setString(10,t9.getText());
                  //   ps.setString(10,t10.getText());
                     ps.setString(11,t11.getText());
                     ps.setString(12,c.getSelectedItem().toString());
                     ps.setString(13,l20.getText());

                     ps.executeUpdate();
                     String msg="Record saved Successfully";
                     JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);

                     cn1.commit();
                     clearall();
                   }
                   catch(Exception e){System.out.println(e);}
                }  
                else if(a1.getSource()==b2)//modify
                {
                  try
                  {
                    ps=cn1.prepareStatement("update custbill set billid=?,CustomerID=?,cname=?,address=?,area=?,from=?,to=?,monthlycharge=?,subtotal=?,othercharge=?,total=?,status=? where billid=?");
                    ps.setInt(1,Integer.parseInt(t1.getText()));
                    ps.setInt(2,Integer.parseInt(t2.getText()));
                    ps.setString(3,t3.getSelectedItem().toString().toLowerCase());
                    ps.setString(4,ta.getText().toLowerCase());
                    ps.setString(5,t4.getText().toLowerCase());
                    ps.setString(6,t5.getSelectedItem().toString()+" "+t12.getText());
                    ps.setString(7,t6.getSelectedItem().toString()+" "+t13.getText());
                    ps.setString(8,t7.getText().toLowerCase());
                    ps.setString(9,t8.getText().toLowerCase());
                    ps.setString(10,t9.getText().toLowerCase());
                   // ps.setString(11,t10.getText().toLowerCase());
                    ps.setString(12,c.getSelectedItem().toString());
                    ps.setInt(13,Integer.parseInt(t1.getText()));
         
         
                     ps.executeUpdate();
                

                     String msg="Record Updated Successfully";
                     JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);

                    cn1.commit();
                    }catch(Exception e){}
					clearall();
                }	
                 else if(a1.getSource()==b3)//delete
                {
  					try
        			{
         					int pid=Integer.parseInt(t1.getText());
        					ps2=cn1.prepareStatement("delete * from custbill where billID="+pid);
         					ps2.executeUpdate();
         					cn1.commit();
         					clearall();

         					String msg="Record Deleted Successfully";
         					JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);

        			}
       				 catch(Exception e)
       				 { 
           				String dt="Error Message";
          				String dm="Record Does not Exist";
           				int dtype=JOptionPane.ERROR_MESSAGE;
           				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
       				}
                }
                 else if(a1.getSource()==b10)//search
         		{
                              try
                              {
            			if(t2.getText()!="")
            			{
                            st4 = cn1.createStatement();
                            rs4 = st4.executeQuery("select * from custbill where cname = '" +  t3.getSelectedItem().toString()+"'");
                    		if(rs4.next())
                    		{
                            	t1.setText(rs4.getString(1));
                                t2.setText(rs4.getString(2));
                                t3.setSelectedItem(rs4.getString(3));
                                ta.setText(rs4.getString(4));
                                t4.setText(rs4.getString(5));

                                String frm=rs4.getString(6);
                                int po=frm.indexOf(' ');
                                
                                String f=frm.substring(0,po);
                                String y=frm.substring(po+1,frm.length());
                                        
                                            
                                t5.setSelectedItem(f);
                                          
                                
                                 t12.setText(y);
                                 frm=rs4.getString(7);
                                 po=frm.indexOf(' ');
                             
                                 f=frm.substring(0,po);
                                 y=frm.substring(po+1,frm.length());
                                        
                                 t6.setSelectedItem(f);
                                 t13.setText(y);
                            
                                        //t5.setSelectedItem(rs4.getString(6));
                                        //t12.setText(rs4.getString(6));
                                        //t6.setSelectedItem(rs4.getString(7));
                                       // t13.setText(rs4.getString(7));

                                 t7.setText(rs4.getString(8));
                                 t8.setText(rs4.getString(9));
                                 t9.setText(rs4.getString(10));                         
                                 t11.setText(rs4.getString(11));
                                 c.setSelectedItem(rs4.getString(12)); 
	                }
                    else
                    {
                    	String dt="Error Message";
                        String dm="Record Does Not Exist";
                        int dtype=JOptionPane.ERROR_MESSAGE;
                        JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
                    }//else
                }
            }
            catch(Exception e){}
        }
        else if(a1.getSource()==b5)//clear
        {
        	clearall();
        }
        else if(a1.getSource()==t3)
        {
        try{
           st6 = cn1.createStatement();
           rs6 = st6.executeQuery("select * from customer where cname = '" +  t3.getSelectedItem().toString()+"'");
                             if(rs6.next())
                    		{
                                        t2.setText(rs6.getString(1));
                                        t3.setSelectedItem(rs6.getString(2));
                                        ta.setText(rs6.getString(3));
                                        t4.setText(rs6.getString(4));
                                        t7.setText(rs6.getString(9));
                                }

            }
            catch(Exception e){}
        }
	else if(a1.getSource()==b12)//home
        {
        	new home().show();
        	dispose();
        }
 }//end of actionperformed

                void clearall()
         	{
                        try
                        {
             		t1.setText("");
                    t2.setText("");
                    t3.setSelectedItem("");
                    ta.setText("");
                    t4.setText("");
                    t5.setSelectedItem("");
                    t12.setText("");
                    t6.setSelectedItem("");
                    t13.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                   // t10.setText("");
                    t11.setText("");
                    rs1.beforeFirst();
                 }//try
                 catch(Exception e){}
                   }//clearall
        public static void main(String args[])
        {
               custbill custbill= new custbill();
               custbill.show();
        }
        public void focusGained(FocusEvent fe){}

        public void focusLost(FocusEvent fe)
        {
        String fm=t5.getSelectedItem().toString();
        int pos=fm.indexOf(".");
        int fm1=Integer.parseInt(fm.substring(0,pos));


        String tm=t6.getSelectedItem().toString();
        pos=tm.indexOf(".");
        int tm1=Integer.parseInt(tm.substring(0,pos));

        int f=Integer.parseInt(t12.getText());
        int t=Integer.parseInt(t13.getText());
        int d=1;
        if(f<=t)
        {
          if(fm1<=tm1)
          {
              if(f==t)
               {
                if(fm1==tm1)
                 d=1;
                else
                 d=(tm1-fm1)+1;
               }
               else
               {
                if(fm1==tm1)
                  d=(t-f)*12;
                else
                  d=(tm1-fm1+1)+((t-f)*12);
              }
          }
          else
          {
           String msg="Selecting Month is incorrect. please reselect it";
           JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
           t5.requestFocus();
          }
        }
        else
        {
           String msg="Sequence of year is invalid.";
           JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
           t12.setText("2013");
           t13.setText("2013");
           t12.requestFocus();
        }
        int amt =d*Integer.parseInt(t7.getText());
        t8.setText(Integer.toString(amt));
        int r=Integer.parseInt(t8.getText())+Integer.parseInt(t9.getText());
        t11.setText(Integer.toString(r));

        }
}        
   
