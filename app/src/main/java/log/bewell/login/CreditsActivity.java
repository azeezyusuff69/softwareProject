package log.bewell.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class CreditsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        ImageView boogoogoo = (ImageView) findViewById(R.id.boogoogoo_icon);
        boogoogoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInPlayStore("com.lmp.ParentMessenger");
            }
        });

        ImageView eventsCalendar = (ImageView) findViewById(R.id.eventscalendar_icon);
        eventsCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInPlayStore("com.balychev.eventscalendar");
            }
        });

        ImageView sicknessTracker = (ImageView)findViewById(R.id.sicknesstracker_icon);
        sicknessTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInPlayStore("com.mbalychev.mysicknesstracker");
            }
        });
    }

    private void showInPlayStore(String packageName) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=" + packageName));
        startActivity(intent);
    }
}
