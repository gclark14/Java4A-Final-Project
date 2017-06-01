/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Faculty extends Person{

    transient private static int facultyCount;
    private ArrayList<Student> students = new ArrayList<Student>(); 
    private ArrayList<Course> courses = new ArrayList<Course>();
    
    Faculty(){
        incFacultyCount();
    }

    public void addCourse(Course course){
        courses.add(course);
    }
    
    public void addStudent(Student stud){
        students.add(stud);
    }
    
    public ArrayList getStudents(){
        return students;
    }
    
    public void displayStudents(){
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).toString());
        }
    }
    
    public static int getFacultyCount() {
        return facultyCount;
    }

    private static void incFacultyCount() {
        facultyCount++;
    }
    
    public void displayCourses(){
        for(int i = 0; i < courses.size(); i++){
            System.out.println(courses.get(i).toString());
        }
    }
}