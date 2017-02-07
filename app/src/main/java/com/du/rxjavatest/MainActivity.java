package com.du.rxjavatest;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.du.rxjavatest.fragment.Myfragment;
import com.du.rxjavatest.utils.OkGoUtils;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZonedDateTime;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button whatfuck;
    Button getrx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getRxjava();

        whatfuck = (Button) findViewById(R.id.whatfuck);
        getrx = (Button) findViewById(R.id.getrx);
        whatfuck.setOnClickListener(this);
        getrx.setOnClickListener(this);
    }

    public void getRxjava() {
        Observable.just("1", "2", "3", "4")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.whatfuck:
                OkGoUtils.get();
                break;
            case R.id.getrx:
                OkGoUtils.getbyRx();

                break;

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void testforException() {
        LocalDateTime now1 = LocalDateTime.now();


        ZonedDateTime now = ZonedDateTime.now();
    }
}
