package guru.springframework.sgfpetclinic.services.springdatajpa;

import guru.springframework.sgfpetclinic.model.Vet;
import guru.springframework.sgfpetclinic.repositories.VetRepository;
import guru.springframework.sgfpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 29/10/2021
 */
@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository m_vetRepository;

    public VetSDJpaService(VetRepository vetRepository)
    {
        m_vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll()
    {
        Set<Vet> vets = new HashSet<>();
        m_vetRepository.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet findById(Long id)
    {
        var opt = m_vetRepository.findById(id);

        return opt.orElse(null);
    }

    @Override
    public Vet save(Vet vet)
    {
        return m_vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet)
    {
        m_vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id)
    {
        m_vetRepository.deleteById(id);
    }
}
