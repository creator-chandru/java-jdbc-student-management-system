package StudentManagement;
import java.util.Scanner;
public class Result{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("======= Student Management System =======");
        System.out.println("1. Add Student\n2. View All Students\n3. Find Student by ID\n4. Update Student\n5. Delete Student\n6. Exit");
        
        int choice;
        StudentDAO s1 = new StudentDAO();
        do{
            System.out.println("Enter your choice: ");
            choice = s.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter student id: ");
                    int id = s.nextInt();
                    s.nextLine();
                    System.out.println("Enter student name: ");
                    String name = s.nextLine();
                    System.out.println("Enter student age: ");
                    int age = s.nextInt();
                    s.nextLine();
                    System.out.println("Enter student department: ");
                    String dept = s.nextLine();
                    System.out.println("Enter student cgpa: ");
                    double cgpa = s.nextDouble();
                    s1.addStudent(id,name,age,dept,cgpa);
                    break;
                case 2:
                    s1.viewStudent();
                    break;
                case 3:
                    System.out.println("Enter student id: ");
                    int tId = s.nextInt();
                    s1.findStudent(tId);
                    break;
                case 4:
                    System.out.println("Enter the student id to update details: ");
                    tId = s.nextInt();
                    s1.updateStudent(tId, s);
                    break;
                case 5:
                    System.out.println("Enter student id to be deleted: ");
                    tId = s.nextInt();
                    s1.deleteStud(tId);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }
        }while(choice != 6);
    }
}