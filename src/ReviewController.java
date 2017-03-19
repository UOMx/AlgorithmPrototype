
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class ReviewController {
    public static ArrayList<Student> getAllSubmittedStudents() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        String sql="Select id,first_name,last_name,rating,get_LastContact(id,1) from students;";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Student> students=new ArrayList<>();
        while(rst.next()){
            Student st=new Student(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4),rst.getString(5));
            students.add(st);
        }
        return students;
    }
    public static ArrayList<Student> getEligibleList(int id) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        String sql="Select s.id,s.first_name,s.last_name,s.rating,get_LastContact(s.id,1) from students s,submissions sub where sub.student_id=s.id and sub.status=1 and s.id!="+id+";";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Student> students=new ArrayList<>();
        while(rst.next()){
            Student st=new Student(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4),rst.getString(5));
            students.add(st);
        }
        return students;
    }
    public static void makeDeadLinePassed() throws SQLException, ClassNotFoundException{
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        String sql="Update submissions set status=1;";
        stm.executeUpdate(sql);
    }
    public static Review getStudentToReview(int studentID,double stRating,int assID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        String sql="call getBestToReview("+studentID+","+stRating+","+assID+");";
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            System.out.println(rst.getString(1)+"");
            System.out.println(rst.getString(2));
            Review r=new Review(rst.getInt(1),rst.getInt(5) , rst.getString(2), rst.getString(3), rst.getDouble(6), rst.getString(4));
            
            return r;
        }
        return null;
    }
    public static void saveReview(int stID,String comment1,String comment2,String comment3,String comment4,int subID) throws SQLException, ClassNotFoundException{
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        String sql="select insertReview("+stID+",'"+comment1+"','"+comment2+"','"+comment3+"','"+comment4+"',"+subID+");";
        stm.executeQuery(sql);
    }
    public static void deletAllReviewed() throws SQLException, ClassNotFoundException{
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        String sql="Delete from Reviews;";
        stm.executeUpdate(sql);
    }
    public static void updateALLTOFirstState() throws SQLException, ClassNotFoundException{
        makeDeadLinePassed();
    }
}
