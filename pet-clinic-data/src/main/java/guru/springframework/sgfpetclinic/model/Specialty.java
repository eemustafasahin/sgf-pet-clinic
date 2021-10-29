package guru.springframework.sgfpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by M.Şahin on 24/10/2021
 */
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity { //pet type and specialty tables are reference tables

    @Column(name = "description")
    private String description;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
