package com.fran.pkm.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fran.pkm.model.entity.Note;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;



//this is to implement the link methods use file to store
public class FileNoteRepository implements NoteRepository{
    //IMPLEMENT THE METHODS IN NOTEREPOSITORY
    //identifier the notes.json
    // private final String dataFileString = "data/notes.json";
    // private final File dataFile;
    // private final 

     // === Fields ===
    private final File dataFile;                // 目前只是宣告，未使用
    private final Map<String, Note> cache;      // 模擬資料庫

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
            this.dataFile.getParentFile().mkdirs(); // 確保 data 資料夾存在
            this.cache = new HashMap<>();
        }


        // =======CRUD=========
        /** 建立一筆 Note，成功後回傳含 id 的 Note */
        @Override
        public Note create(Note note){
            cache.put(note.getId(), note);
            return note;
        } 

        /** 以 note.id 覆蓋更新，成功回 true；找不到回 false */
        @Override
        public boolean update(Note note){
            if(!cache.containsKey(note.getId())){
            return false;
            }
            cache.put(note.getId(), note);
            return true;
        }

        /** 依 id 刪除，成功回 true；找不到回 false */
        @Override
        public boolean delete(String id){
            return cache.remove(id) != null;
        }

         /** 依 id 查詢，找不到回 Optional.empty() */
        @Override
        public Optional<Note> findById(String id) {
            return Optional.ofNullable(cache.get(id));
        }

        /** 回傳所有 Notes（可先不排序，之後實作再決定） */
        @Override
        public List<Note> findAll(){
            return new ArrayList<>(cache.values()); //return all notes
        }
    }

        //搜尋 title / content（大小寫不敏感）
        @Override
        public List<Note> searchByKeyword(String keyword){
            if(keyword == null || null){
                return findAll();
            }
            if(note.getTitle() && note.getContent() && note.getSubject() ){
                note.searchByKeyword.add(results);
            }
        }

        @Override
        public List<Note> findByStatus(String status){
            if(status == null){
                return List.of; //return nothing
            }

            //TODO : IF NOT TAGS THEN RETURN LIST.OF()
            return note.getStatus();
        }

        // @Override
        // public List<Note> findByTag(String tag){
        //     return note.getTag();
        // }

        // @Override
        // public List<Note> findByCreatedBetween(LocalDateTime){
        //     //find 
        //     return createdAt();
        // }
