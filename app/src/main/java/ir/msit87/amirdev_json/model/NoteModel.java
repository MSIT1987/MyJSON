package ir.msit87.amirdev_json.model;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import ir.msit87.amirdev_json.activity.AddDrawingActivity;
import ir.msit87.amirdev_json.activity.AddNoteActivity;
import ir.msit87.amirdev_json.application.App;
import ir.msit87.amirdev_json.model.db.DataContract;
import ir.msit87.amirdev_json.model.structures.NoteStruct;

/**
 * NoteModel Class Created by MSIT on 8/7/2017.
 */

public class NoteModel {

    public static final String FOLDER_ID = "folder_id";
    public static final String FOLDER_NAME = "folder_name";

    private final Activity activity;

    public NoteModel(Activity activity) {
        this.activity = activity;
    }

    public void newTextNoteRequest(){
        Intent intent = new Intent(activity, AddNoteActivity.class);
        intent.putExtra(FOLDER_NAME, activity.getIntent().getStringExtra(FOLDER_NAME));
        activity.startActivity(intent);
    }

    public void newDrawingNoteRequest(){
        Intent intent = new Intent(activity, AddDrawingActivity.class);
        intent.putExtra(FOLDER_ID, activity.getIntent().getStringExtra(FOLDER_ID));
        activity.startActivity(intent);
    }

    /**
     * Gets current folder's name.
     *
     * @return The String folder's name
     */
    public String getFolderName() {
        return activity.getIntent().getStringExtra(FOLDER_NAME);
    }


    public void editNoteRequest(NoteStruct note) {
        if (!note.isPainting()) {
            Intent intent = new Intent(activity, AddNoteActivity.class);
//            intent.putExtra(AddNoteModel.FOLDER_ID, note.getFolderId());
//            intent.putExtra(AddNoteModel.IS_EDITING, true);
//            intent.putExtra(AddNoteModel.NOTE, note);
            activity.startActivity(intent);
        } else {
            Intent intent = new Intent(activity, AddDrawingActivity.class);
//            intent.putExtra(AddDrawingModel.FOLDER_ID, note.getFolderId());
//            intent.putExtra(AddDrawingModel.IS_EDITING, true);
//            intent.putExtra(AddDrawingModel.NOTE, note);
            activity.startActivity(intent);
        }
    }



    /**
     * Requests to ContentProvider to delete a note.
     *
     * @param id The String id of deleting note.
     * @return int which is number of deleted rows.
     */
    public int removeNote(String id) {
        Uri uri = Uri.parse(DataContract.FoldersEntry.CONTENT_URI_NOTES.toString() + "/" + activity.getIntent().getStringExtra(FOLDER_ID));
        return App.getContext().getContentResolver().delete(uri, id, null);

    }
}
