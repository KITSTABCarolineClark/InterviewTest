package com.example;

import com.example.model.ProductResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldGetMessage() {
        ResponseEntity<ProductResponse> response = restTemplate.getForEntity("/product", ProductResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        ProductResponse product = response.getBody();
        assertThat(product.getProductName()).isEqualTo("name");
        assertThat(product.getProductDescription()).isEqualTo("description");
    }
}
