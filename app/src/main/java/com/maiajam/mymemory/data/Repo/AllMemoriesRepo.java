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

import java.util.LinkedList;
import java.util.List;

public class AllMemoriesRepo {

    private static AllMemoriesRepo Instance;
    private DatabaseReference mDatabase;
    private DatabaseReference rootRef;
    private MutableLiveData<LinkedList<Memories>> allmemories;
// ...

    public AllMemoriesRepo() {

        rootRef = FirebaseDatabase.getInstance().getReference("memory");
         final List<Memories> allDownloadedMemo = new LinkedList<>();

            rootRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   getmemories(dataSnapshot,allDownloadedMemo);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    // ...
                    GlobalValueSaver.getInstance().setGetAllDataFailerMessage(databaseError.getMessage().toString());
                }
            });
            allmemories.postValue((LinkedList<Memories>) allDownloadedMemo) ;
    }

    private void getmemories(DataSnapshot dataSnapshot, List<Memories> allDownloadedMemo) {
        for (DataSnapshot memDataSnapShot : dataSnapshot.getChildren()) {
            Memories memories = memDataSnapShot.getValue(Memories.class);
            memories.setMemoriesContent(memories.getMemoriesContent());
            allDownloadedMemo.add(memories);
        }
    }

    public static AllMemoriesRepo getInstance() {
        if (Instance == null) {
            Instance = new AllMemoriesRepo();
        }
        return Instance;
    }

    public LiveData<LinkedList<Memories>> getAllmemories() {

        return allmemories;
    }
}
