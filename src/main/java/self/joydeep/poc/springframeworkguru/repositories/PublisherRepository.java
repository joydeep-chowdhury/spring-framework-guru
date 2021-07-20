package self.joydeep.poc.springframeworkguru.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import self.joydeep.poc.springframeworkguru.domains.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
