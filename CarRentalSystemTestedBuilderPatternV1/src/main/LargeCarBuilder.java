package main;

public class LargeCarBuilder {

	private int maxCapacityFuelTank;
	private int currentAmountFuelTank;
	private boolean fullFuelTank;
	private boolean carRented;
	private int minimumAgeToDrive;
	
	public LargeCarBuilder()
	{
		
	}
	
	public LargeCarBuilder withMaxCapacityFuelTank(int newMaxCapacityFuelTank) {
		this.maxCapacityFuelTank = newMaxCapacityFuelTank;
		return this;
	}

	public LargeCarBuilder withCurrentAmountFuelTank(int newCurrentAmountFuelTank) {
		this.currentAmountFuelTank = newCurrentAmountFuelTank;
		return this;
	}

	public LargeCarBuilder withFullFuelTank(boolean newFullFuelTank) {
		this.fullFuelTank = newFullFuelTank;
		return this;
	}

	public LargeCarBuilder withCarRented(boolean newCarRented) {
		this.carRented = newCarRented;
		return this;
	}

	public LargeCarBuilder withMinimumAgeToDrive(int newMinimumAgeToDrive) {
		this.minimumAgeToDrive = newMinimumAgeToDrive;
		return this;
	}
	
	public LargeCar build() 
	{
	        return LargeCar.getInstance(maxCapacityFuelTank, currentAmountFuelTank, fullFuelTank, carRented, minimumAgeToDrive);
	}
	
public static void main(String[] args) {
	
	LargeCar largeCar = LargeCar.Builder()
			.withMaxCapacityFuelTank(60)
			.withCurrentAmountFuelTank(60)
			.withFullFuelTank(true)
			.withCarRented(false)
			.withMinimumAgeToDrive(25)
			.build();
	
	System.out.println(largeCar.toString());
		
}
}


