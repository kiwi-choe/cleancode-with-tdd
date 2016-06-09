package com.example.kiwi.myapplicationwithtdd.notedetail;

import com.example.kiwi.myapplicationwithtdd.data.Note;
import com.example.kiwi.myapplicationwithtdd.data.NotesRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by kiwi on 6/9/16.
 */
public class NoteDetailPresenterTest {

    private static final String TITLE_TEST = "title";
    private static final String DESCRIPTION_TEST = "description";

    private static final String INVALID_ID = "INVALID_ID";

    private NoteDetailPresenter mNotesDetailPresenter;

    @Mock
    private NotesRepository mNotesRepository;
    @Mock
    private NoteDetailContract.View mNotesDetailView;

    @Captor
    private ArgumentCaptor<NotesRepository.GetNoteCallback> mGetNoteCallbackCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mNotesDetailPresenter = new NoteDetailPresenter(mNotesRepository, mNotesDetailView);
    }

    @Test
    public void getNoteFromRepositoryAndLoadIntoView() {
        // Given an initialized NoteDetailPresenter with stubbed note
        Note note = new Note(TITLE_TEST, DESCRIPTION_TEST);
        // When note's presenter is asked to open a note
        mNotesDetailPresenter.openNote(note.getId());

        // Then note is loaded from model,
        // callback is captured and progress indicator is shown
        verify(mNotesRepository).getNote(eq(note.getId()), mGetNoteCallbackCaptor.capture());
        verify(mNotesDetailView).setProgressIndicator(true);

        // When note is finally loaded
        mGetNoteCallbackCaptor.getValue().onNoteLoaded(note);

        // Then progress indicator is hidden and
        // title and description are shown
        verify(mNotesDetailView).setProgressIndicator(false);
        verify(mNotesDetailView).showTitle(TITLE_TEST);
        verify(mNotesDetailView).showDescription(DESCRIPTION_TEST);
    }

    @Test
    public void getUnknownNoteFromRepositoryAndLoadIntoView() {
        // When loading of a note is requested with an invalid note Id
        mNotesDetailPresenter.openNote(INVALID_ID);
        // Then note with invalid id is attempted to load from model,
        // callback is captured and progress indicator is shown.
        verify(mNotesDetailView).setProgressIndicator(true);
        verify(mNotesRepository).getNote(eq(INVALID_ID), mGetNoteCallbackCaptor.capture());

        // When note is finally loaded
        mGetNoteCallbackCaptor.getValue().onNoteLoaded(null);   // Trigger callback
        // Then progress indicator is hidden and
        // missing note UI is shown
        verify(mNotesDetailView).setProgressIndicator(false);
        verify(mNotesDetailView).showMissingNote();
    }

    @Test
    public void showNoteTestWithEmptyTitleAndDescription() {
        // When invalid title, description are loaded,
        Note note = new Note("", "");
        mNotesDetailPresenter.showNote(note);
        // hide title and description
        verify(mNotesDetailView).hideTitle();
        verify(mNotesDetailView).hideDescription();
    }
}