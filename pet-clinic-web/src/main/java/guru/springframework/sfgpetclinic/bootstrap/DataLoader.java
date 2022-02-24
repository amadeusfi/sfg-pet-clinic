package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// initialize data
@Component // spring bean it gets registered in the spring context
public class DataLoader implements CommandLineRunner {


    // implement the 2 services
    private final OwnerService ownerService;
    private final VetService vetService;
    //@Autowired, just dont need because is constructor
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("El chavo");
        owner1.setLastName("Del8");

        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("La Chava");
        owner2.setLastName("Del9");

        ownerService.save(owner2);
        System.out.println("Loaded  owners " + owner1);

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1");
        vet1.setLastName("Dogueira");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2");
        vet2.setLastName("Gateira");

        vetService.save(vet2);

        System.out.println("Loaded vets " + vetService.findAll() );


    }
}
