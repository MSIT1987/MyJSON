package ir.msit87.amirdev_json.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ir.msit87.amirdev_json.R;
import ir.msit87.amirdev_json.model.structures.NoteStruct;

/**
 * NoteAdapter class Created by MSIT on 8/10/2017.
 */

public class NoteAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface OnNoteAdapterClickListener{
        void onNoteAdpaterClick();
        void onNoteAdapterDelete(String id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitle, txtText;
        private ImageView imgId, imgDelete;
        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            txtTitle = (TextView) view.findViewById(R.id.txtNoteTitle);
            txtText = (TextView) view.findViewById(R.id.txtNoteText);
            imgId = (ImageView) view.findViewById(R.id.imgIdentifier);
            imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
        }

        void bindView(final NoteStruct note) {


        }
    }
}
