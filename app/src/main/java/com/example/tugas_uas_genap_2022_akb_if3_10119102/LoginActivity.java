package com.example.tugas_uas_genap_2022_akb_if3_10119102;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tugas_uas_genap_2022_akb_if3_10119102.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/*
 * NIM : 10119102
 *Nama : Muhammad Alfiqh Nugraha
 *Kelas : if3
 *Email : m.alfiqnugraha@gmail.com
 * */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityLoginBinding binding;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(this);
        binding.btnLogin.setOnClickListener(this);
    }

    protected void userSignIn() {
        auth = FirebaseAuth.getInstance();

        String email = binding.emailLayout.getEditText().getText().toString();
        String password = binding.passwordLayout.getEditText().getText().toString();

        if (email.isEmpty() && password.isEmpty()) {
           binding.emailLayout.setError(getApplicationContext().getText(R.string.error));
           binding.passwordLayout.setError(getApplicationContext().getText(R.string.error));
        } else if (email.isEmpty()){
            binding.emailLayout.setError(getApplicationContext().getText(R.string.error));
        } else if (password.isEmpty()) {
            binding.passwordLayout.setError(getApplicationContext().getText(R.string.error));
        }
        else {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        Intent intent = new Intent(getApplicationContext(), ActivityHome.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), ActivityHome.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRegister) {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btnLogin) {
            userSignIn();
        }
    }
}