package com.halitizgin.sehiroyunu;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    City city;
    EditText cityText;
    TextView pointText, lastCityText, timeText;
    Integer time, point;
    Button acceptButton;
    CountDownTimer timer;
    String lastCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = new City();

        cityText = findViewById(R.id.cityEditText);
        pointText = findViewById(R.id.pointText);
        lastCityText = findViewById(R.id.lastCityText);
        timeText = findViewById(R.id.timeText);
        acceptButton = findViewById(R.id.acceptButton);

        time = 20;
        point = 0;

        startTimer();

        cityText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (lastCity != null)
                {
                    if (before == count + 1)
                    {
                        char last = Character.toUpperCase(lastCity.charAt(lastCity.length() - 1));

                        String text = s.toString();
                        if (text.length() > 0)
                        {
                            char textFirst = text.charAt(0);
                            if (textFirst != last)
                            {
                                cityText.setText(last + text);
                                cityText.setSelection(cityText.length());
                            }
                        }
                        else
                        {
                            cityText.setText(String.valueOf(last));
                            cityText.setSelection(1);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cityText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER || actionId == EditorInfo.IME_ACTION_DONE)
                {
                    accept(acceptButton);
                }
                return false;
            }
        });
    }

    public void startTimer()
    {
        time = 20;
        if (timer != null)
            timer.cancel();

        timeText.setText(time.toString());
        timer = new CountDownTimer(20000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                time--;
                timeText.setText(time.toString());
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Süre Doldu!", Toast.LENGTH_LONG).show();
                acceptButton.setEnabled(false);
                cityText.setEnabled(false);
            }
        }.start();
    }

    public void accept(View view)
    {
        CityItem cityItem = city.getAndRemove(cityText.getText().toString());
        if (cityItem.getError() == null)
        {
            point += time;
            lastCity = cityItem.getCity();
            lastCityText.setText("Son Şehir: " + lastCity);
            pointText.setText("Puan: " + point);
            String c = cityItem.getCity();
            cityText.setText(c.substring(c.length() - 1).toUpperCase());
            cityText.setSelection(1);

            startTimer();
        }
        else
        {
            Toast.makeText(this,  cityItem.getError() + " Oyun bitti!", Toast.LENGTH_LONG).show();
            acceptButton.setEnabled(false);
            cityText.setEnabled(false);
            if (timer != null)
                timer.cancel();
        }
    }
}
