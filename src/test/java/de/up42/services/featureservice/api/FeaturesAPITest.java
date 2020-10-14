package de.up42.services.featureservice.api;

import de.up42.services.featureservice.entity.Feature;
import de.up42.services.featureservice.entity.Collection;
import de.up42.services.featureservice.service.FeatureLookupService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigInteger;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = FeaturesApi.class)
public class FeaturesAPITest {

  @MockBean
  FeatureLookupService featureLookupService;

  @Autowired
  MockMvc mockMvc;

  @Test
  @Tag("api")
  @SneakyThrows
  public void shouldReturnNonEmptyFeatureResponseDTOWhenDatasourceIsNotEmpty() {

    given(featureLookupService.getAllFeatures())
            .willReturn(nonEmptyDatasource());
    mockMvc.perform(get("/features"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("features").isNotEmpty())
            .andExpect(jsonPath("features[0].id").isNotEmpty())
            .andExpect(jsonPath("features[0].timestamp").isNotEmpty())
            .andExpect(jsonPath("features[0].beginViewingDate").isNotEmpty())
            .andExpect(jsonPath("features[0].endViewingDate").isNotEmpty())
            .andExpect(jsonPath("features[0].endViewingDate").isNotEmpty());
  }

  @Test
  @Tag("api")
  @SneakyThrows
  public void shouldReturnEmptyFeatureResponseDTOWhenDatasourceIsEmpty() {

    given(featureLookupService.getAllFeatures())
            .willReturn(emptyDatasource());
    mockMvc.perform(get("/features"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("features").isEmpty());
  }

  @Test
  @Tag("api")
  @SneakyThrows
  public void shouldReturnFeatureResponseDTOWhenDatasourceIsNotEmptyAndFeatureIsPresent() {

    given(featureLookupService.getFeatureById(anyString()))
            .willReturn(feature());
    mockMvc.perform(get("/features/{id}","39c2f29e"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("id").value("39c2f29e"))
            .andExpect(jsonPath("timestamp").value(BigInteger.ONE))
            .andExpect(jsonPath("beginViewingDate").value(BigInteger.ONE))
            .andExpect(jsonPath("endViewingDate").value(BigInteger.TWO))
            .andExpect(jsonPath("missionName").value("Sentinel-1B"));
  }

  private static List<Collection> nonEmptyDatasource() {
    return List.of(Collection.builder()
            .type("FeatureCollection")
            .features(List.of(
                    Feature.builder()
                            .type("Feature")
                            .properties(
                                    Feature.Properties.builder()
                                            .id("39c2f29e")
                                            .timestamp(BigInteger.ONE)
                                            .acquisition(
                                                    Feature.Properties.Acquisition.builder()
                                                            .endViewingDate(BigInteger.TWO)
                                                            .beginViewingDate(BigInteger.ONE)
                                                            .missionName("Sentinel-1B")
                                                            .build()
                                            )
                                            .quicklook("test")
                                            .build()
                            )
                            .build()
                    )
            )
            .build());
  }

  private static List<Collection> emptyDatasource() {
    return List.of();
  }

  private static Feature feature(){
    return Feature.builder()
            .type("Feature")
            .properties(
                    Feature.Properties.builder()
                            .id("39c2f29e")
                            .timestamp(BigInteger.ONE)
                            .acquisition(
                                    Feature.Properties.Acquisition.builder()
                                            .endViewingDate(BigInteger.TWO)
                                            .beginViewingDate(BigInteger.ONE)
                                            .missionName("Sentinel-1B")
                                            .build()
                            )
                            .quicklook("test")
                            .build()
            )
            .build();
  }
}
