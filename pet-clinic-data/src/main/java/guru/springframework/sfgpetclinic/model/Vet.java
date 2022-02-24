package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
    private Set<Specialty> specilities = new HashSet<>();

    public Set<Specialty> getSpecilities() {
        return specilities;
    }

    public void setSpecilities(Set<Specialty> specilities) {
        this.specilities = specilities;
    }
}
