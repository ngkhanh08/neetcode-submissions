/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //y tuong su dung bfs, nhung dao thu tu duyert giua trai va con phai,
        // mot level se batr dau tuw node ben phai ngoai cung
        // Nhu vay,m moi khi level (node> > current.)

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while( !q.isEmpty()){
            TreeNode rightSide = null;
            int qLen = q.size();

            for (int i = 0; i < qLen; i++){
                TreeNode node = q.poll();
                if(node != null){
                    rightSide = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(rightSide != null){
                res.add(rightSide.val);
            }
        }
        return res;
    }
}
