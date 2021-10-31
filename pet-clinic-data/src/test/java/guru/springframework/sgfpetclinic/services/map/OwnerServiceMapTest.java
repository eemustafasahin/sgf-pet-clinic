package guru.springframework.sgfpetclinic.services.map;

import guru.springframework.sgfpetclinic.model.Owner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by M.Şahin on 31/10/2021
 */
@Slf4j
class OwnerServiceMapTest {

    OwnerServiceMap m_ownerServiceMap;

    private final Long ownerId = 1L;
    private final String firstName = "mustafa";
    private final String lastName = "şahin";

    @BeforeEach
    void setUp()
    {
        log.info("SetUp is called");
        m_ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        m_ownerServiceMap.save(Owner.builder().id(ownerId).firstName(firstName).lastName(lastName).build());
    }

    @Test
    void findAll()
    {
        log.info("findAll is called");
        Set<Owner> ownerSet = m_ownerServiceMap.findAll();

        assertEquals(1L, ownerSet.size());
    }

    @Test
    void findById()
    {
        log.info("findById is called");
        Owner owner = m_ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId()
    {
        log.info("saveExistingId is called");
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner savedOwner = m_ownerServiceMap.save(owner);
        assertEquals(2, savedOwner.getId());
    }

    @Test
    void saveNoId()
    {
        log.info("saveNoId is called");
        Owner owner = Owner.builder().build();
        Owner savedOwner = m_ownerServiceMap.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
        assertEquals(2, savedOwner.getId());
    }

    @Test
    void delete()
    {
        log.info("delete is called");
        m_ownerServiceMap.delete(m_ownerServiceMap.findById(ownerId));
        assertEquals(0, m_ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById()
    {
        log.info("deleteById is called");
        m_ownerServiceMap.deleteById(ownerId);
        assertEquals(0, m_ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName()
    {
        log.info("findByLastName is called");
        Owner owner = m_ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals("şahin",owner.getLastName().toLowerCase(Locale.ENGLISH));
    }
}