package BST;

/**
 * Created by brandon on 11/15/2016.
 */
public class AVLTree {
    private MyTreeNode root;

    public AVLTree() {
        this.root = null;
    }

    public void add(Integer data) throws Exception {
        this.root = add(root, data);
    }

    private MyTreeNode add(MyTreeNode node, Integer data) throws Exception {
        if (node == null) {
            return new MyTreeNode(data);
        } else if (node.getData().equals(data)) {
            throw new Exception("Item is already in the tree");
        }

        if (data < node.getData()) {
            node.setLeft(add(node.getLeft(), data));

            if(1 <= node.getBalance() || node.getBalance() <= -1){
                //if(data < )
                if(data > node.getLeft().getData()){
                    node = rotateLR(node);
                }
                else node = rotateRight(node);
            }
        }else if (data > node.getData()) {
            node.setRight(add(node.getRight(),data));

            if(1 <= node.getBalance() || node.getBalance() <= -1){
                if(data < node.getRight().getData()){
                    node = rotateRL(node);
                }
                else node = rotateLeft(node);
            }
        }
        node.setHeight(compare(height(node.getRight()), height(node.getLeft())) + 1);
        node.setBalance(balance(node));
        return node;
    }

    private int height( MyTreeNode node) {
        return node == null ? 0 : node.getHeight();
    }

    private int compare(int one, int two) {
        return one > two ? one : two;
    }

    private int balance(MyTreeNode node){
        if(node.getLeft() == null && node.getRight() == null) return 0;
        if(node.getLeft() == null) return node.getRight().getHeight();
        if(node.getRight() == null) return node.getLeft().getHeight();
        return node.getLeft().getHeight() - node.getRight().getHeight();
    }

    private int solveHeight(MyTreeNode node){
        return compare(height(node.getLeft()), height(node.getRight())) + 1;
    }

    private void set(MyTreeNode node){
        node.setHeight(solveHeight(node));
        node.setBalance(balance(node));
    }

    private MyTreeNode rotateLR(MyTreeNode node) {
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
    }

    private MyTreeNode rotateRL(MyTreeNode node) {
        node.setRight(rotateRight(node.getRight()));
        return rotateLeft(node);
    }

    private MyTreeNode rotateLeft(MyTreeNode n) {
        MyTreeNode temp = n.getRight();
        n.setRight(temp.getLeft());
        temp.setLeft(n);
        n.setHeight(compare(height(n.getRight()), height(n.getLeft())) + 1);
        temp.setHeight(compare(height(temp.getRight()), n.getHeight()) + 1);
        temp.setBalance(balance(temp));
        n.setBalance(balance(n));
        return temp;
    }

    private MyTreeNode rotateRight(MyTreeNode n){
        MyTreeNode temp = n.getLeft();
        n.setLeft(temp.getRight());
        temp.setRight(n);
        n.setHeight(compare(height(n.getRight()), height(n.getLeft())) + 1);
        temp.setHeight(compare(height(temp.getLeft()), n.getHeight()) + 1);
        n.setBalance(balance(n));
        temp.setBalance(balance(temp));
        return temp;
    }

    public int greater(){
        return 0;
    }

    public boolean contains(Integer data) {
        return contains(root, data);
    }

    private boolean contains(MyTreeNode root, Integer data) {
        if (root == null) {
            return false;
        } else if (root.getData() < data) {
            return contains(root.getLeft(), data);
        } else if(root.getData() > data)  {
            return contains(root.getRight(), data);
        } else {
            return true;
        }
    }

    public String toString() {
        return toString(root);
    }

    /*private String toString(MyTreeNode root) {
        if (root == null) {
            return "";
        } else {
            return toString(root.getLeft()) + root.getData() + " " + toString(root.getRight());
        }
    }*/

    private String toString(MyTreeNode root) {
        if (root == null) {
            return "";
        } else {
            return toString(root.getLeft()) + root.getData() + " " + toString(root.getRight());
        }
    }

    private void print() {
        if (root != null) {
            root.print();
        }
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


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        try{

            tree.add(10);
            tree.add(20);
            tree.add(30);
            tree.add(40);
            tree.add(50);
            tree.add(60);
            tree.add(70);
            tree.add(80);
            tree.add(71);
            tree.add(61);
            tree.add(51);
            tree.add(41);
            tree.add(31);
            tree.add(21);
            tree.add(11);
        }catch (Exception e){
            System.out.println("OMG");
        }
        System.out.println(tree.toString());
        tree.print();
    }
}
