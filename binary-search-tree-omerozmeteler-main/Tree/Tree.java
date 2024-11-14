package Tree;
import Student.Student;
public class Tree {

    final static int LEFT = 0;
    final static int RIGHT = 1;

    protected TreeNode root;

    public Tree(){
        root = null;
    }

    public TreeNode getRoot(){
        return root;
    }

    public void setRoot(TreeNode root){
        this.root = root;
    }

    public TreeNode recursiveSearch(int value){
        if (root != null){
            return root.recursiveSearch(value);
        } else {
            return null;
        }
    }

    public TreeNode iterativeSearch(int value){
        TreeNode tmp = root;
        while (tmp != null){
            if (value < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                if (value > tmp.getData()){
                    tmp = tmp.getRight();
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }

    public Student iterativeSearchStudent(int value){ //This method is for exact searching.
        TreeNode tmp = root;
        while (tmp != null){
            if (value < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                if (value > tmp.getData()){
                    tmp = tmp.getRight();
                } else {
                    return tmp.getStudent();
                }
            }
        }
        return null;
    }

    public Student[] intervalSearch(int lowerLimit,int upperLimit){ //This is the method for interval searching. The node count is found and a student array of size node count is formed.
        TreeNode tmp = root;
        int nodeCount = countNodesInRange(tmp,lowerLimit,upperLimit);
        Student[] studentList = new Student[nodeCount];
        int[] i = {0};
        searchWithinInterval(tmp,lowerLimit,upperLimit,studentList,i);
        return studentList;
    }

    public void searchWithinInterval(TreeNode node,int lowerLimit,int upperLimit,Student[] studentList,int[] i){ //This method is called in the intervalSearch method.It searches the desired value within the given interval.
        if(node == null){
            return;
        }
        if(node.getData() >= lowerLimit){
            searchWithinInterval(node.getLeft(),lowerLimit,upperLimit,studentList,i);
        }
        if(node.getData() >= lowerLimit && node.getData() <= upperLimit){
            studentList[i[0]++] = node.getStudent();
        }
        if(node.getData() <= upperLimit){
            searchWithinInterval(node.getRight(),lowerLimit,upperLimit,studentList,i);
        }
    }
    public int countNodesInRange(TreeNode node,int lowerLimit,int upperLimit){ //This method counts the amount of nodes within the desired range.
        if(node == null){
            return 0;
        }
        int count = 0;
        if(node.getData() >= lowerLimit && node.getData() <= upperLimit){
            count = 1;
        }
        count += countNodesInRange(node.getLeft(),lowerLimit,upperLimit);
        count += countNodesInRange(node.getRight(),lowerLimit,upperLimit);
        return count;
    }

    public TreeNode iterativeMinSearch(){
        TreeNode tmp = root;
        TreeNode parent = null;
        while (tmp != null) {
            parent = tmp;
            tmp = tmp.getLeft();
        }
        return parent;
    }

    public TreeNode iterativeMaxSearch(){
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.getRight() == null){
                return tmp;
            }
            tmp = tmp.getRight();
        }
        return null;
    }

    public TreeNode recursiveMinSearch(){
        if (root != null){
            return root.recursiveMinSearch();
        }
        return null;
    }

    public TreeNode recursiveMaxSearch(){
        if (root != null){
            return root.recursiveMaxSearch();
        }
        return null;
    }

    protected TreeNode getParent(TreeNode node){
        TreeNode x = root, parent = null;
        while (x != node){
            parent = x;
            if (x.data > node.data){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return parent;
    }

    public void delete(int value){
        TreeNode y, x = root, parent;
        while (x.data != value){
            if (x.data > value){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        parent = getParent(x);
        while (true){
            if (x.left != null){
                y = x.left.recursiveMaxSearch();
                parent = getParent(y);
            } else {
                if (x.right != null){
                    y = x.right.recursiveMinSearch();
                    parent = getParent(y);
                } else {
                    if (parent == null){
                        root = null;
                    } else {
                        if (parent.left == x){
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                    break;
                }
            }
            x.data = y.data;
            x = y;
        }
    }

    public void inorder(){
        if (root != null){
            root.inorder();
        }
    }

    public void preorder(){
        if (root != null){
            root.preorder();
        }
    }

    public void postorder(){
        if (root != null){
            root.postorder();
        }
    }

    protected void insertChild(TreeNode parent, TreeNode child){
        if (parent == null) {
            root = child;
        } else {
            if (child.data < parent.data) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }

    public void iterativeInsert(TreeNode node){
        TreeNode parent = null;
        TreeNode tmp = root;
        while (tmp != null) {
            parent = tmp;
            if (node.getData() < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        insertChild(parent, node);
    }

    public void recursiveInsert(TreeNode node){
        if (root == null){
            root = node;
        } else {
            root.recursiveInsert(node);
        }
    }

    public void prettyPrint(){
        if (root != null){
            root.prettyPrint(0);
        }
    }

    /*public int nodeCountWithStack(){
        TreeNode tmp;
        int count = 0;
        Stack c = new Stack(100);
        if (root != null){
            c.push(new Element(root));
        }
        while (!c.isEmpty()){
            Element e = c.pop();
            count++;
            tmp = e.getData();
            if (tmp.getLeft() != null){
                c.push(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null){
                c.push(new Element(tmp.getRight()));
            }
        }
        return count;
    }

    public int nodeCountWithQueue(){
        TreeNode tmp;
        int count = 0;
        Queue c = new Queue(100);
        if (root != null){
            c.enqueue(new Element(root));
        }
        while (!c.isEmpty()){
            Element e = c.dequeue();
            count++;
            tmp = e.getData();
            if (tmp.getLeft() != null){
                c.enqueue(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null){
                c.enqueue(new Element(tmp.getRight()));
            }
        }
        return count;
    }*/

}