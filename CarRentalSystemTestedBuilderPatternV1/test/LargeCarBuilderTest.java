import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


import org.junit.Test;
import main.LargeCar;
import main.Person;

public class LargeCarBuilderTest {
	
	Person person = new Person("Alex", "Matthews", 02,07, 1989);
	
	LargeCar largeCar = LargeCar.Builder()
			.withMaxCapacityFuelTank(60)
			.withCurrentAmountFuelTank(60)
			.withFullFuelTank(true)
			.withCarRented(false)
			.withMinimumAgeToDrive(25)
			.build();
	

	LargeCar largeCar2 = LargeCar.Builder()
			.withMaxCapacityFuelTank(60)
			.withCurrentAmountFuelTank(5)
			.withFullFuelTank(true)
			.withCarRented(false)
			.withMinimumAgeToDrive(25)
			.build();

	@Test
	public void test() {
		
		assertEquals(true, largeCar instanceof LargeCar);
		assertEquals(true, largeCar2 instanceof LargeCar);

		assertEquals(largeCar, largeCar); // testing equals method
		assertThat(largeCar, not(equalTo(largeCar2)));
		//assertThat(92936631, is(largeCar.hashCode()));

		assertThat(60, is(largeCar.getMaximumCapacityFuelTank()));
		assertFalse(0 == largeCar.getMaximumCapacityFuelTank());
		
		assertThat(60, is(largeCar.getCurrentAmountFuelTank()));
		assertFalse(0 == largeCar.getCurrentAmountFuelTank());
		
		assertTrue(largeCar.getIsFuelTankFull());
		assertThat(true, is(largeCar.getIsFuelTankFull()));
		
		assertFalse(largeCar.getIsCarRented());
		assertThat(false, is(largeCar.getIsCarRented()));
		
		assertThat(25, is(largeCar.getMinimumAgeToDrive()));
		assertFalse(21 == largeCar.getMinimumAgeToDrive());
		
		assertThat(25, is(largeCar.getAgeToDriveCar()));
		assertFalse(21 == largeCar.getAgeToDriveCar());
		
		assertThat(5, is(largeCar.getMinimumYearsLicenceHeld()));
		assertFalse(1 == largeCar.getMinimumYearsLicenceHeld());
		
		assertThat("c1000", is(largeCar.returnCarRegistrationNumber()));
		
}
	@Test
	public void largeCarLitresConsumedTest() {
		
		assertThat(5, is(largeCar.litresConsumed10KilometresPerLitre(50)));
		assertThat(10, is(largeCar.litresConsumed10KilometresPerLitre(100)));
		
		assertThat(3, is(largeCar.litresConsumed15KilometresPerLitre(50)));
		assertThat(6, is(largeCar.litresConsumed15KilometresPerLitre(100)));	
		
		assertThat(5, is(largeCar.litresConsumedLargeCar(50)));
		assertThat(8, is(largeCar.litresConsumedLargeCar(100)));
		
		assertThat(13, is(largeCar.fillFuelTankToMaximumCapacity()));
			
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void litresConsumedLargeCarExceptionTest() 
	{
		largeCar2.litresConsumedLargeCar(100);	
	}
	
}
