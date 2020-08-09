/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    int count;
    public int totalNQueens(int n) {
        count = 0;
        getList(0,0,0,0,n);
        return count;    
    }
    
    private void getList(int left, int right, int col, int row, int n) {
        if(row == n) {
            count++;
            return;
        }
        int mask1 = (1<<n) - 1;
        int mask = (left|right|col)&(mask1);
        if(mask == mask1) return;
        for(int i  = 0; i < n; i++) {
            int new_mask = 1 << (n-i-1);
            if((mask&new_mask) > 0) continue;
            getList((left|new_mask) << 1, (right|new_mask) >> 1, (col|new_mask), row+1, n);
        }
    }
}
// @lc code=end

