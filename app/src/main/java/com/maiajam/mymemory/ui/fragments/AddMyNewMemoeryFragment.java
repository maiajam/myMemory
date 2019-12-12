package com.maiajam.mymemory.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.maiajam.mymemory.HelperMethodes;
import com.maiajam.mymemory.R;
import com.maiajam.mymemory.ui.viewModel.AddMyNewMemoriesViewModel;
import com.maiajam.mymemory.ui.viewModel.SignUpViewModel;


public class AddMyNewMemoeryFragment extends Fragment implements View.OnClickListener {

    private EditText memoryContent_edt;
    private Button addMemoryb;
    private Button cancelAdd;
    private View view;
    private AddMyNewMemoriesViewModel addMyNewMemoryViewModel;

    public AddMyNewMemoeryFragment() {
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
        view = inflater.inflate(R.layout.fragment_addmy_new_memory, container, false);

        memoryContent_edt = (EditText) view.findViewById(R.id.addmyMewMemories_EdT_memoryContent);
        addMemoryb = (Button) view.findViewById(R.id.addmyMewMemories_B_addMemory);
        cancelAdd = (Button) view.findViewById(R.id.addmyMewMemories_B_cancelAdd);

        initialViewModel();

        addMemoryb.setOnClickListener(this);
        cancelAdd.setOnClickListener(this);
    }

    private void initialViewModel() {
        addMyNewMemoryViewModel = ViewModelProviders.of(this).get(AddMyNewMemoriesViewModel.class);
    }
    @Override
    public void onClick(View v) {
        if (v == addMemoryb) {
            String memoryContent = memoryContent_edt.getText().toString();
            if (addMyNewMemoryViewModel.checkMemoryContentNotEmpty(memoryContent))
            {
                addMyNewMemoryViewModel.addNewMemory(memoryContent);
                HelperMethodes.beginTransaction(getFragmentManager().beginTransaction()
                        ,new AllMemoriesFragment(),R.id.allmemories_fame);
            }
            else
                Toast.makeText(getActivity(), getString(R.string.Toast_enterMemory), Toast.LENGTH_LONG).show();
        } else if (v == cancelAdd) {
            HelperMethodes.beginTransaction(getFragmentManager().beginTransaction()
                    ,new AllMemoriesFragment(),R.id.allmemories_fame);
        }

    }
}
