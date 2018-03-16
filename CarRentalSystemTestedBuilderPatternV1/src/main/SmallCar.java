package main;

public class SmallCar implements TheCar { 
	
	public static SmallCarBuilder Builder() {
		return new SmallCarBuilder();
	}	
   
  private static int ageToDriveCar = 21; 
  private static int minimumYearsLicence = 1; 	
	
  private String registrationNumber; 
  private final int maxCapacityFuelTank;
  private int currentAmountFuelTank; 
  private boolean fullFuelTank; 
  private boolean carRented; 
  private int minimumAgeToDrive; 
	
    
  private SmallCar(String registrationNumber, int maxCapacityFuelTank, 
      int currentAmountFuelTank, boolean fullFuelTank, boolean carRented, int minimumAgeToDrive) 
  {  
    this.registrationNumber = registrationNumber; 
    this.maxCapacityFuelTank = maxCapacityFuelTank; 
    this.currentAmountFuelTank = currentAmountFuelTank; 
    this.fullFuelTank = fullFuelTank; 
    this.carRented = carRented; 
    this.minimumAgeToDrive = minimumAgeToDrive; 
   } 
   
public static SmallCar getInstance(int maxCapacityFuelTank, 
      int currentAmountFuelTank, boolean fullFuelTank, boolean carRented, int minimumAgeToDrive)  
  {   
    String registrationNumber = CarRegistrationNumber.getInstance().getRegistrationNumber(); 
    SmallCar smallCar = new SmallCar(registrationNumber, maxCapacityFuelTank, currentAmountFuelTank, fullFuelTank 
        ,carRented, minimumAgeToDrive); 
     return smallCar; 
  } 

public int getMinimumAgeToDrive() {
	return minimumAgeToDrive;
}
    
  public int getAgeToDriveCar() 
  { 
    return ageToDriveCar; 
  } 
   
  public int getMinimumYearsLicenceHeld() 
  { 
    return minimumYearsLicence; 
  } 
 
  public String returnCarRegistrationNumber()  
  {   
    return registrationNumber; 
  } 
 
  public int getMaximumCapacityFuelTank()  
  {   
    return maxCapacityFuelTank; 
  } 
  
  public int getCurrentAmountFuelTank() 
  {
	  return currentAmountFuelTank; 
  } 
 
  public void setFuelTankFull(boolean fuelTank) 
  {   
    this.fullFuelTank = fuelTank;   
  } 
 
  public boolean getIsFuelTankFull()  
  {   
    return fullFuelTank; 
  } 
 
  public boolean getIsCarRented()  
  {  
    return carRented; 
  } 
   
  public void setCarRented(boolean rental) 
  {   
    this.carRented = rental;   
  } 
 
  public int litresConsumedSmallCar(int kilometres)  
  { 
    int litresConsumed = Math.floorDiv(kilometres, 20); 
    return litresConsumed; 
  } 
  
  public int litresConsumedDuringTravell(int kilometresTravelled)  
  { 
	int currentAmountFuel = getCurrentAmountFuelTank();
	
	  if(currentAmountFuel <= 5)
	  {
		  throw new IllegalArgumentException("This car needs refuelling");  
	  }
	  else
	  {  
	  this.currentAmountFuelTank = currentAmountFuel - litresConsumedSmallCar(kilometresTravelled);  
	  return currentAmountFuelTank;
	  }
}
  
  public int fillFuelTankToMaximumCapacity()  
  { 
	int currentAmount =  getCurrentAmountFuelTank(); 
	int litresAdded = 50 - currentAmount;
	this.currentAmountFuelTank += litresAdded;
	setFuelTankFull(true);   
	return litresAdded; 
  }
  
  @Override
	public boolean equals(Object o) {
		// Joshua Bloch's Override Equals
		if (this == o)
			return true;
		if (!(o instanceof SmallCar))
			return false;
		SmallCar p = (SmallCar) o;
		return registrationNumber.equals(p.registrationNumber); 
	}
	
	@Override
	public int hashCode() {
		// Joshua Bloch's HashCode
		int result = 17;
		result = 37 * result + registrationNumber.hashCode();
		return result;
	}
   
  public String toString()  
  { 
    return "NewSmallCar [registrationNumber=" + registrationNumber + ", maxCapacityFuelTank=" + maxCapacityFuelTank 
        + ", currentAmountFuelTank=" + currentAmountFuelTank + ", fullFuelTank=" + fullFuelTank + ", carRented=" 
        + carRented + ", minimumAgeToDrive=" + ageToDriveCar + "]"; 
  } 
 
  public static void main(String[] args) { 
     
 /*
    SmallCar car = SmallCar.getInstance(49, 49, true, false, 21); 
    car.litresConsumedDuringTravell(100); 
	System.out.println(car.getCurrentAmountFuelTank());	
	
    SmallCar car2 = SmallCar.getInstance(49, 49, true, false, 21); 
    System.out.println(car.litresConsumedDuringTravell(100)); 
**/ 
  }
}


 
   
 
