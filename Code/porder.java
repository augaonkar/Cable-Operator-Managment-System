import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class porder extends JFrame implements ActionListener
{
        product pr;
        JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
        JTextField t1,t4,t5,t6;
        JComboBox c,c1;
        Font f1,f2;
        ResultSet rs1,rs2,rs3,rs4,rs5,rs6;
        Connection cn1;
        Statement st1,st2,st3,st4,st5,st6;
        PreparedStatement ps,ps1,ps2,ps3;
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
        Container p;
        porder() 
        {
                super("CABLE OPERATING SYSTEM");
                setSize(980,720);setLocation(200,50);
//              setResizable(false);
                p=getContentPane();
                p.setLayout(null);
          		p.setBackground(Color.darkGray);
				f1=new Font("Arial",Font.BOLD,13);
				f2=new Font("Arial",Font.BOLD,30);
                
                
                l=new JLabel("PURCHASE ORDER"); 
                l.setFont(f2);
                l.setForeground(Color.white);	
                l.setBounds(170,10,800,50);
			p.add(l);
                
                l1=new JLabel("Purchase"); 
                l1.setFont(f1);
                l1.setForeground(Color.white);	
                l1.setBounds(30,65,70,40);
			p.add(l1);                
                
                l2=new JLabel("orderID:");
                l2.setFont(f1);
                l2.setForeground(Color.white);
                l2.setBounds(30,77,70,40);
           	p.add(l2);     
                
                t1=new JTextField();
                t1.setBounds(150,71,60,30);
          	p.add(t1);    
                
                l3=new JLabel("SupplierID:");
                l3.setFont(f1);
                l3.setForeground(Color.white);
                l3.setBounds(30,125,74,40);
          	p.add(l3);    
                
                c=new JComboBox();
                c.setBounds(150,125,185,30);
          	p.add(c);      
                
                l5=new JLabel("No of Item:");
                l5.setFont(f1);
                l5.setForeground(Color.white);
                l5.setBounds(30,170,70,60);
          	p.add(l5);      
                
                t4=new JTextField(5);
                t4.setBounds(150,180,100,30);
    			t4.addActionListener(this);      	
          	p.add(t4);
          
                
                l6=new JLabel("Total:");
                l6.setFont(f1);
                l6.setForeground(Color.white);
                l6.setBounds(30,530,70,40);
          	p.add(l6);     
                
                t5=new JTextField("0",15);
                t5.setBounds(150,530,120,30);
          	p.add(t5);     
                
               l7=new JLabel("DATE:");//system date
          		l7.setFont(f1);
                l7.setForeground(Color.white);
                l7.setBounds(450,65,60,40);
          	p.add(l7);
          		
                l10=new JLabel();
                l10.setBounds(510,70,70,30);
          		l10.setForeground(Color.white);               
          	p.add(l10);
          		
          		Date date2 = new Date(); 
	   			SimpleDateFormat sdf= new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy");
	   			String s= sdf.format(date2);
                l10.setText(s);         
                
                                      
                b1=new JButton("AddNew");
                b1.setBounds(750,30,120,50);
                b1.setMnemonic('A');
                b1.setToolTipText("Adds New Record");
                b1.addActionListener(this);
          	p.add(b1);b1.setIcon(addnew);
    
                b3=new JButton("Delete");
                b3.setBounds(750,150,120,50);
                b3.setMnemonic('D');
                b3.setToolTipText("Deletes Record");
                b3.addActionListener(this);
          	p.add(b3);b3.setIcon(delete);
     
                
                b4=new JButton("Save");
                b4.setBounds(750,90,120,50);
                b4.setMnemonic('S');
                b4.setToolTipText("Saves Record");
                b4.addActionListener(this);
          	p.add(b4);b4.setIcon(save);
      
                
                b5=new JButton("Cancel");
                b5.setBounds(750,210,120,50);
                b5.setMnemonic('C');
                b5.setToolTipText("Clears TextField");
                b5.addActionListener(this);
          	p.add(b5);b5.setIcon(cancel);
      
                
                b6=new JButton("Next");
                b6.setBounds(750,270,120,50);
                b6.setMnemonic('N');
                b6.setToolTipText("Moves To NEXT Record");
                b6.addActionListener(this);
          	p.add(b6);b6.setIcon(next);
      
                
                b7=new JButton("Previous");
                b7.setBounds(750,330,120,50);
                b7.setMnemonic('P');
                b7.setToolTipText("Moves To PREVIOUS Record");
                b7.addActionListener(this);
          	p.add(b7);b7.setIcon(previous);
      
                
                b8=new JButton("First");
                b8.setBounds(750,390,120,50);
                b8.setMnemonic('F');
                b8.setToolTipText("Moves To FIRST Record");
                b8.addActionListener(this); 
          	p.add(b8);b8.setIcon(first);
      
                
                b9=new JButton("Last");
                b9.setBounds(750,450,120,50);
                b9.setMnemonic('L');
                b9.setToolTipText("Moves To LAST Records");
                b9.addActionListener(this);
          	p.add(b9);b9.setIcon(last);
      
                b11=new JButton("EXIT");
                b11.setBounds(350,530,120,50);
                b11.setMnemonic('E');
                b11.setToolTipText("Closes Window");
                b11.addActionListener(this);  
          	p.add(b11);b11.setIcon(exit);
          		
          		b12=new JButton("HOME");
                b12.setBounds(550,530,120,50);
                b12.setMnemonic('H');
                b12.setToolTipText("Goes To HOMESCREEN");
                b12.addActionListener(this);  
                p.add(b12);b12.setIcon(home);
                
                ImageIcon product=new ImageIcon("product.png");
        		l11=new JLabel(product);
        		l11.setBounds(375,180,280,260);
        		l11.setToolTipText("PRODUCT WINDOW");
        	p.add(l11);

			
                try
     			{
			       	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			       	cn1=DriverManager.getConnection("jdbc:odbc:mydsn1");
			        st1=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			        rs1=st1.executeQuery("Select * from purchaseorder");
		
			        st2=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		        	rs2=st2.executeQuery("Select * from supplier");
		            while(rs2.next())
          			{
                        c.addItem(rs2.getString(2));
                    }
                }
     			catch(Exception e)
     			{
                    String msg="Connection Failed.2";
            		JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
     			}
            
      
	 				setVisible(true);
	 				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 
		}//end of constructor
        
        public void actionPerformed(ActionEvent a1)
        {
        	if(a1.getSource()==t4)
            {
            	try
            	{
                	setVisible(false);
                	if(pr!=null)
                    p.remove(pr);
                  	t5.setText("0");
                  	pr=new product(Integer.parseInt(t4.getText()));

                 	int h=20+(Integer.parseInt(t4.getText())*50);

                 	pr.setBounds(20,250,650,h);
                 	p.add(pr); 
                  	setVisible(true);
                  	l11.setVisible(false);
                }
                catch(Exception e)
                {
                	System.out.println("Error t4"+e);
                }
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
        else if(a1.getSource()== b6)//next
        {
        	try
            {
            	rs1.next();rs1.refreshRow();
                t1.setText(rs1.getString(1)); t1.setEnabled(false);
                c.setSelectedItem(rs1.getString(2));
                t4.setText(rs1.getString(3)); t4.setEnabled(false);
                t5.setText(rs1.getString(4));t5.setEnabled(false);
                l10.setText(rs1.getString(5));

            }
            catch(Exception e)
            {
            	String msg="No Record beyond this.";
                JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
            }
       }
       else if(a1.getSource()==b7)//previous
       {
       		try
	        {
	        	rs1.previous();rs1.refreshRow();
				t1.setText(rs1.getString(1)); t1.setEnabled(false);
				c.setSelectedItem(rs1.getString(2));
				t4.setText(rs1.getString(3)); t4.setEnabled(false);
				t5.setText(rs1.getString(4)); t5.setEnabled(false);
				l10.setText(rs1.getString(5));
			}
			catch(Exception e)
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
                  
                t1.setText(rs1.getString(1)); t1.setEnabled(false);
                c.setSelectedItem(rs1.getString(2));
                t4.setText(rs1.getString(3)); t4.setEnabled(false);
                t5.setText(rs1.getString(4)); t5.setEnabled(false);
                l10.setText(rs1.getString(5));
            }
            catch(Exception e)
            {
             	String msg="Displaying of First Record Failed .";
                JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
            }
		}
        else if(a1.getSource()==b9)//last
        {
			try
            {
            	rs1.last();rs1.refreshRow(); 
                t1.setText(rs1.getString(1)); t1.setEnabled(false);
                c.setSelectedItem(rs1.getString(2));
                t4.setText(rs1.getString(3)); t4.setEnabled(false);
                t5.setText(rs1.getString(4)); t5.setEnabled(false);
                l10.setText(rs1.getString(5));
                                
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
	            t4.setText("");
	            t5.setText("");
	            t1.setEnabled(false);
                String msg="Enter All Information and Click on SAVE button.";
	            JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception e){}
		}
        else if(a1.getSource()==b4)//Save
        {
			try //this try block store data into purchase order1
            {
             	ps=cn1.prepareStatement("insert into purchaseorder values(?,?,?,?,?)");
                ps.setInt(1,Integer.parseInt(t1.getText()));
                ps.setString(2,c.getSelectedItem().toString());
                ps.setString(3,t4.getText());
                ps.setString(4,t5.getText());
                ps.setString(5,l10.getText());
                ps.executeUpdate();
                String msg="Record Saved Successfully";
                JOptionPane.showMessageDialog((Component)null,msg,"mydsn1",JOptionPane.INFORMATION_MESSAGE);

                cn1.commit();
            }
            catch(Exception e){System.out.println(e);}
            try //this try block store data into purchase order2
            {
            	for(int i=0;i<Integer.parseInt(t4.getText());i++)
                {
                	ps1=cn1.prepareStatement("insert into purchaseorder2 values(?,?,?,?,?,?)");
                    ps1.setInt(1,Integer.parseInt(t1.getText()));
                    ps1.setString(2,pr.tpid[i].getSelectedItem().toString());
                    ps1.setString(3,pr.tpname[i].getText());
                    ps1.setString(4,pr.tpqty[i].getText());
                    ps1.setString(5,pr.tprate[i].getText());
                    ps1.setString(6,pr.tpamt[i].getText());
                    ps1.executeUpdate();
                    cn1.commit();
                }
            }//try
            catch(Exception e)
            {
             	System.out.println("Call 2"+e);
            }
            try //this try block update stock into product table
            {
				for(int i=0;i<Integer.parseInt(t4.getText());i++)
                {
                 	ps3=cn1.prepareStatement("update product set stock = stock + ? where ProductID =?");
                
                    ps3.setInt(1,Integer.parseInt(pr.tpqty[i].getText()));
    				ps3.setInt(2,Integer.parseInt(pr.tpid[i].getSelectedItem().toString()));
                    ps3.executeUpdate();
                    cn1.commit();
                }
        	}//try
             catch(Exception e)
             {
              	System.out.println("Call 3"+e);
             }
		}
        
        else if(a1.getSource()==b3)//delete
        {
  			try
  			{
         		int pid=Integer.parseInt(t1.getText());
        		ps2=cn1.prepareStatement("delete * from purchaseorder where PorderID="+pid);
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
        
        else if(a1.getSource()==b5)//clear
        {
        	clearall();
        }
        else if(a1.getSource()==b12)//home
        {
        	dispose();
        	new home().show();
        }
     }//end of actionlistener
        void clearall()
         {
                         try
                           {
                            t1.setText("");
                            t4.setText("");
                            t5.setText("");
                            rs1.beforeFirst();
                            }catch(Exception e){}


         }
          
class product extends JPanel implements ActionListener
{
   JLabel pid,pname,pqty,prate,pamt;
   JTextField tpname[],tpqty[],tprate[],tpamt[];
   JComboBox tpid[];
   String val;
   int n;
   product(int n) throws Exception
   {
   		this.n=n;
   	    pid=new JLabel("Product Id");
	    pname=new JLabel("Product Name");
	    prate=new JLabel("Rate per unit");
	    pqty=new JLabel("Quantity ");
	    pamt=new JLabel("Amount");
	
	    tpid=new JComboBox[n];
	    tpname=new JTextField[n];
	    tpqty=new JTextField[n];
	    tprate=new JTextField[n];
	    tpamt=new JTextField[n];
        setLayout(null);
	    pid.setBounds(20,10,170,10);
	add(pid);
	    
	    pname.setBounds(120,10,90,10);
    add(pname);
        
        pqty.setBounds(410,10,70,15);
    add(pqty);
        prate.setBounds(250,10,90,15);
    add(prate);
	    pamt.setBounds(550,10,50,10);
    add(pamt);
	    int x=30;

        for(int j=0;j<n;j++)
        {
         	tpid[j]=new JComboBox();

            st5=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs5=st5.executeQuery("Select * from product");
            while(rs5.next())
          	{
             	tpid[j].addItem(rs5.getString(1));
            }
            tpid[j].setBounds(10,x,90,30);
            tpid[j].addActionListener(this);       
	   		add(tpid[j]);
            x=x+50;

        }
			x=30;
            for(int i=0;i<n;i++)
            {
      			tpname[i]=new JTextField(15);
      			tpname[i].setBounds(100,x,120,30);
		add(tpname[i]);
      			tprate[i]=new JTextField(5);
      			tprate[i].setBounds(220,x,140,30);
        add(tprate[i]);
      			tpqty[i]=new JTextField(5);
      			tpqty[i].setBounds(360,x,140,30);
            	tpqty[i].addActionListener(this);
        add(tpqty[i]);
      			tpamt[i]=new JTextField(5);
      			tpamt[i].setBounds(500,x,140,30);
        add(tpamt[i]);
      			x=x+50;
            }

    }
    public void actionPerformed(ActionEvent ae1)
    {
        try
    	{
      		for (int j=0;j<n;j++)
      		{
       			if(ae1.getSource()==tpid[j])
       			{
            		st6=cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            		int x=Integer.parseInt((String)(tpid[j].getSelectedItem()));
            		rs6=st6.executeQuery("Select * from product where ProductID="+x);
            		if(rs6.next())
                        {
                    	tpname[j].setText(rs6.getString(2));
                        tprate[j].setText(rs6.getString(4));
                	}
       			}//if  
      		}//for

      		for (int j=0;j<n;j++)
      		{
       			if(ae1.getSource()==tpqty[j])
       			{
          			int r=Integer.parseInt(tpqty[j].getText())*Integer.parseInt(tprate[j].getText());
          			tpamt[j].setText(Integer.toString(r));
          			int a= Integer.parseInt(t5.getText());
          			int tamt=a+r;
          			t5.setText(Integer.toString(tamt));
				}//if
     		}//for
      	}//try
      	catch(Exception e)
      	{
      		System.out.println(e);
      	}
    }
}//end of actionPerformed
public static void main(String args[])
{
	porder porder=new porder();
    porder.show();
}
}        
