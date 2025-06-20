package com.himanshu.journelApp.repository;

import com.himanshu.journelApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> { // here 1st param is the pojo class or entity and 2nd is String cause our PK or id in pojo is also a String

}
