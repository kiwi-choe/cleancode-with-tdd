package com.example.kiwi.myapplicationwithtdd.notes;

import android.support.annotation.NonNull;

import com.example.kiwi.myapplicationwithtdd.data.Note;

import java.util.List;

/**
 * Created by kiwi on 6/8/16.
 */
public interface NotesContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showNotes(List<Note> notes);

        void showAddNote();

        void showNoteDetailUi(String noteId);
    }

    interface UserActionsListener {

        void loadNotes(boolean forceUpdate);

        void addNewNote();

        void openNoteDetails(@NonNull Note requestedNote);
    }
}
