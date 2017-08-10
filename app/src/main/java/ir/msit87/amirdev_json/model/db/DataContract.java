package ir.msit87.amirdev_json.model.db;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * DataContract Class Created by MSIT on 8/10/2017.
 */

public class DataContract {

    public static final String CONTENT_AUTHORITY = "ir.coursio.notes";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_FOLDERS = "folders";
    public static final String PATH_NOTES = "notes/";


    //Contract class cannot be initiated
    private DataContract() {
    }

    /* Inner class that defines the table contents for folders */
    public static abstract class FoldersEntry implements BaseColumns {
        public final static String _ID = BaseColumns._ID;
        public static final String TABLE_NAME = "folders";
        public static final String COLUMN_FOLDER_NAME = "folder_name";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_FOLDERS);
        public static final Uri CONTENT_URI_NOTES = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_NOTES + PATH_FOLDERS);
        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FOLDERS;
    }

    /* Inner class that defines the table contents for notes */
    public static abstract class NoteEntry implements BaseColumns {
        public final static String _ID = BaseColumns._ID;
        public static final String TABLE_NAME = "note";
        public static final String COLUMN_NOTE_TITLE = "note_title";
        public static final String COLUMN_NOTE_TEXT = "note_text";
        public static final String COLUMN_NOTE_DRAW = "note_draw";
        public static final String COLUMN_FOLDER_ID = "folder_id";
    }
}
