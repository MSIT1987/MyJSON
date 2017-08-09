package ir.msit87.amirdev_json.view;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import net.i2p.android.ext.floatingactionbutton.FloatingActionsMenu;

import ir.msit87.amirdev_json.R;
import ir.msit87.amirdev_json.presenter.NotePresenter;

/**
 * NoteView Class Created by MSIT on 8/7/2017.
 */

public class NoteView extends FrameLayout implements View.OnClickListener {

    private enum ClickedItemType {
        TEXT, DRAWING
    }

    private NotePresenter notePresenter;

    private FloatingActionsMenu fabAddNote;

    public NoteView(final Activity activity) {
        super(activity);

        final ViewGroup mainLayout = (ViewGroup) findViewById(R.id.mainLayout);

        View view = inflate(getContext(), R.layout.activity_note, this);

        fabAddNote = (FloatingActionsMenu) view.findViewById(R.id.fabAddNote);

        FloatingActionButton fabAddText = (FloatingActionButton) view.findViewById(R.id.fabAddText);
        fabAddText.setTag(ClickedItemType.TEXT);
        fabAddText.setOnClickListener(this);

        FloatingActionButton fabAddDrawing = (FloatingActionButton) view.findViewById(R.id.fabAddDrawing);
        fabAddDrawing.setTag(ClickedItemType.DRAWING);
        fabAddDrawing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * This interface request presenter to make or update a note.
     */
    public interface OnNewNoteRequestListener {
        void onNewTextNoteRequest();
        void onNewDrawingNoteRequest();
    }
}
