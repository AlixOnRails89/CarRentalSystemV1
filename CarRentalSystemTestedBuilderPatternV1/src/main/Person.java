package main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author Alex Matthews
 */
public final class Person {

	public static PersonBuilder Builder() {
		return new PersonBuilder();
	}

	private final String firstName;
	private final String secondName;
	private final Date dateOfBirth;

	public Person(String firstName, String secondName, int day, int month, int year) {
		if (firstName.length() == 0)
			throw new IllegalArgumentException("Please insert your First Name");

		if (secondName.length() == 0)
			throw new IllegalArgumentException("Please insert your Last Name");

		if (isTheDateInTheFutureCheck(day, month, year))
			throw new IllegalArgumentException("Please insert a date of birth which is not in the future");

		if (!isTheDateValid(day, month, year))
			throw new IllegalArgumentException("Please insert a valid date of birth");

		this.firstName = firstName;
		this.secondName = secondName;
		dateOfBirth = setDateSpecified(day, month, year);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FirstName: " + firstName);
		sb.append(" SecondName: " + secondName);
		sb.append(" DateOfBirth: " + dateOfBirth);

		return sb.toString();
	}

	public Date getPersonDateOfBirth() {
		return dateOfBirth;
	}

	public String getPersonFirstName() {
		return firstName;
	}

	public String getPersonSecondName() {
		return secondName;
	}

	public boolean isPersonAboveTheRequiredAge(int requiredAge) {
		Calendar today = Calendar.getInstance();
		Calendar birthdayPlus = new GregorianCalendar();
		birthdayPlus.setTime(dateOfBirth);
		birthdayPlus.add(Calendar.YEAR, requiredAge);
		return birthdayPlus.before(today);
	}

	public boolean isTheDateInTheFutureCheck(int day, int month, int year) {

		Boolean returnValue = false;
		Date today = getTodayDate();
		Date dateSpecified = setDateSpecified(day, month, year);

		if (dateSpecified.after(today)) {
			returnValue = true;
		}
		return returnValue;
	}

	public Date getTodayDate() {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date today = c.getTime();
		return today;
	}

	public static Date setDateSpecified(int day, int month, int year) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, day);
		Date dateSpecified = c.getTime();
		return dateSpecified;
	}

	public boolean isTheDateValid(int d, int m, int y) {

		String stringDateOfBirth = d + "/" + m + "/" + y;

		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			format.setLenient(false);
			format.parse(stringDateOfBirth);
		} catch (ParseException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		// Joshua Bloch's HashCode
		int result = 17;
		result = 37 * result + firstName.hashCode();
		result = 37 * result + secondName.hashCode();
		result = 37 * result + dateOfBirth.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o) {
		// Joshua Bloch's Override Equals
		if (this == o)
			return true;
		if (!(o instanceof Person))
			return false;
		Person p = (Person) o;
		return firstName.equals(p.firstName) && secondName.equals(p.secondName)
				&& dateOfBirth.getTime() == (p.dateOfBirth.getTime());

	}
	
	public static void main(String[] args) {
		
		Person person = new Person("Alex", "Matthews", 02,07, 1989);
		System.out.println(person.toString());
			
	}
}
	