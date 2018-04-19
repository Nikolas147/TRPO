package Laba3;

import java.sql.*;

public class DAO {
    private static final String url = "jdbc:mysql://localhost:3306/dreamhome";
    private static final String login = "root";
    private static final String password = "1234";
    private String response = "";
    private static Statement statement;

    public void create(Car car){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(url,login,password);
            statement = connection.createStatement();
            System.out.println("Connection successful");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO car_manager(Mark, Model, Year, Price) VALUE (?, ?, ?, ?)");
            statement.setString(1, car.getMark());
            statement.setString(2, car.getModel());
            statement.setString(3, String.valueOf(car.getYear()));
            statement.setString(4, String.valueOf(car.getPrice()));
            System.out.println(statement.toString());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void read(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(url,login,password);
            statement = connection.createStatement();
            System.out.println("Connection successful");

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM car_manager;");
            while (rs.next()) {
                response = response + "<TR><TD>";
                String ID = rs.getString("ID");
                String Mark = rs.getString("Mark");
                String Model = rs.getString("Model");
                String Year = rs.getString("Year");
                String Price = rs.getString("Price");
                response = response + ID + "</TD><TD>";
                response = response + Mark + "</TD><TD>";
                response = response + Model + "</TD><TD>";
                response = response + Year + "</TD><TD>";
                response = response + Price + "</TD>";
                System.out.println(ID + Mark + Model + Year + " " + Price);
                response = response + "</TR>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String Model, String Price){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(url,login,password);
            statement = connection.createStatement();
            System.out.println("Connection successful");

            PreparedStatement statement = connection.prepareStatement("UPDATE car_manager SET Price = (?) WHERE Model = (?)");
            statement.setString(1, Price);
            statement.setString(2, Model);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Car car){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(url,login,password);
            statement = connection.createStatement();
            System.out.println("Connection successful");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM car_manager where Mark = (?)");
            System.out.println(car.toString());
            statement.setString(1, car.getMark());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getResponse() {
        return response;
    }
}