/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;
import java.util.ArrayList;
import javafinal.course;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
/**
 *
 * @author rmarzolo1
 */
@XmlRootElement
public class studentImporter {

    @XmlElement
    public int id;
    @XmlElement
    public String first_name;
    @XmlElement
    public String last_name;
    @XmlElement
    public String email;
    @XmlElement
    public String address;
    @XmlElement
    public String zip;

    // These are of the percentage points, not the types with descriptions
    @XmlElement(name="course")
    @XmlElementWrapper(name="courses")
    public ArrayList<course> courses = new ArrayList<course>();
}
