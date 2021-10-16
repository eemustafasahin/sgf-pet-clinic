package guru.springframework.sgfpetclinic.services;

import guru.springframework.sgfpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findall();
}
