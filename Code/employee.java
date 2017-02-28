import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
class employee extends JFrame implements ActionListener,KeyListener
{
        JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
        JTextField t1,t2,t5,t6,t7;
        JComboBox c;
        JTextArea ta;
        ResultSet rs1,rs2,rs3,rs4;
        Connection cn1;
        Statement st1,st2,st3,st4;
        PreparedStatement ps,ps2;
        Font f1,f2;
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
        
        employee()
        {
                super("CABLE OPERATING SYSTEM");
                setSize(980,650);setLocation(200,50);
                setResizable(false);
	 			Container p=getContentPane();
     	  		p.setLayout(null);
          		p.setBackground(Color.darkGray);
          
          		f1=new Font("Arial",Font.BOLD,13);
 				f2=new Font("Times New Roman",Font.BOLD,30);
                 
                p.setLayout(null);
                
                l=new JLabel("EMPLOYEE INFORMATION");
                l.setFont(f2);
                l.setForeground(Color.white);
                l.setBounds(170,10,800,40);
       p.add(l);
                
                l1=new JLabel("EmployeeID:");
                l1.setFont(f1);
                l1.setForeground(Color.white);
                l1.setBounds(30,80,80,40);
       p.add(l1);    
                
                t1=new JTextField(5);
                t1.setBounds(140,80,60,30);
       p.add(t1);       
                l2=new JLabel("Name:");
                l2.setFont(f1);
                l2.setForeground(Color.white);
                l2.setBounds(30,150,80,40);
       p.add(l2);       
                
                t2=new JTextField(20);
                t2.addKeyListener(this);
                t2.setBounds(140,150,150,30);
       p.add(t2);       
                
                l3=new JLabel("Address:");
                l3.setFont(f1);
                l3.setForeground(Color.white);
                l3.setBounds(30,220,80,40);
       p.add(l3);       
                
                ta=new JTextArea(50,90);
                ta.addKeyListener(this);
                ta.setBounds(140,220,180,60);
       p.add(ta);       
                
                l4=new JLabel("Designation:");
                l4.setFont(f1);
                l4.setForeground(Color.white);
                l4.setBounds(30,315,80,40);
       p.add(l4);       
                
                c=new JComboBox();
                c.setBounds(140,315,120,30);
       p.add(c);
                
                l5=new JLabel("PhoneNo:");
                l5.setFont(f1);
                l5.setForeground(Color.white);
                l5.setBounds(30,382,80,30);
       p.add(l5);        
                
                t5=new JTextField(12);
                t5.addKeyListener(this);
                t5.setBounds(140,382,120,30);
       p.add(t5);        
                
                l6=new JLabel("MobileNo:");
                l6.setFont(f1);
                l6.setForeground(Color.white);
                l6.setBounds(30,445,70,30);
       p.add(l6);        
                
                t6=new JTextField(12);
                t6.addKeyListener(this);
                t6.setBounds(140,445,120,30);
       p.add(t6);
       
       			l7=new JLabel("DATE:");//system date
          		l7.setFont(f1);
                l7.setForeground(Color.white);
                l7.setBounds(440,65,60,40);
          p.add(l7);
          		
          		l8=new JLabel();
          		l8.setForeground(Color.white);
                l8.setBounds(510,69,70,30);
          p.add(l8);               
          		
          		Date date2 = new Date(); 
	   			SimpleDateFormat sdf= new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy");
	   			String s= sdf.format(date2);
	   			l8.setText(s);         
                
                b1=new JButton("AddNew");
                b1.setBounds(750,30,120,50);
                b1.setMnemonic('A');
                b1.setToolTipText("Adds new record");
                b1.addActionListener(this);
       p.add(b1); b1.setIcon(addnew);      
                
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
                b4.setBounds(190,510,120,50);
                b4.setMnemonic('S');
                b4.setToolTipText("Saves the record");
                b4.addActionListener(this);
        p.add(b4);b4.setIcon(save);      
                
                b5=new JButton("Cancel");
                b5.setBounds(750,210,120,50);
                b5.setMnemonic('C');
                b5.setToolTipText("Clear the info");
                b5.addActionListener(this);
        p.add(b5);b5.setIcon(cancel);      
                
                b6=new JButton("Next");
                b6.setBounds(750,270,120,50);
                b6.setMnemonic('N');
                b6.setToolTipText("Moves to NEXT record");
                b6.addActionListener(this);
        p.add(b6);b6.setIcon(next);      
                
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
		p.add(b8);b8.setIcon(first);	                
                
                b9=new JButton("Last");
                b9.setBounds(750,450,120,50);
                b9.setMnemonic('L');
                b9.setToolTipText("Moves to LAST records");
                b9.addActionListener(this);
        p.add(b9);b9.setIcon(last);     
                
                b10=new JButton("Search");
                b10.setBounds(750,510,120,50);
                b10.setMnemonic('S');
                b10.setToolTipText("Search the record");
                b10.addActionListener(this);
        p.add(b10);b10.setIcon(search);     
                
                b11=new JButton("EXIT");
                b11.setBounds(365,510,120,50);
                b11.setMnemonic('E');
                b11.setToolTipText("Closes the window");
                b11.addActionListener(this);
		p.add(b11);b11.setIcon(exit);
				
				
				b12=new JButton("HOME");
                b12.setBounds(550,510,120,50);
                b12.setMnemonic('H');
                b12.setToolTipText("Goes To HOMESCREEN");
                b12.addActionListener(this);
		p.add(b12);b12.setIcon(home);
		
				ImageIcon employee=new ImageIcon("employee.png");
        		l8=new JLabel(employee);
        		l8.setBounds(380,160,280,260);
        		l8.setToolTipText("EMPLOYEE WINDOW");
        	p.add(l8);
		
		try
     	{
       	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       	cn1=DriverManager.getConnection("jdbc:odbc:mydsn1");
        st1=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	    rs1=st1.executeQuery("Select * from employee");
        st2=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs2=st2.executeQuery("Select * from designation");
               while(rs2.next())
          	{
                   c.addItem(rs2.getString(1));
           	}
       
     	}
     	catch(Exception e)
     	{
       		
		 String msg="Connection Failed.";
                 JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
     	}
      
	 	setVisible(true);
	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          }//constructor of employee

