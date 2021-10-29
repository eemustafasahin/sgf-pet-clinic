package guru.springframework.sgfpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by M.Şahin on 24/10/2021
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity { //pet type and specialty tables are reference tables

    @Column(name = "description")
    private String description;

}
