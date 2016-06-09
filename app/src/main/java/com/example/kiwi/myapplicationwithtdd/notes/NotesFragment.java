package com.example.kiwi.myapplicationwithtdd.notes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiwi.myapplicationwithtdd.Injection;
import com.example.kiwi.myapplicationwithtdd.R;
import com.example.kiwi.myapplicationwithtdd.data.Note;

import java.util.List;

public class NotesFragment extends Fragment implements NotesContract.View {

    private NotesContract.UserActionsListener mActionsListener;

    public NotesFragment() {
        // Required empty public constructor
    }

    public static NotesFragment newInstance() {
        NotesFragment fragment = new NotesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_notes, container, false);

        // Set up floating action button
        FloatingActionButton fab =
                (FloatingActionButton)getActivity().findViewById(R.id.fab_add_notes);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActionsListener.addNewNote();
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);

        mActionsListener = new NotesPresenter(Injection.provideNotesRepository(), this);
    }

    /*
        * Listener for clicks on notes in the RecyclerView
        * */
    NoteItemListener mItemListener = new NoteItemListener() {

        @Override
        public void onNoteClick(Note clickedNote) {
            mActionsListener.openNoteDetails(clickedNote);
        }
    };


    @Override
    public void setProgressIndicator(boolean active) {

    }

    @Override
    public void showNotes(List<Note> notes) {

    }

    @Override
    public void showAddNote() {

    }

    @Override
    public void showNoteDetailUi(String noteId) {

    }

    private interface NoteItemListener {
        void onNoteClick(Note clickedNote);
    }
}
