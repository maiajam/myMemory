package com.maiajam.mymemory.data.Repo;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.maiajam.mymemory.GlobalValueSaver;
import com.maiajam.mymemory.data.models.Memories;
import com.maiajam.mymemory.interfaces.ReadDataCallBack;

import java.util.LinkedList;
import java.util.List;

public class AllMemoriesRepo {

    private static AllMemoriesRepo Instance;
    private DatabaseReference mDatabase;
    private DatabaseReference rootRef;
    private MutableLiveData<LinkedList<Memories>> allmemories;
    private List<Memories> allDownloadedMemo;
// ...

    public AllMemoriesRepo() {

    }

    public static AllMemoriesRepo getInstance() {
        if (Instance == null) {
            Instance = new AllMemoriesRepo();
        }
        return Instance;
    }

    private void getmemories(DataSnapshot dataSnapshot, List<Memories> allDownloadedMemo) {
        for (DataSnapshot memDataSnapShot : dataSnapshot.getChildren()) {
            Memories memories = memDataSnapShot.getValue(Memories.class);
            memories.setMemoriesContent(memories.getMemoriesContent());
            allDownloadedMemo.add(memories);
        }
    }

    public void readAllData(final ReadDataCallBack readDataCallBack) {
        rootRef = FirebaseDatabase.getInstance().getReference("user");
        ValueEventListener valueEventListener = new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                allDownloadedMemo = new LinkedList<>();
                allDownloadedMemo.clear();
                getmemories(dataSnapshot, allDownloadedMemo);
                allmemories.postValue((LinkedList<Memories>) allDownloadedMemo);
                readDataCallBack.ReadDataCallback(allmemories);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                GlobalValueSaver.getInstance().setGetAllDataFailerMessage(databaseError.getMessage().toString());
            }
        };
        rootRef.addValueEventListener(valueEventListener);
    }
}
