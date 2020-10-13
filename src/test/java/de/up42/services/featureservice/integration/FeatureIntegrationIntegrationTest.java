package de.up42.services.featureservice.integration;

import com.jayway.restassured.http.ContentType;
import de.up42.services.featureservice.support.AbstractIntegrationTest;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.jayway.restassured.RestAssured.given;

@RequiredArgsConstructor
public class FeatureIntegrationIntegrationTest extends AbstractIntegrationTest {

  @Test
  @Tag("integration")
  public void shouldReturnAllFeaturesInTheNonEmptySourceFile(){
    var ALL_FEATURES = "/features";
    given(requestSpecification)
            .when()
            .get(ALL_FEATURES)
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("features",Matchers.hasSize(14));
  }
}
