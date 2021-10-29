package guru.springframework.sgfpetclinic.services.springdatajpa;

import guru.springframework.sgfpetclinic.model.Specialty;
import guru.springframework.sgfpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sgfpetclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 29/10/2021
 */
@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtiesService {

    private final SpecialtyRepository m_specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository)
    {
        m_specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll()
    {
        Set<Specialty> specialties = new HashSet<>();

        m_specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id)
    {
        return m_specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty specailty)
    {
        return m_specialtyRepository.save(specailty);
    }

    @Override
    public void delete(Specialty specailty)
    {
        m_specialtyRepository.delete(specailty);
    }

    @Override
    public void deleteById(Long id)
    {
        m_specialtyRepository.deleteById(id);
    }
}
