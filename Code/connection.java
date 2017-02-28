import java.sql.*;
import java.io.*;

class connection
{
  Connection conn;
  Statement st;


  connection()
  {
    try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     conn=DriverManager.getConnection("jdbc:odbc:mydsn1");
     st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
