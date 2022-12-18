package com.simbirsoft.derevyankoA.api.jackson_entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesResponse {

    private BreedsResponse[] breeds;

    @JsonProperty("id")
    private String idImages;
    @JsonProperty("url")
    private String urlImages;
}
