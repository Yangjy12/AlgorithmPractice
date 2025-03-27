import java.util.*;

public class two_sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(indexMap.containsKey(target-nums[i])){
                return new int[]{indexMap.get(target-nums[i]),i};
            }else {
                indexMap.put(nums[i],i);
            }
        }
        return null;
    }

//    四数相加
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums1){
            for (int j:nums2){
                int sum=i+j;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        for(int i:nums3){
            for(int j:nums4){
                res+=map.getOrDefault(0-i-j,0);
            }
        }
        return res;
    }
//    赎金值
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record=new int[26];
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        for(char c:magazine.toCharArray()){
            record[c-'a']++;
        }
        for (char c:ransomNote.toCharArray()){
            record[c-'a']--;
        }
        for(int i:record){
            if(i<0){
                return false;
            }
        }
        return true;
    }
//    三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return res;
            }
            int left=i+1;
            int right=nums.length-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                }else if (sum<0){
                    left++;
                }else {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right && nums[left]==nums[left+1]) left++;
                    while (left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
//    四数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int k=0;k<nums.length;k++){
            if(nums[k]>target&&nums[k]>0){
                break;
            }
            if(k>0&&nums[k-1]==nums[k]){
                continue;
            }
            for(int i=k+1;i<nums.length;i++){
                if(nums[k]+nums[i]>target&&nums[k]+nums[i]>=0){
                    break;
                }
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                int left=i+1;
                int right=nums.length-1;
                while(left<right){
                    long sum=(long)nums[k]+nums[i]+nums[left]+nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        // 对nums[left]和nums[right]去重
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
