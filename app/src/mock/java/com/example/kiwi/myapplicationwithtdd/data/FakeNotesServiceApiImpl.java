package com.example.kiwi.myapplicationwithtdd.data;

import android.support.v4.util.ArrayMap;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by kiwi on 6/6/16.
 *
 * Fake implementation of {@link NotesServiceApi} to inject a fake service in a hermetic test.
 */
public class FakeNotesServiceApiImpl implements NotesServiceApi {

    // TODO replace this with a new test specific data set.
    private static final ArrayMap<String, Note> NOTES_SERVICE_DATA = new ArrayMap();

    @Override
    public void getNote(String noteId, NotesServiceCallback<Note> notesServiceCallback) {
        Note note = NOTES_SERVICE_DATA.get(noteId);
        notesServiceCallback.onLoaded(note);
    }
}
