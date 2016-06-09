package com.example.kiwi.myapplicationwithtdd.data;

import com.google.common.base.Objects;

import java.util.UUID;

/**
 * Created by kiwi on 6/8/16.
 */
public class Note {

    private String mId;
    private final String mTitle;
    private final String mDescription;
    private String mImageUrl;

    public Note(String title, String description) {
        mId = UUID.randomUUID().toString();
        mTitle = title;
        mDescription = description;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public boolean isEmpty() {
        return (mTitle == null || "".equals(mTitle)) &&
                (mDescription == null || "".equals(mDescription));
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        Note note = (Note)o;
        return Objects.equal(mId, note.mId) &&
                Objects.equal(mTitle, note.mTitle) &&
                Objects.equal(mDescription, note.mDescription);
    }
}
