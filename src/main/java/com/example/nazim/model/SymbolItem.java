package com.example.nazim.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@ToString
@Setter
public class SymbolItem {

    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Exchange")
    private String exchange;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Isin")
    private String isin;

}
