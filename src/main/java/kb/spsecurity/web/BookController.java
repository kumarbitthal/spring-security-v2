package kb.spsecurity.web;

import kb.spsecurity.dto.ApiResponse;
import kb.spsecurity.model.Book;
import kb.spsecurity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET: "/book" - Accessible by ROLE_USER or ROLE_ADMIN
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        ApiResponse<List<Book>> response = new ApiResponse<>(books, true);
        return ResponseEntity.ok(response);
    }

    // POST: "/book" - Accessible by ROLE_ADMIN
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse<Book>> createBook(@RequestBody Book book) {
        Book savedBook = bookService.createBook(book);
        ApiResponse<Book> response = new ApiResponse<>(savedBook, true);
        return ResponseEntity.ok(response);
    }

    // PUT: "/book" - Accessible by ROLE_ADMIN
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse<Book>> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(id, bookDetails);
        ApiResponse<Book> response = new ApiResponse<>(updatedBook, true);
        return ResponseEntity.ok(response);
    }

    // DELETE: "/book" - Accessible by ROLE_ADMIN
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse<Void>> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        ApiResponse<Void> response = new ApiResponse<>(null, true);
        return ResponseEntity.ok(response);
    }
}