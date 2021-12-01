package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Util {
    public static String url = "jdbc:h2:./h2/db";
    public  static String username = "sa";
    public  static String password  = "sa";

    public static void createTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "CREATE TABLE clients(\n" +
                    "id serial PRIMARY KEY,\n" +
                    "first_name varchar(20) NOT NULL,\n" +
                    "last_name varchar(20) NOT NULL\n" +
                    ");";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void dropTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "DROP TABLE clients;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}