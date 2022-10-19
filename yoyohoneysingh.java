class Solution {
    public int maxArea(int[] height) {
        if(height.length==1)
            return 0;
        int slow=0, fast=height.length-1;
        int max=0;
        while(slow!=fast){
            int res=(fast-slow)*(height[slow]<height[fast]?height[slow]:height[fast]);
            if(res>max)
                max=res;
            if(height[slow]<height[fast])
                slow++;
            else
                fast--;
        }
        return max;
    }
}