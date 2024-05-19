class removeElement {
    
    public static int removing(int[] nums, int val) {

        int k = 0;

        for(int i=0; i<nums.length;i++){
            if(nums[i] != val){
                nums[k++]=nums[i];
            }
        }

        return k;
    }

    public static void main(String[] args) {
        
        int[] nums = {3,2,2,3};
        System.out.println(removing(nums, 3)); //2 (meaning 2 values are left after removing the number 3)

        int[] nums2 = {0,1,2,2,3,0,4,2};
        System.out.println(removing(nums2, 2)); //5 (meaning 5 values are left after removing the number 2)
    }
}