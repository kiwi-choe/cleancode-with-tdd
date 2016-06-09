package com.example.kiwi.myapplicationwithtdd.data;

/**
 * Created by kiwi on 6/8/16.
 *
 * Defines an interface to the service API that is used by this app.
 * All data request should be piped through this interface.
 */
public interface NotesServiceApi {

    void getNote(String noteId, NotesServiceCallback<Note> notesServiceCallback);

    interface NotesServiceCallback<T> {

        void onLoaded(T notes);
    }


}
