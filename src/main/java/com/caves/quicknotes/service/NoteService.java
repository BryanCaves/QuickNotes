package com.caves.quicknotes.service;

import com.caves.quicknotes.model.Note;
import com.caves.quicknotes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public void updateNoteById(Long id, Note note) {
        Note noteToUpdate = findById(id);

        if (noteToUpdate != null) {
            noteToUpdate.setTitle(note.getTitle());
            noteToUpdate.setContent(note.getContent());
        }
    }
}
