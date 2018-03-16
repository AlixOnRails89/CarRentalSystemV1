import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import main.SmallCar;

public class SmallCarBuilderTest {
	
	SmallCar smallCar = SmallCar.Builder()
			.withMaxCapacityFuelTank(50)
			.withCurrentAmountFuelTank(50)
			.withFullFuelTank(true)
			.withCarRented(false)
			.withMinimumAgeToDrive(21)
			.build();
	
	SmallCar smallCar2 = SmallCar.Builder()
			.withMaxCapacityFuelTank(50)
			.withCurrentAmountFuelTank(5)
			.withFullFuelTank(true)
			.withCarRented(false)
			.withMinimumAgeToDrive(21)
			.build();
	@Test
	public void test() {
		
		assertEquals(true, smallCar instanceof SmallCar);
		assertEquals(true, smallCar2 instanceof SmallCar);
		
		assertThat("e1000", is(smallCar.returnCarRegistrationNumber()));
		assertFalse("z1000" == smallCar.returnCarRegistrationNumber());
		
		assertEquals(smallCar, smallCar); // testing equals method
		assertThat(smallCar, not(equalTo(smallCar2)));
		//assertThat(92936631, is(smallCar.hashCode()));

		assertThat(50, is(smallCar.getMaximumCapacityFuelTank()));
		assertFalse(0 == smallCar.getMaximumCapacityFuelTank());
		
		assertThat(50, is(smallCar.getCurrentAmountFuelTank()));
		assertFalse(0 == smallCar.getCurrentAmountFuelTank());
		
		assertThat(21, is(smallCar.getMinimumAgeToDrive()));
		assertFalse(25 == smallCar.getMinimumAgeToDrive());
		
		assertThat(21, is(smallCar.getAgeToDriveCar()));
		assertFalse(25 == smallCar.getAgeToDriveCar());
		
		assertThat(1, is(smallCar.getMinimumYearsLicenceHeld()));
		assertFalse(5 == smallCar.getMinimumYearsLicenceHeld());
		
		assertThat(1, is(smallCar.litresConsumedSmallCar(20)));
		assertThat(2, is(smallCar.litresConsumedSmallCar(40)));
		assertThat(3, is(smallCar.litresConsumedSmallCar(60)));
		assertThat(4, is(smallCar.litresConsumedSmallCar(80)));
		assertThat(5, is(smallCar.litresConsumedSmallCar(100)));
		
		assertThat(49, is(smallCar.litresConsumedDuringTravell(20)));
		assertThat(47, is(smallCar.litresConsumedDuringTravell(40)));
		assertThat(44, is(smallCar.litresConsumedDuringTravell(60)));
		assertThat(40, is(smallCar.litresConsumedDuringTravell(80)));
		assertThat(35, is(smallCar.litresConsumedDuringTravell(100)));
		
		assertThat(15, is(smallCar.fillFuelTankToMaximumCapacity()));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void litresConsumedLargeCarExceptionTest() 
	{
		smallCar2.litresConsumedDuringTravell(100);	
	}
	
	@Test
	public void TestSetCarRented() 
	{
		assertThat(false, is(smallCar.getIsCarRented()));
		smallCar.setCarRented(true);	
		assertThat(true, is(smallCar.getIsCarRented()));
	}
	
	@Test
	public void TestSetsetFuelTankFull() 
	{
		assertThat(true, is(smallCar.getIsFuelTankFull()));
		smallCar.setFuelTankFull(false);
		assertThat(false, is(smallCar.getIsFuelTankFull()));
	}	
}

	










		
		  
			


