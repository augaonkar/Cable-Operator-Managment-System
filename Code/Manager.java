import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Manager extends JFrame implements ActionListener
{
        JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21;
        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
        JTextField t1,t2,t3,t4,t5,t6,t7,t8;
        JComboBox c,c1,c2;
        Font f1,f2;
        ResultSet rs1,rs2,rs3,rs4,rs5;
        Connection cn1;
        Statement st1,st2,st3,st4,st5;
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
        Manager()
        {
            super("CABLE OPERATING SYSTEM");
            setSize(880,600);
            setLocation(200,50);
            setResizable(false);
            Container p=getContentPane();
     	    p.setLayout(null);
            p.setBackground(Color.darkGray);

            f1=new Font("Arial",Font.BOLD,13);
            f2=new Font("Timer New Roman",Font.BOLD,30);            
                l=new JLabel("MANAGER INFORMATION");
                l.setFont(f2);
                l.setForeground(Color.white);
                l.setBounds(180,10,400,50);
         p.add(l);           
        	        
        	  
                l1=new JLabel("AgentName:");
                l1.setFont(f1);
                l1.setForeground(Color.white);
                l1.setBounds(30,98,90,30);
         p.add(l1);       
                
                c1=new JComboBox();
                c1.setBounds(160,98,150,25);
                c1.addActionListener(this);
          p.add(c1);      
                
                l2=new JLabel("Month:");
                l2.setFont(f1);
                l2.setForeground(Color.white);
                l2.setBounds(340,98,90,40);
         p.add(l2);       
                
                c=new JComboBox();
                c.addItem("1.January");
                c.addItem("2.February");c.addItem("3.March");
                c.addItem("4.April");c.addItem("5.May");
                c.addItem("6.June");c.addItem("7.July");
                c.addItem("8.Augest");c.addItem("9.September");
                c.addItem("10.October");c.addItem("11.November");
                c.addItem("12.December");
                c.setBounds(465,98,100,25);
                c.addActionListener(this);
                
         p.add(c);       
                
                l3=new JLabel("No of New");
                l3.setFont(f1);
                l3.setForeground(Color.white);
                l3.setBounds(30,150,110,40);
        p.add(l3);        
                
                l4=new JLabel("Customer Added:");
                l4.setFont(f1);
                l4.setForeground(Color.white);
                l4.setBounds(30,165,110,40);
        p.add(l4);        
                
                t1=new JTextField(5);
                t1.setBounds(160,158,90,25);
        p.add(t1);        
                
	            l5=new JLabel("Commission:");
                l5.setFont(f1);
                l5.setForeground(Color.white);
                l5.setBounds(340,150,100,40);
       p.add(l5);         
                c2=new JComboBox();
                c2.addItem("9");
                c2.addItem("11");
                c2.addItem("12");
                c2.setBounds(465,158,80,25);
       p.add(c2);
       c2.addActionListener(this);
       			l21=new JLabel("%");
                l21.setFont(f1);
                l21.setForeground(Color.white);
                l21.setBounds(555,158,80,25);
       p.add(l21);
                
                l6=new JLabel("Deposit");
                l6.setFont(f1);
                l6.setForeground(Color.white);
                l6.setBounds(30,212,110,40);
       p.add(l6);         
                
                l7=new JLabel("Collection:");
                l7.setFont(f1);
                l7.setForeground(Color.white);
                l7.setBounds(30,230,110,40);
		p.add(l7);                
                
                t2=new JTextField(12);
                t2.setBounds(160,220,90,25);
        p.add(t2);        
                
                l8=new JLabel("Commission");
                l8.setFont(f1);
                l8.setForeground(Color.white);
                l8.setBounds(340,210,110,30);
         p.add(l8);       
                
                l9=new JLabel("on deposit:");
                l9.setFont(f1);
                l9.setForeground(Color.white);
                l9.setBounds(340,218,100,40);
          p.add(l9);      
                
                t3=new JTextField(12);
                t3.setBounds(465,214,80,25);
           p.add(t3);     
                
                l10=new JLabel("Monthly rental");
                l10.setFont(f1);
                l10.setForeground(Color.white);
                l10.setBounds(30,280,110,30);
          p.add(l10);      
                
                l11=new JLabel("Collection:");
                l11.setFont(f1);
                l11.setForeground(Color.white);
                l11.setBounds(34,294,110,30);
           p.add(l11);     
                
                t4=new JTextField(5);
                t4.setBounds(160,285,90,25);
            p.add(t4);    
                
                l12=new JLabel("Commission on");
                l12.setFont(f1);
                l12.setForeground(Color.white);
                 l12.setBounds(340,280,110,30);
           p.add(l12);     
                
                l13=new JLabel("Monthly rental:");
                l13.setFont(f1);
                l13.setForeground(Color.white);
                l13.setBounds(340,295,110,30);
          p.add(l13);      
                
                t5=new JTextField(5);
                t5.setBounds(465,285,80,25);
          p.add(t5);      
                
                l14=new JLabel("Total collection:");
                l14.setFont(f1);
                l14.setForeground(Color.white);
                l14.setBounds(30,340,110,30);
          p.add(l14);      
                
                l15=new JLabel("(Monthly)");
                l15.setFont(f1);
                l15.setForeground(Color.white);
                l15.setBounds(30,348,110,40);
          p.add(l15);      
                
                t6=new JTextField(10);
                t6.setBounds(160,342,90,25);
           p.add(t6);               
           
                l16=new JLabel("Total Commission:");
                l16.setFont(f1);
                l16.setForeground(Color.white);
                l16.setBounds(340,340,150,40);
		p.add(l16);                
                
                l17=new JLabel("(Monthly)");
                l17.setFont(f1);
                l17.setForeground(Color.white);
                l17.setBounds(340,352,110,40);
		p.add(l17);                
                
                t7=new JTextField(5);
                t7.setBounds(465,352,80,25); 
         p.add(t7);     

                l19=new JLabel("Area of");
                l19.setFont(f1);
                l19.setForeground(Color.white);
                l19.setBounds(580,85,60,40);
               p.add(l19);

                l20=new JLabel("Agent:");
                l20.setFont(f1);
                l20.setForeground(Color.white);
                l20.setBounds(580,100,60,40);
               p.add(l20);


                t8=new JTextField(15);
                t8.setBounds(660,98,80,25);
              p.add(t8);


            /*    b1=new JButton("AddNew");
                b1.setBounds(750,30,120,50);
                b1.setMnemonic('A');
                b1.setToolTipText("Adds new record");
       p.add(b1);b1.setIcon(addnew);*/         
                
            /*    b2=new JButton("Modify");
                b2.setBounds(750,90,120,50);
                b2.setMnemonic('M');
                b2.setToolTipText("Modifies the record");
       p.add(b2);b2.setIcon(modify); */        
                
            /*    b3=new JButton("Delete");
                b3.setBounds(750,150,120,50);
                b3.setMnemonic('D');
                b3.setToolTipText("Deletes the record");
       p.add(b3);b3.setIcon(delete);*/         
                
                b4=new JButton("Save");
                b4.setBounds(90,480,120,50);
                b4.setMnemonic('S');
                b4.setToolTipText("Saves the record");
                b4.addActionListener(this);
       p.add(b4);b4.setIcon(save);         
                
                b5=new JButton("Cancel");
                b5.setBounds(230,480,120,50);
                b5.setMnemonic('C');
                b5.setToolTipText("Cancel the record");
                b5.addActionListener(this);
       p.add(b5);b5.setIcon(cancel);         
                
            /*    b6=new JButton("Next");
                b6.setBounds(750,270,120,50);
                b6.setMnemonic('N');
                b6.setToolTipText("Moves to NEXT record");
       p.add(b6);b6.setIcon(next);         
                
                b7=new JButton("Previous");
                b7.setBounds(750,330,120,50);
                b7.setMnemonic('P');
                b7.setToolTipText("Moves to PREVIOUS record");
       p.add(b7);b7.setIcon(previous);         
                
                b8=new JButton("First");
                b8.setBounds(750,390,120,50);
                b8.setMnemonic('F');
                b8.setToolTipText("Moves to FIRST record");
       p.add(b8);b8.setIcon(first);         
                
                b9=new JButton("Last");
                b9.setBounds(750,450,120,50);
                b9.setMnemonic('L');
                b9.setToolTipText("Moves to LAST records");
       p.add(b9);  b9.setIcon(last);       
                
                b10=new JButton("Search");
                b10.setBounds(750,510,120,50);
                b10.setMnemonic('S');
                b10.setToolTipText("Search the record");
        p.add(b10);b10.setIcon(search); */       
                
                b11=new JButton("EXIT");
                b11.setBounds(370,480,120,50);
                b11.setMnemonic('E');
                b11.setToolTipText("Closes the window");
                b11.addActionListener(this);
                p.add(b11);b11.setIcon(exit);
			
                b12=new JButton("HOME");
                b12.setBounds(510,480,120,50);
                b12.addActionListener(this);
                b12.setMnemonic('H');
                b12.setToolTipText("Goes To HOMESCREEN");
                p.add(b12);b12.setIcon(home); 
			
                ImageIcon manager=new ImageIcon("manager.png");
                l18=new JLabel(manager);
                l18.setBounds(512,160,280,260);
                l18.setToolTipText("MANAGER WINDOW");

        	p.add(l18);               
        	try
     		{
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		       	cn1=DriverManager.getConnection("jdbc:odbc:mydsn1");
		        st1=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		        rs1=st1.executeQuery("Select * from manager");
		        st2=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		        rs2=st2.executeQuery("Select * from agent");
                        while(rs2.next())
        		{
                                c1.addItem(/*rs2.getString(1)+" . "+*/rs2.getString(2)/*+"."+rs2.getString(4)*/);
        		}
       
     		}
     		catch(Exception e)
     		{
                        System.out.println(e);
                        String msg="Connection Failed.";
	         	JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
     		}
      
			 setVisible(true);
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}//constructor of Manager 
         
        public void actionPerformed(ActionEvent a1)
        {
           if(a1.getSource()==c1 || a1.getSource()==c)
           {

           try{
            String cn=(c1.getSelectedItem().toString()).trim();
            String m=c.getSelectedItem().toString();
            st5=cn1.createStatement();
            rs5=st5.executeQuery("Select * from agent where agentname='"+cn+"'");
              if(rs5.next())
        		{
                         t8.setText(rs5.getString("area"));
        		}


            st3=cn1.createStatement();//ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs3=st3.executeQuery("Select count(*),sum(package) from customer where joiningmonth='"+m+"' and AgentID='"+cn+"'");
            if(rs3.next())
            {
            t1.setText(rs3.getString(1));
            t2.setText(rs3.getString(2));

            }

            st4=cn1.createStatement();


            rs4=st4.executeQuery("select total,cdate from custbill where area='"+t8.getText()+"'");
             int t=0;
            while(rs4.next())
            {
             int cm=Integer.parseInt((rs4.getString("cdate")).substring(3,5));
             System.out.println("cm"+cm);
             int po=m.indexOf('.');
             int dm=Integer.parseInt(m.substring(0,po));
             System.out.println("dm"+dm);
             if(cm == dm)
             {       
                 t=t+rs4.getInt(1);
             }
            }
            t4.setText(Integer.toString(t));
            }
               catch(Exception e)
               {
               System.out.println("msg from acp"+e);
               }

           }
           if(a1.getSource()==c2)//calculateing,deposit,rental,total
           {
            double cmm=Double.parseDouble(c2.getSelectedItem().toString());

            double comm=(cmm*Double.parseDouble(t2.getText()))/100;

            double mcomm=(cmm*Double.parseDouble(t4.getText()))/100;
            t3.setText(Double.toString(comm));
            t5.setText(Double.toString(mcomm));
            double tm=Double.parseDouble(t4.getText())+Double.parseDouble(t2.getText());
            t6.setText(Double.toString(tm));
            double tcm=Double.parseDouble(t3.getText())+Double.parseDouble(t5.getText());
            t7.setText(Double.toString(tcm));




           }
        	if(a1.getSource()==b11)//exit
            {
	        	try
	        	{
                        cn1.close();
              		dispose();
                    }catch(Exception e){System.out.println(e);}

            }
            else if(a1.getSource()== b6)//next
            {
            	try
                {
                	rs1.next();
                  	rs1.refreshRow();
                    c1.setSelectedItem(rs1.getString(1));
                    c.setSelectedItem(rs1.getString(2));
                    t1.setText(rs1.getString(3));
                    c2.setSelectedItem(rs1.getString(4));
                    t2.setText(rs1.getString(5));
                    t3.setText(rs1.getString(6));
                    t4.setText(rs1.getString(7));
                    t5.setText(rs1.getString(8));
                    t6.setText(rs1.getString(9));
                    t7.setText(rs1.getString(10));

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
                                c1.setSelectedItem(rs1.getString(1));
                                c.setSelectedItem(rs1.getString(2));
                                t1.setText(rs1.getString(3));
                                c2.setSelectedItem(rs1.getString(4));
                                t2.setText(rs1.getString(5));
                                t3.setText(rs1.getString(6));
                                t4.setText(rs1.getString(7));
                                t5.setText(rs1.getString(8));
                                t6.setText(rs1.getString(9));
                                t7.setText(rs1.getString(10));

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
                                c1.setSelectedItem(rs1.getString(1));
                                c.setSelectedItem(rs1.getString(2));
                                t1.setText(rs1.getString(3));
                                c2.setSelectedItem(rs1.getString(4));
                                t2.setText(rs1.getString(5));
                                t3.setText(rs1.getString(6));
                                t4.setText(rs1.getString(7));
                                t5.setText(rs1.getString(8));
                                t6.setText(rs1.getString(9));
                                t7.setText(rs1.getString(10));

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
                                c1.setSelectedItem(rs1.getString(1));
                                c.setSelectedItem(rs1.getString(2));
                                t1.setText(rs1.getString(3));
                                c2.setSelectedItem(rs1.getString(4));
                                t2.setText(rs1.getString(5));
                                t3.setText(rs1.getString(6));
                                t4.setText(rs1.getString(7));
                                t5.setText(rs1.getString(8));
                                t6.setText(rs1.getString(9));
                                t7.setText(rs1.getString(10));                            
                                

                }catch(Exception e)
                {
                            String msg="Displaying of Last Record Failed .";
                            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                
                }

                }
                
                /*else if(a1.getSource()==b1)//addnew
                {
                            try
                            {
                            rs1.last();
                            int id=Integer.parseInt(rs1.getString(1));
                            id++;

                            t1.setText(""+id);
                            t2.setText("".toLowerCase());
                            t3.setText("".toLowerCase());
                            t4.setText("".toLowerCase());
                            t5.setText("");
                            t6.setText("");
                            t7.setText("");
                            String msg="Enter All Information and Click on SAVE button.";
                            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                            }catch(Exception e){}

                 
                }*/
                
                else if(a1.getSource()==b4)//Save
                {
                  try
                  {
                    ps=cn1.prepareStatement("insert into manager values(?,?,?,?,?,?,?,?,?,?,?)");
                    //ps.setInt(1,Integer.parseInt(t1.getText()));
                    ps.setString(1,c1.getSelectedItem().toString());
                    ps.setString(2,c.getSelectedItem().toString());
                    ps.setString(3,t1.getText());
                    ps.setString(4,c2.getSelectedItem().toString());
                    ps.setString(5,t2.getText());
                    ps.setString(6,t3.getText());
                    ps.setString(7,t4.getText());
                    ps.setString(8,t5.getText());
                    ps.setString(9,t6.getText());                    
                    ps.setString(10,t7.getText());
                    ps.setString(11,t8.getText());
         
                     ps.executeUpdate();
                     String msg="Record Saved Successfully";
                     JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);

                    cn1.commit();
                    clearall();

                 }  catch(Exception e){System.out.println(e);}
                }
                
                else if(a1.getSource()==b2)//modify
                {
                  try
                  {
	                    ps=cn1.prepareStatement("update manager set agentname=?,amonth=?,newcustadded=?,commission=?,dcollection=?,cdeposit=?,mrentcollection=?,cmrental=?,tcollection=?,tcommission=?");
	                    //ps.setInt(1,Integer.parseInt(t1.getText()));
	                    ps.setString(1,c1.getSelectedItem().toString());
	                    ps.setString(2,c.getSelectedItem().toString());
	                    ps.setString(3,t1.getText());
	                    ps.setString(4,c2.getSelectedItem().toString());
	                    ps.setString(5,t2.getText());
	                    ps.setString(6,t3.getText());
	                    ps.setString(7,t4.getText());
	                    ps.setString(8,t5.getText());
	                    ps.setString(9,t6.getText());
	                    ps.setString(10,t7.getText());
	                    //ps.setInt(10,Integer.parseInt(t1.getText()));
	         
	         
	                     ps.executeUpdate();
	                
	
	                     String msg="Record Updated Successfully";
	                     JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);

                    	cn1.commit();
                    }catch(Exception e){}
					clearall();
                }
                
                /*else if(a1.getSource()==b3)//delete
                {
  					try
        			{
         					int pid=Integer.parseInt(t1.getText());
        					ps2=cn1.prepareStatement("delete * from customer where CustomerID="+pid);
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
                }*/
                
                else if(a1.getSource()==b10)//search
         		{
					try
		 			{
                    	if(t2.getText()!="")
                    	{
                    		st3 = cn1.createStatement();
	                        rs3 = st3.executeQuery("select * from Customer where cname = '" +  t2.getText()+"'");
	                        if(rs3.next())
	                        {
	                      //	t2.setText(rs.getString(4));
	                      		c1.setSelectedItem(rs3.getString(1));
								c.setSelectedItem(rs3.getString(2));
								t1.setText(rs3.getString(3));
								c2.setSelectedItem(rs3.getString(4));
		                        t2.setText(rs3.getString(5));
		                        t3.setText(rs3.getString(6));
		                        t4.setText(rs3.getString(7));
		                        t5.setText(rs3.getString(8));
		                        t6.setText(rs3.getString(9));
		                        t7.setText(rs3.getString(10));
	                         }
                       }
            	  }//try
				  catch(SQLException e)
				  {
					System.out.print(e);
				  }
			
               }
                
               else if(a1.getSource()==b12)//home
        {
        	new home().show();
        	dispose();
        } 
                
                else if(a1.getSource()==b5)//clear
                {
                  clearall();
                }
		}//end of actionPerformed   
		
		 void clearall()
         {
                         try
                           {
	                            t1.setText("");
	                            t2.setText("");
	                            t3.setText("");
	                            t4.setText("");
	                            t5.setText("");
	                            t6.setText("");
	                            t7.setText("");
	                            
	                            rs1.beforeFirst();
                            }catch(Exception e){}


         }
         
                
                
//}
        public static void main(String args[])
        {
                Manager m1=new Manager();
              //  m1.setSize(920,768);
                m1.show();
        }
}        
