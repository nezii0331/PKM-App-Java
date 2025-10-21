//respond for taking datas from database
//interact with databases（Database、JSON 、API、cache）
package com.fran.pkm.repository;

import java.time.LocalDateTime;
import com.fran.pkm.model.entity.Note;
import java.util.List;
import java.util.Optional;

//design part
//1. what functions do users need
//2. what problem does the system need to address
//3. what scenarios are needed?
//4. what operations could be merged?
//5. what operations are required?

//According to the need to design the method sign
public interface NoteRepository{
    //basic CRUD(i.e. create, read, update, delete)
    Note create(Note note);
    boolean update(Note note);
    Optional<Note> findById(String id);
    List<Note> findAll();
    boolean delete(String id);
    //use boolean-this way api can respond with 200/404


    //while user searching
    List<Note> searchByKeyword(String keyword);
    List<Note> findByStatus(String status);
    List<Note> findByTag(String tag);
    List<Note> findByCreatedBetween(LocalDateTime start, LocalDateTime end);
}