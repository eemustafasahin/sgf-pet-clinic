package guru.springframework.sgfpetclinic.services.springdatajpa;

import guru.springframework.sgfpetclinic.model.Owner;
import guru.springframework.sgfpetclinic.repositories.OwnerRepository;
import guru.springframework.sgfpetclinic.repositories.PetRepository;
import guru.springframework.sgfpetclinic.repositories.PetTypeRepository;
import guru.springframework.sgfpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by M.Şahin on 29/10/2021
 */
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository m_ownerRepository;
    private final PetRepository m_petRepository;
    private final PetTypeRepository m_petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository)
    {
        m_ownerRepository = ownerRepository;
        m_petRepository = petRepository;
        m_petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastname)
    {
        return m_ownerRepository.findByLastName(lastname);
    }

    @Override
    public Set<Owner> findAll()
    {
        Set<Owner> owners = new HashSet<>();

        m_ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(Long id)
    {
        Optional<Owner> ownerOptional = m_ownerRepository.findById(id);

        return ownerOptional.orElse(null);
    }

    @Override
    public Owner save(Owner owner)
    {
        return m_ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner)
    {
        m_ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id)
    {
        m_ownerRepository.deleteById(id);
    }
}
