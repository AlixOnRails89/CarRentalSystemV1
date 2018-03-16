
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.CarRentalCompany;
import main.LargeCar;
import main.Licence;
import main.Person;
import main.SmallCar;

public class CarRentalCompanyBuilderTest {
	
	CarRentalCompany carRentalCompany = CarRentalCompany.Builder().build();
	
	/* LargeCar parameters  [maxCapacityFuelTank, currentAmountFuelTank, fullFuelTank, carRented, minimumAge = 25] **/
	LargeCar largeCar1 = LargeCar.getInstance(100, 100, true, false, 25);
	LargeCar largeCar2 = LargeCar.getInstance(100, 100, true, false, 25);
	LargeCar largeCar3 = LargeCar.getInstance(100, 100, true, false, 25);
	LargeCar largeCar4 = LargeCar.getInstance(100, 100, true, false, 25);
	LargeCar largeCar5 = LargeCar.getInstance(100, 100, true, false, 25);
	LargeCar largeCar6 = LargeCar.getInstance(100, 100, true, false, 25);
	
	SmallCar smallCar1 = SmallCar.getInstance(100, 100, true, false, 21);
	SmallCar smallCar2 = SmallCar.getInstance(100, 100, true, false, 21);
	SmallCar smallCar3 = SmallCar.getInstance(100, 100, true, false, 21);
	SmallCar smallCar4 = SmallCar.getInstance(100, 100, true, false, 21);
	
	Person person1 = new Person("Joanne", "Rowling", 31, 7, 1965);
	Person person2 = new Person("Roald", "Dahl", 5, 2, 1997);
	Person person3 = new Person("Oscar", "Wilde", 4, 2,1950);
	Person person4 = new Person("Charles", "Dickens", 4, 2, 1986); 
	Person person5 = new Person("Stephenie", "Meyer", 7, 11, 1943);  
	
    Licence person1Licence = Licence.getInstance(person1, 13, 9, 2000, true);
    Licence person2Licence = Licence.getInstance(person2, 2, 2, 2018, true);
    Licence person3Licence = Licence.getInstance(person3, 11, 3, 2014, true);
    Licence person4Licence = Licence.getInstance(person4, 11, 3, 2013, true);
    Licence person5Licence = Licence.getInstance(person5, 21, 7, 1990, true);
   
	@Test
	public void addLargeCarToQueue() {
		
    assertThat(false, is(CarRentalCompany.isThereACar(largeCar1)));	
		
    carRentalCompany.addCarToQueue(largeCar1);
	carRentalCompany.addCarToQueue(largeCar2);
	carRentalCompany.addCarToQueue(largeCar3);
	carRentalCompany.addCarToQueue(largeCar4);
	
	assertThat(4, is(CarRentalCompany.numberAvailableCarsToRent(largeCar1)));	
	assertThat(true, is(CarRentalCompany.isThereACar(largeCar1)));	
	}
	
	@Test
	public void addSmallCarToQueue() {
		
	assertThat(false, is(CarRentalCompany.isThereACar(smallCar1)));
	
	carRentalCompany.addCarToQueue(smallCar1);
	carRentalCompany.addCarToQueue(smallCar2);
	carRentalCompany.addCarToQueue(smallCar3);
	carRentalCompany.addCarToQueue(smallCar4);
	
	assertThat(5, is(CarRentalCompany.numberAvailableCarsToRent(smallCar1)));	
	assertThat(true, is(CarRentalCompany.isThereACar(smallCar1)));
	}

	@Test
	public void isPersonCurrentlyRentingCar() {
		
	carRentalCompany.addLicenceAndCarMap(person1Licence, largeCar1);
    assertThat(true, is(carRentalCompany.isPersonCurrentlyRentingACar(person1Licence)));
    
    assertThat(false, is(carRentalCompany.isPersonCurrentlyRentingACar(person2Licence)));
    
	carRentalCompany.addLicenceAndCarMap(person3Licence, largeCar3);
    assertThat(true, is(carRentalCompany.isPersonCurrentlyRentingACar(person3Licence)));

	}
		
	@Test
	public void canThePersonRentCar() 
	{
	
    carRentalCompany.addCarToQueue(largeCar1);
	carRentalCompany.addCarToQueue(smallCar1);
	
    assertThat(true, is(carRentalCompany.canThePersonRentTheCar(person1Licence, largeCar1)));
    assertThat(false, is(carRentalCompany.canThePersonRentTheCar(person2Licence, largeCar1)));
    assertThat(false, is(carRentalCompany.canThePersonRentTheCar(person3Licence, largeCar1)));
    assertThat(true, is(carRentalCompany.canThePersonRentTheCar(person4Licence, largeCar1)));
    assertThat(true, is(carRentalCompany.canThePersonRentTheCar(person5Licence, largeCar1)));
    
    assertThat(true, is(carRentalCompany.canThePersonRentTheCar(person1Licence, smallCar1)));
    assertThat(false, is(carRentalCompany.canThePersonRentTheCar(person2Licence, smallCar1)));
    assertThat(true, is(carRentalCompany.canThePersonRentTheCar(person3Licence, smallCar1)));
    assertThat(true, is(carRentalCompany.canThePersonRentTheCar(person4Licence, smallCar1)));
    assertThat(true, is(carRentalCompany.canThePersonRentTheCar(person5Licence, smallCar1)));
  	
    }
	
	@Test
	public void issueCarTest() {
	
	carRentalCompany.addCarToQueue(largeCar1);
	carRentalCompany.addCarToQueue(smallCar1);
	
	assertThat(true, is(carRentalCompany.issueCar(person1Licence, largeCar1)));	
	assertThat(true, is(carRentalCompany.isPersonCurrentlyRentingACar(person1Licence)));	

	assertThat(false, is(carRentalCompany.issueCar(person2Licence, largeCar1)));	
	assertThat(false, is(carRentalCompany.isPersonCurrentlyRentingACar(person2Licence)));
	
	assertThat(false, is(carRentalCompany.issueCar(person3Licence, largeCar1)));	
	assertThat(false, is(carRentalCompany.isPersonCurrentlyRentingACar(person3Licence)));	
	
	assertThat(true, is(carRentalCompany.issueCar(person4Licence, largeCar1)));	
	assertThat(true, is(carRentalCompany.isPersonCurrentlyRentingACar(person4Licence)));

	}
	
	@Test
	public void whatCarIsPersonRentingTest() {
	
	carRentalCompany.addCarToQueue(largeCar1);
	carRentalCompany.addCarToQueue(smallCar1);
	carRentalCompany.addCarToQueue(largeCar2);
	carRentalCompany.addCarToQueue(smallCar2);
	
	assertThat(true, is(carRentalCompany.issueCar(person1Licence, largeCar1)));	
	assertThat(largeCar1, is(carRentalCompany.whatCarIsPersonRenting(person1Licence)));	

	assertThat(true, is(carRentalCompany.issueCar(person4Licence, largeCar2)));	
	assertThat(largeCar2, is(carRentalCompany.whatCarIsPersonRenting(person4Licence)));	
	
	}
}


	
	


