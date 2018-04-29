package gabriel.app.firebase;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        if(savedInstanceState == null) {
            viewModel.loadQuestions(((App) getApplication()).getFirestoreInstance());
        }

        viewModel.getResult().observe(this, new Observer<Questão>() {
            @Override
            public void onChanged(@Nullable Questão questão) {
                if(questão != null){

                    //TODO lidar com o resultado
                }
            }
        });

    }

    private void inicializarComponentes() {
        tvenunciado = (TextView) findViewById(R.id.tvEnunciado);
        listView = (ListView) findViewById(R.id.listView);
    }
}
