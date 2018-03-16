package main;

public class CarRegistrationNumberBuilder {
	
    public String reg;

	public CarRegistrationNumberBuilder()
	{
		
	}
	
	public CarRegistrationNumber build() 
	{
	        return CarRegistrationNumber.getInstance();
	}

public static void main(String[] args) {
	
	CarRegistrationNumber carRegistrationNumberBuilder = CarRegistrationNumber.Builder().build();
	System.out.println(carRegistrationNumberBuilder.toString());
		
}
}
