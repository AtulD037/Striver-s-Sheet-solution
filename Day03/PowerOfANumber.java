package Day03;
//Implement pow(x, n), which calculates x raised to the power n.
public class PowerOfANumber {
    public static double myPow(double x, int n) {
    // return Math.pow(x,n);-Inbuilt function
        if (n==0){
            return 1;
        }
        if(n<0){
            return 1/x*myPow(1/x,-(n+1));
        }
        return (n%2==0) ? myPow(x*x,n/2):x*myPow(x*x,n/2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,4));
    }
}
