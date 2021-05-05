package com.ojas;
import java.util.Scanner;
class Messages {

	public static final String COUNTRYINVALID = "The employee should be an Indian citizen for calculating tax";
	public static final String NAMEINVALID = "The employee name cannot be null or empty";
	public static final String TAXNOTELIGIBLE = "The employee does not need to pay tax";
	public static final String SUCCESS = "Successfully calculated Tax";

}
class CountryNotValidException extends Exception {

	public CountryNotValidException(String s)
	{
		System.out.println(s);
	}
}
class NameNotValidException extends Exception {
	public NameNotValidException(String s)
	{
		System.out.println(s);
	}
}

class NotEligibleForTaxException extends Exception 
{

	public NotEligibleForTaxException(String s) 
	{
		System.out.println(s);
	}
}


class Employee {

	private String employeeName;
	private String nationality;
	private double salary;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee() {
	}
	public Employee(String employeeName, String nationality, double salary) {
		this.employeeName = employeeName;
		this.nationality = nationality;
		this.salary = salary;
	}

}
class Tester {
	public static void main(String args[]) throws CountryNotValidException, NotEligibleForTaxException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name,nationality and salary ?");
		Employee e = new Employee(sc.next(), sc.next(), sc.nextDouble());
		TaxSimulator tx = new TaxSimulator();
		try	{
			System.out.println(tx.findTaxOutput(e));
		}
		catch(NameNotValidException ec)	{
			System.out.println(ec);
		}
		catch(NotEligibleForTaxException s)	{
			System.out.println(s);
		}
	}
}

class TaxCalculator {
	
	public TaxCalculator() {
	}

	
	public double calculateTax(Employee emp) throws NameNotValidException,CountryNotValidException,NotEligibleForTaxException
	{
		double d = 0;
	
		try
		{
			if(emp.getNationality().equalsIgnoreCase("indian") == true ) 
			{
				if(emp.getEmployeeName().isEmpty() == true || emp.getEmployeeName() == null )
				{
					new NameNotValidException(Messages.NAMEINVALID);
				
						
				}
				else
				{
					if(emp.getSalary() > 100000)
					{
						d = emp.getSalary() * 8/100;
					}
					else if(emp.getSalary() > 50000 && emp.getSalary() < 100000)
					{
						d = emp.getSalary() * 6/100;
						
					}
					else if(emp.getSalary() > 30000 && emp.getSalary() < 50000)
					{
						d = emp.getSalary()* 5/100;
						
					}
					else if(emp.getSalary() > 10000 && emp.getSalary() < 30000)
					{
						d = emp.getSalary()*4/100;
						
					}
					else if(emp.getSalary() < 10000)
					{
						new NotEligibleForTaxException(Messages.TAXNOTELIGIBLE);
					}
				}
			}
			else
			{
				new CountryNotValidException(Messages.COUNTRYINVALID);
			}
		}
		catch(Exception c)
		{
			System.out.println(c);
		}
		
		return d;
	}
}
class TaxSimulator extends TaxCalculator {
	
	public TaxSimulator() {
	}
	
	public String findTaxOutput(Employee emp) throws NameNotValidException, NotEligibleForTaxException	{
	
		double d;
		String s = " ";
		try	{
			d = calculateTax(emp);
			//System.out.println(d);
			s = s+ d;
		}
		catch(CountryNotValidException e){
			System.out.println(e);
		}
		catch(NameNotValidException ec)	{
			System.out.println(ec);
		}
		return s;
	}

}


