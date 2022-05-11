package repository;

import model.Product;
import util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements ProductRepo{

    private static final String GET_ALL_PRODUCT = "select * from product";
    private static final String INSERT_PRODUCT = "insert into product values (?,?,?,?,?,?,?)";
    private static final String UPDATE_PRODUCT = " update product set name = ?, price = ?, quantity = ?, color = ?, describe = ?, menu =?";

    @Override
    public List<Product> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            statement = connection.createStatement();
            resultSet= statement.executeQuery(GET_ALL_PRODUCT);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getNString("name");
                Double price = Double.parseDouble(resultSet.getString("price"));
                int quantity = Integer.parseInt(resultSet.getString("quantity"));
                String color = resultSet.getString("color");
                String describe = resultSet.getString("describe");
                String menu = resultSet.getString("menu");
                products.add(new Product(id,name,price,quantity,color,describe,menu));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public void create(Product product) {
        Connection connection= null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.getConnection();
            statement = connection.prepareStatement(INSERT_PRODUCT);
            statement.setString(1, product.getId());
            statement.setNString(2, product.getName());
            statement.setDouble(3,product.getPrice());
            statement.setInt(4,product.getQuantity());
            statement.setString(5, product.getColor());
            statement.setString(6, product.getDescribe());
            statement.setString(7, product.getMenu());

            int result = statement.executeUpdate();
            if (result==0){
                System.out.println("Insert fail");
            }else {
                System.out.println("Insert successfully");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public int update(Product product) {
        Connection connection =null;
        try {
            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescribe());
            preparedStatement.setString(6, product.getMenu());


            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
      return 0;
    }

    @Override
    public void remove(String id) {

    }
}
