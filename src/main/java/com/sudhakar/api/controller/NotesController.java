package com.sudhakar.api.controller;

import com.sudhakar.api.Entity.Note;
import com.sudhakar.api.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotesController {
    @Autowired
    NotesRepository nRepo;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> readnotes(){
        return new ResponseEntity<List<Note>>(nRepo.findAll(),HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> savenotes(@RequestBody Note note ){
        return new ResponseEntity<Note>(nRepo.save(note), HttpStatus.OK);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getnotes(@PathVariable Long id){
        return new ResponseEntity<Note>(nRepo.findById(id).get(),HttpStatus.OK);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<HttpStatus> deletenotes(@PathVariable Long id){
        nRepo.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/notes")
    public ResponseEntity<Note> updatenote(@RequestBody Note note){
        return new ResponseEntity<Note>(nRepo.save(note),HttpStatus.OK);
    }
}
