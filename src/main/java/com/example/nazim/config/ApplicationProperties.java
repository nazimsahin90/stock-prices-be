package com.example.nazim.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Component
@Getter
@PropertySource(value = "classpath:application.properties")
@Slf4j
@ToString
public class ApplicationProperties {
	@Value("${data.source.url}")
	private String dataUrl;

	@Value("${api.token}")
	private String apiToken;
	@Value("${eod.path}")
	private String eodPath;
	@Value("${symbol.path}")
	private String symPath;
}
