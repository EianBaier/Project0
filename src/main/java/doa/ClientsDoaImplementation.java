package doa;

import models.Clients;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDoaImplementation implements ClientsDoa {

    //public static List<Clients> getAllClients;
    String url;
    String username ;
    String password ;

    Logger logger = Logger.getLogger(ClientsDoaImplementation.class);

    public ClientsDoaImplementation(){
        this.url = "jdbc:postgresql://"+ System.getenv("AWS_RDS_ENDPOINT")+ "/project0";
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public ClientsDoaImplementation(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }


    @Override
    public void createClient() {

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "INSERT INTO clients VALUES (DEFAULT,'New', 'Client');";
            PreparedStatement ps = conn.prepareStatement(sql);

           // ps.setString(1, firstName);
           // ps.setString(2, lastName);

            //execute the sql statement and return the result set
            ps.executeUpdate();




            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }

    }





    @Override
    public List<Clients> getAllClients() {
        List<Clients> clients = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "SELECT * FROM clients ORDER BY id;";
            PreparedStatement ps = conn.prepareStatement(sql);

            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();


            //itterate through the result set
            while(rs.next()){

                clients.add(new Clients(rs.getInt(1),rs.getString(2), rs.getString(3)));

            }

            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }
        return clients;
    }

    @Override
    public Clients getOneClient(Integer ClientId) {

        Clients client = null;

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "SELECT * FROM clients WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ClientId);

            //execute the sql statement and return the result set
            ResultSet rs = ps.executeQuery();


            //itterate through the result set
            while(rs.next()){

                client = new Clients(rs.getInt(1),rs.getString(2), rs.getString(3));

            }

            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }
        return client;

    }


    @Override
    public void updateClient(Integer clientId) {

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "UPDATE clients SET first_name = 'Updated', last_name = 'Name' WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientId);



            //execute the sql statement and return the result set
            ps.executeUpdate();




            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }




    }

    @Override
    public void deleteClient(Integer clientId) {

        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //generate out connection
            // Connection conn = DriverManager.getConnection(url, username, password);

            // sql that we will be executing
            String sql = "DELETE FROM clients WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientId);



            //execute the sql statement and return the result set
            ps.executeUpdate();




            //  conn.close(); putting the Conection in the try is called try with resouces and automatically closes it

        }catch (SQLException e){
            logger.error(e);
        }




    }

    }




