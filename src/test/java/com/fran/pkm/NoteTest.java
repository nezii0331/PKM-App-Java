package com.fran.pkm;

import org.junit.jupiter.api.Test; //tell JUnit this is a test method
import static org.junit.jupiter.api.Assertions.*; //tell JUnit to use the assertions
import com.fran.pkm.model.entity.Note; //tell JUnit to use the Note class

public class NoteTest {

     @Test  //tell JUnit this is a test method
     void testNoteConstructor() {

	//create new note obj
	Note note = new Note();

	// is this note here?
     assertNotNull(note);

	//is ID initialize?  // is not blank?
	assertNotNull(note.getId());
	assertFalse(note.getId().isBlank());

	// is this status right?
	assertEquals("Learning", note.getStatus());
	}
}

