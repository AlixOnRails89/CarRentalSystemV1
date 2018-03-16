import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import main.CarRegistrationNumber;

 public class RegistrationBuilderVoidMethodTest {
	
	CarRegistrationNumber secondRegistrationNumber = CarRegistrationNumber.Builder()
			.build();

	@Test
	public void nextRegistrationNumberTest() {
		
		assertEquals('b', CarRegistrationNumber.getNextLetter());
		assertEquals(1000, CarRegistrationNumber.getNextNumber());
		CarRegistrationNumber.generateValuesNextRegistrationNumber();
		assertThat('c', is(CarRegistrationNumber.getNextLetter()));	
		assertEquals(1000, CarRegistrationNumber.getNextNumber());
	}
	
	@Test
	public void nextRegistrationNumberAfterTest() {
		
		assertEquals('d', CarRegistrationNumber.getNextLetter());
		assertEquals(1000, CarRegistrationNumber.getNextNumber());
		for(int i = 0; i < 60; i++)
		{
		CarRegistrationNumber.generateValuesNextRegistrationNumber();
		}
		assertThat('l', is(CarRegistrationNumber.getNextLetter()));	
		assertEquals(1002, CarRegistrationNumber.getNextNumber());	
	}
}
