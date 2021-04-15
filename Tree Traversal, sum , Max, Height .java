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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<Integer>();
        postorder(root,al);
        System.out.println(size(root));
         System.out.println(sum(root));
        System.out.println(max(root));
         System.out.println(height(root));
        return al;
        
    }
    public void postorder(TreeNode root, List<Integer> al){
        if(root!=null){
            if(root.left!=null){
                postorder(root.left,al);
            }
            if(root.right!=null){
                postorder(root.right,al);
                
            }
            al.add(root.val);
        }
    }
    public int size(TreeNode root){
        if(root==null)
            return 0;
        int leftside = size(root.left);
        int rightside = size(root.right);
        int total = leftside+rightside+1;
        return total;
      
    }
    public int sum(TreeNode root){
        if(root==null)
            return 0;
        int leftside = sum(root.left);
        int rightside = sum(root.right);
        int total = leftside+rightside+root.val;
        return total;
    }
     public int max(TreeNode root){
        if(root==null)
            return Integer.MIN_VALUE;
        int curr = 0;
        int leftMax = max(root.left);
        int rightMax = max(root.right);
        int final_max = Math.max(root.val,Math.max(leftMax,rightMax));
        return final_max;
    }
    public int height(TreeNode root){
        if(root==null)
            return -1;
        int rightDepth = height(root.right);
        int leftDepth = height(root.left);
        int final_height = Math.max(rightDepth,leftDepth)+1;
        return final_height;
    }
}