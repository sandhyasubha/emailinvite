package alumni.cit.edu.in.alumni;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by user on 30-07-2017.
 */

public class alumni extends Application{
   @Override
    public void onCreate() {
        super.onCreate();
       Firebase.setAndroidContext(this);
    }
    }

