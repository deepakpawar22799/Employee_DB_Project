package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;


public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Database Project");
		System.out.println("-----------------------------------");

		Scanner scan = new Scanner(System.in);

		EmployeeManagementSystem ems = new EmployeeManagementSysteImpl();

		while(true) {

			System.out.println("n1:Add Employee\n2:Display Employee");
			System.out.println("n3:displayAllEmployee\n4:removeEmployee");
			System.out.println("n5:removeAllEmployee\n6:updateEmployee");
			System.out.println("n7:countEmployee\n8:sortEmployee");
			System.out.println("n9:getEmployeeWithHigestSalary\n10:getEmployeeWithLowestSalary");
			System.out.println("11:Exit");

			int choice = scan.nextInt();

			switch(choice) {
			case 1:ems.addEmployee();
			break;

			case 2:ems.displayEmployee();
			break;

			case 3:ems.displayAllEmployee();
			break;

			case 4:ems.removeEmployee();
			break;

			case 5:ems.removeAllEmployee();
			break;

			case 6:ems.addEmployee();
			break;

			case 7:ems.countEmployee();
			break;

			case 8:ems.sortEmployee();
			break;

			case 9:ems.getEmployeeWithHigestSalary();
			break;

			case 10:ems.getEmployeeWithLowestSalary();
			break;

			case 11:
				System.out.println("Thank You......");
				System.exit(0);
				break;

			default:
				try {
					String message="Invalid Choice, Enter Valid Choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());

				}
			}//end 
			System.out.println("---------------------------");

		}
	}



}


