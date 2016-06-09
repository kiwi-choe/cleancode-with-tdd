package com.example.kiwi.myapplicationwithtdd.addnote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiwi.myapplicationwithtdd.Injection;
import com.example.kiwi.myapplicationwithtdd.R;

public class AddNoteFragment extends Fragment implements AddNoteContract.View {

    private AddNoteContract.UserActionsListener mActionListener;

    private TextView mTitle;
    private TextView mDescription;
    private ImageView mImageThumbnail;

    public AddNoteFragment() {
        // Required empty public constructor
    }

    public static AddNoteFragment newInstance() {
        return new AddNoteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_add_note, container, false);

        mTitle = (TextView) root.findViewById(R.id.add_note_title);
        mDescription = (TextView) root.findViewById(R.id.add_note_description);
        mImageThumbnaicdl = (ImageView) root.findViewById(R.id.add_note_image_thumbnail);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActionListener = new AddNotePresenter(Injection.provideNotesRepository(), this);

        FloatingActionButton fab =
                (FloatingActionButton)getActivity().findViewById(R.id.fab_add_notes);
        fab.setImageResource(R.drawable.ic_done);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void showEmptyNoteError() {

    }

    @Override
    public void showNotesList() {

    }
}
