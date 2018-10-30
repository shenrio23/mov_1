package net.anandsingh.moviez.api;

import net.anandsingh.moviez.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anand Singh on 23-07-2016.
 */
public class RetrofitClient {

    private static Retrofit retrofit = null;


    /**
     * Gets client.
     *
     * @return the client
     */
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.MOVIEDB_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
