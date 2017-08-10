package ir.msit87.amirdev_json.view.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ir.msit87.amirdev_json.R;
import ir.msit87.amirdev_json.component.NotesComponent;
import ir.msit87.amirdev_json.model.structures.NoteStruct;
import ir.msit87.amirdev_json.view.adapter.NoteAdapter;

/**
 * NotesListFragment Class Created by MSIT on 8/10/2017.
 */

public class NotesListFragment extends Fragment implements NoteAdapter.OnNoteAdapterClickListener, NotesComponent.View {

    private NotesComponent.Presenter presenter;
    private NoteAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, parent, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new NoteAdapter(getContext(), new ArrayList<NoteStruct>(), this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.present();
    }

    @Override
    public void onNoteAdapterClick(NoteStruct note) {
        ((OnNoteClickListener)getContext()).onNoteClick(note);
    }

    @Override
    public void onNoteAdapterDelete(String id) {
        ((OnNoteClickListener)getContext()).onImageClick(id);
    }


    /**
     * @param presenter provides presenter for view
     */
    @Override
    public void setPresenter(NotesComponent.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param notes update notes by swapping adapter's data
     */
    @Override
    public void updateNotes(ArrayList<NoteStruct> notes) {
        adapter.swapData(notes);
    }


    public interface OnNoteClickListener{
        void onNoteClick(NoteStruct notes);
        void onImageClick(String id);
    }
}
