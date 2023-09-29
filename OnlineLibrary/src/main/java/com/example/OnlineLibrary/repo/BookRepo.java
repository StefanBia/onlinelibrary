package com.example.OnlineLibrary.repo;

import com.example.OnlineLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {
   // void deleteBookById(Long id);

    Optional<Book> findBookById(Long id);

   // void deleteBookById(Long id);
}
