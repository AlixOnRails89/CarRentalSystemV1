package main;
import java.util.*;

public class CarRentalCompany {
	
	public static CarRentalCompanyBuilder Builder() {
		return new CarRentalCompanyBuilder();
	}
	
	public static Map<Licence, TheCar> rentedCars = new HashMap<Licence, TheCar>();
	public static Queue<TheCar> smallCarQueue = new LinkedList<TheCar>();
	public static Queue<TheCar> largeCarQueue = new LinkedList<TheCar>();

	public CarRentalCompany() 
	{}
	
	public boolean issueCar(Licence licence, TheCar typeOfCar) {
		
		boolean canThePersonRentACar = canThePersonRentTheCar(licence, typeOfCar);		
		boolean personIsNotCurrentlyRenting = !isPersonCurrentlyRentingACar(licence);
		boolean issueCar = false;
		
		if(canThePersonRentACar && personIsNotCurrentlyRenting)
		{
			addLicenceAndCarMap(licence, typeOfCar);
			issueCar = true;
		}
		return issueCar;
	}
	
	public boolean canThePersonRentTheCar(Licence licence, TheCar typeOfCar)
	{
		boolean issueCar = false;
		int ageToDrive = typeOfCar.getAgeToDriveCar();
		int minimumLicenceYears = typeOfCar.getMinimumYearsLicenceHeld();
		boolean canIRentACar = licence.canIRentACar(ageToDrive, minimumLicenceYears);
		boolean isThereACar = isThereACar(typeOfCar);

		if(canIRentACar && isThereACar)
		{
		issueCar = true;
		}
		return issueCar;
	}
	
	public static int numberAvailableCarsToRent(TheCar typeOfCar)
	{
		int carQueueSize = 0;
		if(typeOfCar instanceof SmallCar) 
		{
			carQueueSize = smallCarQueue.size();
		}
		if(typeOfCar instanceof LargeCar)
		{
			carQueueSize = largeCarQueue.size();
		}
		return carQueueSize;
	}
	
	public static boolean isThereACar(TheCar typeOfCar) 
	{
		if(typeOfCar instanceof SmallCar) {
			return smallCarQueue.contains(typeOfCar);
		}
		else
		{
			return largeCarQueue.contains(typeOfCar);
		}
	}
	
	public void addCarToQueue(SmallCar car)
	{
		smallCarQueue.add(car);
	}
	
	public void addCarToQueue(LargeCar car)
	{
		largeCarQueue.add(car);
	}

	public TheCar whatCarIsPersonRenting(Licence licence) {
		return rentedCars.get(licence);
	}

	public boolean isPersonCurrentlyRentingACar(Licence licence) {
		return rentedCars.containsKey(licence);			
	}
	
	public void addLicenceAndCarMap(Licence licence, TheCar car)
	{
		rentedCars.put(licence, car);
	}

	public static void main(String[] args) {
			
	}
}