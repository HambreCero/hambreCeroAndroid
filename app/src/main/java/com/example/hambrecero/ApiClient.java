package com.example.hambrecero;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    // 🔁 Mañana solo cambias esta URL192.168.56.1
    public static final String BASE_URL = "http://172.22.254.252:8080/";

    // Emulador: 10.0.2.2
    // Móvil real: pon la IP de tu PC, ej: http://192.168.1.50:8080/

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
