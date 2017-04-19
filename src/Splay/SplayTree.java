package Splay;

/**
 * Created by brandon on 11/21/2016.
 */
public class SplayTree {
    private MyTreeNode root;

    public SplayTree() {
        this.root = null;
    }

    public void add(Integer data) throws Exception {
        this.root = add(root, data);
    }

    public MyTreeNode add(MyTreeNode node, int data) throws Exception {
        if(node == null)
            return new MyTreeNode(data);
        else if (node.getData().equals(data)) {
            throw new Exception("Item is already in the tree");
        }
        return null;
    }



    private class MyTreeNode {
        private Integer data;
        private MyTreeNode left;
        private MyTreeNode right;
        private int height;
        private int balance;

        public MyTreeNode(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
            this.balance = 0;
        }

        public void print() {
            print("", true);
        }

        private void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + data + "(b:" + balance + " h:" + height + ")");
            if (right != null) {
                right.print(prefix + (isTail ? "    " : "│   "), false);
            } else {
                System.out.println(prefix + (isTail ? "    " : "│   ") + (isTail ? "└── " : "├── "));
            }

            if (left != null) {
                left.print(prefix + (isTail ? "    " : "│   "), false);
            } else {
                System.out.println(prefix + (isTail ? "    " : "│   ") + (isTail ? "└── " : "├── "));
            }
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public MyTreeNode getLeft() {
            return left;
        }

        public void setLeft(MyTreeNode left) {
            this.left = left;
        }

        public MyTreeNode getRight() {
            return right;
        }

        public void setRight(MyTreeNode right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
}
