package tasklistingsystem;
import java.util.Scanner;
public class Tasklistingsystem {
    
        public void addEmpAcc(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Account ID: ");
        int accID = sc.nextInt();
        System.out.print("Employee First Name: ");
        String fname = sc.next();
        System.out.println("Employee Last Name: ");
        String lname = sc.next();
        System.out.print("Employee Email: ");
        String email = sc.next();
        System.out.println("Employee Department");
        String edpt = sc.next();
        System.out.print("Employee Role: ");
        String erole = sc.next();

        String sql = "INSERT INTO employee-acc (acc_id, e_fname, e_lname, e_email, e_department, e_role) VALUES (?, ?, ?, ?, ?, ?)";


        conf.addAcc(sql, fname, lname, email, edpt, erole);


    }
    public static void main(String[] args) {
        Tasklistingsystem tls = new Tasklistingsystem ();
        config conf = new config();
        Scanner sc = new Scanner (System.in);
        
        System.out.println("------Task Listing System----");
        System.out.println("1. Add Employee Acc");
        System.out.println("2. Add Employee Task");
        System.out.println("3. View Employee Task");
        System.out.println("4. View Employee Acc");
        System.out.println("5. Update Empployee Task");
        System.out.println("6. Delete Employee Task");
        System.out.println("7. Exit");
        
        System.out.print("Enter Action: ");
        int act = sc.nextInt();
        
        switch(act){
            case 1:
                tls.addEmpAcc();
            break;
            
            case 2:
                break;
            
            case 3:
                break;
            
            case 4:
                conf.viewEmpAcc();
                break;
        }
    }
}
