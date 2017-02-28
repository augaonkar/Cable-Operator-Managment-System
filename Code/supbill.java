import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class supbill extends JFrame  implements ActionListener,KeyListener
{
        JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
        JTextField t1,t3,t4,t5;
        JComboBox c;
        Font f1,f2;
        Connection cn1,cn2;
        ResultSet rs1,rs2,rs3,rs4,rs5;
        Statement st1,st2,st3,st4,st5;
        PreparedStatement ps;
        Icon save = new ImageIcon("save.jpg");
        Icon previous = new ImageIcon("previous.jpg");
        Icon next = new ImageIcon("next.jpg");
        Icon first = new ImageIcon("first.jpg");
        Icon last = new ImageIcon("last.jpg");
        Icon addnew = new ImageIcon("addnew.jpg");
        Icon exit = new ImageIcon("exit.jpg");
        Icon cancel = new ImageIcon("cancel.jpg");
        Icon search = new ImageIcon("search.jpg");
        Icon home = new ImageIcon("home.jpg");
        supbill()
        {
                super("CABLE OPERATING SYSTEM");
                Container p=getContentPane();
                setSize(800,500);setLocation(200,50);
                setResizable(false);
                p.setLayout(null);
                p.setBackground(Color.darkGray);

                f1=new Font("Arial",Font.BOLD,13);
                f2=new Font("Times New Roman",Font.BOLD,30);
                
                l=new JLabel("SUPPLIER BILL");
                l.setFont(f2);
                l.setForeground(Color.white);
                l.setBounds(170,10,800,40);
             p.add(l);                

                l1=new JLabel("Bill ID:");
                l1.setFont(f1);
                l1.setForeground(Color.white);
                l1.setBounds(30,60,70,40);
			p.add(l1);                
                
                t1=new JTextField(5);
                t1.setBounds(130,60,60,25);
            p.add(t1);    
                
                l2=new JLabel("Purchase");
                l2.setFont(f1);
                l2.setForeground(Color.white);
                l2.setBounds(30,119,70,40);
           p.add(l2);     
                
                l3=new JLabel("orderID:");
                l3.setFont(f1);
                l3.setForeground(Color.white);
                l3.setBounds(30,130,70,40);
           p.add(l3);     
                
                c=new JComboBox();
                c.setBounds(130,125,60,25);
           p.add(c);
           c.addActionListener(this);
                
                l4=new JLabel("Supplier");
                l4.setFont(f1);
                l4.setForeground(Color.white);
                l4.setBounds(30,178,70,40);
           p.add(l4);     
                
                l5=new JLabel("Name:");
                l5.setFont(f1);
                l5.setForeground(Color.white);
                l5.setBounds(30,190,120,40);
           p.add(l5);     
                
                t3=new JTextField(10);
                t3.setBounds(130,190,110,25);
           p.add(t3);     
                
                l6=new JLabel("Estimated");
                l6.setFont(f1);
                l6.setForeground(Color.white);
                l6.setBounds(30,240,70,40);
           p.add(l6);     
                
                l7=new JLabel("Amount:");
                l7.setFont(f1);
                l7.setForeground(Color.white);
                l7.setBounds(30,254,70,40);
           p.add(l7);     
                
                t4=new JTextField(15);
                t4.setBounds(130,255,60,25);
           p.add(t4);

                l8=new JLabel("Total");
                l8.setBounds(30,315,70,30);
                l8.setForeground(Color.white);
              p.add(l8);    
                
                l9=new JLabel("Amount:");
                l9.setBounds(30,325,70,30);
                l9.setForeground(Color.white);
                p.add(l9);
                
                t5=new JTextField(15);
                t5.addKeyListener(this);
                t5.setBounds(130,322,60,25);
                p.add(t5);
                
                l10=new JLabel("DATE:");//system date
                l10.setFont(f1);
                l10.setForeground(Color.white);
                l10.setBounds(440,10,60,40);
          p.add(l10);
          		
                        l11=new JLabel();
                l11.setBounds(490,15,70,30);
          p.add(l11);l11.setForeground(Color.white);               
          		
          		Date date2 = new Date(); 
	   			SimpleDateFormat sdf= new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy");
	   			String s= sdf.format(date2);
                                l11.setText(s); 
                
                b1=new JButton("AddNew");
                b1.setBounds(600,30,120,50);
                b1.setMnemonic('A');
                b1.setToolTipText("Adds new record");
                b1.addActionListener(this);
          p.add(b1);b1.setIcon(addnew);      
                
                           
                b4=new JButton("Save");
                b4.setBounds(600,90,120,50);
                b4.setMnemonic('S');
                b4.setToolTipText("Saves the record");
                b4.addActionListener(this);
          p.add(b4);b4.setIcon(save);      
                
                b5=new JButton("Cancel");
                b5.setBounds(600,150,120,50);
                b5.setMnemonic('C');
                b5.setToolTipText("Cancel the record");
                b5.addActionListener(this);
          p.add(b5);b5.setIcon(cancel);      
                
                b6=new JButton("Next");
                b6.setBounds(600,210,120,50);
                b6.setMnemonic('N');
                b6.setToolTipText("Moves to NEXT record");
                b6.addActionListener(this);
          p.add(b6);b6.setIcon(next);      
                
                b7=new JButton("Previous");
                b7.setBounds(600,270,120,50);
                b7.setMnemonic('P');
                b7.setToolTipText("Moves to PREVIOUS record");
                b7.addActionListener(this);
          p.add(b7);b7.setIcon(previous);      
                
                b8=new JButton("First");
                b8.setBounds(600,330,120,50);
                b8.setMnemonic('F');
                b8.setToolTipText("Moves to FIRST record");
                b8.addActionListener(this);
          p.add(b8);  b8.setIcon(first);    
                
                b9=new JButton("Last");
                b9.setBounds(600,390,120,50);
                b9.setMnemonic('L');
                b9.setToolTipText("Moves to LAST records");
                b9.addActionListener(this);
           p.add(b9); b9.setIcon(last);
    
                          
                b11=new JButton("EXIT");
                b11.setBounds(450,390,120,50);
                b11.setMnemonic('E');
                b11.setToolTipText("Closes the window");
                b11.addActionListener(this);
		  p.add(b11);b11.setIcon(exit);
		  		
                b12=new JButton("HOME");
                b12.setBounds(300,390,120,50);
                b12.setMnemonic('E');
                b12.setToolTipText("Goes To HOMESCREEN");
                b12.addActionListener(this);
		  p.add(b12);b12.setIcon(home);
		  
                  ImageIcon bill=new ImageIcon("bill.png");
                  l9=new JLabel(bill);
                  l9.setBounds(300,90,280,260);
                  l9.setToolTipText("BILL DETAILS WINDOW");
        	p.add(l9);
          
        try
     	{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn1=DriverManager.getConnection("jdbc:odbc:mydsn1");
            st1=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs1=st1.executeQuery("Select * from supplierbill");
            st2=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs2=st2.executeQuery("Select * from purchaseorder");
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
}//constructor
public void keyReleased(KeyEvent K)
          {
          }
           public void keyTyped(KeyEvent K)
  {
  }
  	public void keyPressed(KeyEvent k)
 	{
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
 	}//end of keyListener
public void actionPerformed(ActionEvent a1)
{
        if(a1.getSource()==c)//PorderID
        {
        try{
            st5=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs5=st5.executeQuery("Select * from purchaseorder where PorderID="+c.getSelectedItem().toString());
            if(rs5.next())
            {
             t3.setText(rs5.getString(2));
             t4.setText(rs5.getString(4));
            }
           }
           catch(Exception e){System.out.println(e);}

        }
        if(a1.getSource()==b11)//exit
        {
                try
                {
                        cn1.close();
                        dispose();
                }
                catch(Exception e){}
        }
        else if(a1.getSource()==b6)//next
        {
                try
                {
                        rs1.next();rs1.refreshRow();
                        t1.setText(rs1.getString(1));t1.setEnabled(false);
                        c.setSelectedItem(rs1.getString(2));
                        t3.setText(rs1.getString(3));t3.setEnabled(false);
                        t4.setText(rs1.getString(4));t4.setEnabled(false);
                        t5.setText(rs1.getString(5));t5.setEnabled(false);
                }
                catch(Exception e)
                {
                        String msg="No Record Beyond this.";
                        JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                }
        }
        else if(a1.getSource()==b7)//previous
        {
                try
                {
                        rs1.previous();rs1.refreshRow();
                        t1.setText(rs1.getString(1));t1.setEnabled(false);
                        c.setSelectedItem(rs1.getString(2));
                        t3.setText(rs1.getString(3));t3.setEnabled(false);
                        t4.setText(rs1.getString(4));t4.setEnabled(false);
                        t5.setText(rs1.getString(5));t5.setEnabled(false);
                }
                catch(Exception e)
                {
                        String msg="No Record Beyond this.";
                        JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                }
        }
        else if(a1.getSource()==b8)//first
        {
                try
                {
                        rs1.first();rs1.refreshRow();
                        t1.setText(rs1.getString(1));t1.setEnabled(false);
                        c.setSelectedItem(rs1.getString(2));
                        t3.setText(rs1.getString(3));t3.setEnabled(false);
                        t4.setText(rs1.getString(4));t4.setEnabled(false);
                        t5.setText(rs1.getString(5));t5.setEnabled(false);
                }
                catch(Exception e)
                {
                        String msg="No Record Beyond this.";
                        JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);  
                }
        }
        else if(a1.getSource()==b9)//last
        {
                try
                {
                        rs1.last();rs1.refreshRow();t1.setEnabled(false);
                        t1.setText(rs1.getString(1));
                        c.setSelectedItem(rs1.getString(2));t3.setEnabled(false);
                        t3.setText(rs1.getString(3));t3.setEnabled(false);
                        t4.setText(rs1.getString(4));t4.setEnabled(false);
                        t5.setText(rs1.getString(5));t5.setEnabled(false);
                }
                catch(Exception e)
                {
                        String msg="No Record Beyond this.";
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
                       // t3.setText("");
                       // t4.setText("");
                        t5.setText("".toLowerCase());
                        t1.setEnabled(false);
                        String msg="Enter the Information and Click on SAVE button.";
                      JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception e)
                {
                	System.out.println(e);
                }
        }
        else if(a1.getSource()==b4)//Save
                {

                  try
                  {
                    ps=cn1.prepareStatement("insert into supplierbill values(?,?,?,?,?)");
                    ps.setInt(1,Integer.parseInt(t1.getText()));
                    ps.setString(2,c.getSelectedItem().toString());
                    ps.setString(3,t3.getText().toLowerCase());
                    ps.setString(4,t4.getText());
                    ps.setString(5,t5.getText());
                       
                     ps.executeUpdate();
                     String msg="Record Saved Successfully";
                     JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);

                    cn1.commit();
                    clearall();

                 }  catch(Exception e){System.out.println(e);}
                }
         

        else if(a1.getSource()==b5)//clear
        {
                clearall();
        }
        else if(a1.getSource()==b12)//home
        {
                dispose();
                new home().show();
        }
}//action performed  

void clearall()
{
        try
        {
        t1.setText("");
        t5.setText("");
        rs1.beforeFirst();
        }
        catch(Exception e){}
}

        public static void main(String args[])
        {
                supbill supbill=new supbill();
              	supbill.show();
               
        }
}        

