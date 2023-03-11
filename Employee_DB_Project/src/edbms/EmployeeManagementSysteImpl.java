package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customesorting.SortEmployeeByAge;
import customesorting.SortEmployeeById;
import customesorting.SortEmployeeByName;
import customesorting.SortEmployeeBySalary;
import customexception.EmployeeNotFoundException;


public class EmployeeManagementSysteImpl implements EmployeeManagementSystem{
	Scanner scan=new Scanner(System.in);

	Map<String, Employee> db=new LinkedHashMap<String,Employee>();
	@Override
	public void addEmployee() {
		System.out.println("Enter Employee Age: ");
		int age=scan.nextInt();

		System.out.println("Enter Employee name:");
		String name=scan.next();

		System.out.println("Enter Employee salary:");
		double salary=scan.nextInt();

		Employee emp=new Employee(age, name, salary);
		db.put(emp.getId(), emp);
		System.out.println("Employee Record Inserted Successfully");
		System.out.println("Employee Id is "+emp.getId());

	}
		
	

	@Override
	public void displayEmployee() {
		System.out.println("Enter Employee Id:");
		String id=scan.next();
		id = id.toUpperCase();

		if(db.containsKey(id)) {
			Employee std= db.get(id);
			System.out.println("Id:"+std.getId());
			System.out.println("Age:"+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Salary:"+std.getSalary());
		}
		else {
			try {
				String message = "Student with the Id"+id+" is not Found!";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e){
				System.out.println(e.getMessage());

			}
		}
		
	}

	@Override
	public void displayAllEmployee() {
		if(db.size()!=0) {
			System.out.println("Employee Records are as follows");
			System.out.println("--------------------------------");
			Set<String> keys = db.keySet();//JSP101 JSP102 JSP103
			for(String key : keys) {
				Employee emp= db.get(key);
				System.out.println(emp); // System.Out.println(db.get(Key));
			}
		}
		else {
			try {
				String message ="Student Database is Empty, Nothing to Display";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

		
	}

	@Override
	public void removeEmployee() {
		System.out.println("Enter Employee Id:");
		String id=scan.next();
		id = id.toUpperCase();


		if(db.containsKey(id)) {
			System.out.println("Employee Record Succesfully");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Employee Record Deleted Successfully");
		}
		else
		{
			try {
				String message ="Employee with Id "+id+" is not Found";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}

		}
		
	}

	@Override
	public void removeAllEmployee() {
		if(db.size() !=0) {
			System.out.println("Available Employee Records:"+db.size());
			db.clear();
			System.out.println("All the Employee record deleted Successfully");
		}
		else {
			try {
				String message ="Employee Database is Empty, Nothing to Delete";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void updateEmployeet() {
		System.out.println("Enter Employee Id:");
		String id=scan.next();
		id = id.toUpperCase();

		if(db.containsKey(id)) {
			Employee emp = db.get(id);

			System.out.println("1:Update Age\n2:Update Name\n3:Update salary");
			System.out.println("Enter Choice");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age:");
				int age =scan.nextInt();
				emp.setAge(age); //std.setAge(scan.nextInt());
				System.out.println("Age Updated SuccessFully");
				break;

			case 2:
				System.out.println("Enter Name:");
				String name =scan.next();
				emp.setName(name); //emp.setName(scan.next());
				System.out.println("Name Updated SuccessFully");
				break;

			case 3:
				System.out.println("Enter Marks:");
				int marks =scan.nextInt();
				emp.setSalary(choice); //emp.setMarks(scan.nextInt());
				System.out.println("Salary Updated SuccessFully");
				break;
			default:
				try {
					String message ="Invalid Choice, Enter Valid Choice";
					throw new EmployeeNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
		}
		else {
			try {
				String message ="Invalid Choice, Enter Valid Choice";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}

		}
		
	}

	@Override
	public void countEmployee() {
		System.out.println("Avaliable Employee Records:"+db.size());
		
	}

	@Override
	public void sortEmployee() {
		if(db.size()>=2) {


			Set<String> keys = db.keySet();
			List<Employee> list =new ArrayList<Employee>();
			for(String key : keys) {
				list.add(db.get(keys));
			}

			System.out.println("1:Sort Employee By Id:\n2:Sort Employee By Age");
			System.out.println("3:Sort Employee By Name:\n4:Sort Employee By Marks");
			System.out.println("Enter Choice:");
			int choice = scan.nextInt();

			switch(choice) {
			case 1:
				Collections.sort(list, new SortEmployeeById());
				display(list);

				break;

			case 2:
				Collections.sort(list, new SortEmployeeByAge());
				display(list);
				break;

			case 3:
				Collections.sort(list, new SortEmployeeByName());
				display(list);
				break;

			case 4:
				Collections.sort(list, new SortEmployeeBySalary());
				display(list);
				break;
			default:
				try {
					String message ="Invalid Choice, Enter Valid Choice";
					throw new EmployeeNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
              }
			}
		else{
			try {
				String message ="No Sufficient Student Records to Sort";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void display(List<Employee> list) {
		for(Employee s :list) {
			System.out.println(s);
		}
		
	}

	@Override
	public void getEmployeeWithHigestSalary() {
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Employee> list =new ArrayList<Employee>();
			for(String key : keys) {
				list.add(db.get(keys));
			}
			Collections.sort(list,new SortEmployeeBySalary());
			System.out.println(list.get(db.size()));
		}  else {
			try {
				String message ="No Sufficent Student Records Found to sort";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());

			}
		}
		
	}

	@Override
	public void getEmployeeWithLowestSalary() {
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Employee> list =new ArrayList<Employee>();
			for(String key : keys) {
				list.add(db.get(keys));
			}
			Collections.sort(list,new SortEmployeeBySalary());
			System.out.println(list.get(0));
		}
		else {
			try {
				String message ="No Sufficent Employee Records to Compare";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}

		}
	}
		
	}

	

