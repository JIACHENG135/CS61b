public class Max{
    public static int whileSum(int[] a){
        int i = 0;
        int sum = 0;
        while(i<a.length){
            sum += a[i];
            i += 1;
        }
        return sum;
    }
    public static int max(int[] a){
        int i=0;
        int max = 0;
        while(i<a.length){
            if((a[i]-max)>0){
                max = a[i];
            }
            i += 1;
        }
        return max;
    }
    public static int formax(int[] a){
        int max = 0;
        for(int i=0;i<a.length;i+=1){
            if((max-a[i])<0){
                max = a[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(whileSum(a));
        System.out.println(max(a));
        System.out.println(formax(a));

    }
}