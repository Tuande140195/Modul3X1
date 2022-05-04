package repository;

import bean.Student;
import sun.rmi.runtime.NewThreadAction;
import util.DBConnect;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {


    private static final String GET_ALL_STUDENT = "Select * from student";
    private static final String INSERT_STUDENT = "Insert into student values (?, ?, ?, ?)";

    @Override
    public void create(Student student) {
           Connection connection = null;
           PreparedStatement statement = null;
        try {
            connection = DBConnect.getConnection();
            statement = connection.prepareStatement(INSERT_STUDENT);
            statement.setString(1, student.getId());
            statement.setNString(2, student.getName());
            statement.setDate(3,new java.sql.Date(student.getBirthDay().getTime()));
            statement.setBoolean(4, student.isSex());

            int result = statement.executeUpdate();
            if (result == 0){
                System.out.println("Insert DB fail");
            }else {
                System.out.println(" Insert DB successfully");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Student> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet= null;
        List<Student> students = new ArrayList<>();

        try {
            connection = DBConnect.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_STUDENT);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getNString("name");
                Date birthday = new Date(resultSet.getDate("birthday").getTime());
                boolean sex = resultSet.getBoolean("sex");
                students.add(new Student(id,name, birthday,sex));

              }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return students;
    }

    @Override
    public Student findById(String id) {
        return null;
    }
}
