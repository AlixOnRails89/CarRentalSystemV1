package main;

public class CarRentalCompanyBuilder {
	
	public CarRentalCompanyBuilder()
	{
		
	}
	
	public CarRentalCompany build() 
	{
	        return new CarRentalCompany();
	}

public static void main(String[] args) {
	
	CarRentalCompany carRentalCompany = CarRentalCompany.Builder().build();
	System.out.println(carRentalCompany.toString());
		
}
}
