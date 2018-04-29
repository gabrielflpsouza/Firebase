package gabriel.app.firebase

import android.app.Application

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

/**
 * Created by lispa on 28/04/2018.
 */

class App : Application() {

    val firestoreInstance : FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance().apply {
            firestoreSettings = FirebaseFirestoreSettings.Builder()
                    .setPersistenceEnabled(true)
                    .build()
        }
    }

    override fun onCreate() {
        super.onCreate()

    }

}
