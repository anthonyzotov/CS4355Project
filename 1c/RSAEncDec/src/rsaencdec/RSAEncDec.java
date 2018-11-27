/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsaencdec;

import java.util.Random;

/**
 *
 * @author Anthony
 */


public class RSAEncDec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String p = generatePrimeP();
        System.out.println(p);
        String q = generatePrimeQ();
        System.out.println(q);
    }
    public static String generatePrimeP(){
        
        Random rand = new Random();
        int low = 5000;
        int high = 20000;// generate a random number
        int num = rand.nextInt(high - low) + low;

        while (!isPrime(num)) {          
            num = rand.nextInt(high - low) + low;
        }
        
        return Integer.toString(num);
    }
    
    public static String generatePrimeQ(){
        
        int num = 0;
        Random rand = new Random(); // generate a random number
        num = rand.nextInt(5000) + 1;

        while (!isPrime(num)) {          
            num = rand.nextInt(5000) + 1;
        }
        
        return Integer.toString(num);
    }
    
    private static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0) 
            return inputNum == 2 || inputNum == 3; //this returns false if number is <=1 & true if number = 2 or 3
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0)) 
            divisor += 2; //iterates through all possible divisors
        return inputNum % divisor != 0; //returns true/false
    }
    
}
