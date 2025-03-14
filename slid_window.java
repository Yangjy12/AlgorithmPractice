import java.util.HashMap;
import java.util.Map;

public class slid_window {
    //力扣209长度最小的子数组
//    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
    //暴力解法
    public int minSubArrayLen(int s, int[] nums) {
        int sum=0;
        int len=0;
        for (int j=0;j<nums.length;j++){
            int i=j;
            while(i<=nums.length){
                if (sum<s){
                    sum+=nums[i++];
                }else {
                    len=Math.min(len,i-j+1);
                }
            }
        }
        return len;
    }
//    滑动窗口,与暴力算法不同的是起始位置与终止位置的寻找，而且还要注意使用while而不是if
    public int minSubArrayLen2(int s, int[] nums) {
        int sum=0;
        int len=Integer.MAX_VALUE;
        int start=0;
        for (int end=0;end<nums.length;end++){
            sum+=nums[end];
            while (sum>=s){
                len=Math.min(len,end-start+1);
                sum-=nums[start];
                start++;
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
    //水果成篮
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        int len=0;
        for (int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while (map.size()>2){
                map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);
                if (map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            len=Math.max(len,right-left+1);
        }
        return len;
    }
    //最小覆盖子串
    public String minWindow(String s, String t) {

        Map<Character,Integer> smap=new HashMap<>();
        Map<Character,Integer> tmap=new HashMap<>();
        int count=0;
        String res="";
        //将目标字符串放入hashmap中，并统计字符出现的次数
        for (char c:t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        for (int i = 0,j=0; i < s.length(); i++) {
            char c = s.charAt(i);
            //更新字符串 s 中当前字符的出现次数
            smap.put(c,smap.getOrDefault(c,0)+1);
            //如果smap中该字符出现的次数小于tmap，
            if (smap.get(c)<=tmap.getOrDefault(c,0)){
                count++;
            }
            while (j<=i&&smap.getOrDefault(s.charAt(j),0)>tmap.getOrDefault(s.charAt(j),0)){
                smap.put(s.charAt(j), smap.get(s.charAt(j))-1);
                j++;
            }
            if (count==t.length()){
                if (res.isEmpty()||i-j+1<res.length()){
                    res=s.substring(j,i+1);
                }
            }

        }
        return res;
    }


}
