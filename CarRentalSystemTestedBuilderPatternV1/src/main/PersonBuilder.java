package main;

public class PersonBuilder {
	
	private String firstName;
	private String secondName;
	
	private int day;
	private int month;
	private int year;
	
	
	public PersonBuilder()
	{
		
	}
	
	public PersonBuilder withFirstName(String newFirstName)
	{
		this.firstName = newFirstName;
		return this;
	}
	
	public PersonBuilder withSecondName(String newSecondName)
	{
		this.secondName = newSecondName;
		return this;
	}
	
	public PersonBuilder withDayOfDOB(int dayBorn)
	{
		this.day = dayBorn;
		return this;
	}
	
	public PersonBuilder withMonthOfDOB(int monthBorn)
	{
		this.month = monthBorn;
		return this;
	}
	
	public PersonBuilder withYearOfDOB(int yearBorn)
	{
		this.year = yearBorn;
		return this;
	}
	
	public Person build() 
	{
	        return new Person(firstName, secondName, day, month, year);
	}
	
	public static void main(String[] args) {
		
          Person personOne = Person.Builder()
				
                .withFirstName("Alex")
                .withSecondName("Matthews")
                .withDayOfDOB(02)
		        .withMonthOfDOB(07)
		        .withYearOfDOB(1989)
		        .build();
          
          System.out.println(personOne.toString());
          
          }
}
