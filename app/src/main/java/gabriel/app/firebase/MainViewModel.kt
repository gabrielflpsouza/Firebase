package gabriel.app.firebase

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

/**
 * Created by lispa on 28/04/2018.
 */
class MainViewModel() : ViewModel() {

    val result : MutableLiveData<Questão> = MutableLiveData()


    fun loadQuestions(firestoreInstance: FirebaseFirestore){
        firestoreInstance.collection("Questão")
                .get()
                .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                    if (task.isSuccessful) {
                        for (documentSnapshot in task.result) {
                            Log.d("Foi", documentSnapshot.id + " => " + documentSnapshot.data)
                            val docRef = firestoreInstance.collection("Questão").document(documentSnapshot.id)
                            docRef.get().addOnSuccessListener(OnSuccessListener<DocumentSnapshot> { documentSnapshot ->
                                val city = documentSnapshot.toObject(Questão::class.java)
                                Log.d("Foi2", city.enunciado)

                                result.value = documentSnapshot.toObject(Questão::class.java)
                            })

                        }
                    } else {
                        Log.d("Errou", "Error getting documents: " + task.exception!!)
                    }
                })
    }

}