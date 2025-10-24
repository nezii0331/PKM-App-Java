//respond for taking datas from database
//interact with databases（Database、JSON 、API、cache）
package com.fran.pkm.repository;

// import com.fasterxml.jackson.core.type.TypeReference;
// import com.fasterxml.jackson.databind.ObjectMapper;
import com.fran.pkm.model.entity.Note;
import org.springframework.stereotype.Repository;

// import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.io.File;



//this is to implement the link methods use file to store
@Repository
public class FileNoteRepository implements NoteRepository{
    //IMPLEMENT THE METHODS IN NOTEREPOSITORY
    //identifier the notes.json
    // private final String dataFileString = "data/notes.json";
    // private final File dataFile;
    //TODO: load()/save() 

     // === Fields ===
    private final File dataFile;                // only declare not use yet
    private final Map<String, Note> cache;      // simulate database

    // use map to simulate the database
    // private Map<String, Note> cache = new HashMap<>();

    // //constructor
    // // public FileNoteRepository(){
    // // }
        
    //     //check whether the file is there or not
    //     this.dataFile = new File("data/notes.json");
    //     dataFile.getParentFile().mkdirs();

        // === Constructor ===
        public FileNoteRepository() {
            this.dataFile = new File("data/notes.json");
            this.dataFile.getParentFile().mkdirs(); // ensure data directory exists
            this.cache = new HashMap<>();
        }


        // =======CRUD=========
        /** create one Note，succeed return Note's with id*/
        @Override
        public Note create(Note note){
            cache.put(note.getId(), note);
            return note;
        } 

        /** as note.id overwrite update，succeed getid as true；if can't find return false */
        @Override
        public boolean update(Note note){
            if(note == null || note.getId() == null){
                return false;
            }
            if(!cache.containsKey(note.getId())){
            return false;
            }
            cache.put(note.getId(), note);
            return true;
        }

        /** as id deleted，succeed return true；if can't finr return false */
        @Override
        public boolean delete(String id){
            if(id == null){
                return false;
            }
            return cache.remove(id) != null;
        }

         /** according id search，if can't find return Optional.empty() */
        @Override
        public Optional<Note> findById(String id) {
            if(id == null){
                return Optional.empty();
            }
            return Optional.ofNullable(cache.get(id));
        }

        /** Return all Notes（not sorted yet; decide later，descide afterword） */
        @Override
        public List<Note> findAll(){
            return new ArrayList<>(cache.values()); //return all notes
        }


        // ======= Queries =======
        //Search title / content（toLowerCase()）;
        @Override
        public List<Note> findByKeyword(String keyword){
            //avoid the Nullpointerexception
            if(keyword == null || keyword.isBlank()){
                return findAll();
            }
            String k = keyword.toLowerCase(); //all turn into not checking the ipper or lower cases.
            List<Note> result = new ArrayList<>(); 
            for (Note n :cache.values()){  // takeout all the notes
                if (n.getTitle().toLowerCase().contains(k)||  //see whether title or content include that verbs
                n.getContent().toLowerCase().contains(k)){
                    result.add(n); //if so then put it into the list.
                }
            }
            return result;
        }
        

        @Override
        public List<Note> findByStatus(String status){
            if(status == null){
                return List.of(); //return nothing
            }
            String s = status.toLowerCase();
            List<Note> result = new ArrayList<>();
            for(Note n :cache.values()){
                String st = n.getStatus();
                if(st != null && st.toLowerCase().contains(s)){
                    result.add(n);
                }
            }
            return result;
        }

        @Override
        public List<Note> findByTags(String tag){
            if(tag == null || tag.isBlank()){
                return List.of();
            }
            
            String t = tag.toLowerCase();
            List<Note> result = new ArrayList<>();
            for (Note n : cache.values()){
                List<String> tags = n.getTags(); 
                if (tags == null) {
                    continue; 
                }

                for (String each : tags) {
                    if (each != null && each.toLowerCase().equals(t)) {
                        result.add(n);
                        break; 
                    }
                }
            }
            return result;
        }

        @Override
        public List<Note> findByCreatedBetween(LocalDateTime start, LocalDateTime end){
            List<Note> result = new ArrayList<>();
            for(Note n : cache.values()){
                LocalDateTime c = n.getCreatedAt();
                if(c == null){
                    continue;
                }
                boolean geStart = (start == null) || !c.isBefore(start); // c >= start
                boolean leEnd   = (end == null)   || !c.isAfter(end);    // c <= end
                if (geStart && leEnd){
                    result.add(n);
                }
            }
            return result;
        }
    }