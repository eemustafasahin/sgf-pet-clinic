package guru.springframework.sgfpetclinic.services.springdatajpa;

import guru.springframework.sgfpetclinic.model.Pet;
import guru.springframework.sgfpetclinic.repositories.PetRepository;
import guru.springframework.sgfpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 29/10/2021
 */
@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository m_petRepository;

    public PetSDJpaService(PetRepository petRepository)
    {
        m_petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll()
    {
        Set<Pet> pets = new HashSet<>();
        m_petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id)
    {
        return m_petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet)
    {
        return m_petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet)
    {
        m_petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id)
    {
        m_petRepository.deleteById(id);
    }
}
