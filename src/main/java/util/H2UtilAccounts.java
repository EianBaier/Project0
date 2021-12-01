package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2UtilAccounts {
    public static String url = "jdbc:h2:./h2/db";
    public  static String username = "sa";
    public  static String password  = "sa";

    public static void createTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "CREATE TABLE accounts(\n" +
                    "client_id_fk int REFERENCES clients(id) ON DELETE CASCADE,\n" +
                    "account_number serial NOT Null,\n" +
                    "amount_in_account int NOT NULL,\n" +
                    "withdraw int NOT NULL,\n" +
                    "deposit int NOT NULL,\n" +
                    "amount int NOT NULL \n" +
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
            String sql = "DROP TABLE accounts;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
