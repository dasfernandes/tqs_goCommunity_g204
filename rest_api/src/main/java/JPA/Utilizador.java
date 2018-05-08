/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table (name="UTILIZADOR")
@XmlRootElement
public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NAME")
    private String name;

    @Column(name = "SUMDONATED")
    private Double sumdonated;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PWHASH")
    private String pwhash;
    
    @OneToMany(
        mappedBy = "utilizador",
        cascade = CascadeType.ALL,
        orphanRemoval = true    
    )
    private List<Donation> donations = new ArrayList<>();
    
    public Utilizador() {
    }

    
    public Utilizador(String name, double sumdonated, String email, String pwhash){
        this.name=name;
        this.sumdonated=sumdonated;
        this.email=email;
        this.pwhash=pwhash;
        
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSumdonated() {
        return sumdonated;
    }

    public void setSumdonated(Double sumdonated) {
        this.sumdonated = sumdonated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwhash() {
        return pwhash;
    }

    public void setPwhash(String pwhash) {
        this.pwhash = pwhash;
    }

    @XmlTransient
    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
    
    public void addDonation(Donation donation){
        donations.add(donation);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilizador other = (Utilizador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "id=" + id + ", name=" + name + ", sumdonated=" + sumdonated + ", email=" + email + ", pwhash=" + pwhash + '}';
    }


    
}
