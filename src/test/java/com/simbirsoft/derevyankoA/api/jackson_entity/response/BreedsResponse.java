package com.simbirsoft.derevyankoA.api.jackson_entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BreedsResponse {

    @JsonProperty("id")
    private String idBreed;
    @JsonProperty("name")
    private String nameBreed;
}
