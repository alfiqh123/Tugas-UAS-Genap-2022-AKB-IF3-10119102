package com.example.tugas_uas_genap_2022_akb_if3_10119102.ui.profile;

/*
 * NIM : 10119102
 *Nama : Muhammad Alfiqh Nugraha
 *Kelas : if3
 *Email : m.alfiqnugraha@gmail.com
 * */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.tugas_uts_genap_2022_akb_if3_10119102.DialogAbout;
import com.example.tugas_uas_genap_2022_akb_if3_10119102.DialogAbout;
import com.example.tugas_uas_genap_2022_akb_if3_10119102.R;

import androidx.fragment.app.Fragment;

public class FragmentProfile extends Fragment {
    ImageView Instagram, Whatsapp, Telegram, Gmail, Github, Linkedin, Maps;
    TextView Abouts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        Abouts = root.findViewById(R.id.about);



        Abouts.setOnClickListener(view -> {
            DialogAbout DialogAbout = new DialogAbout();
            DialogAbout.show(requireFragmentManager(),"Muhammad Alfiqh Nugraha");
        });

        return root;
    }
}

