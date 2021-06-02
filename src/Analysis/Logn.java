package Analysis;

/**
 * 
 * @author Anjan Kailash
 * 
 * Logn is the time complexity in three cases
 * 
 * 1. doubling/ trippling/ nning
 * 
 * 2. halving/ fractioning
 * 
 * 3. Super spreader like covid
 *
 */
public class Logn {
	public static void main(String[] args) {
		
		
		/**
		 * Genetically modified rabbit dies after giving birth to 2 rabbits daily which inturn does the same thing. How many days
		 * it will take to produce n rabbits. logn complexity
		 */
		Integer n = Integer.parseInt(args[0]);
		int rabbitn = 1; //no. of rabbits
		int days = 0;
		
		//daily there are twice as number of rabbits as of previous day as parents die and children live until they give birth that day
		for (rabbitn = 1; rabbitn < n; rabbitn *= 2) {
			//rabbit population keeps increasing in days
			days++;
		}
		System.out.println("no: of days: "+days);
		
		
		
		/**
		 * -------------------------------------------------------------------------------------------------------
		 */
		/**
		 * half of the patients recover from covid daily, how many days it takes if there are n patients initially
		 */
		int patientsCount = n; //no. of patients
		days = 0;
		
		//daily patients reduce to half
		for (patientsCount = n; patientsCount > 0; patientsCount /= 2) {
			days++;
		}
		System.out.println("no. of days: "+days);
		
		
		/**
		 * ---------------------------------------------------------------------------------------------------------
		 */
		/**
		 * super spreader: covid spreads to twice no of people daily, 
		 * along with original patients, how many days required for there to be n patients
		 */
		/**
		 * 
		 * 
		 * 1st day => 1 patient ----------------------------------------> 2^0 - 1
		 * 2nd day => 2 + 1 (original) = 3 patients --------------------> 2^1 - 1
		 * 3rd day => 4 + 3 (originsl) = 7 patients --------------------> 2^2 - 1
		 * ...
		 * ...
		 * ...
		 * nth day => --------------------------------------------------> 2^n - 1
		 * 
		 * 
		 * (In case of trippling it should be 3^n - 1)
		 * 
		 * on dth day
		 * n = 2^d - 1
		 * 2^d = n+1
		 * d = log2 (n+1)
		 */
		patientsCount = 1;
		days = 0;
		
		//patients double + original number each day
		for (; patientsCount < n; patientsCount = (int) (Math.pow(2, days) - 1)) {
			days++;
		}
		System.out.println("no. of days: "+days);
		
		
		/***
		 * n log n problem  
		 */
		patientsCount = 1;
		days = 0;
		for (; patientsCount <= n; patientsCount *= 2) { // log n times
			for (int i = 1; i < n; i++) { // n times
				days ++;
			}
		}
		System.out.println("days: "+days+" ("+n+" * log"+ n+")"); //n log n
	}
}
