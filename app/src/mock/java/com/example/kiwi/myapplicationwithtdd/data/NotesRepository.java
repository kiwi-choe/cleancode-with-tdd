package com.example.kiwi.myapplicationwithtdd.data;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by kiwi on 6/8/16.
 *
 * Main entry point for accessing notes data
 */
public interface NotesRepository {

    interface LoadNotesCallback {
        void onNotesLoaded(List<Note> notes);
    }

    interface GetNoteCallback {
        void onNoteLoaded(Note note);
    }

    void getNotes(@NonNull LoadNotesCallback callback);

    void refreshData();

    void getNote(@NonNull String noteId, @NonNull GetNoteCallback callback);

    void saveNote(Note note);
}
