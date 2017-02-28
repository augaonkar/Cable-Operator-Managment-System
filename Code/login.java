import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
class login extends JFrame implements ActionListener
{
        JLabel l,l1,l2,l3,l8,l9,l10,l11,l12;
        JButton b1,b2,b3,b4;
        JTextField t1;
        Font f1,f2;
        TextField t2;
        ResultSet rs;
        Connection cn;
        Statement st1,st2,st3,st4,st5;
        PreparedStatement pst;
        int cnt;
        Icon exit = new ImageIcon("exit.jpg");
        Icon ok = new ImageIcon("ok.jpg");
        Icon addnew = new ImageIcon("addnew.jpg");
        Icon save = new ImageIcon("save.jpg");
        login()
        {
                super("CABLE OPERATING SYSTEM");
                setSize(900,640);setLocation(200,50);
                setResizable(false);
                Container p=getContentPane();
                p.setLayout(null);
                p.setBackground(Color.white);
                f1=new Font("Arial Narrow",Font.BOLD,15);
                f2=new Font("Rockwell",Font.BOLD,50);
                setLayout(null);
                ImageIcon tv=new ImageIcon("login5.jpg");
                l8=new JLabel(tv);
                l8.setBounds(20,0,900,700);
                l8.setBackground(Color.gray);

                l=new JLabel("CABLE");
                l.setFont(f2);
                l.setBounds(60,20,800,50);
                l.setForeground(Color.gray);
                p.add(l);

                l9=new JLabel("OPERATING");
                l9.setFont(f2);
                l9.setBounds(110,80,800,50);
                l9.setForeground(Color.gray);
                p.add(l9);

                l10=new JLabel("SYSTEM!!!");
                l10.setFont(f2);
                l10.setBounds(260,140,800,50);
                l10.setForeground(Color.gray);
                p.add(l10);

                l1=new JLabel("Login ID:");
                l1.setFont(f1);
               // l1.setForeground(Color.red);
                l1.setBounds(90,290,110,50);
              p.add(l1);
                
                t1=new JTextField(20);
                t1.setBounds(210,295,150,30);
               p.add(t1); 
                
                l2=new JLabel("Password:");
                l2.setFont(f1);
                //l2.setForeground(Color.red);
                l2.setBounds(90,355,110,50);
             p.add(l2);   
               
                t2=new TextField(10);
                t2.setBounds(210,355,150,30);
                t2.setEchoChar('*');
               p.add(t2);
               
               l3=new JLabel();
               l3.setBounds(500,700,100,40);
               p.add(l3);
               	
                l11=new JLabel("DATE:");//system.date
                l11.setFont(f1);
               // l11.setForeground(Color.red);
                l11.setBounds(648,59,100,50);
           p.add(l11);

                l12=new JLabel();
                l12.setFont(f1);
                l12.setBounds(700,58,100,50);
                p.add(l12);

                Date date2= new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy");
                String s=sdf.format(date2);
                l12.setText(s);
                 
                b1=new JButton("OK");
                b1.setBounds(90,400,100,40);
              b1.addActionListener(this);
                b1.setIcon(ok); 
             p.add(b1);

               b2=new JButton("EXIT");
               b2.setBounds(200,400,100,40);
               b2.setToolTipText("Closes the SYSTEM");
               b2.addActionListener(this);
               b2.setIcon(exit);
             p.add(b2);

               b3=new JButton("NEW");
               b3.setBounds(310,400,100,40);
               b3.setMnemonic('N');
               b3.setToolTipText("Entering NEW USER");
               b3.addActionListener(this);
               b3.setIcon(addnew);
             p.add(b3);

               
            p.add(l8);
              
              
            try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		cn=DriverManager.getConnection("jdbc:odbc:mydsn1");

	}
	catch(Exception e){}
	}

	
        public void actionPerformed(ActionEvent e)
	{
        
        if(e.getSource()==b1)//ok
        {
        try{
        String un=t1.getText();
        String pw=t2.getText();
         pst=cn.prepareStatement("select * from login where login=? and password=?");
         pst.setString(1,un);
         pst.setString(2,pw);
         ResultSet rs=pst.executeQuery();
         if(rs.next())
         {
          new home().show();
          dispose();
         }
         else
         {
          JOptionPane.showMessageDialog(this,"Invalid ID or PASSWORD","SEARCH FAIL",JOptionPane.INFORMATION_MESSAGE);
         }

            }catch(Exception e1){}
        }
        	   
	    if(e.getSource()==b2)//exit
        {
        	//cn1.close();
        	dispose();
        }
        	
        if(e.getSource()==b3)//new
        {
        	new reg().show();
        }
        	      
     }//actionperformed*/

 	public static void main (String[] args)
 	{
 		login login=new login();
 		login.show();
	}   
    
}
