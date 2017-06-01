/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rmarzolo1
 */
@XmlRootElement
public class courseImporter {
    @XmlElement
    public int id;
    @XmlElement
    public String Description;
    @XmlElement
    public String Name;
    @XmlElement
    public String Faculty;	
    @XmlElement
    public int Term;

}