         public void keyReleased(KeyEvent K)
          {
          }
           public void keyTyped(KeyEvent K)
  {
  }
  	public void keyPressed(KeyEvent k)
 	{
  		if(k.getSource()==t2 )//name
  		{
   			while(true)
   			{
 				if(k.getKeyChar()=='A'|| k.getKeyChar()=='a')
    			break;
  
			 	else if(k.getKeyChar()=='B'|| k.getKeyChar()=='b')
			    break;
		  
			 	else if(k.getKeyChar()=='C'|| k.getKeyChar()=='c')
		    	break;
		  
		 		else if(k.getKeyChar()=='D'|| k.getKeyChar()=='d')
		   		break;
		  
		 		else if(k.getKeyChar()=='E'|| k.getKeyChar()=='e')
		   	 	break;
		  
		 	    else if(k.getKeyChar()=='F'|| k.getKeyChar()=='f')
		    	break;
		  		
		  		else if(k.getKeyChar()=='G'|| k.getKeyChar()=='g')
		    	break;
				
				else if(k.getKeyChar()=='H'|| k.getKeyChar()=='h')
      		    break;            
		  
			   else if(k.getKeyChar()=='I'|| k.getKeyChar()=='i')
			   break;
		
		   		else if(k.getKeyChar()=='J'|| k.getKeyChar()=='j')
		   		break;
		  
		   		else if(k.getKeyChar()=='K'|| k.getKeyChar()=='k')
		   		break;
		  
		
		   		else if(k.getKeyChar()=='L'|| k.getKeyChar()=='l')
		   		break;
		  
		
		   		else if(k.getKeyChar()=='M'|| k.getKeyChar()=='m')
		   		break;
		  
		
		  		else if(k.getKeyChar()=='N'|| k.getKeyChar()=='n')
		   		break;
		   
		   		else if(k.getKeyChar()=='O'|| k.getKeyChar()=='o')
		   		break;
		  
		
		   		else if(k.getKeyChar()=='P'|| k.getKeyChar()=='p')
		   		break;
		  
		
		   		else if(k.getKeyChar()=='Q'|| k.getKeyChar()=='q')
		   		break;
		  
		
		  	 	else if(k.getKeyChar()=='R'|| k.getKeyChar()=='r')
		   		break;
		  
		 		else if(k.getKeyChar()=='S'|| k.getKeyChar()=='s')
		        break;
		  
		
		 		else if(k.getKeyChar()=='T'|| k.getKeyChar()=='t')
		        break;
		  
		
		 		else if(k.getKeyChar()=='U'|| k.getKeyChar()=='u')
		        break;
		  
		
		 		else if(k.getKeyChar()=='v'|| k.getKeyChar()=='V')
		        break;
		 
		 		else if(k.getKeyChar()=='w'|| k.getKeyChar()=='W')
		        break;
		
		 		else if(k.getKeyChar()=='X'|| k.getKeyChar()=='x')
		        break;
		  
		
		 		else if(k.getKeyChar()=='Y'||k.getKeyChar()=='y')
		        break;
		  
		
		 		else if(k.getKeyChar()=='Z'||k.getKeyChar()=='z')
		        break;
		  
		 		else if(k.getKeyCode()==KeyEvent.VK_SPACE)
		        break;
		
		  
		 		else if(k.getKeyCode()==KeyEvent.VK_SHIFT)
		        break;
		
		 		else if(k.getKeyCode()==KeyEvent.VK_CAPS_LOCK)
		        break;
		 		
		 		else if(k.getKeyCode()==KeyEvent.VK_BACK_SPACE)
		        break;
         else
         {
            JOptionPane.showMessageDialog(this,"Invalid Input","Please Enter Correct Input",JOptionPane.ERROR_MESSAGE);
            t2.setText("");
            break;
         }
     
       }//while
       }//if
      else if(k.getSource()==ta )//address
      {
       	while(true)
       	{
         	if(k.getKeyChar()=='A'|| k.getKeyChar()=='a')
            break;
          
            else if(k.getKeyChar()=='B'|| k.getKeyChar()=='b')
            break;
          
         	else if(k.getKeyChar()=='C'|| k.getKeyChar()=='c')
            break;
          
            else if(k.getKeyChar()=='D'|| k.getKeyChar()=='d')
            break;
          
            else if(k.getKeyChar()=='E'|| k.getKeyChar()=='e')
            break;
          
            else if(k.getKeyChar()=='F'|| k.getKeyChar()=='f')
            break;
          
            else if(k.getKeyChar()=='G'|| k.getKeyChar()=='g')
            break;
          
            else if(k.getKeyChar()=='H'|| k.getKeyChar()=='h')
            break;            
          
            else if(k.getKeyChar()=='I'|| k.getKeyChar()=='i')
            break;
        
            else if(k.getKeyChar()=='J'|| k.getKeyChar()=='j')
            break;
          
            else if(k.getKeyChar()=='K'|| k.getKeyChar()=='k')
            break;
          

            else if(k.getKeyChar()=='L'|| k.getKeyChar()=='l')
            break;
          

         	else if(k.getKeyChar()=='M'|| k.getKeyChar()=='m')
            break;
          

         	else if(k.getKeyChar()=='N'|| k.getKeyChar()=='n')
            break;
         
         	else if(k.getKeyChar()=='O'|| k.getKeyChar()=='o')
            break;
          

         	else if(k.getKeyChar()=='P'|| k.getKeyChar()=='p')
            break;
          

         	else if(k.getKeyChar()=='Q'|| k.getKeyChar()=='q')
            break;
          

         	else if(k.getKeyChar()=='R'|| k.getKeyChar()=='r')
            break;
          
         	else if(k.getKeyChar()=='S'|| k.getKeyChar()=='s')
            break;
          

         	else if(k.getKeyChar()=='T'|| k.getKeyChar()=='t')
        	break;
          

         	else if(k.getKeyChar()=='U'|| k.getKeyChar()=='u')
            break;
          

         	else if(k.getKeyChar()=='v'|| k.getKeyChar()=='V')
            break;
          

         	else if(k.getKeyChar()=='X'|| k.getKeyChar()=='x')
            break;
          

         	else if(k.getKeyChar()=='Y'||k.getKeyChar()=='y')
            break;
          

         	else if(k.getKeyChar()=='Z'||k.getKeyChar()=='z')
            break;
          
         	else if(k.getKeyCode()==KeyEvent.VK_SPACE)
            break;

          
         	else if(k.getKeyCode()==KeyEvent.VK_SHIFT)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_COMMA)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_CAPS_LOCK)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_BACK_SPACE)
            break;
         	
