package guru.springframework.sgfpetclinic.controller;

import guru.springframework.sgfpetclinic.model.Owner;
import guru.springframework.sgfpetclinic.services.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by M.Şahin on 01/11/2021
 */
@ExtendWith(MockitoExtension.class) //open mocks by default
class OwnerControllerTest {

    @Mock
    private OwnerService m_ownerService;

    @InjectMocks
    private OwnerController m_controller;

    private Set<Owner> owners;

    MockMvc m_mockMvc;

    @BeforeEach
    void setUp()
    {
         owners = new HashSet<>();
         owners.add(Owner.builder().id(1L).build());
         owners.add(Owner.builder().id(2L).build());

         m_mockMvc = MockMvcBuilders.standaloneSetup(m_controller).build();
    }

    @Test
    void listOwners() throws Exception
    {
        when(m_ownerService.findAll()).thenReturn(owners);

        m_mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.view().name("owners/index"))
                .andExpect(MockMvcResultMatchers.model().
                        attribute("owners", Matchers.hasSize(2)));
    }

    @Test
    void findOwners() throws Exception
    {
        m_mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("notImplemented"));

        verifyNoInteractions(m_ownerService);
    }
}