package com.example.tugas_uas_genap_2022_akb_if3_10119102.ui.home;

/*
 * NIM : 10119102
 *Nama : Muhammad Alfiqh Nugraha
 *Kelas : if3
 *Email : m.alfiqnugraha@gmail.com
 * */

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tugas_uas_genap_2022_akb_if3_10119102.LoginActivity;
import com.example.tugas_uas_genap_2022_akb_if3_10119102.R;
import com.example.tugas_uas_genap_2022_akb_if3_10119102.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;

public class FragmentHome extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =  FragmentHomeBinding.inflate(inflater, container, false);

        binding.btnLogout.setOnClickListener(this);

        return binding.getRoot();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            this.getActivity().finish();
        }
    }
}
