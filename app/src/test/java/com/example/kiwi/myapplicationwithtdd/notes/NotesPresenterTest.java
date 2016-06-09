package com.example.kiwi.myapplicationwithtdd.notes;

import com.example.kiwi.myapplicationwithtdd.data.Note;
import com.example.kiwi.myapplicationwithtdd.data.NotesRepository;
import com.example.kiwi.myapplicationwithtdd.data.NotesRepository.LoadNotesCallback;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by kiwi on 6/8/16.
 */
public class NotesPresenterTest {

    private static final List<Note> NOTES = Lists.newArrayList(
            new Note("Title1", "Description1"),
            new Note("Title2", "Description2"));

    private NotesPresenter mNotesPresenter;

    @Mock
    private NotesContract.View mNotesView;
    @Mock
    private NotesRepository mNotesRepository;

    @Captor
    private ArgumentCaptor<LoadNotesCallback> mLoadNotesCallbackCaptor;

    @Before
    public void setUp() throws Exception {
        // Set initMocks before
        MockitoAnnotations.initMocks(this);

        mNotesPresenter = new NotesPresenter(mNotesRepository, mNotesView);
    }

    @Test
    public void clickOnFab_ShowsAddsNoteUi() {
        // When adding a new note
        mNotesPresenter.addNewNote();

        // Then add note UI is shown
        verify(mNotesView).showAddNote();
    }

    // Validates that the presenter correctly displays a list of notes
    @Test
    public void loadNotesFromRepositoryAndLoadIntoView() {
        mNotesPresenter.loadNotes(true);

        // Callback is captured and invoked with stubbed notes.
        verify(mNotesRepository).getNotes(mLoadNotesCallbackCaptor.capture());
        mLoadNotesCallbackCaptor.getValue().onNotesLoaded(NOTES);

        // Then progress indicator is hidden and notes are shown in UI
        verify(mNotesView).setProgressIndicator(false);
        verify(mNotesView).showNotes(NOTES);
    }

    // Validates that the presenter correctly show a clicked note detail
    @Test
    public void clickOnNote_ShowDetailUi() {

        // Given a stubbed note
        Note requestedNote = new Note("Details title", "des: For this note");
        // When open note details is requested,
        mNotesPresenter.openNoteDetails(requestedNote);
        // Then note detail UI is shown
        verify(mNotesView).showNoteDetailUi(any(String.class));
    }
}