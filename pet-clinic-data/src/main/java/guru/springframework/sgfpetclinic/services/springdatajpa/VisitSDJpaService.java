package guru.springframework.sgfpetclinic.services.springdatajpa;

import guru.springframework.sgfpetclinic.model.Visit;
import guru.springframework.sgfpetclinic.repositories.VisitRepository;
import guru.springframework.sgfpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 29/10/2021
 */

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository m_visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository)
    {
        m_visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll()
    {
        Set<Visit> visits = new HashSet<>();
        m_visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id)
    {
        return m_visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit)
    {
        return m_visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit)
    {
        m_visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id)
    {
        m_visitRepository.deleteById(id);
    }
}
