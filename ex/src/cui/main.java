package cui;

import domein.*;

public class main {
	public static void main(String[] args) {		
		Auto auto1 = new Auto("BMW", 2024, 30000, 4);
		Auto auto2 = new Auto("BMW", 2024, 30000, 4);
		Auto auto3 = new Auto("Tesla", 2017, 50000, 2);
		
		Motor motor1 = new Motor("Vespa", 2010, 4000, 200);
		
		System.out.println(auto1.equals(auto2));
		System.out.printf("Auto1 - %s%nAuto2 - %s%nAuto3 - %s%nMotor1 - %s%n",
				auto1.toString(), auto2.toString(), auto3.toString(), motor1.toString());
		System.out.printf("Belasting Auto1 - %f%nBelasting Auto2 - %f%nBelasting Auto3 - %f%nBelasting Motor1 - %f%n",
				auto1.berekenBelasting(), auto2.berekenBelasting(), auto3.berekenBelasting(), motor1.berekenBelasting());
	}
}
