package com.ericmadu.springrestapi.repositories;

import com.ericmadu.springrestapi.TestDataUtil;
import com.ericmadu.springrestapi.domain.Author;
import com.ericmadu.springrestapi.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public class BookRepositoryIntegrationTests {

    private BookRepository underTest;

    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA(author);
        underTest.save(book);
        Optional<Book> result = underTest.findById("1111-0000-1111");
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

//    @Test
//    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthorId(author.getId());
//        underTest.create(bookA);
//
//        Book bookB = TestDataUtil.createTestBookB();
//        bookB.setAuthorId(author.getId());
//        underTest.create(bookB);
//
//        Book bookC = TestDataUtil.createTestBookC();
//        bookC.setAuthorId(author.getId());
//        underTest.create(bookC);
//
//        List<Book> result = underTest.find();
//        assertThat(result)
//                .hasSize(3)
//                .containsExactly(bookA, bookB, bookC);
//    }
//
//    @Test
//    public void testThatBookCanBeUpdated() {
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book book = TestDataUtil.createTestBookA();
//        book.setAuthorId(author.getId());
//        underTest.create(book);
//
//        book.setTitle("Reborn as Code Master");
//
//        underTest.update(book.getIsbn(), book);
//        Optional<Book> result = underTest.findOne(book.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//    }
//
//    @Test
//    public void testThatBookCanBeDeleted() {
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book book = TestDataUtil.createTestBookA();
//        underTest.create(book);
//
//        underTest.delete(book.getIsbn());
//        Optional<Book> result = underTest.findOne(book.getIsbn());
//        assertThat(result).isEmpty();
//    }
}
