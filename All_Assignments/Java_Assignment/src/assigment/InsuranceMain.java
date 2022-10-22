package assigment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsuranceMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		char choice;

		while(true) {
			try {
				do{
					Car car = new Car();
					System.out.println("****Welcome to Car Insurance Calcuting App****");
					System.out.println("Enter the CarModel:");
					car.setCarModel(s.next());

					selectCarType(s,car);

					System.out.println("Enter cost of the car:");
					car.setCarCost(s.nextInt());

					selectInsuranceType(s,car);

					System.out.println("Do you want to enter details of any other Car? (y/n):");

					choice = s.next().charAt(0);
				}while(choice =='y');
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid Entry! Please enter again the details!"+s.nextLine());
			}
		}	

	}

	private static void selectCarType(Scanner s, Car car) {
		System.out.println("Select the type of car provided in the option:");
		System.out.println("1: Hatchback");
		System.out.println("2: Sedan");
		System.out.println("3: SUV");

		int carType = s.nextInt();

		do {
			if(carType>3 || carType<1) {
				System.out.println("Please select from given option");
				carType = s.nextInt();
			}
			if(carType==1) {
				car.setCarType("Hatchback");
				System.out.println("You selected : Hatchback");
			}
			else if(carType==2) {
				car.setCarType("Sedan");
				System.out.println("You selected : Sedan");
			}
			else if(carType==3) {
				car.setCarType("SUV");
				System.out.println("You selected : SUV");
			}
		}while(carType<1 || carType>3);
	}

	private static void selectInsuranceType(Scanner s, Car car) {
		System.out.println("Select the type of insurance plan you took for your car 1 or 2: ");
		System.out.println("1: Basic ");
		System.out.println("2: Premium");

		int inType = s.nextInt();

		do {
			if(inType>2 || inType<1){ 
				System.out.println("Please select from given option");
				inType = s.nextInt();
			}

			if(inType==1) {
				Insurance.calculateInsuranceForBasic(car);
			}
			else if(inType==2) {
				Insurance.calculateInsuranceForPremium(car);
			}
		}while(false);
	}

}
