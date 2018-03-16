
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import main.Person;

/*
 * Note when testing whether two people are equal based on overriding equals method.
 * Two people can only be equal if the two instances are created too the exact millisecond. Date.getTime() returns 
 */

public class PersonBuilderTest {

	Person personOne = Person.Builder()
			
            .withFirstName("Alex")
            .withSecondName("Matthews")
            .withDayOfDOB(02)
	        .withMonthOfDOB(07)
	        .withYearOfDOB(1989)
	        .build();
	
    Person personTwo = Person.Builder()
			
            .withFirstName("Alex")
            .withSecondName("Matthews")
            .withDayOfDOB(02)
	        .withMonthOfDOB(07)
	        .withYearOfDOB(1989)
	        .build();
    
	@Test
	public void test() {
        
		assertFalse(personOne.isTheDateInTheFutureCheck(02, 07, 1989));
		assertTrue(personOne.isTheDateInTheFutureCheck(02, 07, 2080));
		assertTrue(personOne.isTheDateValid(02, 07, 1989));
		assertFalse(personOne.isTheDateValid(36, 14, 1989));
		assertEquals(true, personOne.getPersonDateOfBirth() instanceof Date);
		assertEquals(true, personOne.getTodayDate() instanceof Date);

        assertTrue(personOne.isPersonAboveTheRequiredAge(21));
        assertFalse(personOne.isPersonAboveTheRequiredAge(30));
		assertThat(personOne.getPersonFirstName(), is("Alex"));
        assertThat(personOne.getPersonSecondName(), is("Matthews"));
		assertThat(745100940, is(personOne.hashCode()));
        assertEquals(personOne, personTwo); // Testing equals                 
}
	@Test
	public void testTodayDate() 
	{
		
       Person personThree = Person.Builder()
				
                .withFirstName("Alex")
                .withSecondName("Matthews")
                .withDayOfDOB(02)
		        .withMonthOfDOB(07)
		        .withYearOfDOB(1989)
		        .build();
       
		GregorianCalendar calendar = new GregorianCalendar();
        Date expectedTodayDate = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String expectedDate = dateFormat.format(expectedTodayDate);
        String returnTodayDate = dateFormat.format(personThree.getTodayDate());
		assertEquals(expectedDate, returnTodayDate);
			
	}
	
	@Test
	public void testDateOfBirth() 
	{
		
       Person personFour = Person.Builder()
				
                .withFirstName("Alex")
                .withSecondName("Matthews")
                .withDayOfDOB(02)
		        .withMonthOfDOB(07)
		        .withYearOfDOB(1989)
		        .build();
       
		GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1989, 07 - 1, 02);
        Date expectedDateOfBirth = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String expectedDOB = dateFormat.format(expectedDateOfBirth);
        String personDateOfBirth = dateFormat.format(personFour.getPersonDateOfBirth());
		assertEquals(expectedDOB, personDateOfBirth);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void PersonFirstNameConstructorExceptionTest() 
	{
		Person personFive = new Person("", "Matthews", 02, 07, 1989);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void PersonSecondNameConstructorExceptionTest() 
	{
		Person personSix = new Person("Alex", "", 02, 07, 1989);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void PersonDayConstructorExceptionTest() 
	{
		Person personSix = new Person("Alex", "Matthews", 0, 07, 1989);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void PersonMonthConstructorExceptionTest() 
	{
		Person personSeven = new Person("Alex", "Matthews", 2, -1, 1989);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void PersonYearConstructorExceptionTest() 
	{
		Person personEight = new Person("Alex", "Matthews", 2, 07, 2020);		
	}
}
	
	
	
	
	

