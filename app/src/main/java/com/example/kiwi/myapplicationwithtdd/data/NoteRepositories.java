package com.example.kiwi.myapplicationwithtdd.data;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kiwi on 6/8/16.
 */
public class NoteRepositories {

    private NoteRepositories() {
        // no instance
    }

    private static NotesRepository repository = null;

    public synchronized static NotesRepository getInMemoryRepoInstance(
            @NonNull NotesServiceApi notesServiceApi) {

        checkNotNull(notesServiceApi);
        if(null == repository)
            repository = new InMemoryNotesRepository(notesServiceApi);

        return repository;
    }
}
