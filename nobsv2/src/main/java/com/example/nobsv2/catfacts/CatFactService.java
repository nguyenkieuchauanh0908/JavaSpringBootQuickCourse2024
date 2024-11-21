package com.example.nobsv2.catfacts;

import com.example.nobsv2.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@Service
public class CatFactService implements Query<Integer, CatFactDTO> {
    private final RestTemplate restTemplate;
    private final String url = "https://catfact.ninja/fact";
    private final String MAX_LENGTH = "max_length";

    public CatFactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<CatFactDTO> execute(Integer input) {
        //sets up URL with query string parameters
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam(MAX_LENGTH, input)
                .build()
                .toUri();
        //headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept","application/json"); //can also abstract these to the top of the class

        //use the headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        //handle cat fact error response
        try{
            ResponseEntity<CatFactResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, CatFactResponse.class);
            CatFactDTO catFactDTO = new CatFactDTO(Objects.requireNonNull(response.getBody()).getFact());
            return ResponseEntity.ok(catFactDTO);
        }catch (Exception exception){
            //can throw your own customized exception
            throw new RuntimeException("Cat Facts API is down!");
        }



    }
}
