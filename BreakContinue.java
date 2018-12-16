public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
        for(int i =0;i <a.length;i += 1){
            if(a[i]>0){
                int k =n;
                int temp = 0;
                while(k>=0){
                    if(i+k<a.length){
                    temp += a[i+k];
                    }
                    k -=1;
                }
                a[i] = temp;
            }
        }
        // return a;
  }

  public static void main(String[] args) {
    // int[] a = {1, 2, -3, 4, 5, 4};
    int[] a = {1, -1, -1, 10, 5, -1};

    int n = 2;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}