package com.maiajam.mymemory.data.Repo;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.maiajam.mymemory.GlobalValueSaver;
import com.maiajam.mymemory.data.models.Memories;

public class AddMyNewMemoriesRepo {

    private static AddMyNewMemoriesRepo Instance;
    private DatabaseReference mDatabase;
    private String _CONTENT = "memorycontent";
// ...

    public AddMyNewMemoriesRepo() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public static AddMyNewMemoriesRepo getInstance() {
        if (Instance == null)
            Instance = new AddMyNewMemoriesRepo();
        return Instance;
    }

    public void setMemory(final String content) {
        final String UserId = GlobalValueSaver.getInstance().getUserId();
        Memories memories = new Memories();
        memories.setUserId(UserId);
        memories.setMemoriesContent(content);

        mDatabase.child("memory").child(memories.getUserId()).setValue(memories);
    }


}
