package guru.springframework.sgfpetclinic.repositories;

import guru.springframework.sgfpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by M.Şahin on 29/10/2021
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastname);
}
