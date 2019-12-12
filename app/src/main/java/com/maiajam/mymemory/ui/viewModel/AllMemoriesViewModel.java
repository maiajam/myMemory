package com.maiajam.mymemory.ui.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.maiajam.mymemory.data.Repo.AllMemoriesRepo;
import com.maiajam.mymemory.data.models.Memories;
import com.maiajam.mymemory.interfaces.ReadDataCallBack;

import java.util.LinkedList;

public class AllMemoriesViewModel extends ViewModel {

    private static AllMemoriesViewModel allMemoriesInstance;
    private MutableLiveData<LinkedList<Memories>> allMemories;


    public static AllMemoriesViewModel getInstance() {
        if(allMemoriesInstance == null)
            allMemoriesInstance = new AllMemoriesViewModel();
        return allMemoriesInstance;
    }

    public LiveData <LinkedList<Memories>> getAllmemories() {
        if(allMemories == null) {
            allMemories = new MutableLiveData<>();
            readAllMemories();
        }

        return allMemories;
    }

    private void readAllMemories() {
        AllMemoriesRepo.getInstance().readAllData(new ReadDataCallBack() {
            @Override
            public void ReadDataCallback(MutableLiveData<LinkedList<Memories>> allmemories) {
                 allMemories = allmemories ;
            }
        });
    }

}
