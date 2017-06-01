/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this 
template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.util.ArrayList;
 
/**
 *
 * @author gabriel
 */
public class Student extends Person{
    
    private ArrayList<Course> courses = new ArrayList<Course>();
    transient private static int studCount;

    Student(){
        super();
        incStudentCount();
    }
    
    public ArrayList<Course> getCoursesByTerm(int t){
        ArrayList<Course> coursesByTerm = new ArrayList<Course>();
        for(int i = 0; i < courses.size();i++){
            if(courses.get(i).getTerm() == t){
                coursesByTerm.add(courses.get(i));
            }
        }
        return coursesByTerm;
    }
    
    public double getGPA(){
        ArrayList<Double> grades = new ArrayList<Double>();
        int classCount = 0;
        int sum = 0;
        for(int i = 0; i < courses.size();i++){
            classCount++;
            sum = sum + calcGPA(courses.get(i).cp.getTotalGrade());
        }
        
        return sum/classCount;
    }

    private int calcGPA(double grade){
        if(grade >= 90)
            return 4;
        else if(grade >= 80)
            return 3;
        else if(grade >= 70)    
            return 2;
        else return 0;
    }
    
    private void incStudentCount(){
        studCount++;
    }

    public static int getStudCount() {
        return studCount;
    }
    
    public void getCommonStudents(){
        ArrayList<Student> studs = new ArrayList<Student>();
        for(int i = 0; i < courses.size(); i++){
            studs.addAll(courses.get(i).getStudents());
        }
    }
    
    public void addCourse(Course course){
        courses.add(course);
    }
    
    public void displayCourses(){
        for(int i = 0; i < courses.size(); ++i){
            System.out.println(courses.get(i).cp.toString());
        }
    }

    public void printSchedule(){
        displayCourses();
    }

}