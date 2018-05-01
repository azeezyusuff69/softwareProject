package log.bewell.login;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import log.bewell.login.nutritionrecorder.CalorieActivity;
import log.bewell.login.nutritionrecorder.UserInfoCal;


public class HomeScreen extends AppCompatActivity {

    Button workout,calorie,sound,support,calorie1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        calorie1 = (Button)findViewById(R.id.testingbtn);
        //Event if Guest button click
        calorie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(HomeScreen.this, CalorieActivity.class));
            }
        });

        workout =(Button)findViewById(R.id.workoutbtn);
        calorie = (Button)findViewById(R.id.caloriebtn);
        sound =(Button)findViewById(R.id.soundbtn);
        support = (Button)findViewById(R.id.supportbtn);


        //Event if UserInfo button click
        calorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, UserInfoCal.class));
            }
        });

        //Event if user click support click
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, SupportActivity.class));
            }
        });


        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, FHomeActivity.class));
            }
        });


        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, RelaxActivity.class));
            }
        });



    }
}
