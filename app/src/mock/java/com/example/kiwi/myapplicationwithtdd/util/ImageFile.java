package com.example.kiwi.myapplicationwithtdd.util;

import java.io.IOException;

/**
 * Created by kiwi on 6/8/16.
 */
public interface ImageFile {

    void create(String name, String extension) throws IOException;

    boolean exists();

    void delete();

    String getPath();
}
