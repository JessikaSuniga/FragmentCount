package com.example.fragmentappcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentButton.OnIncrementListener {

    private FragmentCount counter1Fragment;
    private FragmentCount counter2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentButton fragmentButton = new FragmentButton();
        fragmentTransaction.add(R.id.layButton, fragmentButton);

        counter1Fragment = new Fragment1Count();
        fragmentTransaction.add(R.id.layCounter1, counter1Fragment);

        counter2Fragment = new Fragment2Count();
        fragmentTransaction.add(R.id.layCounter2, counter2Fragment);

        fragmentTransaction.commit();
    }

    @Override
    public void onIncrement() {
        counter1Fragment.increment();
        counter2Fragment.increment();
    }

}