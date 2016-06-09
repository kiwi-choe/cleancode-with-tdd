package com.example.kiwi.myapplicationwithtdd.notedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiwi.myapplicationwithtdd.Injection;
import com.example.kiwi.myapplicationwithtdd.R;

public class NoteDetailFragment extends Fragment implements NoteDetailContract.View {

    private static final String ARG_NOTE_ID = "NOTE_ID";

    private TextView mDetailTitle;
    private TextView mDetailDescription;
    private ImageView mDetailImage;

    private NoteDetailContract.UserActionsListener mActionsListener;

    public NoteDetailFragment() {
        // Required empty public constructor
    }

    public static NoteDetailFragment newInstance(String noteId) {
        NoteDetailFragment fragment = new NoteDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOTE_ID, noteId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActionsListener = new NoteDetailPresenter(Injection.provideNotesRepository(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_note_detail, container, false);
        mDetailTitle = (TextView) root.findViewById(R.id.note_detail_title);
        mDetailDescription = (TextView) root.findViewById(R.id.note_detail_description);
        mDetailImage = (ImageView) root.findViewById(R.id.note_detail_image);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setProgressIndicator(boolean active) {

    }

    @Override
    public void showMissingNote() {

    }

    @Override
    public void hideTitle() {

    }

    @Override
    public void showTitle(String title) {

    }

    @Override
    public void hideImage() {

    }

    @Override
    public void showImage(String imageUrl) {

    }

    @Override
    public void hideDescription() {

    }

    @Override
    public void showDescription(String description) {

    }
}
