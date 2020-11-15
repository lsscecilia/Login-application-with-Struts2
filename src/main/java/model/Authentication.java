package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * model class
 * logic for data access object and authentication
 */
public class Authentication {

    public static Connection conn() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/UserPasswordTable?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "cecilia", "xxxx");
    }

    //hard coded , to link to mysql
    public static boolean isLoginValid(String userName, String password) {
        
        String name="no have";
        String ret = ERROR;
        Connection conn = null;

        try {
            conn = conn();

            /* TEST CONNECTIONS
            System.out.println("table in sql..");
            Statement stmt = conn.createStatement();
            String strSelect = "select * FROM users";
 
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                String un = rset.getString("userName");
                String pwd= rset.getString("password");
                System.out.println(un + ", " + pwd );
            }*/

            String sql = "SELECT userName FROM users WHERE";
            sql+=" userName = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            System.out.println("query: " + ps);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                name = rs.getString(1);
                ret = SUCCESS;
            }
        } catch (Exception e) {
            ret = ERROR;
            System.out.println("NO SQL CONNECTION");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }

        //System.out.println("AUTHENTICATION name: "+ name + " result:" + ret.equals(SUCCESS));
        return ret.equals(SUCCESS);

        /*
        System.out.println("AUTHENTICATION RESULT: " +  ("admin".equals(userName) && "admin".equals(password)));
        return "admin".equals(userName) && "admin".equals(password);*/
    }
}
