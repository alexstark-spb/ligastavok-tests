package com.simbirsoft.derevyankoA.api.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiEndpoints {

    GET_BREEDS("/breeds"),
    SEARCH_IMAGES("/images/search"),
    ADD_TO_FAVOURITES("/favourites");

    private final String endpoint;
}
