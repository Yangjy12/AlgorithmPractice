
public class binary_search {
    //力扣第702题
    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
    //写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }

    //力扣35.搜索插入位置
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    //如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    public int search2(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]==target){
                return mid;
            }
        }
//        if (target<nums[0]){
//                return 0;
//        }
        return right+1;
    }

//    力扣34. 在排序数组中查找元素的第一个和最后一个位置
//    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//    如果数组中不存在目标值 target，返回 [-1, -1]。
//    进阶：你可以设计并实现时间复杂度为 $O(\log n)$ 的算法解决此问题吗？
    public int[] search3(int[] nums, int target) {
        int rightBorder=getRightBorder(nums, target);
        int leftBorder=getLeftBorder(nums, target);
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        if (rightBorder-leftBorder>1){return new int[]{leftBorder+1, rightBorder-1};}
        return new int[]{-1, -1};

    }
    public int getLeftBorder(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int leftBorder=-2;
        while(left<=right){ //这里有等号，是为了能区分包含target和不包含target ，如果不加=，那么如果数组里不包含target，leftborder和rightborder也是相等的，最后无法进行区分二者
            //但是加了=之后，如果num里包含target，那么rightborder与leftborder之间总会差2以上
            int mid=left+(right-left)/2;
            if (nums[mid]>=target){
                right=mid-1;
                leftBorder=right;
            }else {
                left=mid+1;
            }
        }
        return leftBorder;
    }
    public int getRightBorder(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int rightBorder=-2;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
                rightBorder=left;
            }
        }
        return rightBorder;
    }

    public static void main(String[] args) {
        binary_search obj = new binary_search();
        int[] nums = {1,2,3,4,6,7,8,9};
        int target=2;
        System.out.println(obj.search3(nums,target));

    }
}
