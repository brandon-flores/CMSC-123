package BST;

/**
 * Created by brandon on 11/11/2016.
 */
public class MyBinarySearchTree {

    private MyTreeNode root;

    public MyBinarySearchTree() {
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
        } else if (data > node.getData()) {
            node.setRight(add(node.getRight(), data));
        }
        return node;
    }

    public void remove(Integer data) {
        root = remove(root, data);
    }

    public MyTreeNode remove(MyTreeNode node, Integer data) {
        if (node == null){
            return null;
        }
        if(node.getData().equals(data)){
            if (node.getLeft() == null && node.getRight() == null){
                node = null;
                return null;
            }
            if(node.getLeft() != null && node.getRight() != null){
                int i = succ(node).getData();
                node.setData(i);
                node.setRight(remove(node.getRight(), i));
            }
            else{
                if(node.getRight() != null){
                    return node.getRight();
                }else{
                    return node.getLeft();
                }
            }
        }
        if(data > node.getData()) node.setRight(remove(node.getRight(), data));
        else node.setLeft(remove(node.getLeft(), data));
        return node;
    }

    private MyTreeNode succ(MyTreeNode node) {
        if (node == null) {
            return null;
        }
        return min(node.getRight());
    }

    private MyTreeNode min(MyTreeNode node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() == null) {
            return node;
        } else {
            return min(node.getLeft());
        }
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

    private String toString(MyTreeNode root) {
        if (root == null) {
            return "";
        } else {
            return toString(root.getLeft()) + root.getData() + " " + toString(root.getRight());
        }
    }


    private class MyTreeNode {
        private Integer data;
        private MyTreeNode left;
        private MyTreeNode right;

        public MyTreeNode(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public MyTreeNode(Integer data, MyTreeNode left, MyTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
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

    }
}

