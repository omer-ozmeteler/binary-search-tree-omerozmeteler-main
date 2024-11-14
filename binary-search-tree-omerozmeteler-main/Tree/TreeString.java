package Tree;
import Student.Student;
public class TreeString {

    final static int LEFT = 0;
    final static int RIGHT = 1;

    protected TreeNodeString root;

    public TreeString(){
        root = null;
    }

    public TreeNodeString getRoot(){
        return root;
    }

    public void setRoot(TreeNodeString root){
        this.root = root;
    }

    public TreeNodeString recursiveSearch(String value){
        if (root != null){
            return root.recursiveSearch(value);
        } else {
            return null;
        }
    }

    public TreeNodeString iterativeSearch(String value){
        TreeNodeString tmp = root;
        int result = tmp.getSurnameName().compareTo(value);
        while (tmp != null){
            result = tmp.getSurnameName().compareTo(value);
            if (result < 0){
                tmp = tmp.getRight();
            } else {
                if (result > 0){
                    tmp = tmp.getLeft();
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }
    public Student iterativeSearchStudent(String value){ //This method is for exact searching.
        TreeNodeString tmp = root;
        int result = tmp.getSurnameName().compareTo(value);
        while (tmp != null){
            result = tmp.getSurnameName().compareTo(value);
            if (result < 0){
                tmp = tmp.getRight();
            } else {
                if (result > 0){
                    tmp = tmp.getLeft();
                } else {
                    return tmp.getStudent();
                }
            }
        }
        return null;
    }
    public Student[] intervalSearch(String lowerLimit,String upperLimit){ //This is the method for interval searching. The node count is found and a student array of size node count is formed.
        TreeNodeString tmp = root;
        int nodeCount = countNodesinRange(tmp,lowerLimit,upperLimit);
        Student[] studentList = new Student[nodeCount];
        int[] i = {0};
        searchWithinInterval(tmp,lowerLimit,upperLimit,studentList,i);
        return studentList;
    }
    public void searchWithinInterval(TreeNodeString node, String lowerLimit,String upperLimit,Student[] studentList,int[] i){ //This method is called in the intervalSearch method.It searches the desired value within the given interval.
        if(node == null){
            return;
        }
        int result = node.getSurnameName().compareTo(lowerLimit); //should be positive
        int result1 = node.getSurnameName().compareTo(upperLimit); //should be negative
        if(result >= 0){
            searchWithinInterval(node.getLeft(),lowerLimit,upperLimit,studentList,i);
        }
        if(result >= 0 && result1 <= 0){
            studentList[i[0]++] = node.getStudent();
        }
        if(result1 <= 0){
            searchWithinInterval(node.getRight(),lowerLimit,upperLimit,studentList,i);
        }
    }
    public int countNodesinRange(TreeNodeString node ,String lowerLimit,String upperLimit){ //This method counts the amount of nodes within the desired range.
        if(node == null){
            return 0;
        }
        int count = 0;
        int result = node.getSurnameName().compareTo(lowerLimit);
        int result1 = node.getSurnameName().compareTo(upperLimit);
        if(result >= 0 && result1 <= 0){
            count = 1;
        }
        count += countNodesinRange(node.getLeft(),lowerLimit,upperLimit);
        count += countNodesinRange(node.getRight(),lowerLimit,upperLimit);
        return count;
    }
    public TreeNodeString iterativeMinSearch(){
        TreeNodeString tmp = root;
        TreeNodeString parent = null;
        while (tmp != null) {
            parent = tmp;
            tmp = tmp.getLeft();
        }
        return parent;
    }

    public TreeNodeString iterativeMaxSearch(){
        TreeNodeString tmp = root;
        while (tmp != null) {
            if (tmp.getRight() == null){
                return tmp;
            }
            tmp = tmp.getRight();
        }
        return null;
    }

    public TreeNodeString recursiveMinSearch(){
        if (root != null){
            return root.recursiveMinSearch();
        }
        return null;
    }

    public TreeNodeString recursiveMaxSearch(){
        if (root != null){
            return root.recursiveMaxSearch();
        }
        return null;
    }

    protected TreeNodeString getParent(TreeNodeString node){
        TreeNodeString x = root, parent = null;
        int result = x.getSurnameName().compareTo(node.getSurnameName());
        while (x != node){
            result = x.getSurnameName().compareTo(node.getSurnameName());
            parent = x;
            if (result > 0){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return parent;
    }

    public void delete(String value){
        TreeNodeString y, x = root, parent;
        int result = x.getSurnameName().compareTo(value);
        while (result != 0){
            result = x.getSurnameName().compareTo(value);
            if (result > 0){
                x = x.left;
            } else if(result < 0){
                x = x.right;
            } else if (result == 0){
                x = x;
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
            x.surnameName = y.surnameName;
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

    protected void insertChild(TreeNodeString parent, TreeNodeString child){
        int result = parent.getSurnameName().compareTo(child.getSurnameName());
        if (parent == null) {
            root = child;
        } else {
            if (result > 0) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }

    public void iterativeInsert(TreeNodeString node){
        TreeNodeString parent = null;
        TreeNodeString tmp = root;
        int result = tmp.getSurnameName().compareTo(node.getSurnameName());
        while (tmp != null) {
            result = tmp.getSurnameName().compareTo(node.getSurnameName());
            parent = tmp;
            if (result > 0){
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        insertChild(parent, node);
    }

    public void recursiveInsert(TreeNodeString node){
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