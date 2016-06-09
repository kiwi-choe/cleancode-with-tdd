package com.example.kiwi.myapplicationwithtdd.addnote;

import com.example.kiwi.myapplicationwithtdd.data.Note;
import com.example.kiwi.myapplicationwithtdd.data.NotesRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by kiwi on 6/9/16.
 */
public class AddNotePresenterTest {

    private static final String TITLE_TEST = "new title";
    private static final String DESCRIPTION_TEST = "new description";

    @Mock
    private NotesRepository mNotesRepository;
    @Mock
    private AddNoteContract.View mAddNoteView;

    private AddNotePresenter mAddNotePresenter;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mAddNotePresenter = new AddNotePresenter(mNotesRepository, mAddNoteView);
    }

    @Test
    public void saveNoteToRepository_showsSuccessMessageUi() {
        // When the presenter is asked to save a note
        mAddNotePresenter.saveNote(TITLE_TEST, DESCRIPTION_TEST);
        // Then a note is,
        // saved to the model and
        verify(mNotesRepository).saveNote(any(Note.class));
        // shown in the UI
        verify(mAddNoteView).showNotesList();
    }

    @Test
    public void saveNote_emptyNoteShowsErrorUi() {
        // When the presenter is asked to save an empty note
        mAddNotePresenter.saveNote("", "");
        // Then an empty not error is shown in the UI
        verify(mAddNoteView).showEmptyNoteError();
    }
}