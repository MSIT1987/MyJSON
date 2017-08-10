package ir.msit87.amirdev_json.model.structures;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import ir.msit87.amirdev_json.model.db.DataContract;

/**
 * NoteStruct Class Created by MSIT on 8/10/2017.
 */

public class NoteStruct implements Parcelable {

    private String id;

    private String title;

    private String text;

    private String folder_id;

    private byte[] drawing;

    private boolean painting;

    public NoteStruct(Cursor cursor){
        id = cursor.getString(cursor.getColumnIndex(DataContract.NoteEntry._ID));
        title = cursor.getString(cursor.getColumnIndex(DataContract.NoteEntry.COLUMN_NOTE_TITLE));
        text = cursor.getString(cursor.getColumnIndex(DataContract.NoteEntry.COLUMN_NOTE_TEXT));
        folder_id = cursor.getString(cursor.getColumnIndex(DataContract.NoteEntry.COLUMN_FOLDER_ID));
        drawing = cursor.getBlob(cursor.getColumnIndex(DataContract.NoteEntry.COLUMN_NOTE_DRAW));
        painting = text == null;
    }

    /**
     * Initializes a {@code NoteStruct} object from parcel.
     * @param in The Parcel that contains our data.
     */
    protected NoteStruct(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.text = in.readString();
        this.folder_id = in.readString();
        this.drawing = in.createByteArray();
    }

    /**
     * Generates instances of {@code NoteStruct}  from a Parcel
     */
    public static final Creator<NoteStruct> CREATOR = new Creator<NoteStruct>() {
        @Override
        public NoteStruct createFromParcel(Parcel in) {
            return new NoteStruct(in);
        }

        @Override
        public NoteStruct[] newArray(int size) {
            return new NoteStruct[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.text);
        dest.writeString(this.folder_id);
        dest.writeByteArray(this.drawing);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getFolder_id() {
        return folder_id;
    }

    public byte[] getDrawing() {
        return drawing;
    }

    public boolean isPainting(){
        return this.painting;
    }
}
