package tax;
import java.util.Scanner;


public class tax{
	static Scanner in = new Scanner(System.in);
	
	public static int getInt() {

	        //System.out.print("Please enter an integer");
	        if (in.hasNext("stop")) {
	            System.out.println("***Terminated***");
	            System.exit(0);
	        }
	        while (!in.hasNextInt()) {
	            System.out.print("Input is not an integer!");
	            in.next();
	        }
	        int dum = in.nextInt();
	        return dum;
	        
	    }
	
	
public static void main(String []args){
        
        
        double w1, h1;
        System.out.println("Please input Wife Personal income");
        w1 = getInt();
        System.out.println("Please input Husband Personal income");
        h1 = getInt();
        tcase(w1,h1);
    }
	
	
public static double taxpay(double a){
    	
    	double tax = 0;
    	if (a < 45000){
   		 tax = a*0.02;
   		 }else if (a < 90000){
   			 tax = 900 +(a - 45000)*0.07;	 
   		 	}else if (a <= 135000){
   		 		tax = 900 + 3150 + (a-90000)*0.12;	 
   		 			}else {
   		 				tax = 900 + 3150 + 5400 + (a-135000)*0.17;	 
   		 }
    	
    	if (tax*0.75 >= 20000 ) {
    		tax = tax - 20000;
    			}else tax = tax*0.25;
    	
    	if (tax < 0){
    		tax = 0;
    	} 
    	
    	return tax;
    	}


public static double NI(double b){
	
		double ni = 0;
		if(b*0.05>15000){  
			ni = b-15000;
		}else{
			ni = b*0.95;
			if (ni < 0)
				ni = 0;	
}
			return ni;
}

	public static void tcase(double wife, double hus) {
	double wIncome, hIncome, combineIncome, wNCI,hNCI,totalNCI;
	wIncome = wife;
	hIncome = hus;
	combineIncome = wife+hus;
	
	System.out.println("Wife  income is "+ wIncome);
	System.out.println("Husband income is "+ hIncome);
	
	System.out.println("Total income is "+ combineIncome);
	
	if(wIncome*0.05>15000){  // wife
    	wNCI = wIncome-15000-132000;
    }else{
    	wNCI = wIncome*0.95-132000;
    	if (wNCI < 0)
    		wNCI = 0;
    }
    System.out.println("Wife net chargeble income is "+ wNCI);
            
    if(hIncome*0.05>15000){ //husband
    	hNCI = hIncome-15000-132000;
    }else{
    	hNCI = hIncome*0.95-132000;
    	if (hNCI < 0)
    		hNCI = 0;
    }
    System.out.println("Husband net chargeble income is is "+ hNCI);
             
    
    totalNCI = NI(wIncome)+NI(hIncome)-264000; 
    System.out.println("Combine net chargeble income is is "+ totalNCI);

    double w = taxpay(wNCI);
    double h = taxpay(hNCI);
    double t = taxpay(totalNCI);
    
    System.out.println("Wife payable tax is "+ w);
    System.out.println("Husband payable tax is "+ h);
    System.out.println("The toatl payable tax under separate taxation is "+ (w+h));
    System.out.println("Join payable tax is "+ t);
    
    if(w+h>t)
    {
    	System.out.println("So, join assessment recommended: YES\n");
    }else if(w+h == t)
    {
    	System.out.println("So, join assessment recommended: NO DIFFERENT\n");
    }else{
    	System.out.println("So, join assessment recommended: NO\n");
    }
}
}
    
    
        
        
    
    
    
    
             

   




