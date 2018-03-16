package main;

public class LargeCar implements TheCar {

	public static LargeCarBuilder Builder() {
		return new LargeCarBuilder();
	}

	private static int litresConsumedFirst50Kilometres = 5;
	private static int ageToDriveCar = 25;

	private String registrationNumber;
	private int maxCapacityFuelTank;
	private int currentAmountFuelTank;
	private boolean fullFuelTank;
	private boolean carRented;
	private int minimumAgeToDrive;

	private LargeCar(String registrationNumber, int maxCapacityFuelTank, int currentAmountFuelTank,
			boolean fullFuelTank, boolean carRented, int minimumAge) {
		this.registrationNumber = registrationNumber;
		this.maxCapacityFuelTank = maxCapacityFuelTank;
		this.currentAmountFuelTank = currentAmountFuelTank;
		this.fullFuelTank = fullFuelTank;
		this.carRented = carRented;
		this.minimumAgeToDrive = minimumAge;
	}

	public static LargeCar getInstance(int maxCapacityFuelTank, int currentAmountFuelTank, boolean fullFuelTank,
			boolean carRented, int minimumAge) {
		String registrationNumber = CarRegistrationNumber.getInstance().getRegistrationNumber();
		LargeCar largeCar = new LargeCar(registrationNumber, maxCapacityFuelTank, currentAmountFuelTank, fullFuelTank,
				carRented, minimumAge);
		return largeCar;
	}
	
	public int litresConsumedLargeCar(int kilometres)  
	  { 
		int litresConsumed = 0;
		int kilometresTravelledAfter50Kilometres = 0;
		int currentAmountFuel = getCurrentAmountFuelTank();
		
		if(currentAmountFuel <= 5)
		{
			  throw new IllegalArgumentException("This car needs refuelling");
         }
		
		else if(kilometres <= 50)
		{
			litresConsumed = litresConsumed10KilometresPerLitre(kilometres); 
		}
		else
		{
			litresConsumed = litresConsumedFirst50Kilometres;
			kilometresTravelledAfter50Kilometres = kilometres - 50;
			litresConsumed += litresConsumed15KilometresPerLitre(kilometresTravelledAfter50Kilometres);
		}
		
		this.currentAmountFuelTank = currentAmountFuel - litresConsumed;
	    return litresConsumed; 
	  } 
	
	public int fillFuelTankToMaximumCapacity()  
	  { 
		int currentAmount =  getCurrentAmountFuelTank(); 
		int litresAdded = 60 - currentAmount;
		this.currentAmountFuelTank += litresAdded;
		return litresAdded; 
	  } 
	
	public int litresConsumed10KilometresPerLitre(int kilometres)  
	  { 
	    int distanceRound = Math.floorDiv(kilometres, 10); 
	    return distanceRound; 
	  } 
	
	public int litresConsumed15KilometresPerLitre(int kilometres)  
	  { 
	    int distanceRound = Math.floorDiv(kilometres, 15); 
	    return distanceRound; 
	  } 

	@Override
	public String returnCarRegistrationNumber() {
		return registrationNumber;
	}

	@Override
	public int getMaximumCapacityFuelTank() {
		return maxCapacityFuelTank;
	}

	@Override
	public int getCurrentAmountFuelTank() {
		return currentAmountFuelTank;
	}

	@Override
	public boolean getIsFuelTankFull() {
		return fullFuelTank;
	}

	@Override
	public boolean getIsCarRented() {
		return carRented;
	}
	
	@Override
	public int getMinimumYearsLicenceHeld() {
		// TODO Auto-generated method stub
		return 5;
	}

	public int getMinimumAgeToDrive() {
		return minimumAgeToDrive;

	}

	public int getAgeToDriveCar() {
		return ageToDriveCar;
	}

	
	
	@Override
	public boolean equals(Object o) {
		// Joshua Bloch's Override Equals
		if (this == o)
			return true;
		if (!(o instanceof LargeCar))
			return false;
		LargeCar p = (LargeCar) o;
		return registrationNumber.equals(p.registrationNumber); 
	}
	
	@Override
	public int hashCode() {
		// Joshua Bloch's HashCode
		int result = 17;
		result = 37 * result + registrationNumber.hashCode();
		return result;
	}
	
	@Override
	public String toString() {
		return "NewLargeCar [registrationNumber=" + registrationNumber + ", maxCapacityFuelTank=" + maxCapacityFuelTank
				+ ", currentAmountFuelTank=" + currentAmountFuelTank + ", fullFuelTank=" + fullFuelTank + ", carRented="

				+ carRented + ", minimumAgeToDrive=" + minimumAgeToDrive + "]";
	}
	
	
	public static void main(String[] args) {

		/* LargeCar parameters  [maxCapacityFuelTank, currentAmountFuelTank, fullFuelTank, carRented, minimumAge] 
		
		LargeCar car = LargeCar.getInstance(100, 100, true, false, 25);
		
		car.litresConsumedLargeCar(50);
		System.out.println(car.getCurrentAmountFuelTank());	
		car.fillFuelTankToMaximumCapacity();
		System.out.println(car.getCurrentAmountFuelTank());	
		
		**/
	   
	}

	
}
