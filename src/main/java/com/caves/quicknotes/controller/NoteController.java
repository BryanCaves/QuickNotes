package com.caves.quicknotes.controller;

import com.caves.quicknotes.model.Note;
import com.caves.quicknotes.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
    }

    @PutMapping("/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody Note note) {
        noteService.updateNoteById(id, note);
    }
}
