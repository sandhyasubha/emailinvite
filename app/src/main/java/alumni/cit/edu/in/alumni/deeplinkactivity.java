package alumni.cit.edu.in.alumni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.appinvite.AppInviteReferral;


public class deeplinkactivity extends AppCompatActivity implements
        View.OnClickListener {
private static final String TAG = deeplinkactivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeplinkactivity);
        findViewById(R.id.button_ok).setOnClickListener(this);

    }
    @Override
    protected void onStart(){
        super.onStart();
        Intent intent=getIntent();
        if(AppInviteReferral.hasReferral(intent)){
            processReferralIntent(intent);

        }
    }

    private void processReferralIntent(Intent intent) {
 String invitationId=AppInviteReferral.getInvitationId(intent);
        String deepLink=AppInviteReferral.getDeepLink(intent);
        Log.d(TAG," referral:"+invitationId +":"+ deepLink);
        ((TextView) findViewById(R.id.deep_Link_text))
                .setText(getString(R.string.deep_Link_fmt.deepLink));
        ((TextView)findViewById(R.id.invitation_id_text))
                .setText(getString(R.string.invitation_id_fmt,invitationId));

    }

    @Override
    public void onClick(View v) {
      switch (v.getId())  {
          case R.id.button_ok:
              finish();
              break;

      }
    }
}
