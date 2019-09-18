package com.maiajam.mymemory.ui.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.maiajam.mymemory.data.Repo.AllMemoriesRepo;
import com.maiajam.mymemory.data.models.Memories;

import java.util.LinkedList;

public class AllMemoriesViewModel extends ViewModel {

    private static AllMemoriesViewModel allMemoriesInstance;
    private LinkedList<LiveData<Memories>> allmemories;


    public static AllMemoriesViewModel getInstance() {
        if(allMemoriesInstance == null)
            allMemoriesInstance = new AllMemoriesViewModel();
        return allMemoriesInstance;
    }

    public LiveData <LinkedList<Memories>> getAllmemories() {
        return AllMemoriesRepo.getInstance().getAllmemories();
    }

}
