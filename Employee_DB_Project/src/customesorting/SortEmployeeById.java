package customesorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeById  implements Comparator<Employee>{

	@Override
	public int compare (Employee e1, Employee e2) {
		String x = e1.getId();//A
		String y = e2.getId();//B
		return x.compareTo(y);//return e1.getId().compareTo(e2.getId());
	}
}
//e1 -> object to be inserted  and e2 -> already existing object