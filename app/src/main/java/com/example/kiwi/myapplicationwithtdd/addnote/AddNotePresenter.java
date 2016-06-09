package com.example.kiwi.myapplicationwithtdd.addnote;

import android.support.annotation.NonNull;

import com.example.kiwi.myapplicationwithtdd.data.Note;
import com.example.kiwi.myapplicationwithtdd.data.NotesRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kiwi on 6/9/16.
 */
public class AddNotePresenter implements AddNoteContract.UserActionsListener {
    
    @NonNull
    private final NotesRepository mNotesRepository;
    @NonNull
    private final AddNoteContract.View mAddNoteView;

    public AddNotePresenter(@NonNull NotesRepository notesRepository,
                            @NonNull AddNoteContract.View addNoteView) {
        mNotesRepository = checkNotNull(notesRepository, "notesRepository cannot be null");
        mAddNoteView = checkNotNull(addNoteView, "addNoteView cannot be null");
    }

    @Override
    public void saveNote(String title, String description) {

        Note newnote = new Note(title, description);
        if(newnote.isEmpty())
            mAddNoteView.showEmptyNoteError();
        else {
            mNotesRepository.saveNote(newnote);
            mAddNoteView.showNotesList();
        }
    }
}
