package com.osmbiradar.journals.entity;


import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Getter
@Setter
public class Users {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String username;

    @NonNull
    private String password;

    @DBRef
    List<JournalEntry> journalEntries = new ArrayList<>();

}
