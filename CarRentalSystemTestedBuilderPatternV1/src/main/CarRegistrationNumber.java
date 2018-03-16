package main;
import java.util.HashMap;

public class CarRegistrationNumber {
	
	public static CarRegistrationNumberBuilder Builder() {
		return new CarRegistrationNumberBuilder();
	}

	private String registrationNumber;
	private static final HashMap<String, CarRegistrationNumber> registrationLicences = new HashMap<String, CarRegistrationNumber>();
	private static final String lastRegistrationNumber = "a10000";
	private static int minimumNumber = 1000;
	private static int nextNumber = minimumNumber;
	private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static char minimumLetter = alphabet[0];
	private static char nextLetter = minimumLetter;
	private static char lastLetter = alphabet[25];

	private CarRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public static CarRegistrationNumber generateRegistrationNumber(String registrationNumber) {
		CarRegistrationNumber generateRegistrationNumber = new CarRegistrationNumber(registrationNumber);
		registrationLicences.put(registrationNumber, generateRegistrationNumber);
		return generateRegistrationNumber;
	}

	public static CarRegistrationNumber getInstance() {
		String registrationNumber;
		do {
			registrationNumber = stringOfRegistrationNumber();
			checkRegistrationNumberIsNotLastRegistrationNumber(registrationNumber);
			generateValuesNextRegistrationNumber();
		} while (registrationLicences.containsKey(registrationNumber));
		return generateRegistrationNumber(registrationNumber);
	}
	
	public static void checkRegistrationNumberIsNotLastRegistrationNumber(String registrationNumber) {
		if (registrationNumber.compareTo(getLastregistrationNumber()) == 0) {
			throw new IllegalArgumentException("No more number plates");
		}
	}

	public static void generateValuesNextRegistrationNumber() {
		if (getNextLetter() != getLastLetter()) {
			nextLetter++;
		} else {
			nextLetter = minimumLetter;
			nextNumber++;
		}
	}
	
	public static String stringOfRegistrationNumber() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNextLetter());
		sb.append(getNextNumber());
		return sb.toString();
	}

	public static int getNextNumber() {
		return nextNumber;
	}
	
	public static char getNextLetter() {
		return nextLetter;
	}

	public static char getMinimumLetter() {
		return minimumLetter;
	}

	public static char getLastLetter() {
		return lastLetter;
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public static void setLastLetter(char lastLetter) {
		CarRegistrationNumber.lastLetter = lastLetter;
	}

	public static String getLastregistrationNumber() {
		return lastRegistrationNumber;
	}
	
	@Override
	public String toString() {
		return "CarRegistrationNumber [registrationNumber=" + registrationNumber + "]";
	}

	


}
