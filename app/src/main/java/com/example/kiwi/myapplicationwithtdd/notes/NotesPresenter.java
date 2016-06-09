package com.example.kiwi.myapplicationwithtdd.notes;

import android.support.annotation.NonNull;

import com.example.kiwi.myapplicationwithtdd.data.Note;
import com.example.kiwi.myapplicationwithtdd.data.NotesRepository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kiwi on 6/8/16.
 */
public class NotesPresenter implements NotesContract.UserActionsListener {


    private final NotesRepository mNotesRepository;
    private final NotesContract.View mNotesView;

    public NotesPresenter(
            @NonNull NotesRepository notesRepository, @NonNull NotesContract.View notesView) {
        mNotesRepository = checkNotNull(notesRepository, "notesRepository cannot be null");
        mNotesView = checkNotNull(notesView, "notesView cannot be null");
    }

    @Override
    public void loadNotes(boolean forceUpdate) {

        // Display a progress indicator
        mNotesView.setProgressIndicator(true);
        // Refresh the data from the repository if an update is forced
        if(forceUpdate)
            mNotesRepository.refreshData();

        // Load the notes from the repository
        mNotesRepository.getNotes(new NotesRepository.LoadNotesCallback() {
            // When the notes have been loaded,
            @Override
            public void onNotesLoaded(List<Note> notes) {
                // hide the progress indicator
                mNotesView.setProgressIndicator(false);
                // and display them
                mNotesView.showNotes(notes);
            }
        });
    }

    @Override
    public void addNewNote() {
        mNotesView.showAddNote();
    }

    @Override
    public void openNoteDetails(@NonNull Note requestedNote) {
        checkNotNull(requestedNote, "requestedNote cannot be null");
        mNotesView.showNoteDetailUi(requestedNote.getId());
    }
}
