package com.example.tugas_uas_genap_2022_akb_if3_10119102;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tugas_uas_genap_2022_akb_if3_10119102.databinding.ActivityRegisterBinding;
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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityRegisterBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(this);
    }

    protected void registerAccount() {
        mAuth = FirebaseAuth.getInstance();

        String email = binding.emailLayout.getEditText().getText().toString();
        String password = binding.emailLayout.getEditText().getText().toString();

        if (email.isEmpty() && password.isEmpty()) {
            binding.emailLayout.setError(getApplicationContext().getText(R.string.error));
            binding.passwordLayout.setError(getApplicationContext().getText(R.string.error));
        } else if (email.isEmpty()){
            binding.emailLayout.setError(getApplicationContext().getText(R.string.error));
        } else if (password.isEmpty()) {
            binding.passwordLayout.setError(getApplicationContext().getText(R.string.error));
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage(R.string.text_dialog)
                                .setPositiveButton(R.string.text_login, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }).create().show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Register failed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRegister) {
            registerAccount();
        }
    }
}