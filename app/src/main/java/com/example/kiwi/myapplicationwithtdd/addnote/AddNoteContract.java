package com.example.kiwi.myapplicationwithtdd.addnote;

/**
 * Created by kiwi on 6/9/16.
 *
 * This specifies the contract between the view and the presenter.
 */
public interface AddNoteContract {

    interface View {

        void showEmptyNoteError();

        void showNotesList();

        // About Image...
    }

    interface UserActionsListener {

        void saveNote(String title, String description);

        // About Image...
    }
}
