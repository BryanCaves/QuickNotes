package com.caves.quicknotes.repository;

import com.caves.quicknotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {}
