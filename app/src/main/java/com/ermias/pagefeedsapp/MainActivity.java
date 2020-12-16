package com.ermias.pagefeedsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private List<Card> cardList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if(!isOnline()){
            Toast.makeText(this, "Not internet connection ",
                    Toast.LENGTH_LONG).show();
            onDestroy();
        }
        JSONHelper jsonHelper = new JSONHelper();
        List<Card> cards = jsonHelper.getCardList(
                "https://private-8ce77c-tmobiletest.apiary-mock.com/test/home");

        PageFeedsAdapter adapter = new PageFeedsAdapter(this, cards);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}