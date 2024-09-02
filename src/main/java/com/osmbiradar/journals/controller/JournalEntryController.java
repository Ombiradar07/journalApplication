package com.osmbiradar.journals.controller;


import com.osmbiradar.journals.entity.JournalEntry;
import com.osmbiradar.journals.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/journal-entries")
public class JournalEntryController {

     private final JournalService journalService;

    public JournalEntryController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping("/create")
    public ResponseEntity<JournalEntry> createJournalEntry(@RequestBody JournalEntry journalEntry) {
        JournalEntry newEntry = journalService.createJournalEntry(journalEntry);
        return new ResponseEntity<>(newEntry, HttpStatus.CREATED);
    }

    @GetMapping("/getEntry/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId id) {
        JournalEntry entry = journalService.findJournalEntryById(id);
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@RequestBody JournalEntry journalEntry,@PathVariable ObjectId id) {
        JournalEntry updatedEntry = journalService.updateJournalEntry(journalEntry,id);
        return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJournalEntry(@PathVariable ObjectId id) {
        journalService.deleteJournalEntry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<JournalEntry> getAllJournalEntries(){
        List<JournalEntry> allJournalEntries = journalService.findAllJournalEntries();
       return allJournalEntries.stream().map(journalEntry ->
                journalService.findJournalEntryById(journalEntry.getId())).collect(Collectors.toList());
    }
}
