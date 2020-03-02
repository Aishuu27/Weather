package com.example.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import java.lang.Object;
import android.view.View;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Main3Activity extends AppCompatActivity {
    public static String BaseUrl = "http://api.openweathermap.org/";
    public static String AppId = "37c6a960a6d8df2fb5a48774a1590c79";
    public static String lat = "12.9716";
    public static String lon = "77.5946";
    private TextView weatherData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        weatherData = findViewById(R.id.textView);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "Lato-Bold.ttf");
        FontUtils fontUtils = new FontUtils();
        fontUtils.applyFontToView(weatherData, typeface);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentData();
            }
        });

    }
//    public void next(View v1){
//        getCurrentData();
//    }

    void getCurrentData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);
        Call <WeatherResponse> call = service.getCurrentWeatherData(lat, lon, AppId);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    WeatherResponse weatherResponse = response.body();
                    assert weatherResponse != null;

                    String stringBuilder = "Country: " +
                            weatherResponse.sys.country +
                            "\n" +
                            "Temperature: " +
                            weatherResponse.main.temp +
                            "\n" +
                            "Temperature(Min): " +
                            weatherResponse.main.temp_min +
                            "\n" +
                            "Temperature(Max): " +
                            weatherResponse.main.temp_max +
                            "\n" +
                            "Humidity: " +
                            weatherResponse.main.humidity +
                            "\n" +
                            "Pressure: " +
                            weatherResponse.main.pressure;

                    weatherData.setText(stringBuilder);
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                weatherData.setText(t.getMessage());
            }
        });
    }

}
