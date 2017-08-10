package ir.msit87.amirdev_json.view.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ir.msit87.amirdev_json.R;
import ir.msit87.amirdev_json.model.structures.NoteStruct;

/**
 * NoteAdapter class Created by MSIT on 8/10/2017.
 */

public class NoteAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<NoteStruct> note;
    private OnNoteAdapterClickListener onNoteAdapterClickListener;

    public NoteAdapter(Context context, ArrayList<NoteStruct> note, OnNoteAdapterClickListener onNoteAdapterClickListener) {
        this.context = context;
        this.note = note;
        this.onNoteAdapterClickListener = onNoteAdapterClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.bindView(note.get(position));
    }

    @Override
    public int getItemCount() {
        if (note != null) {
            return note.size();
        } else {
            return 0;
        }
    }

    public interface OnNoteAdapterClickListener {
        void onNoteAdapterClick(NoteStruct note);

        void onNoteAdapterDelete(String id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

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
            txtTitle.setText(note.getTitle());
            if (note.getDrawing() == null) {
                setImageDrawable(R.drawable.ic_note_24dp, imgId);
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                    txtText.setText(Html.fromHtml(note.getText(), Html.FROM_HTML_MODE_COMPACT));
                } else {
                    txtText.setText(Html.fromHtml(note.getText()));
                }
            } else {
                setImageDrawable(R.drawable.ic_image_24dp, imgId);
                txtText.setVisibility(View.GONE);
            }

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNoteAdapterClickListener.onNoteAdapterDelete(note.getId());
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNoteAdapterClickListener.onNoteAdapterClick(note);
                }
            });

        }
    }

    private void setImageDrawable(int id, ImageView imageView) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            imageView.setImageDrawable(context.getDrawable(id));
        } else {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, id));
        }
    }

    private void swapData(ArrayList<NoteStruct> notes){
        if(notes.size() < 1){
            this.note.clear();
            this.note.addAll(notes);
            notifyDataSetChanged();
        }
    }
}
