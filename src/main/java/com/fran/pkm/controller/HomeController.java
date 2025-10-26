package com.fran.pkm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

//like tests

@RestController    //tell spring that there are internet API
public class HomeController{

	@GetMapping("/")  //when someone use get / will check this meathod.
	public String home(){
	   return "Welcome to PKN App!" + "Visit/api/note for the REST API endpoint.";

	}
 
    @GetMapping("/health")  //when someone click [/health] then return ok message.
    public Map<String, String> health(){
	   	return Map.of("status", "ok", "message", "PKM app is healthy and running!");
	}

}
