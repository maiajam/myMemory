package com.maiajam.mymemory.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.maiajam.mymemory.HelperMethodes;
import com.maiajam.mymemory.R;
import com.maiajam.mymemory.adapters.AllMemoriesAdapter;
import com.maiajam.mymemory.data.models.Memories;
import com.maiajam.mymemory.ui.viewModel.AllMemoriesViewModel;

import java.util.LinkedList;


public class AllMemoriesFragment extends Fragment implements View.OnClickListener {


    private View view;
    private FloatingActionButton addNewMemoryFAB;
    private RecyclerView allMemoetiesRec;
    private Object allMemoriesViewModel;
    private AllMemoriesAdapter allMemoriesAdapter;


    public AllMemoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initialView(inflater, container);
        return view;
    }

    private void initialView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_memorylist_, container, false);
        addNewMemoryFAB = (FloatingActionButton) view.findViewById(R.id.fab);
        allMemoetiesRec = (RecyclerView) view.findViewById(R.id.Allmemories_Rec);
        addNewMemoryFAB.setOnClickListener(this);
       // initialAllMemoryRecView();
    }

    private void initialAllMemoryRecView() {
        allMemoriesViewModel = ViewModelProviders.of(this).get(AllMemoriesViewModel.class);
        ((AllMemoriesViewModel) allMemoriesViewModel).getAllmemories().observe(this, new Observer<LinkedList<Memories>>() {
            @Override
            public void onChanged(LinkedList<Memories> memories) {
                allMemoriesAdapter = new AllMemoriesAdapter(getContext(), memories);
                allMemoetiesRec.setAdapter(allMemoriesAdapter);
                allMemoetiesRec.setLayoutManager(new LinearLayoutManager(getContext()));
                allMemoriesAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == addNewMemoryFAB) {
            HelperMethodes.beginTransaction(getFragmentManager().beginTransaction(), new AddMyNewMemoeryFragment(), R.id.allmemories_fame);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
       initialAllMemoryRecView();
    }
}
