package com.ericmadu.springrestapi.repositories;

import com.ericmadu.springrestapi.TestDataUtil;
import com.ericmadu.springrestapi.domain.entities.AuthorEntity;
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
public class AuthorEntityRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorEntityRepositoryIntegrationTests(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        AuthorEntity authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);
        AuthorEntity authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);
        AuthorEntity authorC = TestDataUtil.createTestAuthorC();
        underTest.save(authorC);
        Iterable<AuthorEntity> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(authorA, authorB, authorC);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        AuthorEntity author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        author.setName("Master Engineer");
        author.setAge(35);
        underTest.save(author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatAuthorCanBeDeleted() {
        AuthorEntity author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        underTest.delete(author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatGetAuthorsWithAgeLessThan() {
        AuthorEntity authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);
        AuthorEntity authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);
        AuthorEntity authorC = TestDataUtil.createTestAuthorC();
        underTest.save(authorC);

        // Spring Data JPA inferred the query from the method name, looking for keywords like 'age' and 'LessThan'.
        Iterable<AuthorEntity> result = underTest.ageLessThan(40);
        assertThat(result)
                .hasSize(2)
                .containsExactly(authorA, authorB);
    }

    @Test
    public void testThatGetAuthorsWithAgeGreaterThan() {
        AuthorEntity authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);
        AuthorEntity authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);
        AuthorEntity authorC = TestDataUtil.createTestAuthorC();
        underTest.save(authorC);

        Iterable<AuthorEntity> result = underTest.findAuthorsWithAgeGreaterThan(41);
        assertThat(result)
                .hasSize(1)
                .containsExactly(authorC);
    }
}
