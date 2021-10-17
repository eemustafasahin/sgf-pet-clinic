package guru.springframework.sgfpetclinic.bootstrap;

import guru.springframework.sgfpetclinic.model.Owner;
import guru.springframework.sgfpetclinic.model.Vet;
import guru.springframework.sgfpetclinic.services.OwnerService;
import guru.springframework.sgfpetclinic.services.VetService;
import guru.springframework.sgfpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sgfpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService m_ownerService;
    private final VetService m_vetService;

    DataLoader()
    {
        m_ownerService = new OwnerServiceMap();
        m_vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception
    {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        m_ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glemanne");

        m_ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        m_vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        m_vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
