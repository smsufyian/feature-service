package de.up42.services.featureservice.support;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import de.up42.services.featureservice.FeatureServiceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(
        classes = FeatureServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)

@Slf4j
public class AbstractIntegrationTest {

  @LocalServerPort
  protected int localServerPort;
  protected RequestSpecification requestSpecification;

  @BeforeEach
  public void setupAbstractIntegrationTest() {
    requestSpecification = new RequestSpecBuilder()
      .setPort(localServerPort)
      .setContentType(ContentType.JSON)
      .build();
  }
}
