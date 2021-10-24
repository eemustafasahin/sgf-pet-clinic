package guru.springframework.sgfpetclinic.services.map;

import guru.springframework.sgfpetclinic.model.PetType;
import guru.springframework.sgfpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by M.Şahin on 24/10/2021
 */

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll()
    {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object)
    {
        return super.save(object);
    }

    @Override
    public void delete(PetType object)
    {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
