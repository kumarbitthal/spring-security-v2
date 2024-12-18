package kb.spsecurity.service;

import kb.spsecurity.model.Book;
import kb.spsecurity.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.isPresent() ? optionalBook.get() : new Book();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        book.setName(bookDetails.getName());
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        bookRepository.delete(book);
    }
}