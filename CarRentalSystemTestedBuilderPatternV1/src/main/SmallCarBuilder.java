package main;

public class SmallCarBuilder {
	
		private int maxCapacityFuelTank;
		private int currentAmountFuelTank;
		private boolean fullFuelTank;
		private boolean carRented;
		private int minimumAgeToDrive;
		
		public SmallCarBuilder()
		{
			
		}
		
		public SmallCarBuilder withMaxCapacityFuelTank(int newMaxCapacityFuelTank) {
			this.maxCapacityFuelTank = newMaxCapacityFuelTank;
			return this;
		}

		public SmallCarBuilder withCurrentAmountFuelTank(int newCurrentAmountFuelTank) {
			this.currentAmountFuelTank = newCurrentAmountFuelTank;
			return this;
		}

		public SmallCarBuilder withFullFuelTank(boolean newFullFuelTank) {
			this.fullFuelTank = newFullFuelTank;
			return this;
		}

		public SmallCarBuilder withCarRented(boolean newCarRented) {
			this.carRented = newCarRented;
			return this;
		}

		public SmallCarBuilder withMinimumAgeToDrive(int newMinimumAgeToDrive) {
			this.minimumAgeToDrive = newMinimumAgeToDrive;
			return this;
		}
		
		public SmallCar build() 
		{
		        return SmallCar.getInstance(maxCapacityFuelTank, currentAmountFuelTank, fullFuelTank, carRented, minimumAgeToDrive);
		}
		
		public static void main(String[] args) {
			
			SmallCar smallCar = SmallCar.Builder()
					.withMaxCapacityFuelTank(100)
					.withCurrentAmountFuelTank(100)
					.withFullFuelTank(true)
					.withCarRented(false)
					.withMinimumAgeToDrive(21)
					.build();
			
			 System.out.println(smallCar.toString());
				
		}
	}




