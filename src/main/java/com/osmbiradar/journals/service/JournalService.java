package com.osmbiradar.journals.service;

import com.osmbiradar.journals.entity.JournalEntry;
import org.bson.types.ObjectId;

import java.util.List;

public interface JournalService {

    // TODO: CRUD operations for Journal entries

    JournalEntry createJournalEntry(JournalEntry entry);

    JournalEntry updateJournalEntry(JournalEntry entry , ObjectId id);

    void deleteJournalEntry(ObjectId id);

    JournalEntry findJournalEntryById(ObjectId id);

    List<JournalEntry> findAllJournalEntries();

}
