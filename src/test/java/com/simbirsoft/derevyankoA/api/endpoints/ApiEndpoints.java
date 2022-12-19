package com.simbirsoft.derevyankoA.api.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiEndpoints {

    GET_BREEDS("/breeds"),
    SEARCH_IMAGES("/images/search"),
    FAVOURITES("/favourites"),
    DELETE_FROM_FAVOURITES("/favourites/{favouritesID}");

    private final String endpoint;
}
