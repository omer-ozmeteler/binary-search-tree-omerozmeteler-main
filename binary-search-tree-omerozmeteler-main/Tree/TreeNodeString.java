package Tree;
import Student.Student;
public class TreeNodeString {

    protected TreeNodeString left;
    protected TreeNodeString right;
    protected String surnameName;
    protected Student student;

    public TreeNodeString(Student student1){ //I changed the constructor to where it takes a Student as a parameter. I did this because this was my way of saving the Student identity in the tree.
        this.student = student1;
        this.surnameName = student1.getSurnameName();
        this.left = null;
        this.right = null;
    }
    public Student getStudent(){
        return this.student;
    }

    public TreeNodeString getLeft(){
        return left;
    }

    public TreeNodeString getRight(){
        return right;
    }

    public String getSurnameName(){
        return surnameName;
    }

    public void setLeft(TreeNodeString left){
        this.left = left;
    }

    public void setRight(TreeNodeString right){
        this.right = right;
    }

    public TreeNodeString recursiveSearch(String value){
        int result = this.surnameName.compareTo(value);
        if (result == 0){
            return this;
        }
        if (result < 0){
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

    public TreeNodeString recursiveMinSearch(){
        if (left == null){
            return this;
        }
        return left.recursiveMinSearch();
    }

    public TreeNodeString recursiveMaxSearch(){
        if (right == null){
            return this;
        }
        return right.recursiveMaxSearch();
    }

    public void preorder(){
        System.out.println(surnameName);
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
        System.out.println(surnameName);
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
        System.out.println(surnameName);
    }

    public void prettyPrint(int level){
        for (int i = 0; i < level; i++){
            System.out.print("\t");
        }
        System.out.println(surnameName);
        if (left != null){
            left.prettyPrint(level + 1);
        }
        if (right != null){
            right.prettyPrint(level + 1);
        }
    }

    public void recursiveInsert(TreeNodeString node){
        int result = surnameName.compareTo(node.getSurnameName());
        if (result > 0){
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