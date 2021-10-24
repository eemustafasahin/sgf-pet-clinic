package guru.springframework.sgfpetclinic.bootstrap;

import guru.springframework.sgfpetclinic.model.Owner;
import guru.springframework.sgfpetclinic.model.Pet;
import guru.springframework.sgfpetclinic.model.PetType;
import guru.springframework.sgfpetclinic.model.Vet;
import guru.springframework.sgfpetclinic.services.OwnerService;
import guru.springframework.sgfpetclinic.services.PetTypeService;
import guru.springframework.sgfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService m_ownerService;
    private final VetService m_vetService;
    private final PetTypeService m_petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService)
    {
        m_ownerService = ownerService;
        m_vetService = vetService;
        m_petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = m_petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = m_petTypeService.save(cat);

        System.out.println("Loaded PetTypes...");

        Owner owner1 = new Owner();
        //owner1.setId(1L); //we have auto-generated method for id values anymore. (getNextId())
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("+90 536 555 44 33");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthdate(LocalDate.now());
        mikesPet.setName("Misco");
        //following is done to sync both relationship.
        owner1.getPets().add(mikesPet);

        m_ownerService.save(owner1);

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glemanne");
        owner2.setAddress("124 Pickerel");
        owner2.setCity("Ankara");
        owner2.setTelephone("+90 535 555 44 33");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthdate(LocalDate.now());
        fionasPet.setName("Fisco");
        //following is done to sync both relationship.
        owner2.getPets().add(fionasPet);

        m_ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        m_vetService.save(vet1);

        Vet vet2 = new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        m_vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
