import java.util.HashSet;
import java.util.Set;

public class happymath {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();

        while(n!=1&&!set.contains(n)) {
            set.add(n);
            n=getNum(n);
        }
        return n==1;
    }
    private int getNum(int n){
        int res=0;
        while(n>0){
            int temp=n%10;
            res+=temp*temp;
            n=n/10;
        }
        return res;
    }
}
