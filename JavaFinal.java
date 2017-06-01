package javafinal;

import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author gabriel
 */
public class JavaFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Directory dir = new Directory();
        AppDataLoader app = new AppDataLoader();
        try{
//             If you need to load data, remove comments on your loader and comment my 
//             deserialize call on line 28.
//            app.LoadData();
//            ArrayList<courseImporter> courses = app.importedCourses;
//            ArrayList<facultyImporter> faculty = app.importedFaculty;
//            ArrayList<studentImporter> students = app.importedStudents;
            
//            dir.loadDirectoryFromImporter(courses, students, faculty);

            dir.deserializeDirectory();

            dir.serializeDirectory();
    
            dir.displayStudentsWithGPA();
        
            dir.displayDirectory();
            
            dir.displayDirectorySize();
        
        }catch(Exception ex) {
            //handle the error, and we know what kind of error
            System.out.println("General Exception");
            System.out.println(ex);            
            System.out.println("Serialization Error");
            System.out.println(ex);
        }
    }
}
