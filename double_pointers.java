import java.util.Arrays;

public class double_pointers {
//    力扣27. 移除元素
//    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

    //暴力解法
    public int removeElement(int[] nums, int val) {
        int size=nums.length;
        for (int i=0;i<size;i++){
            if (nums[i]==val){
                for (int j=i+1;j<size;j++){
                    nums[j-1]=nums[j];
                }
                i--;//因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                size--;
            }
        }
        return size;
    }
    //快慢指针
    public int removeElement2(int[] nums, int val) {
        int slow=0;
        for (int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

    //力扣26. 删除有序数组中的重复项
    //给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。

    public int removeElement3(int[] nums, int val) {
        int slow=1;
        for (int fast=1;fast<nums.length;fast++){
            if (nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

    //力扣283. 移动零
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    public void moveZeroes(int[] nums) {
        int slow=0;
        for (int fast=0;fast<nums.length;fast++){
            if (nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        for (int i=slow;i<nums.length;i++){
            nums[i]=0;
        }
    }
    //交换思想
    public void moveZeroes2(int[] nums) {
        int slow=0;
        for (int fast=0;fast<nums.length;fast++){
            if (nums[fast]!=0){
                swap(nums,slow,fast);
                slow++;
            }
        }


    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    //力扣844. 比较含退格的字符串
    //给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
    //注意：如果对空文本输入退格字符，文本继续为空。
    public boolean backspaceCompare(String s, String t) {
        return newString(s).equals(newString(t));
    }
    public String newString(String s){
        char[] s1=s.toCharArray();
        int slow=0;
        for (int fast=0;fast<s.length();fast++){
            if(s1[fast]!='#'){
                s1[slow]=s1[fast];
                slow++;
            }else if (slow>0){
                slow--;
            }
        }
//        注意这里要用new String，否则返回的是地址，并且要写从0到slow，因为slow指向的是最后一个字符的下一个位置
        return new String(s1,0,slow);
    }

    //力扣977. 有序数组的平方
    //给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    public int[] sortedSquares(int[] nums) {
        int left=0,right=nums.length-1;
        int[] result=new int[nums.length];
        while (left<=right){
            for (int k= nums.length-1;k>=0;k--){
                if (nums[left]*nums[left]<=nums[right]*nums[right]){
                    result[k]=nums[right]*nums[right];
                    right--;
                }else {
                    result[k]=nums[left]*nums[left];
                    left++;
                }
            }
        }
        return result;
    }

}
