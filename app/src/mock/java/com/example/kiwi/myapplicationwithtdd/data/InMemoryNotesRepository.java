package com.example.kiwi.myapplicationwithtdd.data;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kiwi on 6/8/16.
 *
 * Concrete implementation to load notes from a data source.
 */
public class InMemoryNotesRepository implements NotesRepository {


    private final NotesServiceApi mNotesServiceApi;

    public InMemoryNotesRepository(NotesServiceApi notesServiceApi) {
        mNotesServiceApi = checkNotNull(notesServiceApi);
    }

    @Override
    public void getNotes(@NonNull LoadNotesCallback callback) {

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void getNote(@NonNull String noteId, @NonNull final GetNoteCallback callback) {
        checkNotNull(noteId);
        checkNotNull(callback);
        // Load a note matching the id always directly from the API
        mNotesServiceApi.getNote(noteId, new NotesServiceApi.NotesServiceCallback<Note>() {
            @Override
            public void onLoaded(Note note) {
                callback.onNoteLoaded(note);
            }
        });

    }

    @Override
    public void saveNote(Note note) {

    }
}
