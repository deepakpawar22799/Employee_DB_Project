package customesorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee>{

	@Override
	public int compare (Employee e1, Employee e2) {
		Double x = e1.getSalary();//2.8 -> Auto boxing
		Double y = e2.getSalary();//2.6
		return x.compareTo(y);// 2.8.compareTo(2.6) -> +1

}
}   //e1 -> object to be inserted  and e2 -> already existing object