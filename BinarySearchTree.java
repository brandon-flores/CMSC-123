/**
 *
 * @author localuser
 */
public class BinarySearchTree {

    private MyTreeNode root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        size = 0;
    }

    public MyTreeNode

    public void add(Integer data) throws Exception {
        root = add(root, data);
    }

    public MyTreeNode add(MyTreeNode root, Integer data) throws Exception {
        if (root == null) {
            root = new MyTreeNode(data);
        }else{
            if (contains(root, data)) {
                throw new Exception("Invalid use of add!");
            } else {
                if (data < root.data) {
                    root.setLeft(add(root.getLeft(), data));
                } else {
                    root.setRight(add(root.getRight(), data));
                    root.right = add(root.right, data);
                }
            }
        }
        return root;
    }



    /*public boolean remove(Integer data) {
        MyTreeNode temp = root;
        return removeTree(temp, data);
    }

    boolean removeTree (MyTreeNode root, int data){
        if(root == null){
            return false;
        }
        else{
            if(root.data.equals(data)){
                if(root.left == null && root.right == null){
                    root = null;
                    return true;
                }
                if(root.left != null && root.right != null){
                    root.data = getLeast(root.right);
                    return true;
                }
                if(root.left != null){
                    if(root.parent != null){
                        root.parent.left = root.left;
                    }
                    root = null;
                    return true;
                }
                if(root.right != null){
                    if(root.parent != null){
                        root.parent.right = root.right;
                    }
                    root = null;
                    return true;
                }
            }
        }
        if(data > root.data) return removeTree(root.right, data);
        return removeTree(root.left, data);
    }*/

    int getLeast(MyTreeNode root){
        if(root.left == null){
            int i = root.data;
            root = null;
            return i;
        }
        return getLeast(root.left);
    }

    public boolean contains(Integer data) {
        return contains(root, data);
    }

    private boolean contains(MyTreeNode root, Integer data) {
        if (root == null) {
            return false;
        } else {
            if (root.getData() < data) {
                return contains(root.getLeft(), data);
            } else if (root.getData() > data) {
                return contains(root.getRight(), data);
            } else {
                return true;
            }
        }
    }

    private String toString(MyTreeNode root){
        String fin = "";
        if(root == null){
            return "";
        }
        fin += toString(root.left);

        fin += toString(root.right);
        fin += root.data.toString();
        return fin;
    }

    public void display(MyTreeNode root){
        if(root != null){
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }

    }

    public MyTreeNode getRoot(){
        return root;
    }

    public int size() {
        return size;
    }

    private class MyTreeNode {

        private Integer data;
        private MyTreeNode left;
        private MyTreeNode right;
        private MyTreeNode parent;

        public MyTreeNode(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public MyTreeNode(Integer data, MyTreeNode left, MyTreeNode right, MyTreeNode parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
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

        public MyTreeNode getParent() {
            return parent;
        }

        public void setParent(MyTreeNode parent) {
            this.parent = parent;
        }

    }

    public static void main(String[] args) throws Exception {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(10);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.remove(5);
        tree.display(tree.getRoot());
        //System.out.println(tree.root);
    }
}
