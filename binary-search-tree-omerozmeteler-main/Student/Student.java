package Student;

public class Student {// I created the java class with all the necessary attributes. I also implemented the getters and setters of these attributes.

    private int ID;
    private String Name;
    private String Surname;
    private int Age;
    private double GPA;
    private String surnameName;

    public Student(int ID,String Name,String Surname,int Age,double GPA){
        this.ID = ID;
        this.Name = Name;
        this.Surname = Surname;
        this.Age = Age;
        this.GPA = GPA;
        this.combineSurnameName();
    }
    public void combineSurnameName(){
        this.surnameName = getSurname()+","+getName();
    }

    public int getID() {
        return ID;
    }
    public double getGPA() {
        return GPA;
    }
    public int getAge() {
        return Age;
    }
    public String getName() {
        return Name;
    }
    public String getSurname() {
        return Surname;
    }
    public String getSurnameName() {
        return surnameName;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setAge(int age) {
        this.Age = age;
    }
    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public void setSurname(String surname) {
        this.Surname = surname;
    }

}
