/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Directory {
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Faculty> faculty = new ArrayList<Faculty>();
    
    public void serializeStudents() throws IOException{
        try (ObjectOutputStream fout = new ObjectOutputStream
                (new FileOutputStream("students.dat"))) {
            fout.writeObject(students);
        }
    }
    
    public void serializeCourses() throws IOException{
        try (ObjectOutputStream fout = new ObjectOutputStream
                (new FileOutputStream("courses.dat"))) {
            fout.writeObject(courses);
        }
    }
    
    public void serializeFaculty() throws IOException{
        try (ObjectOutputStream fout = new ObjectOutputStream
                (new FileOutputStream("faculty.dat"))) {
            fout.writeObject(faculty);
        }
    }
    
    public void serializeDirectory() throws IOException{
        serializeCourses();
        serializeFaculty();
        serializeStudents();
    }
    
    public void deserializeFaculty() throws ClassNotFoundException, IOException{
        File file = new File("faculty.dat");
        if(file.exists()){
            ObjectInputStream fin = new ObjectInputStream
                    (new FileInputStream(file));
            faculty = (ArrayList<Faculty>)fin.readObject();
        }
    }
    
    public void deserializeCourses() throws ClassNotFoundException, IOException{
        File file = new File("courses.dat");
        if(file.exists()){
            ObjectInputStream fin = new ObjectInputStream
                    (new FileInputStream("courses.dat"));
            courses = (ArrayList<Course>)fin.readObject();
        } 
    }
    
    public void deserializeStudents() throws ClassNotFoundException, IOException{
        File file = new File("students.dat");
        if(file.exists()){
            ObjectInputStream fin = new ObjectInputStream
                    (new FileInputStream(file));
            students = (ArrayList<Student>)fin.readObject();
        }
    }
    
    public void deserializeDirectory() throws ClassNotFoundException, IOException{
        deserializeFaculty();
        deserializeCourses();
        deserializeStudents();
    }
    
    public void loadDirectoryFromImporter(ArrayList courses, ArrayList students, ArrayList faculty){
        loadStudentsFromImporter(students);
        loadFacultyFromImporter(faculty);
        loadCourseInfoFromImporter(courses);
        loadCoursesToFaculty();
    }
    
    public void loadCourseInfoFromImporter(ArrayList importCourses){
        int j = 0;
        for(int i = 0; i < importCourses.size(); ++i){
            Course addCourse = new Course();
            courseImporter importCourse = (courseImporter) importCourses.get(i);
            
            // Transfer data fields
            addCourse.setDescription(importCourse.Description);
            addCourse.setName(importCourse.Name);
            // Changing the add faculty to be populated by my list of faculty.
            addCourse.addFaculty((Faculty)faculty.get(j % 15));
            addCourse.setTerm(importCourse.Term);
            courses.add(addCourse);
            j++;
        }
        
        for(j = 0; j < students.size(); j++){
            // so cheaky
            courses.get(j % importCourses.size()).addStudent((Student) students.get(j));
        }
    }
    
    public void loadStudentsFromImporter(ArrayList importStudents){
        int j = 0;
        for(int i = 0; i < importStudents.size(); ++i){
            Student addStud = new Student();
            studentImporter transferStud = (studentImporter) importStudents.get(i);
            
            // Transfer student data fields
            addStud.setFirst(transferStud.first_name);
            addStud.setLast(transferStud.last_name);
            addStud.setEmail(transferStud.email);
            addStud.setAddress(transferStud.address);
            // Transfer course data fields
        
            course transCourse = transferStud.courses.get(0);
            Course addCourse = new Course();
            addCourse.cp.setGradeFinal(transCourse.gradeFinal);
            addCourse.cp.setGradeHomework(transCourse.gradehomework);
            addCourse.cp.setGradeMidterm(transCourse.gradeMidTerm);
            addCourse.cp.setGradeQuiz(transCourse.gradequiz);
            addStud.addCourse(addCourse);
            students.add(addStud);
        }
    }
    
    public void loadFacultyFromImporter(ArrayList importFaculty){
        for(int i = 0; i < importFaculty.size(); ++i){
            Faculty addFac = new Faculty();
            facultyImporter fac = (facultyImporter) importFaculty.get(i);
            addFac.setAddress(fac.Address);
            addFac.setEmail(fac.email);
            addFac.setFirst(fac.first_name);
            addFac.setLast(fac.last_name);
            faculty.add(addFac);
        }
    }

    public void loadCoursesToFaculty(){
        for(int i = 0; i < courses.size();i++){
            faculty.get(i % faculty.size()).addCourse(courses.get(i));
        }
    }
    
    public void displayDirectorySize(){
        System.out.println("Students count: " + students.size());
        System.out.println("Faculty count: " + faculty.size());
        System.out.println("Courses count: " + courses.size());
    }
    
    public void displayDirectory(){
        System.out.println("----courses----");
        displayCourses();
        System.out.println("----students----");
        displayStudents();
        System.out.println("----faculty----");
        displayFaculty();
    }
    
    public void displayCourses(){
        System.out.println("Courses from directory size: " + courses.size());
        for(int i = 0; i < courses.size(); ++i){
            System.out.println(courses.get(i).toString());
            System.out.println("");
        }
    }
    
    public void displayStudents(){
        System.out.println("Students from directory size: " 
        + students.size());
        for(int i = 0; i < students.size(); ++i){
            System.out.println(students.get(i).toString());
            System.out.println("");
        }
    }

    public void displayStudentsWithGPA(){
        for(int i = 0;i < students.size();i++){
            System.out.println(students.get(i).toString());
            System.out.println("-----GPA-----");
            System.out.println(students.get(i).getGPA());
        }
    }
    
    public void displayStudentsWithCourses(){
        for(int i = 0; i < students.size(); ++i){
            System.out.println("----students-----");
            System.out.println(students.get(i).toString());
            System.out.println("-----courses----");
            students.get(i).displayCourses();
            System.out.println("");
        }
    }
    
    public void displayFacultyWithCourses(){
        for(int i = 0; i < faculty.size(); ++i){
            System.out.println("----faculty-----");
            System.out.println(faculty.get(i).toString());
            System.out.println("-----courses----");
            faculty.get(i).displayCourses();
            System.out.println("");
        }        
    }
    
    public void displayFaculty(){
        System.out.println("Faculty from directory size: " + faculty.size());
        for(int i = 0; i < faculty.size(); ++i){
            System.out.println(faculty.get(i).toString());
            System.out.println("");
        }
    }

    public void mergeCourses(){
        for(int i = 0; i < courses.size(); i++){
            
        }
    }
    
    public void addStudent(Student stud){
        students.add(stud);
    }

    public void addFaculty(Faculty fac){
        faculty.add(fac);
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void deleteCourse(String id){
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getId().equals(id)){
                courses.remove(i);
            }
        }
    }
    
    public void deleteStudent(String id){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId().equals(id)){
                students.remove(i);
            }
        }
    }

    public void deleteFaculty(String id){
        for(int i = 0; i < faculty.size(); i++){
            if(faculty.get(i).getId().equals(id)){
                faculty.remove(i);
            }
        }
    }
}