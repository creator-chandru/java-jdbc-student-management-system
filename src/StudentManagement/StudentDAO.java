package StudentManagement;
import java.sql.*;
import java.util.Scanner;
public class StudentDAO {
    String query;
    Connection con;
    public void addStudent(int id, String name, int age, String dept, double cgpa){
        query = "INSERT INTO student VALUES (?,?,?,?,?);";
        con = DBConnection.returnCon();
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1,id);
            st.setString(2,name);
            st.setInt(3,age);
            st.setString(4,dept);
            st.setDouble(5,cgpa);
            int count = st.executeUpdate();
            System.out.println(count + "row(s) affected");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }  
    public void viewStudent(){
        con = DBConnection.returnCon();
        query = "SELECT * FROM student;";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String dept = rs.getString(4);
                double cgpa = rs.getDouble(5);
                System.out.println(id + " | " + name + " | " + age + " | " + dept + " | " + cgpa);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void findStudent(int tId){
        con = DBConnection.returnCon();
        query = "SELECT * FROM student WHERE id =" + tId +";";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String dept = rs.getString(4);
            double cgpa = rs.getDouble(5);
            System.out.println(id + " | " + name + " | " + age + " | " + dept + " | " + cgpa);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateStudent(int tId, Scanner s){
        con = DBConnection.returnCon();
        query = "UPDATE student SET name = ?, age = ?, department = ?, cgpa = ? WHERE id = ?";
        System.out.println("Enter updated student name: ");
        String name = s.nextLine();
        System.out.println("Enter updated student age: ");
        int age = s.nextInt();
        s.nextLine();
        System.out.println("Enter updated student department: ");
        String dept = s.nextLine();
        System.out.println("Enter updated student cgpa: ");
        double cgpa = s.nextDouble();
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(5,tId);
            st.setString(1,name);
            st.setInt(2,age);
            st.setString(3,dept);
            st.setDouble(4,cgpa);
            int count = st.executeUpdate();
            System.out.println(count + "row(s) affected");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void deleteStud(int tId){
        con = DBConnection.returnCon();
        query = "DELETE FROM student WHERE id=" + tId + ";";
        try{
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);
            System.out.println(count + "row(s) affected");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
