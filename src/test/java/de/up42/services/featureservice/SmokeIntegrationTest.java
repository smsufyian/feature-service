package de.up42.services.featureservice;

import de.up42.services.featureservice.support.AbstractIntegrationTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class SmokeIntegrationTest extends AbstractIntegrationTest {

  @Test
  @Tag("smokeTest")
  void serviceHealthTest() {
    var HEALTH = "/health";
    given(requestSpecification)
            .when()
            .get(HEALTH)
            .then()
            .statusCode(200);
  }

  @Test
  @Tag("smokeTest")
  void serviceDataSourceTest() {
    var DATA_FILE = "/source-data.json";
    var dataStream = this.getClass().getResourceAsStream(DATA_FILE);
    assertNotNull(dataStream);
  }
}