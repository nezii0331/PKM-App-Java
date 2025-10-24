//respond of details like define rules and validate datas, combine with mutiple repository's operation
//like defult value of id createdAt detail's detail
package com.fran.pkm.service;

import com.fran.pkm.model.entity.Note;
import com.fran.pkm.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.List;
// import com.fran.pkm.repository*;

@Service
public class NoteService{
	private final NoteRepository repo;

    //constructor
    public NoteService(NoteRepository repo){
	this.repo = Objects.requireNonNull(repo, "Repository cannot be null.");
    }

	//as a user i would like to create a note(include title content tag and status)
   	//1.create
    public Note createNote(Note note){
        if(note == null || note.getTitle() == null|| note.getTitle().isBlank()){
        throw new IllegalArgumentException("Title cannot be empty");
        } //tell user title cannot be null

        Note toSave = Note.newForCreate(
            note.getTitle(),
            note.getContent(),
            note.getStatus()
        );
        
        return repo.create(toSave);
	}

    //2.getnote
    //Read by id
    public Optional<Note> getNote(String id){
        if(id == null || id.isBlank()){
            return Optional.empty(); //return nothing
        }
        return repo.findById(id);
    } 

    //3. Deletenote
    public boolean deleteNote(String id){
        if(id == null || id.isBlank()){   //input check??
            return false;
        }
        return repo.delete(id);
    }

    //4. updatenote
    public boolean updateNote(Note note){
        if(note == null || note.getId() == null || note.getId().isBlank()){
            return false;
        }
        return repo.update(note);
    }

    //6.find all function
    public List<Note> listNote(){
        return repo.findAll();
    }

    public List<Note> searchNotes(String keyword){
        if(keyword == null || keyword.isBlank()){
            return List.of();
        }
        return repo.findByKeyword(keyword.trim());

    }
    
    public List<Note> findByStatus(String status){
        if(status == null || status.isBlank()){
            return List.of();
        }
        return repo.findByStatus(status.trim());
    }
    
    public List<Note> findByTags(String tag){
        if(tag == null || tag.isBlank()){
            return List.of();
        }
        return repo.findByTags(tag.trim());
    }
    
    public List<Note> findByCreatedBetween(LocalDateTime start, LocalDateTime end){
        return repo.findByCreatedBetween(start, end);
    }
    
}
