import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

/** Class MillerRabin **/
public class MillerRabin{
  public static void main (String[] args){
      Scanner sc = new Scanner(System.in);
      System.out.println("Miller Rabin Primality Algorithm Test");
      /** Make an object of MillerRabin class **/
      MillerRabin mr = new MillerRabin();
      /** Accept number **/
      System.out.println("Enter number");
      long num = sc.nextLong();
      /** Accept number of iterations **/
      System.out.println("Enter number of iterations");
      int k = sc.nextInt();
      /** check if prime **/
      boolean prime = mr.isPrime(num, k);
      if (prime)
          System.out.println("1 - the number is prime");
      else
          System.out.println("0 - the number is not prime");

  }
    /** Function to check if prime or not **/
    public boolean isPrime(long n, int iteration)
    {
        /** base case **/
        if (n == 0 || n == 1)
            return false;
        /** base case - 2 is prime **/
        if (n == 2)
            return true;
        /** an even number other than 2 is composite **/
        if (n % 2 == 0)
            return false;

        long s = n - 1;
        while (s % 2 == 0)
            s /= 2;

        Random rand = new Random();
        for (int i = 0; i < iteration; i++)
        {
            long r = Math.abs(rand.nextLong());
            long a = r % (n - 1) + 1, temp = s;
            long mod = modPow(a, temp, n);
            while (temp != n - 1 && mod != 1 && mod != n - 1)
            {
                mod = mulMod(mod, mod, n);
                temp *= 2;
            }
            if (mod != n - 1 && temp % 2 == 0)
                return false;
        }
        return true;
    }
    /** Function to calculate (a ^ b) % c **/
    public long modPow(long a, long b, long c)
    {
        long res = 1;
        for (int i = 0; i < b; i++)
        {
            res *= a;
            res %= c;
        }
        return res % c;
    }
    /** Function to calculate (a * b) % c **/
    public long mulMod(long a, long b, long mod)
    {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }
}
