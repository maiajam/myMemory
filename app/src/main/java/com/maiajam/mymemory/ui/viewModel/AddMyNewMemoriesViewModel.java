package com.maiajam.mymemory.ui.viewModel;

import androidx.lifecycle.ViewModel;

import com.maiajam.mymemory.data.Repo.AddMyNewMemoriesRepo;

public class AddMyNewMemoriesViewModel extends ViewModel {

    private AddMyNewMemoriesViewModel instance;

    public boolean checkMemoryContentNotEmpty(String content)
    {
        if(content.isEmpty())
            return false;
        else
            return true;
    }

    public void addNewMemory(String content)
    {
        AddMyNewMemoriesRepo.getInstance().setMemory(content);
    }
}
