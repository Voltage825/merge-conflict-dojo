package com.example.client;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ClientService {

  private final RestTemplate restTemplate;

  @Autowired
  public ClientService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @PostConstruct
  public void postConstruct() {
    String body = restTemplate.getForEntity("http://localhost:8080/your-endpoint", String.class).getBody();
    log.info("got back: {}", body);
  }
}
