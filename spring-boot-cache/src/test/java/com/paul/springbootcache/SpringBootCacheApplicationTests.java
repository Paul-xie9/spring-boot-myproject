package com.paul.springbootcache;

import com.paul.springbootcache.dao.BookDao;
import com.paul.springbootcache.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootCacheApplicationTests {
    @Autowired
    BookDao bookDao;

    @Test
    void contextLoads() {
        bookDao.getBookById(1L);
        bookDao.getBookById(1L);

        bookDao.updateBook(new Book(2L,"name2","author2"));
        bookDao.getBookById(2L);

        bookDao.deleteBook();
    }
}
