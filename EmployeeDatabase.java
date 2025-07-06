import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDatabase {
	private static Scanner sc=new Scanner(System.in);
	private static Connection con=null;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public static Connection connection() {
		try {
		 String url="jdbc:mysql://localhost:3306/crudopp"; 
		 String usrname="root";
		 String password="1234";
		 con =DriverManager.getConnection(url,usrname,password);
		 return con;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	public static void read(Connection con) {
		try{
		String readQuery="Select * from employeeDatabase;";
		st=con.createStatement();
		rs=st.executeQuery(readQuery);
		
		if(!rs.isBeforeFirst()){
					System.out.println("-----No data available-----");
		}
		else {
			System.out.printf("%-5s %-10s %-5s %-20s %-10s %-15s\n", 
				    "ID", "Name", "Age", "Job.Desc", "Salary", "Branch");

				while (rs.next()) {
				    System.out.printf("%-5d %-10s %-5d %-20s %-10d %-15s\n",
				        rs.getInt(1), rs.getString(2), rs.getInt(3),
				        rs.getString(4), rs.getInt(5), rs.getString(6));
				}
			}
		con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void create(Connection con) {
		
		try {
		
		System.out.print("Enter Employee Name : ");
		String eName=sc.nextLine();
		if(eName==null||eName.equals("")||eName.equals(" ")) {
			System.out.println("Enter correct name!");
			return;
		}
		
		System.out.print("Enter Employee Age : ");
		int eAge=sc.nextInt();
		sc.nextLine();
		if(eAge<18 || eAge>60) {
			System.out.println("Please check the age!");
			return;
		}
		
		System.out.print("Enter Employee Job description : ");
		String eJobDesc=sc.nextLine();
		
		System.out.print("Enter Employee Salary : ");
		int eSalary=sc.nextInt();
		sc.nextLine();
		if(eSalary<=100000) {
			System.out.println("please check the salary(above 1,00,000)!");
			return;
		}
		
		System.out.print("Enter Employee Branch Name : ");
		String eBranch=sc.nextLine();
		if(eBranch==null||eBranch.equals("")) {
			System.out.println("Enter correct branch name");
			return;
		}
		
		String creatQuery="Insert into employeeDatabase (eName,eAge,job_desc,salary,branch)values (?,?,?,?,?);";
		pst=con.prepareStatement(creatQuery);
		pst.setString(1,eName);
		pst.setInt(2,eAge);
		pst.setString(3,eJobDesc);
		pst.setInt(4,eSalary);
		pst.setString(5,eBranch);
		
		int row=pst.executeUpdate();
		System.out.println("Employee Data Created...!");
		con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void update(Connection c) {
		try {
		System.out.print("Enter Employee Id for update:");
		int eId=sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Employee Name : ");
		String eName=sc.nextLine();
		if(eName==null||eName.equals("")||eName.equals(" ")) {
			System.out.println("Enter correct name!");
			return;
		}
		
		System.out.print("Enter Employee Age : ");
		int eAge=sc.nextInt();
		sc.nextLine();
		if(eAge<18 || eAge>60) {
			System.out.println("Please check the age!");
			return;
		}
		
		System.out.print("Enter Employee Job description : ");
		String eJobDesc=sc.nextLine();
		
		System.out.print("Enter Employee Salary : ");
		int eSalary=sc.nextInt();
		sc.nextLine();
		if(eSalary<=100000) {
			System.out.println("please check the salary(above 1,00,000)!");
			return;
		}
		
		System.out.print("Enter Employee Branch Name : ");
		String eBranch=sc.nextLine();
		if(eBranch==null||eBranch.equals("")) {
			System.out.println("Enter correct branch name");
			return;
		}
		
		String updateQuery="update employeeDatabase set eName=?,eAge=?,job_desc=?,salary=?,branch=? where eId=?;";
		pst=con.prepareStatement(updateQuery);
		pst.setString(1,eName);
		pst.setInt(2,eAge);
		pst.setString(3,eJobDesc);
		pst.setInt(4,eSalary);
		pst.setString(5,eBranch);
		pst.setInt(6,eId);
		
		int row=pst.executeUpdate();
		if(row>0) {
			
			System.out.println("Employee Data updated...!");
		}
		else {
			System.out.println("No Employee found in the E.Id : "+ eId);
		}
		con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete(Connection con) {
		try {
		System.out.print("Enter Employee Id for Delete :");
		int eId=sc.nextInt();
		System.out.println("Are sure to Delete ?");
		System.out.println("1.Yes");
		System.out.println("2.No");
		int dltchoice=sc.nextInt();
		switch(dltchoice) {
		case 1:
			String deleteQuery="Delete from employeeDatabase where eId=?;";
			pst=con.prepareStatement(deleteQuery);
			pst.setInt(1,eId);
			int row=pst.executeUpdate();
			System.out.println("Record with the E.Id "+eId+" Deleted..!");
			break;
		case 2:
			System.out.println("Record not Deleted");
			break;
		}
		con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		
		System.out.println("\n-*-*- Welcome to Employee Database -*-*-");
		boolean keepRun=true;
		while(keepRun) {
		System.out.println("\n1.View Employee Data");
		System.out.println("2.Add Employee Data");
		System.out.println("3.Update Employee Data");
		System.out.println("4.Delete Employee Data");
		System.out.println("5.Exit");
		
		int choice=sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			read(connection());
			break;
		case 2:
			create(connection());
			break;
		case 3:
			update(connection());
			break;
		case 4:
			delete(connection());
			break;
		case 5:
			System.out.println("Do you want to Exit:");
			System.out.println("1.yes");
			System.out.println("2.No");
			int exit=sc.nextInt();
			if(exit==1) {
			System.out.println("Exiting from app........");
			keepRun=false;}
			else {
			keepRun=true;
				}
			break;
		}
		}

	}

}
