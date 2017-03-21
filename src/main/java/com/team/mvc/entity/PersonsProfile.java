package com.team.mvc.entity;

import javax.persistence.*;

@Entity
@Table(name="PERSONS_PROFILE")
public class PersonsProfile {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_seq_profile")
    @SequenceGenerator(name = "id_seq_profile", sequenceName = "PERSONS_PROFILE_SEQ")
    private int id;

    @Column(name="TYPE", length=30, unique=true, nullable=false)

    private String type = PersonsProfileType.USER.getPersonsProfileType();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof PersonsProfile))
            return false;
        PersonsProfile other = (PersonsProfile) obj;
        if (id != other.id)
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserProfile [id=" + id + ",  type=" + type  + "]";
    }
}
