package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// initialize data
@Component // spring bean it gets registered in the spring context
public class DataLoader implements CommandLineRunner {


    // implement the services
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    //@Autowired, just dont need because is constructor

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);


        Specialty dentistry = new Specialty();
        radiology.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("El chavo");
        owner1.setLastName("Del8");
        owner1.setAddress("Barril");
        owner1.setCity("LaVecindad");
        owner1.setTelephone("123321");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("La Chava");
        owner2.setLastName("Del9");
        owner2.setAddress("Barril");
        owner2.setCity("LaVecindad");
        owner2.setTelephone("123321");

        Pet fionasCat = new Pet();
        fionasCat.setName("FionasCat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(saveCatPetType);
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        System.out.println("Loaded  owners ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1");
        vet1.setLastName("Dogueira");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2");
        vet2.setLastName("Gateira");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets " + vetService.findAll());
    }
}
