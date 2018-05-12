package log.bewell.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnGuest;
    EditText input_email, input_password;
    TextView btnSignup, btnForgotPass, welcomeUser;
    RelativeLayout activity_main;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //View
        btnLogin = (Button) findViewById(R.id.login_btn_login);
        input_email = (EditText) findViewById(R.id.login_email);
        input_password = (EditText) findViewById(R.id.login_password);
        btnSignup = (TextView) findViewById(R.id.login_btn_signup);
        btnForgotPass = (TextView) findViewById(R.id.login_btn_forgot_password);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        welcomeUser = (TextView) findViewById(R.id.user_welcome);
//        btnGuest = (Button)findViewById(R.id.testingid);
//        //testing
//        btnGuest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, DashBoard.class));
//            }
//        });

        btnSignup.setOnClickListener(this);
        btnForgotPass.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        //Init Firebase Auth
        auth = FirebaseAuth.getInstance();

        //Check already session , if ok-> DashBoard
        if (auth.getCurrentUser() != null)
            startActivity(new Intent(MainActivity.this, HomeScreen.class));

    }


    //Checking if user want to login or they forgot there password or take them to the Registration page
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_btn_forgot_password) {
            startActivity(new Intent(MainActivity.this, ForgotPassword.class));
            finish();
        } else if (view.getId() == R.id.login_btn_signup) {
            startActivity(new Intent(MainActivity.this, SignUp.class));
            finish();
        } else if (view.getId() == R.id.login_btn_login) {


            String email = input_email.getText().toString().trim();
            String password = input_password.getText().toString().trim();
            loginUser(email, password);

        }
    }


    //Login User if they have an account
    private void loginUser(final String email, final String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Snackbar snackBar = Snackbar.make(activity_main, "Invalid email address or Password. Register before using the application  ", Snackbar.LENGTH_SHORT);
                            snackBar.show();
                        } else {
                            startActivity(new Intent(MainActivity.this, HomeScreen.class));
                            finish();
                        }
                    }
                });
    }
}
