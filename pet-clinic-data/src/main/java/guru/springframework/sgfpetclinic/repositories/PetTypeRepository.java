package guru.springframework.sgfpetclinic.repositories;

import guru.springframework.sgfpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by M.Şahin on 29/10/2021
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
