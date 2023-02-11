package com.example.projrct5.repstory;

import com.example.projrct5.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepstory extends JpaRepository<Book,Integer> {
    Book findByIdEquals(Integer id);
    List<Book> findByStore_Id(Integer id);
    List<Book> findByGenre(String genre);
}
