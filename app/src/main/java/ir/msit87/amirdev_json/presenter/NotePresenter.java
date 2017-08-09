package ir.msit87.amirdev_json.presenter;

import ir.msit87.amirdev_json.model.NoteModel;
import ir.msit87.amirdev_json.view.NoteView;

/**
 * NotePresenter Class Created by MSIT on 8/9/2017.
 */

public class NotePresenter implements NoteView.OnNewNoteRequestListener {

    private NoteView view;
    private NoteModel model;

    public NotePresenter(NoteView view, NoteModel model){
        this.view = view;
        this.model = model;
    }


    @Override
    public void onNewTextNoteRequest() {
        model.newTextNoteRequest();
    }

    @Override
    public void onNewDrawingNoteRequest() {
        model.newDrawingNoteRequest();
    }
}
