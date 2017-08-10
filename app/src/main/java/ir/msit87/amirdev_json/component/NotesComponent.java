package ir.msit87.amirdev_json.component;

import java.util.ArrayList;

import ir.msit87.amirdev_json.model.structures.NoteStruct;

/**
 * NotesComponent interface Created by MSIT on 8/10/2017.
 */

public interface NotesComponent {

    interface Presenter {
        void present();
    }

    interface View {

        /**
         * provides presenter for view
         *
         * @param presenter inject presenter into view
         */
        void setPresenter(NotesComponent.Presenter presenter);

        /**
         * update folders by swapping adapter's data
         *
         * @param notes inject notes into adapter's RecyclerView
         */
        void updateNotes(ArrayList<NoteStruct> notes);
    }
}
