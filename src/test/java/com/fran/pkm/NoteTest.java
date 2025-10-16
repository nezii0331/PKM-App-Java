package com.fran.pkm;

import org.junit.jupiter.api.Test; //tell JUnit this is a test method
import static org.junit.jupiter.api.Assertions.*; //tell JUnit to use the assertions
import com.fran.pkm.model.entity.Note; //tell JUnit to use the Note class
import java.util.*;

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

	//is there a title?
	assertNotNull("", note.getTitle());
	//check whether there are one title to be set?
	//set is void no return 
	note.setTitle("Week one - Linux Basics" );
	assertEquals("Week one - Linux Basics", note.getTitle());

	// is this status right?
	assertEquals("Learning", note.getStatus());
	
	}

	@Test
	void testCommands(){
		Note note = new Note();
		List<String> commands = new ArrayList<>();
		commands.add("ls -al");
		commands.add("pwd");

		note.setCommands(commands);

		assertNotNull(note.getCommands());
		assertEquals(2, note.getCommands().size());
		assertTrue(note.getCommands().contains("pwd"));
	}
}

