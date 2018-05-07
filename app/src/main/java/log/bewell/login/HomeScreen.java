package log.bewell.login;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import log.bewell.login.nutritionrecorder.UserInfoCal;
import log.bewell.login.quiz.QuizStartActivity;

import com.google.firebase.auth.FirebaseAuth;



public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    private Button workout,calorie,sound,hseBtn,quiz,changepassword,logout;

    TextView welcomeUser;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);


        workout =(Button)findViewById(R.id.workoutbtn);
        calorie = (Button)findViewById(R.id.caloriebtn);
        sound =(Button)findViewById(R.id.soundbtn);
       // support = (Button)findViewById(R.id.supportbtn);
        hseBtn =(Button)findViewById(R.id.hseBtn);
        quiz =(Button)findViewById(R.id.testingbtn);
        welcomeUser = (TextView) findViewById(R.id.user_welcome);
        changepassword = (Button)findViewById(R.id.change_password);
        logout = (Button)findViewById(R.id.logoutid);



        //Init Firebase Auth
        auth = FirebaseAuth.getInstance();


        if(auth.getCurrentUser() != null)
            welcomeUser.setText("Welcome , "+auth.getCurrentUser().getEmail());



        //Event if UserInfo button click
        calorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, UserInfoCal.class));
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


        hseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, Contact_InfoActivity.class));
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, QuizStartActivity.class));
            }
        });

        //Event if UserInfo button click
        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, ForgotPassword.class));
            }
        });

        logout.setOnClickListener(this);

    }


    public void onClick(View view) {
          if(view == logout)
          logoutUser();
    }

    private void logoutUser() {
        auth.signOut();
        if(auth.getCurrentUser() == null)
        {
            startActivity(new Intent(HomeScreen.this,MainActivity.class));
            finish();

        }
    }


}
