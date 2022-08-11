package com.example.tugas_uas_genap_2022_akb_if3_10119102;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
/*
 * NIM : 10119102
 *Nama : Muhammad Alfiqh Nugraha
 *Kelas : if3
 *Email : m.alfiqnugraha@gmail.com
 * */

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.tugas_uts_genap_2022_akb_if3_10119102", appContext.getPackageName());
    }
}