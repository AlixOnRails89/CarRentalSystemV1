
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import main.CarRegistrationNumber;

public class RegistrationBuilderTest {

	CarRegistrationNumber firstRegistrationNumber = CarRegistrationNumber.Builder().build();

	@Test
	public void test() {
		
		assertThat(1000, is(CarRegistrationNumber.getNextNumber()));
		assertFalse(2000 == CarRegistrationNumber.getNextNumber());

		assertThat('c', is(CarRegistrationNumber.getNextLetter()));
		assertFalse('s' == CarRegistrationNumber.getNextLetter());

		assertThat('a', is(CarRegistrationNumber.getMinimumLetter()));
		assertFalse('z' == CarRegistrationNumber.getMinimumLetter());

		assertThat('z', is(CarRegistrationNumber.getLastLetter()));
		assertFalse('q' == CarRegistrationNumber.getLastLetter());

		assertThat("a10000", is(CarRegistrationNumber.getLastregistrationNumber()));
		assertFalse("z9999" == CarRegistrationNumber.getLastregistrationNumber());

		assertThat("b1000", is(firstRegistrationNumber.getRegistrationNumber()));
		assertFalse("c1000" == firstRegistrationNumber.getRegistrationNumber());
		
		assertThat("c1000", is(CarRegistrationNumber.stringOfRegistrationNumber()));
	
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkRegistrationNumberIsNotLastRegistrationNumberTest() {
		CarRegistrationNumber.checkRegistrationNumberIsNotLastRegistrationNumber(CarRegistrationNumber.getLastregistrationNumber());
	}
	
}
