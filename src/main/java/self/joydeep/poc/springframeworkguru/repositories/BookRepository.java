package self.joydeep.poc.springframeworkguru.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import self.joydeep.poc.springframeworkguru.domains.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
