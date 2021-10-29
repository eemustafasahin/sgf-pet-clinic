package guru.springframework.sgfpetclinic.services.map;

import guru.springframework.sgfpetclinic.model.Visit;
import guru.springframework.sgfpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by M.Şahin on 29/10/2021
 */
@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll()
    {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit)
    {
        if (visit == null)
            throw new RuntimeException("Visit object cannot be null.");

        if(visit.getPet() == null || visit.getPet().getOwner() == null ||
           visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid visit");

        return super.save(visit);
    }

    @Override
    public void delete(Visit visit)
    {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
