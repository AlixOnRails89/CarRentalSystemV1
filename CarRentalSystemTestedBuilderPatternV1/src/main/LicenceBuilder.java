package main;

public class LicenceBuilder {
	
	 private Person person; 
	 private int year;  
	 private int month;  
	 private int day;  
	 private Boolean fullLicence; 
	 
	 public LicenceBuilder withPerson(Person person) {
			this.person = person;
			return this;
		}

		public LicenceBuilder withYearOfIssueLicence(int year) {
			this.year = year;
			return this;
		}
		
		public LicenceBuilder withMonthOfIssueLicence(int month) {
			this.month = month;
			return this;
		}
		
		public LicenceBuilder withDayOfIssueLicence(int day) {
			this.day = day;
			return this;
		}
		
		public LicenceBuilder withfullLicence(boolean fullLicence) {
			this.fullLicence = fullLicence;
			return this;
		}
		
		public Licence build() 
		{
		        return Licence.getInstance(person, day, month, year, fullLicence);
		}
		
		public static void main(String[] args) {
			
			Person person = new Person("Alex", "Matthews", 02,07, 1989);
			Licence licenceOne = Licence.Builder()

					.withPerson(person)
					.withDayOfIssueLicence(7)
					.withMonthOfIssueLicence(9)
					.withYearOfIssueLicence(2009)
					.withfullLicence(true)
					.build();
		System.out.println(licenceOne.toString())	;
				
		}
		}
	


