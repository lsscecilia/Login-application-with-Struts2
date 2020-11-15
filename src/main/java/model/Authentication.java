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

    private static Connection conn() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/UserPasswordTable?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "cecilia", "xxxx");
    }

    public static boolean isLoginValid(String userName, String password) {
        String name="";
        String ret = ERROR;

        try (Connection conn = conn()) {
            String sql = "SELECT userName FROM users WHERE";
            sql += " userName = ? AND password = ?";
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
        }
        return ret.equals(SUCCESS);
    }
}
