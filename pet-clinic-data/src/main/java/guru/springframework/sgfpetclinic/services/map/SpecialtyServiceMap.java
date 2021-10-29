package guru.springframework.sgfpetclinic.services.map;

import guru.springframework.sgfpetclinic.model.Specialty;
import guru.springframework.sgfpetclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by M.Şahin on 24/10/2021
 */

@Service
@Profile({"default","map"})
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtiesService {
    @Override
    public Set<Specialty> findAll()
    {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object)
    {
        return super.save(object);
    }

    @Override
    public void delete(Specialty object)
    {
        super.save(object);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
