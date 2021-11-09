package practice.learnkafkaconsumer.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import practice.learnkafkaconsumer.entity.LibraryEvent;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface LibraryEventRepo extends CrudRepository<LibraryEvent, Integer> {
}
