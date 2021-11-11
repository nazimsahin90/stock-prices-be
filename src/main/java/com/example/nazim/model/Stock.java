package com.example.nazim.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@ToString
@Setter
public class Stock {

    @JsonProperty("price")
    private float adjPrice;
    @JsonProperty("timestamp")
    private long date;

}