         	else if(k.getKeyCode()==KeyEvent.VK_ENTER)
            break;
            
         	else if(k.getKeyCode()==KeyEvent.VK_0)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_1)
            break;
         	
         	else if(k.getKeyCode()==KeyEvent.VK_2)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_3)
            break;
         	
         	else if(k.getKeyCode()==KeyEvent.VK_4)
            break;
         	
         	else if(k.getKeyCode()==KeyEvent.VK_5)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_6)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_7)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_8)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_9)
            break;

       else
       {
        	JOptionPane.showMessageDialog(this,"Please Enter Correct Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
            ta.setText("");
            break;
       }
     
       }
     }
      
     if (k.getSource()==t5)//phone no
     {
      	while(true)
        {
         	if(k.getKeyCode()==KeyEvent.VK_0)
            break;
         	
         	else if(k.getKeyCode()==KeyEvent.VK_1)
            break;
         	
         	else if(k.getKeyCode()==KeyEvent.VK_2)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_3)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_4)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_5)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_6)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_7)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_8)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_9)
            break;
         
         	else if(k.getKeyCode()==KeyEvent.VK_BACK_SPACE)
            break;
       else
       {
       		JOptionPane.showMessageDialog(this,"Invalid Input","PLZ Enter Correct Input",JOptionPane.ERROR_MESSAGE);
            t5.setText("");
            break;
       }
     }//while
   }//if
 
     if (k.getSource()==t6)//mobile
     {
 
       while(true)
       {
         if(k.getKeyCode()==KeyEvent.VK_0)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_1)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_2)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_3)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_4)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_5)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_6)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_7)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_8)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_9)
                     break;
         else if(k.getKeyCode()==KeyEvent.VK_BACK_SPACE)
                       break;
    else
    {
	    JOptionPane.showMessageDialog(this,"Invalid Input","PLZ Enter Correct Input",JOptionPane.ERROR_MESSAGE);
        t6.setText("");
        break;
    }
   }
  }
}//end of keylistener       
         public void actionPerformed(ActionEvent a1)
         {
               if(a1.getSource()==b11)//exit
               {

               try
               {
                   cn1.close();
                   dispose();
               }catch(Exception e){}

               }
               else if(a1.getSource()== b6)//next
               {
                try
                {
                  rs1.next();
                  rs1.refreshRow();
                                t1.setText(rs1.getString(1));t1.setEnabled(false);
                                t2.setText(rs1.getString(2));t2.setEnabled(false);
                                ta.setText(rs1.getString(3));ta.setEnabled(false);
                                c.setSelectedItem(rs1.getString(4));
                                t5.setText(rs1.getString(5));t5.setEnabled(false);
                                t6.setText(rs1.getString(6));t6.setEnabled(false);
                                

                }catch(Exception e)
                {
                            String msg="No Record beyond this.";
                            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                
                }
               }
               else if(a1.getSource()==b7)//previous
               {
                try
                {
                  rs1.previous();
                  rs1.refreshRow();
                                t1.setText(rs1.getString(1));t1.setEnabled(false);
                                t2.setText(rs1.getString(2));t2.setEnabled(false);
                                ta.setText(rs1.getString(3));ta.setEnabled(false);
                                c.setSelectedItem(rs1.getString(4));
                                t5.setText(rs1.getString(5));t5.setEnabled(false);
                                t6.setText(rs1.getString(6));t6.setEnabled(false);
                }catch(Exception e)
                {
                            String msg="No Record beyond this.";
                            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                
                }

               }
               else if(a1.getSource()==b8)//first
               {
                try
                {
                  rs1.first();
                  rs1.refreshRow();
                                t1.setText(rs1.getString(1));t1.setEnabled(false);
                                t2.setText(rs1.getString(2));t2.setEnabled(false);
                                ta.setText(rs1.getString(3));ta.setEnabled(false);
                                c.setSelectedItem(rs1.getString(4));
                                t5.setText(rs1.getString(5));t5.setEnabled(false);
                                t6.setText(rs1.getString(6));t6.setEnabled(false);
                                
                }catch(Exception e)
                {
                            String msg="Displaying of First Record Failed .";
                            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                
                }

                }
                else if(a1.getSource()==b9)//last
               {
                try
                {
                  rs1.last();
                  rs1.refreshRow();
                                t1.setText(rs1.getString(1));t1.setEnabled(false);
                                t2.setText(rs1.getString(2));t2.setEnabled(false);
                                ta.setText(rs1.getString(3));ta.setEnabled(false);
                                c.setSelectedItem(rs1.getString(4));
                                t5.setText(rs1.getString(5));t5.setEnabled(false);
                                t6.setText(rs1.getString(6));t6.setEnabled(false);
                                
                }
                catch(Exception e)
                {
                            String msg="Displaying of Last Record Failed .";
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
	                            t2.setText("");
	                            ta.setText("");
	                            t5.setText("");
	                            t6.setText("");
	                            t1.setEnabled(false);
	                            
	                            String msg="Enter All Information and Click on SAVE button.";
	                            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                            }catch(Exception e){}

                 }
                else if(a1.getSource()==b4)//Save
                {
                  try
                  {
                    ps=cn1.prepareStatement("insert into employee values(?,?,?,?,?,?)");
                    ps.setInt(1,Integer.parseInt(t1.getText()));
                    ps.setString(2,t2.getText());
                    ps.setString(3,ta.getText());
                    ps.setString(4,c.getSelectedItem().toString());
                    ps.setString(5,t5.getText());
                    ps.setString(6,t6.getText());
                      
                     ps.executeUpdate();
                     String msg="Record Saved Successfully";
                     JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);

                    cn1.commit();
                    clearall();

                 }  catch(Exception e){}
                }
                else if(a1.getSource()==b2)//modify
                {
                  try
                  {
	                    ps=cn1.prepareStatement("update employee set EmployeeID=?,ename=?,address=?,designation=?,phoneno=?,mobile=? where EmployeeID=?");
	                    ps.setInt(1,Integer.parseInt(t1.getText()));
	                    ps.setString(2,t2.getText());
	                    ps.setString(3,ta.getText());
	                    ps.setString(4,c.getSelectedItem().toString());
	                    ps.setString(5,t5.getText());
	                    ps.setString(6,t6.getText());
	                    ps.setInt(7,Integer.parseInt(t1.getText()));
	         			         
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
        					ps2=cn1.prepareStatement("delete * from employee where EmployeeID="+pid);
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
            	String str=JOptionPane.showInputDialog(this,"Enter the CUSTOMER NAME");
                if(str!=null)                                
            	{
					st4 = cn1.createStatement();
                  
                    rs4 = st4.executeQuery("select * from employee where ename='"+str+"'");

                    if(rs4.next())
                    	{
                    
                                t1.setText(rs4.getString(1));
		                        t2.setText(rs4.getString(2));
		                        ta.setText(rs4.getString(3));
		                        c.setSelectedItem(rs4.getString(4));
		                        t5.setText(rs4.getString(5));
		                        t6.setText(rs4.getString(6));
                    	}   
                    else
                      JOptionPane.showMessageDialog(this,"NO SUCH NAME EXIST","SEARCH FAIL",JOptionPane.INFORMATION_MESSAGE);      
                    }
                    
                }//try
			catch(SQLException e)
			{
				System.out.print(e);
			}
			
                }
                
                
                
                
                
                else if(a1.getSource()==b5)//clear
                {
                  clearall();
                }
                else if(a1.getSource()==b12)//home
                {
                  new home().show();
                  dispose();
                }
		}//end of actionPerformed     
		
		 void clearall()
         {
                         try
                           {
                            t1.setText("");
                            t2.setText("");
                            ta.setText("");
                            t5.setText("");
                            t6.setText("");
                            
                            rs1.beforeFirst();
                            }catch(Exception e){}


         }

             public static void main(String args[])
        {
                new employee();
        }
}        
