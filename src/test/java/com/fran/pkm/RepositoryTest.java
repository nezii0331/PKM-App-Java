package com.fran.pkm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; //tell JUnit to use the assertions
import com.fran.pkm.model.entity.Note; //tell JUnit to use the Note class
import com.fran.pkm.repository.FileNoteRepository;
public class RepositoryTest {
   
    @Test
    void testNoteConstructor(){
        FileNoteRepository repo = new FileNoteRepository();

        Note n = new Note();
        n.setTitle("Java Map");
        n.setContent("Use HashMap for CRUD");
        n.setStatus("Learning");
        n.getTags().add("java");
        repo.create(n);

        Note z = new Note();
        z.setTitle("Spring Data JPA");
        z.setContent("Repository pattern");
        z.setStatus("Learning");
        z.getTags().add("spring");
        repo.create(z);

        // Test searchByKeyword
        assertEquals(1, repo.findByKeyword("repo").size());
        
        // Test findByStatus
        assertEquals(2, repo.findByStatus("learning").size());
        
        // Test findByTag
        assertEquals(1, repo.findByTags("spring").size());
        
        // Test findById
        assertTrue(repo.findById(n.getId()).isPresent());
        assertEquals("Java Map", repo.findById(n.getId()).get().getTitle());
        
        // Test update
        n.setTitle("Updated Java Map");
        assertTrue(repo.update(n));
        assertEquals("Updated Java Map", repo.findById(n.getId()).get().getTitle());
        
        // Test delete
        assertTrue(repo.delete(n.getId()));
        assertFalse(repo.findById(n.getId()).isPresent());
        
        // Test findAll
        assertEquals(1, repo.findAll().size());
    }

}
