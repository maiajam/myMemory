package com.maiajam.mymemory.data.Repo;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.maiajam.mymemory.GlobalValueSaver;
import com.maiajam.mymemory.data.models.Memories;

public class AddMyNewMemoriesRepo {

    private static AddMyNewMemoriesRepo Instance;
    private DatabaseReference memoryDatabase;
    private String _CONTENT = "memorycontent";
// ...

    public AddMyNewMemoriesRepo() {
        memoryDatabase = FirebaseDatabase.getInstance().getReference("user");
    }

    public static AddMyNewMemoriesRepo getInstance() {
        if (Instance == null)
            Instance = new AddMyNewMemoriesRepo();
        return Instance;
    }

    public void setMemory(final String content) {
        final String UserId = GlobalValueSaver.getInstance().getUserId();
        Memories memories = new Memories();
        memories.setMemoriesContent(content);
        memories.setId( memoryDatabase.push().getKey());
        memoryDatabase.child(UserId).child( memoryDatabase.push().getKey()).setValue(memories);
    }


}
