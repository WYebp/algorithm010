/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (70.57%)
 * Likes:    494
 * Dislikes: 0
 * Total Accepted:    54.3K
 * Total Submissions: 77K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自
 * 百度百科 - 皇后 ）
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();
        if(n < 1) return boards;
        int col = 0, aDiag = 0, diag = 0;

        dfs(n, 0, new ArrayList<>(), boards, col, aDiag, diag);
        return boards;
    }

    private void dfs(int n, int row, List<String> board, List<List<String>> boards,int col, int aDiag, int diag){
        //recursion terminator
        if(row >= n) {
            boards.add(new ArrayList<>(board));
            return;
        }
        //get available spots for the current row
        int bits = (~(col | aDiag | diag)) & ((1 << n) - 1);
            
        while(bits > 0){
            int p = bits & -bits;
            int pos = Integer.toBinaryString(p).length();
            
            char[] boardRow = new char[n];
            Arrays.fill(boardRow, '.');
            boardRow[n - pos] = 'Q';
          
            board.add(String.valueOf(boardRow));
            dfs(n, row + 1, board, boards, col | p, (aDiag | p) << 1, (diag | p) >> 1);
            board.remove(board.size() - 1);
            
            bits &= bits - 1;
        }
    }
}
// @lc code=end

