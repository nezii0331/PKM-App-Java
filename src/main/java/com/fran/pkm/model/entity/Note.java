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
   this.studyDate = null;   
   // can be set later 

   this.summary = "";
   this.keyPoints = new ArrayList<>();
   this.commands = new ArrayList<>();
   this.practiceNotes = "";
   }

   // Getters and Setters for main field
   public String getId(){
    return id;  //stright return the id of this obj
   }
   //id is only identifier, so not set to let outer used to change it

   public String getTitle(){
    return title;
   }

   public void setTitle(String title){
    this.title = title; //this is write into the note obj than into database   
    }

   public String getContent(){
    return content; 
   }

  public void setContent(String content){
   this.content = content;
   this.updatedAt = LocalDateTime.now(); //
   }

   public String getWeek(){
    return week;
   } 

   public void setWeek(String week){
   this.week = week;
   }

   public String getSubject(){
   return subject;
   }

   public void setSubject(String subject){
   this.subject = subject;
   }

   public String getCategory(){
   return category;
   }

   public void setCategory(String category){
    this.category = category;
   }

   public String getStatus(){
    return status;
   }

   public void setStatus(String status){
    this.status = status;
   }

   public List<String> getTags(){
    return tags;
   }

   public void setTags(List<String> tags){
   this.tags = tags;
   } 

   public String getDifficulty(){
   return difficulty;
   } 

   public void setDifficulty(String difficulty){
   this.difficulty = difficulty;
   }

   public LocalDateTime getCreatedAt(){
   return createdAt;
   }

   //not create setter for outer to use
   public LocalDateTime getUpdatedAt(){
   return updatedAt;
   }

   public LocalDateTime getStudyDate(){
   return studyDate;
   }

   public String getSummary(){
   return summary;
   }

   public void setSummary(String summary){
   this.summary = summary;
   }
 
   public List<String> getKeyPoints(){
   return keyPoints;
   }

   public void setKeyPoints(List<String> keyPoints){
   this.keyPoints = keyPoints; 
   }

   public List<String> getCommands(){
   return commands;
   }

   public void setCommands(List<String> commands){ 
   this.commands = commands; 
   }

   public String getPracticeNotes(){
   return practiceNotes;
   }

   public void setPracticeNotes(String practiceNotes){
   this.practiceNotes = practiceNotes;
   } 


   public static Note newForCreate(String title, String content, String status){
    if(title == null || title.isBlank()){
        throw new IllegalArgumentException("Title is empty.");
    }
    Note n = new Note();
    n.id = UUID.randomUUID().toString();
    n.title = title;
    n.content = content;
    n.status = (status == null || status.isBlank()) ? "Learning" : status;
    n.createdAt = LocalDateTime.now();
    n.updatedAt = n.createdAt;
    return n;
   }
 
}

