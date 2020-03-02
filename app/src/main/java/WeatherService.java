
public interface WeatherService {
    @GET("data/2.5/weather?")
    Call getCurrentWeatherData(@Query("lat") String lat, @Query("lon") String lon, @Query("APPID") String app_id);
}

