/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gabriel
 */
public class Course implements Serializable {
    
    private String id;
    private String Description;
    private String Name;
    private int Term;
    
    protected CoursePoints cp = new CoursePoints();

    private ArrayList<Faculty> faculty = new ArrayList<Faculty>();
    private ArrayList<Student> students = new ArrayList<Student>();
    transient private static ArrayList<String> ids = new ArrayList<String>();
    
    Course(){
        setId();
        cp.setID(id);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("ID: " + id);
        builder.append("\nDescription: " + Description);
        builder.append("\nName: " + Name);
        builder.append("\nTerm: " + Term);
        return builder.toString();
    }
    
    public CoursePoints getCp() {
        return cp;
    }

    public void setCp(CoursePoints cp) {
        this.cp = cp;
    }
    
    public ArrayList getStudents(){
        return students;
    }
    
    public ArrayList getFacultyStudent(){
        return students;
    }
    
    public void addStudent(Student stud){
        students.add(stud);
    }
    
    public ArrayList getFaculty(){
        return faculty;
    }
    
    public void addFaculty(Faculty fac){
        faculty.add(fac);
    }
    
    public String getId() {
        return id;
    }

    public void setId() {
        Random rand = new Random();
        String ID = Integer.toString(rand.nextInt(999999999) + 100000000);
        if(ids.contains(ID)){
            setId();
        }
        else
            this.id = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void displayFaculty(){
        for(int i = 0; i < faculty.size(); i++){
            System.out.println(faculty.get(i).getFirst()
            + " " + faculty.get(i).getLast());
        }
    }
    
    public void displayStudents(){
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).getFirst()
            + " " + students.get(i).getLast());
        }
    }
    
    public int getTerm() {
        return Term;
    }

    public void setTerm(int Term) {
        this.Term = Term;
    }
    
    public void removeStudent(String id){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId().equals(id)){
                System.out.println("Removed: " + students.get(i).getId());
                students.remove(i);
                return;
            }
        }
    }
}
