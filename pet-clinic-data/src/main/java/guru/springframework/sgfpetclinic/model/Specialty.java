package guru.springframework.sgfpetclinic.model;

/**
 * Created by M.Şahin on 24/10/2021
 */
public class Specialty extends BaseEntity{

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
