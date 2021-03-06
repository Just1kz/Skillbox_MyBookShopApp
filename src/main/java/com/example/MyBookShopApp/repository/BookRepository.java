package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBookByTitle(String title);

    List<Book> findBookByAuthorLastName(String name);

    List<Book> findBookByAuthorFirstName(String name);

    @Query(value = "SELECT * FROM books left join authors a on a.id = books.author_id "
            + "where lower(a.last_name) like '%' || :lastName || '%'",
            nativeQuery = true)
    List<Book> findBookByAuthorLastNameLowerCase(@Param("lastName") String lastName);

    @Query(value = "SELECT * FROM books left join authors a on a.id = books.author_id "
            + "where lower(books.title) like '%' || :title || '%'",
            nativeQuery = true)
    List<Book> findAllByTitleLowerCase(@Param("title") String title);

    List<Book> findAllByTitleContains(String title);

    @Query("from Book ")
    List<Book> customAllBooks();
}
