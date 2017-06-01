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
 * @author xps-1
 */
  @XmlRootElement
public class course {
      @XmlElement
    public int ID;
        @XmlElement
    public int gradehomework;
          @XmlElement
    public int gradequiz;
            @XmlElement
    public int gradeMidTerm;
              @XmlElement
    public int gradeFinal;
}
