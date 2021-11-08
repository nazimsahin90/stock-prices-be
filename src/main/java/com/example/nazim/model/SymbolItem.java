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
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("description")
    private String desc;
    @JsonProperty("displaySymbol")
    private String displaySym;
    @JsonProperty("figi")
    private String figi;
    @JsonProperty("mic")
    private String mic;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("type")
    private String type;
}
