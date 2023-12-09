package BaseStruct.Test5;

public class BinarySearch {

    public int rs = 0;
    public int ls = 0;

    public void Search(int[] nums, int target, int left, int right, boolean type){
        int mid = left;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                if(type){
                    ls = mid;
                    right = mid - 1;
                }
                else{
                    rs = mid;
                    left = mid + 1;
                }
            }
            else{
                if(nums[mid] > target){
                    right = mid - 1;
                }
                else left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6, 6, 6, 6, 6, 6, 6, 9, 45, 213, 9023};
        BinarySearch bs = new BinarySearch();
        bs.Search(nums, 6, 0, nums.length - 1, true);
        bs.Search(nums, 6, 0, nums.length - 1, false);
        System.out.printf("left:%d right:%d %n", bs.ls, bs.rs);
    }
}
