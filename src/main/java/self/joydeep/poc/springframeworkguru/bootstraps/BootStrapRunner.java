package self.joydeep.poc.springframeworkguru.bootstraps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import self.joydeep.poc.springframeworkguru.domains.Author;
import self.joydeep.poc.springframeworkguru.domains.Book;
import self.joydeep.poc.springframeworkguru.domains.Publisher;
import self.joydeep.poc.springframeworkguru.repositories.AuthorRepository;
import self.joydeep.poc.springframeworkguru.repositories.BookRepository;
import self.joydeep.poc.springframeworkguru.repositories.PublisherRepository;

@Component
public class BootStrapRunner implements CommandLineRunner {
    private static final Logger logger= LoggerFactory.getLogger(BootStrapRunner.class);
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapRunner(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher=new Publisher("Rupa Publications","161, B-4, Ground Floor, Gulmohar House, Yusuf Sarai Community Centre","New Delhi","UP","110049");
        publisherRepository.save(publisher);
        Author author=new Author("Chetan","Bhagat");
        Book book=new Book("ISBN10001100","Five Point Someone");
        author.getBooks().add(book);
        book.getAuthors().add(author);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);
        authorRepository.save(author);
        bookRepository.save(book);

        publisherRepository.save(publisher);

        Author author2=new Author("HC","Verma");
        Book book2=new Book("ISBN674787388","Concepts of Physics");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);


        logger.info("Publisher count {}",publisherRepository.count());

        logger.info("Book count {}",bookRepository.count());
        logger.info("Author count {}",authorRepository.count());


    }
}
