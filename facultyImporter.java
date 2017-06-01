/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author rmarzolo1
 */
@XmlRootElement
public class facultyImporter {
    
    @XmlElement
    public int id;
    @XmlElement
    public String first_name;
    @XmlElement
    public String last_name;
    @XmlElement
    public String email;
    @XmlElement
    public String Address;
    @XmlElement
    public String hireddate;

}
