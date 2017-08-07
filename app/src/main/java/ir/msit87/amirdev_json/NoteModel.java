package ir.msit87.amirdev_json;

import android.app.Activity;
import android.content.Intent;

/**
 * NoteModel Class Created by MSIT on 8/7/2017.
 */

public class NoteModel {

    private static final String FOLDER_ID = "folder_id";
    private static final String FOLDER_NAME = "folder_name";

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


}
