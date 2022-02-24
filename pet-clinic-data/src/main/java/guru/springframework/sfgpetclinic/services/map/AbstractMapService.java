package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

// we want to allow the persistence layer - in this case the hash map, we are going to provide an ID setting strategy through an implementation
// yes we can extend the generics, our entity type now muss extend BaseEntity
public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
    // this map get the generics id and type
    // here is saying that the key in the map is going to be long and then whatever that T generic is going to be
    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    // return object out of the map
    T findById(ID id) {
        return map.get(id);
    }

    T save(T object){
        // object is going to be an implementation of the BaseEntity so the getId() method is going to be available
        if(object != null) {
            if(object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {

        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) +1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
