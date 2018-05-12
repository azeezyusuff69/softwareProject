package log.bewell.login;
//
//

/**
 *5/5/2018
 * @reference https://www.youtube.com/watch?v=t5s1_C7nI_o
 * @reference https://www.youtube.com/watch?v=W4hTJybfU7s
 * @author Azeez Yusuff x14443758
 */


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class Contact_InfoActivity extends YouTubeBaseActivity {

    ImageView samaritans_call, samaritans_id, awarecall, awareid, pietacall,pietaid, bodywhyscall,bodywhysid;

    Button clickhelp;

    private static final String TAG = "Contact_InfoActivity";


    YouTubePlayerView mYoutubePview;
    Button playBtn;
    YouTubePlayer.OnInitializedListener OnInitializedListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__info);

        clickhelp = (Button) findViewById(R.id.clickme);

        //Adding a log
        Log.d(TAG, "OnCreate: Starting.");

        playBtn = (Button) findViewById(R.id.playBtn);
        mYoutubePview = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        OnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG,"OnClick: Done Initializing." );

//                List<String> Videolist = new ArrayList<>();
//                Videolist.add("qaNwd47HjfA");
//                Videolist.add("3ZBXldCxZEA");
//                Videolist.add("5j-suBO7k_M");
//
//                youTubePlayer.loadVideos((Videolist));
                youTubePlayer.loadPlaylist("PLZ4LpIeB-0SLH53_Wcsnc-8Gm-ml_Rz20");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"OnClick: Fail to Initializing." );
            }
        };

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"OnClick: Initializing Youtube Player." );
                mYoutubePview.initialize(YouTubeConfig.getApiKey(),OnInitializedListener);
            }
        });


        //Call intent, when you click the call imageview for samaritans
        samaritans_call = (ImageView)findViewById(R.id.samaritans_call);
        samaritans_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = "116 123 ";
                Intent call = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel", phone, null));

                startActivity(call);
                        }
        });

        //web browser intent to  samaritans website
        samaritans_id = (ImageView)findViewById(R.id.samaritans_id);
        samaritans_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("https://www.samaritans.org"));
                startActivity(web);

            }
        });


        //Call intent, when you click the call imageview for samaritans
        awarecall = (ImageView)findViewById(R.id.aware_call);
        awarecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = "1800 80 48 48";
                Intent call = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel", phone, null));

                startActivity(call);
            }
        });

        //web browner intent to  aware website
        awareid = (ImageView)findViewById(R.id.aware_id);
        awareid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("https://www.aware.ie"));
                startActivity(web);

            }
        });


        //Call intent, when you click the call imageview for Pieta
        pietacall = (ImageView)findViewById(R.id.pieta_call);
        pietacall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = "01 623 5606";
                Intent call = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel", phone, null));

                startActivity(call);
            }
        });

        //web browner intent to  Pieta house  website
        pietaid = (ImageView)findViewById(R.id.pieta_id);
        pietaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("https://www.pieta.ie"));
                startActivity(web);

            }
        });


        //Call intent, when you click the call imageview for bodywhys
        bodywhyscall = (ImageView)findViewById(R.id.bodywhys_call);
        bodywhyscall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = "1890 200 444";
                Intent call = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel", phone, null));

                startActivity(call);
            }
        });

        //web browner intent to  bodywhys website
        bodywhysid = (ImageView)findViewById(R.id.bodywhys_id);
        bodywhysid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("https://www.bodywhys.ie"));
                startActivity(web);

            }
        });




        clickhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Contact_InfoActivity.this, SupportActivity.class));
            }
        });



    }
}
