package gabriel.app.firebase

import android.app.Application

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

/**
 * Created by lispa on 28/04/2018.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val settings = FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build()
        db.firestoreSettings = settings
    }

    companion object {

        val db = FirebaseFirestore.getInstance()
    }


}
