package springframework.petclinic.services.Map;

import org.hibernate.dialect.LobMergeStrategy;
import springframework.petclinic.Model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    T findById(ID id){
        return map.get(id);
    }
    T save(ID id,T object){
        if(object!=null){
            if(object.getId()==null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("object cannot be null");
        }

        return object;
    }
    void deleteById(ID id){
        map.remove(id);
    }
    void delete(T object){
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));

    }
    private Long getNextId(){
        Long nexId = null;
        try{
            nexId=Collections.max(map.keySet())+1;
        }catch(NoSuchElementException e){
            nexId = 1L;
        }
        return nexId;
    }
}
