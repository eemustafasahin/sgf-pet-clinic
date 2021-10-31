package guru.springframework.sgfpetclinic.services.map;

import guru.springframework.sgfpetclinic.model.Owner;
import guru.springframework.sgfpetclinic.model.Pet;
import guru.springframework.sgfpetclinic.services.OwnerService;
import guru.springframework.sgfpetclinic.services.PetService;
import guru.springframework.sgfpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


/*
    - aktif profile olmaz ise burası default profile belirtildiği için servis olarak bu bean geçilir.
    - eğer default profile yoksa yani profile belirtilmemiş ise ikiside çağrılmaz. Çünkü "map" profile
    "map" profile aktif olduğunda çağrılır. "springdatajpa" profile "springdatajpa" profile aktif
     olduğunda çağılır.

    - *** yani profile belirtmiyor isek ya profile olmayan bir Service impl yazmalıyız ve onu servis
    etmeliyiz veya profile belirtilen bir impl. default olarak seçmeliyiz ki default olarak o servis
    geçilsin.

    - 2021-10-29 16:22:49.674  INFO 11804 --- [  restartedMain] g.s.s.SgfPetClinicApplication
               : No active profile set, falling back to default profiles: default


 */
@Profile({"default","map"})
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService m_petTypeService;
    private final PetService m_petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService)
    {
        m_petTypeService = petTypeService;
        m_petService = petService;
    }

    @Override
    public Set<Owner> findAll()
    {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object)
    {
        if (object != null){
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(m_petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = m_petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                });
            }
            return super.save(object);
        }
        else
            return null;
    }

    @Override
    public void delete(Owner object)
    {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastname)
    {
        return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastname))
                .findFirst().orElse(null);
    }
}
