/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
/**
 *
 * @author rmarzolo1
 */
public class AppDataLoader {
    
    public ArrayList<facultyImporter> importedFaculty = new ArrayList<facultyImporter>();
    
    public ArrayList<studentImporter> importedStudents = new ArrayList<studentImporter>();
    
    // Holds courses that have descriptions, not grade breakdowns
    public ArrayList<courseImporter> importedCourses = new ArrayList<courseImporter>(); 
    
    //Update Your Paths As Neccesseary
    File studentFile = new File("studentData.xml");
    File facultyFile = new File("faculty.xml");
    File courseFile = new File("courses.xml");
       
  
    
    public void LoadData() throws JAXBException 
    { 
        //setup
        JAXBContext jaxbContext = JAXBContext.newInstance(datasetCourses.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        datasetCourses courses = (datasetCourses)unmarshaller.unmarshal(courseFile);
        
        //first do courses 
        System.out.println("----- course data load -------");
        //map courses
        for(courseImporter course : courses.record)
        {
            //load YOUR students here
            // this is adding course with descriptions
            System.out.println(course.Name);
            importedCourses.add(course);
        }
        
        jaxbContext = JAXBContext.newInstance(datasetStudent.class);
        unmarshaller = jaxbContext.createUnmarshaller();
        datasetStudent student = (datasetStudent)unmarshaller.unmarshal(studentFile);
        
        System.out.println("----- student data load -------");
        //you can map in students here. 
        for(studentImporter stude : student.record)
        {
            System.out.println(stude.first_name);
             System.out.println("----- student data load -------");
            System.out.println(stude.courses.get(0).gradehomework);
            importedStudents.add(stude);
        }
                
        jaxbContext = JAXBContext.newInstance(datasetFaculty.class);
        unmarshaller = jaxbContext.createUnmarshaller();
        datasetFaculty faculty = (datasetFaculty)unmarshaller.unmarshal(facultyFile);
        
        System.out.println("----- faculty data load -------");
        
        for(facultyImporter facu : faculty.record)
        {
            System.out.println(facu.first_name);
            importedFaculty.add(facu);
        }
        
        
    }
    
}
 
