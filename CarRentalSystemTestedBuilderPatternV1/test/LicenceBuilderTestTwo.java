import org.junit.Test;
import main.Licence;
import main.Person;

public class LicenceBuilderTestTwo {
	
	Person person = new Person("Alex", "Matthews", 02, 07, 1989);
	
	Licence LicenceTwo = Licence.Builder()
			
            .withPerson(person)
            .withDayOfIssueLicence(7)
	        .withMonthOfIssueLicence(9)
	        .withYearOfIssueLicence(2009)
	        .withfullLicence(true)
	        .build();
	
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateUniqueLicenceNumberExceptionTest() 
	{
		Licence.generateUniqueLicenceNumber(9, Licence.returnFirstInitial(person), Licence.returnSecondInitial(person), 2020);	
	}

}
	


