import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class reg extends JFrame implements ActionListener,KeyListener
{
        JLabel l,l1,l2,l3,l4;
        JButton b1,b2;
        JTextField t1,t2;
        TextField t3;
        Font f1,f2;
        ResultSet rs1,rs2;
        Connection cn1;
        Statement st1,st2;
        PreparedStatement ps;
        Icon save = new ImageIcon("save.jpg");
        Icon cancel = new ImageIcon("cancel.jpg");
        Icon registor = new ImageIcon("register.png");
        
	reg()
	{
	  super("CABLE OPERATING SYSTEM");
      setSize(480,320);setLocation(400,50);
      setResizable(false);
	  Container p=getContentPane();
     p.setLayout(null);
     p.setBackground(Color.darkGray);
	 f1=new Font("Arial",Font.BOLD,13);
	 f2=new Font("Timer New Roman",Font.BOLD,30);
        
                l=new JLabel("REGISTRATION INFORMATION");
                l.setFont(f2);
                l.setForeground(Color.white);
                l.setBounds(10,10,800,50);
        p.add(l);//l.setIcon(customer);        
                
                
                l1=new JLabel("Name:");
                l1.setFont(f1);
                l1.setForeground(Color.white);
                l1.setBounds(10,45,80,120);
	p.add(l1);

                t1=new JTextField(5);
                t1.setBounds(100,90,120,25);
        p.add(t1);


                l2=new JLabel("LoginID:");
                l2.setFont(f1);
                l2.setForeground(Color.white);
                l2.setBounds(10,135,100,25);
	p.add(l2);

                t2=new JTextField(20);
                //t2.addKeyListener(this);
                t2.setBounds(100,135,120,25);
	p.add(t2);

                l3=new JLabel("Password:");
                l3.setFont(f1);
                l3.setForeground(Color.white);
                l3.setBounds(10,178,70,40);
	p.add(l3);

                t3=new TextField(15);
                t3.setBounds(100,185,120,25);
                t3.setEchoChar('*');
	p.add(t3);

               	
                
                b1=new JButton("Save");
                b1.setBounds(10,240,120,50);
                b1.setMnemonic('S');
                b1.setToolTipText("Saves the record");
                b1.addActionListener(this);
	p.add(b1);b1.setIcon(save);

                b2=new JButton("Cancel");
                b2.setBounds(140,240,120,50);
                b2.setMnemonic('C');
                b2.setToolTipText("Clears the Info");
                b2.addActionListener(this);
        p.add(b2);b2.setIcon(cancel);
        
        		ImageIcon register=new ImageIcon("register.png");
        		l4=new JLabel(register);
        		setBackground(Color.darkGray);
        		l4.setBounds(200,10,280,260);
        		l4.setToolTipText("REGISTRATION WINDOW");
        	p.add(l4);

               

	try
     	{
	       	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	       	cn1=DriverManager.getConnection("jdbc:odbc:mydsn1");
	        st1=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	        rs1=st1.executeQuery("Select * from login");
     	}
	    catch(Exception e)
     	{
       		String msg="Connection Failed.";
            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
     	}
      
	 	setVisible(true);
	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



  }//constructor of cust

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
}//end of keylistener
         public void actionPerformed(ActionEvent a1)
         {

               if(a1.getSource()==b2)//cancel
               {

               try
               {
                   cn1.close();
                   dispose();
               }catch(Exception e){}

               }
                else if(a1.getSource()==b1)//Save
                {

                  try
                  {
                    ps=cn1.prepareStatement("insert into login values(?,?,?)");
                    ps.setString(1,t1.getText().toLowerCase());
                    ps.setString(2,t2.getText().toLowerCase());
                    ps.setString(3,t3.getText().toLowerCase());
                       
                     ps.executeUpdate();
                     String msg="Record Saved Successfully";
                     JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);

                    cn1.commit();dispose();
                    //clearall();

                 }  catch(Exception e){System.out.println(e);}
                }
                

  }//actionPerformed
         void clearall()
         {
                         try
                           {
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            
                            rs1.beforeFirst();
                            }catch(Exception e){}


         }


 public static void main(String args[])
 {
 	new reg();
 }
}

