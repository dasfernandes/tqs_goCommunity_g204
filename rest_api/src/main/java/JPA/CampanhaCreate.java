/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
* @author root
*/
@XmlRootElement
public class CampanhaCreate {
    @XmlElement public String title;
    @XmlElement public String description;
    @XmlElement public double goal;
    @XmlElement public Long user_id;

}
