public class Fib{
    public static int fib(int n) {
        if(n==1){
            return 0;
        }
        else{
            if(n==2){
                return 1;
            }
            else{
                return fib(n-1)+fib(n-2);
            }
        }
    }
    public static void main(String[] args) {
        int n = 10;
        for(int i =1;i<=n;i+=1){
            System.out.println(fib(i));
        }
    }
}