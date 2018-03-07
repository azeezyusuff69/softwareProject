package log.bewell.login;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class HomeScreen extends AppCompatActivity {

    Button workout,calorie,sound,support ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        workout =(Button)findViewById(R.id.workoutbtn);
        calorie = (Button)findViewById(R.id.caloriebtn);
        sound =(Button)findViewById(R.id.soundbtn);
        support = (Button)findViewById(R.id.supportbtn);

        //Event if Guest button click
        calorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   startActivity(new Intent(HomeScreen.this, CalorieActivity.class));
            }
        });



    }
}
