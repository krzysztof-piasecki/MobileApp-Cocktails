package pl.put.poznan.aplikacje.mobilne.cocktails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pl.put.poznan.aplikacje.mobilne.cocktails.databinding.ActivityTempBinding;

public class TempActivity extends AppCompatActivity {

    private ActivityTempBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTempBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}