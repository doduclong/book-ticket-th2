package com.example.th2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.th2.R;
import com.example.th2.model.Ticket;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.HomeViewHolder> {
    private List<Ticket> list;
    private ItemListener itemListener;

    public RecycleViewAdapter(){
        list = new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener){
        this.itemListener = itemListener;
    }

    public List<Ticket> getList() {
        return list;
    }

    public void setList(List<Ticket> list) {
        this.list = list;
        notifyDataSetChanged();

    }

    public Ticket getTicket(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Ticket ticket = list.get(position);

        holder.id.setText(Long.toString(ticket.getId()));
        holder.name.setText(ticket.getName());
        holder.departure.setText(ticket.getDeparture());
        holder.time.setText(ticket.getTime());
        holder.luggage.setText(ticket.getLuggage());
        holder.service.setText(ticket.getService());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView id, name, departure, time, luggage, service;

        public HomeViewHolder(@NonNull View itemView) {

            super(itemView);
            id = itemView.findViewById(R.id.tvId);
            name = itemView.findViewById(R.id.tvName);
            departure = itemView.findViewById(R.id.tvDeparture);
            time = itemView.findViewById(R.id.tvTime);
            luggage = itemView.findViewById(R.id.tvLuggage);
            service = itemView.findViewById(R.id.tvService);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemListener != null){
                itemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemListener{
        void onItemClick(View view, int position);
    }
}
