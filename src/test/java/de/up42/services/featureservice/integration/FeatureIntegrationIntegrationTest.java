package de.up42.services.featureservice.integration;

import com.jayway.restassured.http.ContentType;
import de.up42.services.featureservice.support.AbstractIntegrationTest;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

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

  @Test
  @Tag("integration")
  public void shouldReturnFeatureInTheNonEmptySourceFile(){
    var ALL_FEATURES = "/features/2ed68fe5-f719-48c3-aa27-b0cc155f06cb";
    given(requestSpecification)
            .when()
            .get(ALL_FEATURES)
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("id",Matchers.equalTo("2ed68fe5-f719-48c3-aa27-b0cc155f06cb"));
  }

  @Test
  @Tag("integration")
  public void shouldReturnErrorIfFeatureNotPresent(){
    var ALL_FEATURES = "/features/2ed68fe5";
    given(requestSpecification)
            .when()
            .get(ALL_FEATURES)
            .then()
            .statusCode(404)
            .contentType(ContentType.JSON)
            .body("errors",Matchers.hasSize(1));
  }
}
