import java.util.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class ExtendedEuclid{
  public static void main(String [] args){

    int BIT_LENGTH = 1024;
    Random rand = new SecureRandom();
    BigInteger a = BigInteger.probablePrime(BIT_LENGTH, rand);
    BigInteger b = BigInteger.probablePrime(BIT_LENGTH, rand);
    System.out.println("Random input number 1: " + a);
    System.out.println("Random input number 2: " + b);

    BigInteger c = a.modInverse(b);
    BigInteger d = b.modInverse(a);
    System.out.println("c= " + c);
    System.out.println("d= " + d);

  }
}
