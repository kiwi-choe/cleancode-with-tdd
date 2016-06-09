package com.example.kiwi.myapplicationwithtdd.notedetail;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.kiwi.myapplicationwithtdd.data.Note;
import com.example.kiwi.myapplicationwithtdd.data.NotesRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kiwi on 6/9/16.
 */
public class NoteDetailPresenter implements NoteDetailContract.UserActionsListener {

    private final NotesRepository mNotesRepository;
    private final NoteDetailContract.View mNotesDetailView;

    public NoteDetailPresenter(@NonNull NotesRepository notesRepository,
                               @NonNull NoteDetailContract.View noteDetailView) {
        mNotesRepository = checkNotNull(notesRepository, "notesRepository cannot be null");
        mNotesDetailView = checkNotNull(noteDetailView, "notesRepository cannot be null");
    }

    @Override
    public void openNote(@Nullable String noteId) {

        if (null == noteId || noteId.isEmpty()) {
            mNotesDetailView.showMissingNote();
            return;
        }

        mNotesDetailView.setProgressIndicator(true);
        mNotesRepository.getNote(noteId, new NotesRepository.GetNoteCallback() {
            @Override
            public void onNoteLoaded(Note note) {
                mNotesDetailView.setProgressIndicator(false);
                if (null == note)
                    mNotesDetailView.showMissingNote();
                else {
//                    mNotesDetailView.showTitle(note.getTitle());
//                    mNotesDetailView.showDescription(note.getDescription());
                    showNote(note);
                }

            }
        });
    }

    @Override
    public void showNote(Note note) {

        String title = note.getTitle();
        String description = note.getDescription();
        String imageUrl = note.getImageUrl();

        if (null != title && title.isEmpty())
            mNotesDetailView.hideTitle();
        else
            mNotesDetailView.showTitle(title);

        if (null != description && description.isEmpty())
            mNotesDetailView.hideDescription();
        else
            mNotesDetailView.showDescription(description);

        if (imageUrl != null) {
            mNotesDetailView.showImage(imageUrl);
        } else {
            mNotesDetailView.hideImage();
        }
    }
}
