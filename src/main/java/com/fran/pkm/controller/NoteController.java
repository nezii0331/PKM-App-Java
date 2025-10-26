//This is REST API
package com.fran.pkm.controller; //tell java this file is in this package

import com.fran.pkm.model.entity.Note;
import com.fran.pkm.service.NoteService;

//import the tools in Spring Boot
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import java.time.LocalDateTime;
import java.util.List;


@RestController   //tell spring this is a API controller and then let return thing become JSON
@RequestMapping(path = "/api/notes")  //PATH

public class NoteController {

    private final NoteService noteService;  //helper from service layer
    // public NoteController(NoteService service){
    //     this.service = service;
    // }

    // @PostMapping
    // public ResponseEntity<ApiResponse<Note>> create (@Valid @RequestBody NoteRequest req){
    //     Note n = new Note();
    //     n.setTitle(req.getTitle());
    //     n.setContent(req.getContent());
    //     n.setTags(req.getTagsP());
    //     n.setStatus(req.getStatus());
    //     return ResponseEntity.ok(ApiResponse.ok(service.create(n)));
    // }

    // @GetMapping
    // public ResponseEntity<ApiResponse<List<Note>>> list{
    // }

    // @GetMapping
    // public 

    // @PutMapping{"/{id}"}
    // public ResponseBodyEmitter

    // @DeleteMapping

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    //=== create REQUESTBODY is to let JSON turn into object
    @PostMapping
    public Note create(@RequestBody Note note){  //id someone call POST /api/notes
        //call service to deal with logic(i.e. set id, createdAt, store)
        return noteService.createNote(note);  //this is to transfer to frontend
    }

    //=== read search all the notes
    @GetMapping 
    public List<Note> list(){
        return noteService.listNote();
    }

    //==== read (one) find single note
    @GetMapping ("/{id}")
    public ResponseEntity<Note> get(@PathVariable String id){
        return noteService.getNote(id)
        .map(ResponseEntity::ok)
        .orElseGet(( )->ResponseEntity.notFound().build());
    }


    //=== update
    @PutMapping ("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Note incoming){
        return noteService.getNote(id)
        .map(existing -> {
            // let parser from frontend to cover the old datas
            existing.setTitle(incoming.getTitle());
            existing.setContent(incoming.getContent());
            existing.setTags(incoming.getTags());
            existing.setStatus(incoming.getStatus());
            boolean ok = noteService.updateNote(existing);
            if (ok) {
                // succee：return 200，
                return ResponseEntity.ok(existing);
            } else {
                // no ok validate failed or store faile
                return ResponseEntity.badRequest().build();
            }
        })
        // can't find this id
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //delete
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        boolean ok = noteService.deleteNote(id); 
        return ok? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}