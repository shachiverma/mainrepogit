package assigment;

public class Insurance {


	public Insurance() {
		super();

	}


	public static void calculateInsuranceForBasic(Car car) {
		double insurance_basic = 0;
		System.out.println("\n***Thanks for using Car Insurance Calculating App***\n");
		System.out.println("****Insurance Bill****");
		try {
		if("Hatchback".equalsIgnoreCase(car.getCarType())) {
			insurance_basic=car.getCarCost()*0.05;
		}
		else if("Sedan".equalsIgnoreCase(car.getCarType())) {
			insurance_basic=car.getCarCost()*0.08;
		}
		else if("SUV".equalsIgnoreCase(car.getCarType())) {
			insurance_basic=car.getCarCost()*0.1;}
		
		System.out.println("CarModel:\t\t"+car.getCarModel()+"\nCost of Car:\t\t"+car.getCarCost()+"\nInsurance to be paid is:"+insurance_basic);
		}
		catch(NullPointerException e)
        {
            System.out.print("Please enter the CarType");
        }
		
		
	}


	public static void calculateInsuranceForPremium(Car car) {
		System.out.println("\n***Thanks for using Car Insurance Calculating App***\n");
		System.out.println("****Insurance Bill****");
		double insurance_premium=0;
		try {
			if("Hatchback".equalsIgnoreCase(car.getCarType())) {
				insurance_premium=(car.getCarCost()*0.05)+(car.getCarCost()*0.05*0.2);
			}
			else if("Sedan".equalsIgnoreCase(car.getCarType())) {
				insurance_premium=(car.getCarCost()*0.08)+(car.getCarCost()*0.08*0.2);
			}
			else if("SUV".equalsIgnoreCase(car.getCarType())) {
				insurance_premium=(car.getCarCost()*0.1)+(car.getCarCost()*0.1*0.2);}
			
			System.out.println("CarModel:\t\t"+car.getCarModel()+"\nCost of Car:\t\t"+car.getCarCost()+"\nInsurance to be paid is: "+insurance_premium);
			}
			catch(NullPointerException e)
	        {
	            System.out.print("Please enter the CarType");
	        }
	}

}
