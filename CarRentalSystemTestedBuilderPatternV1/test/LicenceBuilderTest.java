

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;


import main.Licence;
import main.Person;

public class LicenceBuilderTest {

	Person person = new Person("Alex", "Matthews", 02, 07, 1989);

	Licence licenceOne = Licence.Builder()

			.withPerson(person)
			.withDayOfIssueLicence(7)
			.withMonthOfIssueLicence(9)
			.withYearOfIssueLicence(2009)
			.withfullLicence(true)
			.build();
	
	Licence licenceTwo = Licence.Builder()

			.withPerson(person)
			.withDayOfIssueLicence(7)
			.withMonthOfIssueLicence(9)
			.withYearOfIssueLicence(2009)
			.withfullLicence(true)
			.build();

	@Test
	public void test() {
		
		assertEquals(true, licenceOne.getPerson() instanceof Person);

		assertThat("Alex", is(person.getPersonFirstName()));
		assertThat("Matthews", is(person.getPersonSecondName()));

		assertThat('A', is(Licence.returnFirstInitial(person)));
		assertThat('M', is(Licence.returnSecondInitial(person)));

		assertThat("AM-2009-94", is(licenceOne.getLicenceNumber()));
		assertEquals(true, licenceOne.getDateOfIssueLicence() instanceof Date);
		
		assertThat("AM-2009-09", is(Licence.generateUniqueLicenceNumber(9, 'A', 'M', 2009)));
		assertFalse(Licence.isTheYearInTheFutureCheck(2018));

		assertTrue(Licence.isTheYearInTheFutureCheck(2020));
		assertFalse(Licence.isTheYearInTheFutureCheck(2018));

		assertEquals(true, licenceOne instanceof Licence);

		assertTrue(licenceOne.hadLicenceForSpecificNumberOfYears(5));
		assertFalse(licenceOne.hadLicenceForSpecificNumberOfYears(10));

		assertTrue(licenceOne.canIRentACar(21, 5));
		assertTrue(licenceOne.canIRentACar(25, 5));
		assertFalse(licenceOne.canIRentACar(21, 20));
		assertFalse(licenceOne.canIRentACar(25, 20));

		assertTrue(licenceOne.getFullLicence());
		assertFalse(!(licenceOne.getFullLicence()));
		
		assertEquals(licenceOne, licenceOne); // testing equals method
	}

	@Test
	public void testDatedOfLicenceIssue() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(2009, 9 - 1, 7);
		Date expectedDateOfLicence = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String expectedDOL = dateFormat.format(expectedDateOfLicence);
		String dateOfLicence = dateFormat.format(Licence.dateOfLicenceIssue(2009, 9, 7));
		assertEquals(expectedDOL, dateOfLicence);
	}

	@Test
	public void testSetFullLicence() {
		licenceOne.setFullLicence(false);
		assertFalse(licenceOne.getFullLicence());
	}
	
	@Test
	public void SetLicenceNumberTest() {
		assertThat("AM-2009-97", is(licenceTwo.getLicenceNumber()));
		licenceTwo.setLicenceNumber("AM-2009-96");
		assertEquals(licenceOne, licenceTwo);
	}
}