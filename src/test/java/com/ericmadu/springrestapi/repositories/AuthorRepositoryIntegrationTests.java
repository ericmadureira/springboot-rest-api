package com.ericmadu.springrestapi.repositories;

import com.ericmadu.springrestapi.TestDataUtil;
import com.ericmadu.springrestapi.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public class AuthorRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);
        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        underTest.save(authorC);
        Iterable<Author> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(authorA, authorB, authorC);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        Author author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        author.setName("Master Engineer");
        author.setAge(35);
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatAuthorCanBeDeleted() {
        Author author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        underTest.delete(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatGetAuthorsWithAgeLessThan() {
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);
        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        underTest.save(authorC);

        // Spring Data JPA inferred the query from the method name, looking for keywords like 'age' and 'LessThan'.
        Iterable<Author> result = underTest.ageLessThan(40);
        assertThat(result)
                .hasSize(2)
                .containsExactly(authorA, authorB);
    }

    @Test
    public void testThatGetAuthorsWithAgeGreaterThan() {
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);
        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        underTest.save(authorC);

        Iterable<Author> result = underTest.findAuthorsWithAgeGreaterThan(41);
        assertThat(result)
                .hasSize(1)
                .containsExactly(authorC);
    }
}
