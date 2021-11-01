package guru.springframework.sgfpetclinic.services.springdatajpa;

import guru.springframework.sgfpetclinic.model.Owner;
import guru.springframework.sgfpetclinic.repositories.OwnerRepository;
import guru.springframework.sgfpetclinic.repositories.PetRepository;
import guru.springframework.sgfpetclinic.repositories.PetTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by M.Şahin on 01/11/2021
 */
@Slf4j
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private Owner returnedOwner;
    private static final String FIRST_NAME = "mustafa";
    private static final String LAST_NAME = "şahin";

    @Mock
    private OwnerRepository m_ownerRepository;

    @Mock
    private PetRepository m_petRepository;

    @Mock
    private PetTypeRepository m_petTypeRepository;

    @InjectMocks
    OwnerSDJpaService m_ownerSDJpaService;

    @BeforeEach
    void setUp()
    {
        returnedOwner = Owner.builder().id(1L).firstName(FIRST_NAME).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName()
    {
        when(m_ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

        Owner me = m_ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME,me.getLastName());
        verify(m_ownerRepository).findByLastName(any());

    }

    @Test
    void findAll()
    {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        returnedOwnerSet.add(Owner.builder().build());
        returnedOwnerSet.add(Owner.builder().build());

        when(m_ownerRepository.findAll()).thenReturn(returnedOwnerSet);

        Set<Owner> owners = m_ownerSDJpaService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById()
    {
        when(m_ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));

        Owner owner = m_ownerSDJpaService.findById(returnedOwner.getId());
        assertNotNull(owner);
        assertEquals(1, owner.getId());
    }

    @Test
    void findByIdNotFound()
    {
        when(m_ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = m_ownerSDJpaService.findById(returnedOwner.getId());
        assertNull(owner);

    }

    @Test
    void save()
    {
        when(m_ownerRepository.save(any())).thenReturn(returnedOwner);

        Owner savedOwner = m_ownerSDJpaService.save(returnedOwner);

        assertNotNull(savedOwner);
        assertEquals(1, returnedOwner.getId());
        verify(m_ownerRepository).save(returnedOwner);
    }

    @Test
    void delete()
    {
        m_ownerSDJpaService.delete(returnedOwner);
        verify(m_ownerRepository).delete(any());
    }

    @Test
    void deleteById()
    {
        m_ownerSDJpaService.deleteById(returnedOwner.getId());
        verify(m_ownerRepository).deleteById(anyLong());
    }
}