/*
 * @Author: lsd
 * @Date: 2020-02-24 22:40:58
 * @Software: vscode
 * @Description: 
 * 
 */
package cn.andios.jianzhi;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Test57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right != null){
            TreeLinkNode pRight = pNode.right;
            while(pRight.left != null){
                pRight = pRight.left;
            }
            return pRight;
        }
        if(pNode.next !=null && pNode.next.left  == pNode){
            return pNode.next;
        }
        if(pNode.next != null){
            TreeLinkNode pNext = pNode.next;
            while(pNext.next != null && pNext.next.right == pNext){
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }
}