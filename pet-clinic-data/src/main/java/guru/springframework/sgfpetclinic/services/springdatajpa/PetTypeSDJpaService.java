package guru.springframework.sgfpetclinic.services.springdatajpa;

import guru.springframework.sgfpetclinic.model.PetType;
import guru.springframework.sgfpetclinic.repositories.PetTypeRepository;
import guru.springframework.sgfpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 29/10/2021
 */
@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository m_petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository)
    {
        m_petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll()
    {
        Set<PetType>  types = new HashSet<>();
        m_petTypeRepository.findAll().forEach(types::add);
        return types;
    }

    @Override
    public PetType findById(Long id)
    {
        return m_petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType type)
    {
        return m_petTypeRepository.save(type);
    }

    @Override
    public void delete(PetType type)
    {
        m_petTypeRepository.delete(type);
    }

    @Override
    public void deleteById(Long id)
    {
        m_petTypeRepository.deleteById(id);
    }
}
