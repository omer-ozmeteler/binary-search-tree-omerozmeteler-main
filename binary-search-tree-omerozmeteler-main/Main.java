import Student.Student;
import Tree.Tree;
import Tree.TreeString;
import Tree.TreeNode;
import Tree.TreeNodeString;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Student.Student;
public class Main {

    public static void main(String[] args){
        Tree ID = new Tree();
        TreeString surnameName = new TreeString();
        try {                               // This part goes through the file and adds the students into their respective trees.
            File myObj = new File("C:\\Users\\TEMP\\IdeaProjects\\binary-search-tree-omerozmeteler\\random_data.csv");
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter(",");
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String x = myReader.nextLine();
               String[] array = x.split(",");
               Student student1 = new Student(Integer.parseInt(array[0]),array[1],array[2],Integer.parseInt(array[3]),Double.parseDouble(array[4]));
               ID.recursiveInsert(new TreeNode(student1));
               surnameName.recursiveInsert(new TreeNodeString(student1));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        //Student student1 = ID.iterativeSearchStudent(100001);       //These are all my test cases.
        //Student student2 = surnameName.iterativeSearchStudent("Aguirre,Dustin Morris");
        Student[] studentIDList = ID.intervalSearch(999871,999999);
        Student[] studentSurnameNameList = surnameName.intervalSearch("Johnson,Chris Garrett","Johnson,Christine Tate"); // I tested the test cases. It works but it needs to have a comma in between the surname and the name because that is how it is in the .csv file.
        System.out.println("a");
    }
}