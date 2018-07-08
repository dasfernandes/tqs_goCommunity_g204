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
 * @author Dimitri
 */
@XmlRootElement
public class UtilizadorCreate {
    @XmlElement public String email;
    @XmlElement public String name;
    @XmlElement public String pwHash;

    public UtilizadorCreate(String name, String email, String pwHash) {
        this.email = email;
        this.name = name;
        this.pwHash = pwHash;
    }
    public UtilizadorCreate(){}

}
