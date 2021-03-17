import java.util.ArrayList;
import java.util.Arrays;

public class accescode {



    public static int solution(int[] l){
        int[] count = new int[l.length];
        for(int i=0; i<l.length; ++i)
            for(int j=i+1; j<l.length; ++j)
                if(l[i] <= l[j] && l[j] % l[i] == 0)
                    count[i]++;
        int ans = 0 ;
        for(int i=0; i<l.length; ++i)
            for(int j=i+1; j<l.length; ++j)
                if(l[j]%l[i]==0)
                    ans += count[j];
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = new int[2000];
        Arrays.fill(arr, 1);
        double start = System.currentTimeMillis();
        System.out.println(solution(arr));
        System.out.println(System.currentTimeMillis()-start);
    }


}
