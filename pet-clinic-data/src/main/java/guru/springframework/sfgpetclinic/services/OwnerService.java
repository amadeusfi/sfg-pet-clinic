package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

//<Owner, Long> are the generic types in CRUD service are <T,ID>

public interface OwnerService extends CrudService<Owner, Long> {



}
