package com.simbirsoft.derevyankoA.api.client;

import com.simbirsoft.derevyankoA.api.methods.BreedsAPI;
import com.simbirsoft.derevyankoA.api.methods.FavouritesAPI;
import com.simbirsoft.derevyankoA.api.methods.ImagesAPI;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class ApiClient {

    public static final String BASE_URL = "https://api.thecatapi.com/v1";

    private final BreedsAPI BREEDS_API;
    private final ImagesAPI IMAGES_API;
    private final FavouritesAPI FAVOURITES_API;

    public ApiClient() {
        this.BREEDS_API = new BreedsAPI();
        this.IMAGES_API = new ImagesAPI();
        this.FAVOURITES_API = new FavouritesAPI();
    }
}
