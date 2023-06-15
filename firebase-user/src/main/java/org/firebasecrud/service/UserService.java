package org.firebasecrud.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.firebasecrud.api.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService
{
    public String createUser(User user) throws ExecutionException, InterruptedException
    {
        Firestore dbFirestore = FirestoreClient.getFirestore(); // get db
        ApiFuture<WriteResult> collectionsAPIFuture = dbFirestore.collection("crud_user").document(user.getId()).set(user); // get table/collection

        return collectionsAPIFuture.get().getUpdateTime().toString();
    }

    public User getUser(String id) throws ExecutionException, InterruptedException
    {
        Firestore dbFirestore = FirestoreClient.getFirestore(); // get db
        DocumentReference documentReference = dbFirestore.collection("crud_user").document(id);

        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        User user;

        if(document.exists())
        {
            user = document.toObject(User.class);
            return user;
        }

        return null;
    }

    public String updateUser(User user) throws ExecutionException, InterruptedException
    {
        Firestore dbFirestore = FirestoreClient.getFirestore(); // get db
        ApiFuture<WriteResult> collectionsAPIFuture = dbFirestore.collection("crud_user").document(user.getId()).set(user); // get table/collection

        return collectionsAPIFuture.get().getUpdateTime().toString();
    }

    public String removeUser(String id)
    {
        Firestore dbFirestore = FirestoreClient.getFirestore(); // get db
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("crud_user").document(id).delete();

        return "Successfully deleted " + id;
    }
}
