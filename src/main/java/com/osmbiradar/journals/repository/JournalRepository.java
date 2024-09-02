package com.osmbiradar.journals.repository;

import com.osmbiradar.journals.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<JournalEntry, ObjectId> {
}
