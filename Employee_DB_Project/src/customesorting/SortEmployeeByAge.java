package customesorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByAge implements Comparator<Employee>{

	@Override
	public int compare (Employee e1, Employee e2) {
		Integer x = e1.getAge();//21
		Integer y = e2.getAge();//22
		return x.compareTo(y);
		                      //return e1.getId().compareTo(e2.getId());
	}
}
//e1 -> object to be inserted  and e2 -> already existing object {

	
	
