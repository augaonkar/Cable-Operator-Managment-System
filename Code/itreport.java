import java.awt.*;
import java.sql.*;
import java.util.*;	
import  java.awt.event.*;
import javax.swing.*;
//import date.*;

public class itreport extends JFrame implements ActionListener
{
	JLabel jl1,lb1,lb2,lb3,lb4;
	JButton b11,b22;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JTable table;
	Container cp;
	Connection con;
	ResultModel rmodel;
	JScrollPane pane;
        String query;
        public itreport(String rname,String query)
	{

                
                super("CABLE OPERATING SYSTEM NASIK  " + rname);
                this.query=query;
                setSize(720,600);
                cp=getContentPane();
		cp.setLayout(null);
		//cp.setBackground(new Color(225,185,236));
                cp.setBackground(Color.gray);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		cp=new JLabel(new ImageIcon("aq.jpg"));

		
                jl1=new JLabel(rname,JLabel.CENTER);
		jl1.setFont(new Font("Times New Roman",Font.BOLD,37));
		jl1.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.red));
                jl1.setForeground(Color.white);
		jl1.setBounds(0,0,1050,50);
		cp.add(jl1);


		table=new JTable();
		table.setFont(new Font("Times New Roman",Font.PLAIN,18));
		pane=new JScrollPane(table);
		pane.setBounds(10,60,1000,500);
		cp.add(pane);
                
                addKeyListener(
                new KeyAdapter(){
                public void keyPressed(KeyEvent ke)
                {
                try{
                 if(ke.getKeyCode()==17)
                  if(ke.getKeyCode()==80)
                     table.print();
                 }catch(Exception e){}
                }
                });

		b11=new JButton("PRINT");
                
		b11.setFont(new Font("Times New Roman",Font.BOLD,17));
		b11.setBounds(280,600,120,25);
		b11.setMnemonic('P');
		b11.addActionListener(this);
		cp.add(b11);

		b22=new JButton("EXIT");
		b22.setFont(new Font("Times New Roman",Font.BOLD,17));
		b22.setBounds(410,600,120,25);
		b22.setMnemonic('X');
		b22.addActionListener(this);
		cp.add(b22);

		connection();
		setTable();
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		cp.setBounds(0,0,getWidth(),getHeight());
		add(cp);
		
	}
	void setTable()
	{
		try
		{
			System.out.println(query);
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(query);
			rmodel=new ResultModel();
			rmodel.setResultSet(rs);
			table.setModel(rmodel);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void connection()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver");
                        con=DriverManager.getConnection("jdbc:odbc:mydsn1");
			System.out.println("Connection");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	
	public void actionPerformed(ActionEvent ae)
	{	
		
		 if(ae.getSource()==b11)  //print
		{
			try	
			{
				table.print();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}			
		}	
		else if(ae.getSource()==b22)  //exit
		{
			dispose();
		}		
	}
	
}









