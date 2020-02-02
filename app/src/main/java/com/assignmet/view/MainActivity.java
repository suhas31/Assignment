package com.assignmet.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.assignmet.R;
import com.assignmet.adapter.ListAdapter;
import com.assignmet.view_model.ListModelViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private ListModelViewModel listViewModel;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview=findViewById(R.id.viewList);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listViewModel= ViewModelProviders.of(this).get(ListModelViewModel.class);
        listViewModel.getMutableLiveData().observe(MainActivity.this, new Observer<ListModelViewModel>() {
            @Override
            public void onChanged(ListModelViewModel listModelViewModel) {
                getSupportActionBar().setTitle(listModelViewModel.title);
                adapter=new ListAdapter(listModelViewModel.rowsArrayList,MainActivity.this);
                recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerview.setAdapter(adapter);
            }
        });
    }
}
