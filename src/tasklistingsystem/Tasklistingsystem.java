package tasklistingsystem;
import java.util.Scanner;
public class Tasklistingsystem {
   
    public void addEmpAcc(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Acount ID: ");
        int accID = sc.nextInt();
        System.out.print("Employee First Name: ");
        String fname = sc.next();
        System.out.print("Employee Last Name: ");
        String lname = sc.next();
        System.out.print("Employee Email: ");
        String email = sc.next();
        System.out.print("Employee Department: ");
        String edpt = sc.next();
        System.out.print("Employee Role: ");
        String erole = sc.next();

        String sql = "INSERT INTO employee_acc (acc_id, e_fname, e_lname, e_email, e_department, e_role) VALUES (?, ?, ?, ?, ?, ?)";

        conf.addRecord(sql, accID, fname, lname, email, edpt, erole);
    }
    
     public void updateEmpTask(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter Account ID to Update: ");
         int id = sc.nextInt();
         
         System.out.print("Enter new Department: ");
         String edpt = sc.next();
         System.out.print("Enter new Role: ");
         String erole = sc.next();
         
        String sql = "UPDATE employee_acc SET e_department = ?, e_role = ? WHERE acc_id = ?";
        
        config conf = new config();
        conf.updateRecord(sql, edpt, erole, id);
    }
     
    public void deleteEmpTask(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter Account ID to Delete: ");
         int id = sc.nextInt();
         
         String sql = "DELETE FROM employee_acc WHERE acc_id = ?";
        
        config conf = new config();
        conf.updateRecord(sql, id);
    }
     
    public static void main(String[] args) {
        Tasklistingsystem tls = new Tasklistingsystem();
        config conf = new config();
        Scanner sc = new Scanner (System.in);
        int chose;
do{ 
        System.out.println("------Welcome To Task Listing System----");
        System.out.println("1. Add Employee Acc");
        System.out.println("2. View Employee Account");
        System.out.println("3. Update Empployee Account");
        System.out.println("4. Delete Employee Task");
        System.out.println("5. Exit");
        System.out.print("Enter Action: ");
        int act = sc.nextInt();
       
        switch(act){
            case 1:
                tls.addEmpAcc();
            break;

            case 2:
                System.out.println("\nList of Employee's Account");
                conf.viewEmpAcc();
                break;

            case 3:
                System.out.println("\nList of Employee's Account");
                conf.viewEmpAcc();
                tls.updateEmpTask();
                break;

            case 4:
                System.out.println("\nList of Employee's Account");
                conf.viewEmpAcc();
                tls.deleteEmpTask();
                break;

            case 5:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Action Error!");
        }
        System.out.print("Enter Again: ");
        chose = sc.nextInt();
        
}while(chose != 0);
        System.out.println("Thank You!");
    }

}
