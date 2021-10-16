package guru.springframework.sgfpetclinic.services;

import guru.springframework.sgfpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastname);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findall();
}
