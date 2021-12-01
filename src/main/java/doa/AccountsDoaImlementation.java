package doa;

import models.Accounts;
import models.Clients;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsDoaImlementation implements AccountsDoa{
    String url;
    String username ;
    String password ;

    Logger logger = Logger.getLogger(ClientsDoaImplementation.class);

    public AccountsDoaImlementation(){
        this.url = "jdbc:postgresql://"+ System.getenv("AWS_RDS_ENDPOINT")+ "/project0";
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public AccountsDoaImlementation(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void createAccount(Integer clientIdFk) {

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "INSERT INTO accounts VALUES (?, DEFAULT, 1000, 0, 0, 0)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientIdFk);


            //execute the sql statement and return the result set
            ps.executeUpdate();




            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }

    }

    @Override
    public List<Accounts> getAllAccounts(Integer clientIdFk) {
        List<Accounts> accounts = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "SELECT * FROM accounts a WHERE client_id_fk = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientIdFk);

            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();


            //itterate through the result set
            while(rs.next()){

                accounts.add(new Accounts(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getInt(5), rs.getInt(6)));

            }

            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }
        return accounts;
    }



    @Override
    public List<Accounts> getAllAccountsGreaterOrLessThanForACustomer(Integer clientIdFk, Integer lowerValue, Integer upperValue) {
        List<Accounts> accounts = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "SELECT * FROM accounts a WHERE client_id_fk = ? AND amount_in_account BETWEEN ? AND ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientIdFk);
            ps.setInt(3,lowerValue);
            ps.setInt(2, upperValue);


            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();


            //itterate through the result set
            while(rs.next()){

                accounts.add(new Accounts(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getInt(5), rs.getInt(6)));

            }

            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }
        return accounts;
    }

    @Override
    public List<Accounts> getASpecificAccount(Integer clientIdFk, Integer accountNumber) {
        List<Accounts> accounts = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "SELECT * FROM accounts a WHERE client_id_fk = ? AND account_number = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientIdFk);
            ps.setInt(2,accountNumber);

            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();


            //itterate through the result set
            while(rs.next()){

                accounts.add(new Accounts(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getInt(5), rs.getInt(6)));

            }

            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }
        return accounts;
    }

    @Override
    public void updateAccount(Integer clientIdFk, Integer accountNumber) {

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "UPDATE accounts SET amount_in_account = 999 WHERE client_id_fk = ? AND account_number = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientIdFk);
            ps.setInt(2,accountNumber);

            //execute the sql statement and return the result set
            ps.executeUpdate();




            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }


    }

    @Override
    public void deleteAccount(Integer clientIdFk, Integer accountNumber) {

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "DELETE FROM accounts WHERE client_id_fk = ? AND account_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientIdFk);
            ps.setInt(2,accountNumber);

            //execute the sql statement and return the result set
            ps.executeUpdate();




            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void withdrawOrDeposit(Integer clientIdFk, Integer accountNumber, Accounts account)  {

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "UPDATE accounts SET amount_in_account = amount_in_account+? WHERE client_id_fk = ? AND account_number = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,account.getDeposit());
            ps.setInt(2, clientIdFk);
            ps.setInt(3,accountNumber);

            //execute the sql statement and return the result set
            ps.executeUpdate();




            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void transfer(Integer clientIdFk, Integer accountNumber1, Integer accountNumber2, Accounts account) {

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "UPDATE accounts SET amount_in_account = amount_in_account + ? WHERE client_id_fk = ? AND account_number = ?;\n" +
                    "\n" +
                    "UPDATE accounts SET amount_in_account = amount_in_account - ? WHERE client_id_fk = ? AND account_number = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,account.getAmount());
            ps.setInt(2, clientIdFk);
            ps.setInt(3, accountNumber1);
            ps.setInt(4,account.getAmount());
            ps.setInt(5, clientIdFk);
            ps.setInt(6, accountNumber2);


            //execute the sql statement and return the result set
            ps.executeUpdate();




            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }

    }
}
