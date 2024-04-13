class Solution {
    public int maxArea(int[] height) {
        int left =0,right = height.length - 1,maxarea = 0;
        while(left < right){
            int currentarea = Math.min(height[left],height[right])* (right - left);
            maxarea = Math.max(maxarea,currentarea);
            if(height[left] > height[right]) right--;
            else left++;
        }
        return maxarea;
    }
}