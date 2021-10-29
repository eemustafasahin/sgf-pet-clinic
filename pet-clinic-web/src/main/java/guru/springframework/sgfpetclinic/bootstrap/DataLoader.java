package guru.springframework.sgfpetclinic.bootstrap;

import guru.springframework.sgfpetclinic.model.*;
import guru.springframework.sgfpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService m_ownerService;
    private final VetService m_vetService;
    private final PetTypeService m_petTypeService;
    private final SpecialtiesService m_specialtiesService;
    private final VisitService m_visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtiesService specialtiesService,
                      VisitService visitService)
    {
        m_ownerService = ownerService;
        m_vetService = vetService;
        m_petTypeService = petTypeService;
        m_specialtiesService = specialtiesService;
        m_visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        int count = m_petTypeService.findAll().size();
        if(count == 0)
            loadData();
    }

    private void loadData()
    {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = m_petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = m_petTypeService.save(cat);

        System.out.println("Loaded PetTypes...");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = m_specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = m_specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = m_specialtiesService.save(dentistry);

        System.out.println("Loaded Specialties...");

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

        Visit catVisit = new Visit();
        catVisit.setPet(fionasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        m_visitService.save(catVisit);

        System.out.println("Loaded catvisit...");

        Vet vet1 = new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        m_vetService.save(vet1);

        Vet vet2 = new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);

        m_vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
