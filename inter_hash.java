import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class inter_hash {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash1=new int[1002];
        int[] hash2=new int[1002];
        for (int i:nums1) {
            hash1[i]++;
        }
        for (int i:nums2) {
            hash2[i]++;
        }
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < 1002; i++) {
            if (hash1[i]>0&&hash2[i]>0) {
                result.add(i);
            }
        }
//        将list转为int
        int index=0;
        int[] res=new int[result.size()];
        for (int i:result) {
            res[index++]=i;
        }
        return res;
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
//        hashset自动去重
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
