package de.up42.services.featureservice.service;

import de.up42.services.featureservice.entity.Feature;
import de.up42.services.featureservice.entity.Collection;
import de.up42.services.featureservice.repository.JsonFileRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class FeatureLookupServiceTest{

  @Mock
  JsonFileRepository jsonFileRepository;

  FeatureLookupService featureLookupService;

  @BeforeEach
  public void setUp(){
    featureLookupService = new FeatureLookupService(jsonFileRepository);
  }

  @Test
  @Tag("service")
  @SneakyThrows
  public void shouldReturnNonEmptyFeaturesListIfDatasourceIsNotEmpty(){

    given(jsonFileRepository.getAllFeatures(anyString()))
            .willReturn(nonEmptyFeaturesSource());

    var features = featureLookupService.getAllFeatures();

    assertThat(features).isNotEmpty();
    assertThat(features).size().isEqualTo(1);
  }

  @Test
  @Tag("service")
  @SneakyThrows
  public void shouldReturnEmptyFeaturesListIfJsonDatasourceIsEmpty(){

    given(jsonFileRepository.getAllFeatures(anyString()))
            .willReturn(List.of());
    var features = featureLookupService.getAllFeatures();

    assertThat(features).isEmpty();
  }

  private static List<Collection> nonEmptyFeaturesSource(){
    return List.of(Collection.builder()
            .type("FeatureCollection")
            .features(List.of(
                    Feature.builder()
                            .type("Feature")
                            .bbox(List.of(
                                    10.820127,
                                    -7.276685,
                                    13.581676,
                                    -4.690226))
                            .geometry(
                                    Feature.Geometry.builder()
                                            .type("Polygon")
                                            .coordinates(
                                                    List.of(
                                                            List.of(
                                                                    List.of(
                                                                            11.270586,
                                                                            -7.276685
                                                                    ),
                                                                    List.of(
                                                                            13.581676,
                                                                            -6.75867
                                                                    ),
                                                                    List.of(
                                                                            13.124103,
                                                                            -4.690226
                                                                    ),
                                                                    List.of(
                                                                            10.820127,
                                                                            -5.201075
                                                                    ),
                                                                    List.of(
                                                                            11.270586,
                                                                            -7.276685
                                                                    )

                                                            )
                                                    )
                                            )
                                            .build())
                            .properties(
                                    Feature.Properties.builder()
                                            .id("39c2f29e")
                                            .timestamp(BigInteger.TWO)
                                            .centroid(
                                                    Feature.Properties.Centroid.builder()
                                                            .type("Point")
                                                            .coordinates(
                                                                    List.of(
                                                                            12.198765019427462,
                                                                            -5.982393630543264
                                                                    )
                                                            )
                                                            .build()
                                            )
                                            .visibility(
                                                    Feature.Properties.Visibility.builder()
                                                            .deleted(Boolean.FALSE)
                                                            .build()
                                            )
                                            .illumination(Feature.Properties.Illumination.builder()
                                                    .build())
                                            .production(
                                                    Feature.Properties.Production.builder()
                                                            .levelCode("L1")
                                                            .ongoing(Boolean.FALSE)
                                                            .build())
                                            .archive(
                                                    Feature.Properties.Archive.builder()
                                                            .offLine(Boolean.FALSE)
                                                            .size(2314)
                                                            .onLine(Boolean.FALSE)
                                                            .build()
                                            )
                                            .spatialCoverage(
                                                    Feature.Properties.SpatialCoverage.builder()
                                                            .verticality(
                                                                    Feature.Properties.SpatialCoverage.Verticality.builder()
                                                                            .build()
                                                            )
                                                            .geometry(
                                                                    Feature.Properties.SpatialCoverage.Geometry.builder()
                                                                            .geographicBoundingPolygon(
                                                                                    Feature.Properties.SpatialCoverage.Geometry.GeographicBoundingPolygon.builder()
                                                                                            .coordinates(
                                                                                                    List.of(
                                                                                                            List.of(
                                                                                                                    List.of(
                                                                                                                            11.270586,
                                                                                                                            -7.276685
                                                                                                                    ),
                                                                                                                    List.of(
                                                                                                                            13.581676,
                                                                                                                            -6.75867
                                                                                                                    ),
                                                                                                                    List.of(
                                                                                                                            13.124103,
                                                                                                                            -4.690226
                                                                                                                    ),
                                                                                                                    List.of(

                                                                                                                            10.820127,
                                                                                                                            -5.201075
                                                                                                                    ),
                                                                                                                    List.of(
                                                                                                                            11.270586,
                                                                                                                            -7.276685
                                                                                                                    )

                                                                                                            )
                                                                                                    )
                                                                                            )
                                                                                            .type("Polygon")
                                                                                            .build()
                                                                            )
                                                                            .global(Boolean.FALSE)
                                                                            .centerPoint(
                                                                                    Feature.Properties.SpatialCoverage.Geometry.CentrePoint.builder()
                                                                                            .lat(-5.982393630543264)
                                                                                            .lon(12.198765019427462)
                                                                                            .build()
                                                                            )
                                                                            .build()
                                                            )
                                                            .build()
                                            )
                                            .timestamp(BigInteger.ZERO)
                                            .uuid("39c2f29e-c0f8-4a39-a98b-deed547d6aea")
                                            .enrichment(
                                                    Feature.Properties.Enrichment.builder()
                                                            .naturallanguage(
                                                                    Feature.Properties.Enrichment.NaturalLanguage.builder()
                                                                            .searchCloudString("cloud:?")
                                                                            .searchDateString("2019 April 09 17: 17:32 17:32:47")
                                                                            .searchIncidenceAngleString("incidence:?")
                                                                            .searchQualityString("quality:?")
                                                                            .build()
                                                            )
                                                            .build()
                                            )
                                            .identification(
                                                    Feature.Properties.Identification.builder()
                                                            .profile("Image")
                                                            .externalId("S1B_IW_GRDH_1SDV_20190409T173247_20190409T173322_015732_01D861_5713")
                                                            .collection("Sentinel-1")
                                                            .type("GRD")
                                                            .dataset(Feature.Properties.Identification.Dataset.builder().build())
                                                            .build()
                                            )
                                            .transmission(
                                                    Feature.Properties.Transmission.builder()
                                                            .build()
                                            )
                                            .contentDescription(
                                                    Feature.Properties.ContentDescription.builder()
                                                            .build()
                                            )
                                            .acquisition(
                                                    Feature.Properties.Acquisition.builder()
                                                            .endViewingDate(BigInteger.TWO)
                                                            .mission("Sentinel-1")
                                                            .missionId("B")
                                                            .missionCode("S1B")
                                                            .beginViewingDate(BigInteger.ONE)
                                                            .missionName("Sentinel-1B")
                                                            .polarization("VV VH")
                                                            .sensorMode("IW")
                                                            .sensorId("SAR-C SAR")
                                                            .build()
                                            )
                                            .orbit(
                                                    Feature.Properties.Orbit.builder()
                                                            .relativeNumber(131)
                                                            .direction("ASCENDING")
                                                            .build()
                                            )
                                            .state(
                                                    Feature.Properties.State.builder()
                                                            .resources(
                                                                    Feature.Properties.State.Resources.builder()
                                                                            .quicklook(Boolean.TRUE)
                                                                            .thumbnail(Boolean.TRUE)
                                                                            .build()
                                                            )
                                                            .services(
                                                                    Feature.Properties.State.Services.builder()
                                                                            .wms(Boolean.TRUE)
                                                                            .download("internal")
                                                                            .wcs(Boolean.FALSE)
                                                                            .wms(Boolean.TRUE)
                                                                            .build()
                                                            )
                                                            .insertionDate(BigInteger.TEN)
                                                            .build()
                                            )
                                            .attitude(
                                                    Feature.Properties.Attitude.builder()
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

}
