package Tree;

import Student.Student;

public class TreeNode {

    protected TreeNode left;
    protected TreeNode right;
    protected int data;
    protected Student student;

    public TreeNode(Student student1){ //I changed the constructor to where it takes a Student as a parameter. I did this because this was my way of saving the Student identity in the tree.
        this.student = student1;
        this.data = student1.getID();
        this.left = null;
        this.right = null;
    }

    public Student getStudent(){
        return this.student;
    }
    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }

    public int getData(){
        return data;
    }

    public void setLeft(TreeNode left){
        this.left = left;
    }

    public void setRight(TreeNode right){
        this.right = right;
    }

    public TreeNode recursiveSearch(int value){
        if (data == value){
            return this;
        }
        if (value < data){
            if (left != null){
                return left.recursiveSearch(value);
            } else {
                return null;
            }
        } else {
            if (right != null){
                return right.recursiveSearch(value);
            } else {
                return null;
            }
        }
    }

    public TreeNode recursiveMinSearch(){
        if (left == null){
            return this;
        }
        return left.recursiveMinSearch();
    }

    public TreeNode recursiveMaxSearch(){
        if (right == null){
            return this;
        }
        return right.recursiveMaxSearch();
    }

    public void preorder(){
        System.out.println(data);
        if (left != null){
            left.preorder();
        }
        if (right != null){
            right.preorder();
        }
    }

    public void inorder(){
        if (left != null){
            left.inorder();
        }
        System.out.println(data);
        if (right != null){
            right.inorder();
        }
    }

    public void postorder(){
        if (left != null){
            left.postorder();
        }
        if (right != null){
            right.postorder();
        }
        System.out.println(data);
    }

    public void prettyPrint(int level){
        for (int i = 0; i < level; i++){
            System.out.print("\t");
        }
        System.out.println(data);
        if (left != null){
            left.prettyPrint(level + 1);
        }
        if (right != null){
            right.prettyPrint(level + 1);
        }
    }

    public void recursiveInsert(TreeNode node){
        if (node.getData() < data){
            if (left != null){
                left.recursiveInsert(node);
            } else {
                left = node;
            }
        } else {
            if (right != null){
                right.recursiveInsert(node);
            } else {
                right = node;
            }
        }
    }

}