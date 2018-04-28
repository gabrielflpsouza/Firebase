package gabriel.app.firebase;

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import gabriel.app.firebase.Models.Questao;

public class MainActivity extends AppCompatActivity {
    private TextView tvenunciado;
    private ListView listView;
    public static final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        db.collection("tbQuestao")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (DocumentSnapshot documentSnapshot : task.getResult()){
                                Log.d("Foi", documentSnapshot.getId() + " => " + documentSnapshot.getData());
                                DocumentReference docRef = db.collection("tbQuestao").document(documentSnapshot.getId());
                                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        tbQuestao city = documentSnapshot.toObject(tbQuestao.class);
                                        Log.d("Foi2", city.getEnunciado());
                                    }
                                });

                            }
                        } else {
                            Log.d("Errou", "Error getting documents: " + task.getException());
                        }
                    }
                });


        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

    }

    private void inicializarComponentes() {
        tvenunciado = (TextView) findViewById(R.id.tvEnunciado);
        listView = (ListView) findViewById(R.id.listView);
    }
}
