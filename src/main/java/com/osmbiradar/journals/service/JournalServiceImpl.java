package com.osmbiradar.journals.service;

import com.osmbiradar.journals.entity.JournalEntry;
import com.osmbiradar.journals.repository.JournalRepository;
import org.bson.types.ObjectId;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService{

    private final JournalRepository journalRepository;

    public JournalServiceImpl(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @Override
    public JournalEntry createJournalEntry(JournalEntry entry) {
        entry.setDate(LocalDateTime.now());
        return journalRepository.save(entry);
    }

    @Override
    public JournalEntry updateJournalEntry(JournalEntry entry, ObjectId id) {
        Optional<JournalEntry> byId = journalRepository.findById(id);
        if (byId.isPresent()) {
            JournalEntry updatedEntry = byId.get();
            updatedEntry.setTitle(entry.getTitle());
            updatedEntry.setContent(entry.getContent());
            return journalRepository.save(updatedEntry);
        }else {
            return null;
        }
    }

    @Override
    public void deleteJournalEntry(ObjectId id) {
        journalRepository.findById(id).ifPresent(journalEntry -> journalRepository.delete(journalEntry));
    }

    @Override
    public JournalEntry findJournalEntryById(ObjectId id) {
        return journalRepository.findById(id).orElse(null);
    }

    @Override
    public List<JournalEntry> findAllJournalEntries() {
        return journalRepository.findAll();
    }
}
