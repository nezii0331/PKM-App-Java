package com.fran.pkm.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

/**
* This is the main core data model all function are using the objects of this 
* Note.java.
*/

//fileds (tell computer that every note get to have those fileds)
public class Note {
 //The entities inside this file to record the fully functional structure
 //based entity every entity has basic
 //We will have a lot of notes  
 private String id;    //for only note
 private String title;  //for the note title
 private String content;  //for the note content


 //Progress fileds
 private String week;     // e.g. "Week1", "Week2"
 private String subject;   // "Linux System Admin"
 private String category;  // "System Admin"

 //Tag and category
 private List<String> tags = new ArrayList<>(); //help to search
 private String difficulty; //"Linux"
 private String status; // like "Learning", "Completed", "Review" 

 //Time fileds
 private LocalDateTime createdAt;
 private LocalDateTime updatedAt;
 private LocalDateTime studyDate;

 //learning results
 private String summary;
 private List<String> keyPoints = new ArrayList<>();
 private List<String> commands = new ArrayList<>(); //mutiple commands
 private String practiceNotes;

 //Default constructor (tell computer that have when call note how to initialize the note)
public Note(){
    // code to initialise the object when created
   this.id =  UUID.randomUUID().toString(); // EVERY NOTES HAVE ONLY ID
   this.title = "";
   this.content = "";

   this.week = "";
   this.subject = "";
   this.category = "";
   
   this.tags = new ArrayList<>();
   this.difficulty = "";
   this.status = "Learning"; //default value

   this.createdAt = LocalDateTime.now();
   this.updatedAt = LocalDateTime.now(); 
   this.studyDate = null; // can be set later 

   this.summary = "";
   this.keyPoints = new ArrayList<>();
   this.commands = new ArrayList<>();
   this.practiceNotes = "";
   }

   public String getId(){
    return id;
   }

   public String getStatus(){
    return status;
   }

}

 
