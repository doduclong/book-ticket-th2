package com.example.th2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.th2.R;
import com.example.th2.adapter.RecycleViewAdapter;
import com.example.th2.dal.SQLiteHelper;
import com.example.th2.model.Ticket;

import java.util.List;

public class HomeFragment extends Fragment implements RecycleViewAdapter.ItemListener {
    private RecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private SQLiteHelper db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onItemClick(View view, int position) {
//        Ticket ticket = adapter.getTicket(position);
//        Intent intent = new Intent(getActivity(), AddTicketActivity.class);
//        intent.putExtra("ticket", ticket);
//        startActivity(intent);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycleView);
        adapter = new RecycleViewAdapter();
        db = new SQLiteHelper(getContext());
        db.clearDatabase("ticket");

        Ticket i1 = new Ticket("Long", "Ha Noi", "12/12/2022", "co", "hut thuoc");
        Ticket i2 = new Ticket("Huy", "Hai Phong", "12/12/2022", "khong", "an sang");
        Ticket i3 = new Ticket("Hung", "Da Nang", "12/12/2022", "co", "an sang");
        Ticket i4 = new Ticket("Khanh", "Hue", "12/12/2022", "khong", "hut thuoc");
        Ticket i5 = new Ticket("Son", "TP HCM", "12/12/2022", "co", "an sang");

        db.addTicket(i1);
        db.addTicket(i2);
        db.addTicket(i3);
        db.addTicket(i4);
        db.addTicket(i5);


        List<Ticket> list = db.getAllTicket();
        adapter.setList(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        List<Ticket> list = db.getAllTicket();
        adapter.setList(list);
    }

}