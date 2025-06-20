package com.himanshu.journelApp.controller;

import com.himanshu.journelApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {
    private Map<ObjectId, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/getJournal")
    public List<JournalEntry> getAll()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/getJournal/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable long myId)
    {
        return journalEntries.get(myId);
    }

    @DeleteMapping("/getJournal/id/{myId}")
    public JournalEntry removeJournalEntryById(@PathVariable long myId)
    {
        return journalEntries.remove(myId);
    }

    @PutMapping("/updateEntry/id/{myId}")
    public void updatejournalById(@PathVariable ObjectId myId, @RequestBody JournalEntry myentry)
    {
        journalEntries.put(myId,myentry);
    }

    @PostMapping("/createEntry")
    public void createEntry(@RequestBody JournalEntry myEntry)
    {
        journalEntries.put(myEntry.getId(),myEntry);
    }
}
