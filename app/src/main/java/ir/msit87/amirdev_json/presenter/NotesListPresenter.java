package ir.msit87.amirdev_json.presenter;

import android.content.ContentUris;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import java.util.ArrayList;

import ir.msit87.amirdev_json.application.App;
import ir.msit87.amirdev_json.component.NotesComponent;
import ir.msit87.amirdev_json.model.db.DataContract;
import ir.msit87.amirdev_json.model.structures.NoteStruct;

/**
 * NotesListPresenter Class Created by MSIT on 8/10/2017.
 */

public class NotesListPresenter implements NotesComponent.Presenter, LoaderManager.LoaderCallbacks<Cursor> {

    //unique identifier for loader
    private static final int LOADER_IDENTIFIER = 100;

    private NotesComponent.View view;

    //manage content loaders
    private LoaderManager loaderManager;

    private String folderId;

    public NotesListPresenter(NotesComponent.View view, LoaderManager loaderManager, String folderId) {
        this.view = view;
        this.loaderManager = loaderManager;
        this.folderId = folderId;
        view.setPresenter(this);
    }

    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {"*"};
        return new CursorLoader(App.getContext(),
                ContentUris.withAppendedId(DataContract.FoldersEntry.CONTENT_URI, Integer.parseInt(folderId))
                , projection, null
                , null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        // Cursor contains data loaded by loader
        // We fetch data from cursor and pass it to view to update notes list
        if(cursor != null){
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                ArrayList<NoteStruct> note =  new ArrayList<>();
                try {
                    do{
                        note.add(new NoteStruct(cursor));
                    }
                    while (cursor.moveToNext());
                } finally {
                    view.updateNotes(note);
                }
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override
    public void present() {
        loaderManager.initLoader(LOADER_IDENTIFIER, null, this);
    }
}
