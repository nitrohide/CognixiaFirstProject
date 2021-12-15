
public class Employee {

	public static Integer idCounter = 1;

	private int id;
	private String firstName;
	private String lastName;
	private String DOE;
	private int salary;
	private String department;

	public Employee(String firstName,String lastName, String DOE, int salary, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.DOE = DOE;
		this.salary = salary;
		this.department = department;
		this.id = idCounter++;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDOE() {
		return DOE;
	}

	public void setDOE(String DOE) {
		this.DOE = DOE;
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String toString() {
		return "Employee [id=" + id + ", name=" + firstName + " " + lastName + ", Employed=" + DOE + ", salary=" + salary + ", department=" + department + "]";
	}
	
}
