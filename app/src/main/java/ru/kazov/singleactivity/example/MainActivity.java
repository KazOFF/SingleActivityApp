package ru.kazov.singleactivity.example;

import android.os.Bundle;

import ru.kazov.singleactivity.SingleActivity;
import ru.kazov.singleactivity.example.fragments.MainFragment;

public class MainActivity extends SingleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContainer(R.id.container);

        addFragmentNoAnimation(new MainFragment(), "");
    }
}