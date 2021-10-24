package guru.springframework.sgfpetclinic.services.map;

import guru.springframework.sgfpetclinic.model.Specialty;
import guru.springframework.sgfpetclinic.model.Vet;
import guru.springframework.sgfpetclinic.services.SpecialtiesService;
import guru.springframework.sgfpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtiesService m_specialtiesService;

    public VetServiceMap(SpecialtiesService specialtiesService)
    {
        m_specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll()
    {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object)
    {
        if (object.getSpecialties().size() > 0){
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = m_specialtiesService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object)
    {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}