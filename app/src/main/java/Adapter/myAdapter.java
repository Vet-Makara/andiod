package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vibolroeun.recyclerveiew.Detial;
import com.vibolroeun.recyclerveiew.R;

import java.util.List;

import Model.listItems;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder>{

    private Context context;
    private List<listItems> listRow;

    public myAdapter(Context context, List listRow){
        this.context = context;
        this.listRow = listRow;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        listItems listItem = listRow.get(position);
        holder.txtTitle.setText(listItem.getTitle());
        holder.txtDesc.setText(listItem.getDesc());
    }

    @Override
    public int getItemCount() {
        return listRow.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtTitle;
        public TextView txtDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            txtTitle = itemView.findViewById(R.id.titleID);
            txtDesc = itemView.findViewById(R.id.descID);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listItems list = listRow.get(position);

            Intent intent = new Intent(context, Detial.class);
            intent.putExtra("title", list.getTitle());
            intent.putExtra("desc", list.getDesc());

            context.startActivity(intent);
//            Toast.makeText(context, list.getTitle(), Toast.LENGTH_SHORT ).show();
        }
    }


}
