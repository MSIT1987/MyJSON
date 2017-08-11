package ir.msit87.amirdev_json.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ir.msit87.amirdev_json.model.NoteModel;
import ir.msit87.amirdev_json.model.structures.NoteStruct;
import ir.msit87.amirdev_json.presenter.NotePresenter;
import ir.msit87.amirdev_json.view.NoteView;
import ir.msit87.amirdev_json.view.list.NotesListFragment;

public class NoteActivity extends AppCompatActivity implements NotesListFragment.OnNoteClickListener {

    NoteView view;
    NotePresenter presenter;
    NoteModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new NoteModel(this);
        view = new NoteView(this);
        setContentView(view);
        presenter = new NotePresenter(view, model);
        presenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onNoteClick(NoteStruct notes) {
        model.editNoteRequest(notes);
    }

    @Override
    public void onImageClick(String id) {
        model.removeNote(id);
    }
}
