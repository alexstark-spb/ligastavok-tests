package com.simbirsoft.derevyankoA.api.jackson_entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavouritesResponse {

    @JsonProperty("message")
    private String messageFavourites;
    @JsonProperty("id")
    private Integer idFavourites;
}
