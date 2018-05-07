package log.bewell.login;

/**
 * Created by Azeez on 5/1/2018.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class SquatVideoActivity extends AppCompatActivity {

   VideoView VideoView;
    Uri uri;
    MediaController mediaC;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squat_video);
        back = (Button) findViewById(R.id.backToActivity);

        back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity (new Intent(SquatVideoActivity.this, WorkoutActivity.class));

            }
        });

        mediaC = new MediaController(this);
        VideoView = (VideoView) findViewById(R.id.video_view3);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.squat);
        VideoView.setVideoURI(uri);

        Button playButton = (Button) findViewById(R.id.play_button_squat);
        VideoView.setMediaController(mediaC);
        mediaC.setAnchorView(VideoView);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoView.start();
            }
        });


    }
}
