package com.example.kiwi.myapplicationwithtdd.notedetail;

import android.support.annotation.Nullable;

import com.example.kiwi.myapplicationwithtdd.data.Note;

/**
 * Created by kiwi on 6/9/16.
 */
public interface NoteDetailContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showMissingNote();

        void hideTitle();
        void showTitle(String title);

        void hideImage();
        void showImage(String imageUrl);

        void hideDescription();
        void showDescription(String description);
    }

    interface UserActionsListener {

        void openNote(@Nullable String noteId);

        void showNote(Note note);
    }
}
