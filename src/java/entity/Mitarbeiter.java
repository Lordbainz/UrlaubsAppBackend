/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lordbenz
 */
@Entity
@Table(name = "MITARBEITER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mitarbeiter.findAll", query = "SELECT m FROM Mitarbeiter m")
    , @NamedQuery(name = "Mitarbeiter.findById", query = "SELECT m FROM Mitarbeiter m WHERE m.id = :id")
    , @NamedQuery(name = "Mitarbeiter.findByPersonalnumber", query = "SELECT m FROM Mitarbeiter m WHERE m.personalnumber = :personalnumber")
    , @NamedQuery(name = "Mitarbeiter.findByFirstname", query = "SELECT m FROM Mitarbeiter m WHERE m.firstname = :firstname")
    , @NamedQuery(name = "Mitarbeiter.findByLastname", query = "SELECT m FROM Mitarbeiter m WHERE m.lastname = :lastname")
    , @NamedQuery(name = "Mitarbeiter.findByEmail", query = "SELECT m FROM Mitarbeiter m WHERE m.email = :email")
    , @NamedQuery(name = "Mitarbeiter.findByHolydays", query = "SELECT m FROM Mitarbeiter m WHERE m.holydays = :holydays")})
public class Mitarbeiter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONALNUMBER")
    private String personalnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LASTNAME")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOLYDAYS")
    private int holydays;

    public Mitarbeiter() {
    }

    public Mitarbeiter(Integer id) {
        this.id = id;
    }

    public Mitarbeiter(Integer id, String personalnumber, String firstname, String lastname, String email, int holydays) {
        this.id = id;
        this.personalnumber = personalnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.holydays = holydays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonalnumber() {
        return personalnumber;
    }

    public void setPersonalnumber(String personalnumber) {
        this.personalnumber = personalnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHolydays() {
        return holydays;
    }

    public void setHolydays(int holydays) {
        this.holydays = holydays;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mitarbeiter)) {
            return false;
        }
        Mitarbeiter other = (Mitarbeiter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mitarbeiter[ id=" + id + " ]";
    }
    
}
