package main;

import java.util.Date; 
import java.util.Calendar; 
import java.util.GregorianCalendar; 
import java.util.HashMap; 
 
public class Licence { 
	
	public static LicenceBuilder Builder() {
		return new LicenceBuilder();
	}
	
  private Person person; 
  private Date dateOfIssueLicence; 
  private String licenceNumber;  
  private Boolean fullLicence; 
 
  private static HashMap<String, Licence> licences = new HashMap<String, Licence>(); 
 
  private Licence(Person person, Date dateOfIssueLicence, String licenceNumber, boolean fullLicence ) { 
    this.person = person; 
    this.dateOfIssueLicence = dateOfIssueLicence; 
    this.licenceNumber = licenceNumber; 
    this.fullLicence = fullLicence; 
  } 
 
  public static Licence getInstance(Person person, int date, int month, int year, boolean fullLicence)  
 
  { 
    char firstInitial, secondInitial; 
    firstInitial = returnFirstInitial(person);
    secondInitial = returnSecondInitial(person);
   
    Date dateOfIssueLicence = dateOfLicenceIssue(year, month, date); 
 
    String uniqueLicenceNumber; 
    int uniqueNumber = 90; 
 
    do { 
    	uniqueLicenceNumber = generateUniqueLicenceNumber(uniqueNumber, firstInitial, secondInitial, year);
    uniqueNumber++;
    } while(licences.containsKey(uniqueLicenceNumber) && (uniqueNumber <= 99)); 
 
    return generateLicence(person, dateOfIssueLicence,uniqueLicenceNumber, fullLicence);
  } 
  
  public static Date dateOfLicenceIssue(int year, int month, int date) 
  {
	    Calendar dateOfIssue = new GregorianCalendar(); 
	    dateOfIssue.set(year, month - 1, date); 
	    Date dateOfIssueLicence = dateOfIssue.getTime(); 
		return dateOfIssueLicence;
  }
  
  public static String generateUniqueLicenceNumber(int uniqueNumber, char firstInitial, char secondInitial, int year)
  {
	  if(isTheYearInTheFutureCheck(year))
	  throw new IllegalArgumentException("Enter a year that is not in the future");
	  
      StringBuilder sb = new StringBuilder(); 
      sb.append(firstInitial); 
      sb.append(secondInitial); 
      sb.append("-"); 
      sb.append(year); 
      sb.append("-"); 
      if(uniqueNumber < 10)sb.append(0); 
      sb.append(uniqueNumber); 
      return sb.toString();
  }
  
  public static boolean isTheYearInTheFutureCheck(int year) 
  {
		Boolean returnValue = false;
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		 
		if (c.getWeekYear() > today.getWeekYear())
		{
			returnValue = true;
		}
		return returnValue;
  }
 
  public static Licence generateLicence(Person person, Date dateOfIssueLicence, String uniqueLicenceNumber, boolean fullLicence)
  {
  Licence newLicence = new Licence(person, dateOfIssueLicence, uniqueLicenceNumber, fullLicence); 
  licences.put(uniqueLicenceNumber, newLicence); 
  return newLicence; 
  }
  
  public boolean hadLicenceForSpecificNumberOfYears(int years) 
  { 
    Calendar today = Calendar.getInstance(); 
    Calendar birthdayPlus = new GregorianCalendar(); 
 
    birthdayPlus.setTime(dateOfIssueLicence); 
    birthdayPlus.add(Calendar.YEAR, years); 
 
    return birthdayPlus.before(today); 
  } 
 
  public boolean canIRentACar(int minimumAge, int licenceNumberOfYearsRequiredToRentCar) 
  { 
    boolean value = false; 
    { 
      if (person.isPersonAboveTheRequiredAge(minimumAge) && 
          hadLicenceForSpecificNumberOfYears(licenceNumberOfYearsRequiredToRentCar) && 
          fullLicence) 
      { 
        value = true; 
      } 
      return value; 
    } 
  } 
  
  public static char returnFirstInitial(Person personNameInitial)
  {
	    String firstName = personNameInitial.getPersonFirstName();
	    return firstName.charAt(0); 
  }
  
  public static char returnSecondInitial(Person personNameInitial)
  {
	    String secondName = personNameInitial.getPersonSecondName();
	    return secondName.charAt(0); 
  }
 
  public Person getPerson() { 
    return person; 
  } 
 
  public Date getDateOfIssueLicence() { 
    return dateOfIssueLicence; 
  } 
 
  public String getLicenceNumber() { 
    return licenceNumber; 
  } 
 
  public Boolean getFullLicence() { 
    return fullLicence; 
  } 
 
  public void setFullLicence(Boolean fullLicence) { 
    this.fullLicence = fullLicence; 
  } 
  
  public void setLicenceNumber(String licenceNumber) { 
	    this.licenceNumber = licenceNumber; 
	  }
 
  @Override
	public boolean equals(Object o) {
		// Joshua Bloch's Override Equals
		if (this == o)
			return true;
		if (!(o instanceof Licence))
			return false;
		Licence p = (Licence) o;
		return licenceNumber.equals(p.licenceNumber);
	}
	
	@Override
	public int hashCode() {
		// Joshua Bloch's HashCode
		int result = 17;
		result = 37 * result + licenceNumber.hashCode();
		return result;
	}
 
  @Override 
  public String toString() { 
    return "Licence [person=" + person + ", dateOfIssueLicence=" + dateOfIssueLicence + ", licenceNumber=" 
        + licenceNumber + ", fullLicence=" + fullLicence + "]"; 
  } 
 
  public static void main(String[] args) { 
	  
    Person person1 = new Person("Alex", "Matthews", 2, Calendar.JULY, 1989); 
    Licence person1Licence = Licence.getInstance(person1, 5, Calendar.JUNE, 2015, true);
    System.out.println(person1Licence); 
    
    System.out.println(person1Licence.hadLicenceForSpecificNumberOfYears(3));
    System.out.println(person1Licence.canIRentACar(21, 3));
  } 
}

 