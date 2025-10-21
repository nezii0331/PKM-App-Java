//respond of details like define rules and validate datas, combine with mutiple repository's operation
//like defult value of id createdAt detail's detail
package com.fran.pkm.service;

import com.fran.pkm.model.entity.Note;
import com.fran.pkm.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;
import java.util.Optional;
// import com.fran.pkm.repository*;

public class NoteService{
	private final NoteRepository repo;

    //constructor
    public NoteService(NoteRepository repo){
	this.repo = Objects.requireNonNull(repo, "Repository cannot be null.");
    }

	//as a user i would like to create a note(include title content tag and status)
   	public Note createNote(Note note){
	if(note == null || note.getTitle() == null|| note.getTitle().isBlank()){
	throw new IllegalArgumentException("Title cannot be empty");
	} //tell user title cannot be null

    if (note.getId() == null || note.getId().isBlank()){
        note.setId(UUID.randomUUID().toString());
    }

    note.setCreatedAt(LocalDateTime.now());
    note.setUpdatedAt(LocalDateTime.now());

    if(note.getStatus() == null || note.getStatus().isBlank()){
        note.setStatus("Learning");
    }
    
    return repo.create(note);


	}

    //Read by id
    public Optional<Note> getNote(String id){
        if(id == null || id.isBlank()){
            return Optional.empty(); //return nothing
        }
        return repo.findById(id);
    } 

    //Delete
    public boolean deleteNote(String id){
        if(id == null || id.isBlank()){   //input check??
            return false;
        }
        return repo.delete(id);
    }

}
