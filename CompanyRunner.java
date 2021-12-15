import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyRunner {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Management System, commands are inputted in 'Flag,firstName,lastName,Date(MM/DD/YYYY),salary,department' format \nvalid flags a, ud, rm, l, and q.");
		Scanner scanner = new Scanner(System.in);
		String input;
		HashMap<Integer, Employee> employeeMap = new HashMap<>();
		boolean running=true;
		while(running) {
			input = scanner.nextLine();
			String[] inputSplit = input.split(",");
			for (int i=0;i<inputSplit.length;i++) {
				inputSplit[i] = inputSplit[i].trim();
			}
			try {
				switch (inputSplit[0].toLowerCase()) {
					case "a":
						validateDate(inputSplit[3]);                                                 //custom exception
						Employee employee = new Employee(inputSplit[1],inputSplit[2],inputSplit[3], Integer.parseInt(inputSplit[4]), inputSplit[5]);
						employeeMap.put(Employee.idCounter - 1, employee);
						System.out.println("employee added");
						break;
					case "l":
						if (employeeMap.isEmpty()) {
							System.out.println("Database currently Empty");
						}else {
						System.out.println("Current Employee Database: ");
						
							employeeMap.values().stream()                                             //streams
												.forEach(System.out::println);
//							for (Employee e: employeeMap.values()) {
//								System.out.println(e);
//							}
						}
						break;
						
					case "ud":
						Employee updatingEmployee = employeeMap.get(Integer.parseInt(inputSplit[1]));
						updatingEmployee.setFirstName(inputSplit[2]);
						updatingEmployee.setLastName(inputSplit[3]);
						updatingEmployee.setDOE(inputSplit[4]);
						updatingEmployee.setSalary(Integer.parseInt(inputSplit[5]));
						updatingEmployee.setDepartment(inputSplit[6]);
						System.out.println("Employee successfully updated: " + updatingEmployee);
						break;
						
					case "rm":
						Employee removingEmployee = employeeMap.get(Integer.parseInt(inputSplit[1]));
						System.out.println("Removing" + removingEmployee);
						employeeMap.remove(Integer.parseInt(inputSplit[1]));
						break;
						
					case"q":
						running=false;
						System.out.println("System Closed, Final database: \n");
						for (Employee e: employeeMap.values())
						System.out.println(e);
						break;
						
					default:
						System.out.println("not a valid command");
				}
				
			}catch(InvalidInputException e) {
				System.out.println(e.getMessage());
			}
			
		}
		scanner.close();
	}
	//custom exception handler
	public static void validateDate(String date) throws InvalidInputException{
		String regex = "^([0]?[1-9]|[1][0-2])[/]([0]?[1-9]|[1|2][0-9]|[3][0|1])[/]([0-9]{4}|[0-9]{2})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		if (!matcher.matches()) {
			throw new InvalidInputException();
		}
	}
}
