package ir.msit87.amirdev_json.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import net.i2p.android.ext.floatingactionbutton.FloatingActionsMenu;

import ir.msit87.amirdev_json.R;
import ir.msit87.amirdev_json.model.NoteModel;
import ir.msit87.amirdev_json.presenter.NotePresenter;
import ir.msit87.amirdev_json.presenter.NotesListPresenter;
import ir.msit87.amirdev_json.view.list.NotesListFragment;

/**
 * NoteView Class Created by MSIT on 8/7/2017.
 */

public class NoteView extends FrameLayout implements View.OnClickListener {

    private enum ClickedItemType {
        TEXT, DRAWING
    }

    private NotePresenter notePresenter;

    private FloatingActionsMenu fabAddNote;

    private Toolbar toolbar;

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

        //
        FragmentManager fragmentManager = ((FragmentActivity)activity).getSupportFragmentManager();
        LoaderManager loaderManager = ((FragmentActivity)activity).getSupportLoaderManager();

        NotesListFragment notesList = (NotesListFragment) fragmentManager.findFragmentByTag("NotesListFragment");
        if(notesList == null){
            notesList = new NotesListFragment();
            fragmentManager.beginTransaction().add(R.id.mainLayout,notesList,"NotesFragment").commitAllowingStateLoss();
        }
        new NotesListPresenter(notesList, loaderManager, activity.getIntent().getStringExtra(NoteModel.FOLDER_ID));

        //Toolbar setup
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(getIcon(R.drawable.ic_arrow_back_24dp));
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });

    }

    @Override
    public void onClick(View v) {
        fabAddNote.collapse();
        switch ((ClickedItemType) v.getTag()){
            case TEXT:
                notePresenter.onNewTextNoteRequest();
            case DRAWING:
                notePresenter.onNewDrawingNoteRequest();
        }

    }

    /**
     * This interface request presenter to make or update a note.
     */
    public interface OnNewNoteRequestListener {
        void onNewTextNoteRequest();
        void onNewDrawingNoteRequest();
    }

    public void setPresenter(NotePresenter presenter) {
        this.notePresenter = presenter;
    }

    public void setToolbarTitle(String title) {
        toolbar.setTitle(title);
    }

    private Drawable getIcon(int id) {
        return ContextCompat.getDrawable(getContext(), id);
    }

}
