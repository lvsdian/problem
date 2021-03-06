/*
 * @Author: lsd
 * @Date: 2020-02-22 21:54:06
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

import java.util.Stack;

public class 二叉搜索树与双向链表 {
    /**
     * 方法一，非递归
     */
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                pRootOfTree = p;
                pre = pRootOfTree;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }

    /**
     * 方法二，递归
     * left指向前指针，right为后指针
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        //将左子树转成链表，注意，此时left指向左子树链表的头
        TreeNode left = Convert(pRootOfTree.left);
        //让p移到链表末尾
        TreeNode p = left;
        while(p != null && p.right != null){
            p = p.right;
        }
        //将root放到p后面，p一定要移到末尾后才能放root
        if(left != null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        //right放到root后面
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return  left !=null ? left : pRootOfTree;
    }
}