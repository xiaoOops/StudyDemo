package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * 26:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @date 2019/6/19
 */
public class HasSubtree {


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为null的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                //以这个根节点为为起点判断是否包含Tree2
                result = checkIfTreeHasSub(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        //返回结果
        return result;
    }

    private boolean checkIfTreeHasSub(TreeNode node1, TreeNode node2) {
        //如果tree1遍历完了但tree2还没有，说明不包含tree2
        if (node1 == null && node2 != null) {
            return false;
        }
        //如果tree2遍历完了，说明包含tree2
        if (node2 == null) {
            return true;
        }

        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }
        //再分别去匹配左右节点
        return checkIfTreeHasSub(node1.left, node2.left) && checkIfTreeHasSub(node1.right, node2.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}





















