package com.example.nazim.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class EndOfDayStockItem {

	@JsonProperty("date")
	String date;
	@JsonProperty("open")
	float open;
	@JsonProperty("high")
	float high;
	@JsonProperty("low")
	float low;
	@JsonProperty("close")
	float close;
	@JsonProperty("volume")
	long volume;
	@JsonProperty("adjusted_close")
	float adjPrice;
}
