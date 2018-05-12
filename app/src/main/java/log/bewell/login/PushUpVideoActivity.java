//
//
//package log.bewell.login;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.MediaController;
//import android.widget.VideoView;
//
//public class PushUpVideoActivity extends AppCompatActivity {
//
//    VideoView VideoView;
//    VideoView VideoView2;
//    VideoView VideoView3;
//    Uri uri;
//    Uri uri2;
//    Uri uri3;
//    MediaController mediaC;
//    MediaController mediaC2;
//    MediaController mediaC3;
//
//
//    Button pushup;
//    Button situp;
//    Button squat;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fitness_video);
//
//         pushup = (Button) findViewById(R.id.backToActivity);
//
//
//         pushup.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 startActivity (new Intent(PushUpVideoActivity.this, WorkoutActivity.class));
//
//             }
//         });
//
//
//
//
//        mediaC = new MediaController(this);
//        mediaC2 = new MediaController(this);
//        mediaC3 = new MediaController(this);
//
//        VideoView = (VideoView) findViewById(R.id.video_view);
//        VideoView2 = (VideoView) findViewById(R.id.video_view2);
//        VideoView3 = (VideoView) findViewById(R.id.video_view3);
//
//        //link to the exercise videos to be played
//        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.push_ups);
//        VideoView.setVideoURI(uri);
//
//        uri2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sit_ups);
//        VideoView2.setVideoURI(uri2);
//
//        uri3 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.squat);
//        VideoView3.setVideoURI(uri3);
//
//        Button playButton = (Button) findViewById(R.id.play_button);
//        VideoView.setMediaController(mediaC);
//        mediaC.setAnchorView(VideoView);
//
//        Button playButton2 = (Button) findViewById(R.id.play_button_situp);
//        VideoView2.setMediaController(mediaC2);
//        mediaC2.setAnchorView(VideoView2);
//
//        Button playButton3 = (Button) findViewById(R.id.play_button_squat);
//        VideoView3.setMediaController(mediaC3);
//        mediaC3.setAnchorView(VideoView3);
//
//
//
//        playButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                VideoView.start();
//            }
//        });
//
//        playButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                VideoView2.start();
//            }
//        });
//
//        playButton3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                VideoView3.start();
//            }
//        });
//    }
//}
package log.bewell.login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class PushUpVideoActivity extends AppCompatActivity {

    VideoView VideoView;
    Uri uri;
    MediaController mediaC;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_video);
         back = (Button) findViewById(R.id.backToActivity);

         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity (new Intent(PushUpVideoActivity.this, WorkoutActivity.class));

             }
         });

         //The video instruction that the user can watch to get the technique of push up right
        mediaC = new MediaController(this);
        VideoView = (VideoView) findViewById(R.id.video_view);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.push_ups);
        VideoView.setVideoURI(uri);

        Button playButton = (Button) findViewById(R.id.play_button);
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
