/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rmarzolo1
 */
@XmlRootElement
public class dataset{

    @XmlElement
    ArrayList<studentImporter> record = new ArrayList<studentImporter>();
    

}