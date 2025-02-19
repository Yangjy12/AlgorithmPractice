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
}
