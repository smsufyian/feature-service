package de.up42.services.featureservice.api;

import de.up42.services.featureservice.entity.Collection;
import de.up42.services.featureservice.entity.Feature;
import de.up42.services.featureservice.service.FeatureLookupService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/features")
@Validated
public class FeaturesApi {

  final FeatureLookupService lookupService;

  @GetMapping
  public ResponseEntity<FeaturesResponseDTO> features() {
    return ResponseEntity.ok()
            .body(FeaturesResponseDTO.from(lookupService.getAllFeatures()));
  }

  @Value
  @Builder
  static class FeaturesResponseDTO {

    List<FeatureResponseDTO> features;

    public static FeaturesResponseDTO from(List<Collection> featuresCollection) {
      return FeaturesResponseDTO.builder()
              .features(featuresCollection.stream()
                      .flatMap(collection -> collection.getFeatures()
                              .stream()
                              .map(FeatureResponseDTO::from))
                      .collect(Collectors.toList()))
              .build();
    }

  }

  @Value
  @Builder
  static class FeatureResponseDTO {
    String id;
    BigInteger timestamp;
    BigInteger beginViewingDate;
    BigInteger endViewingDate;
    String missionName;

    public static FeatureResponseDTO from(Feature feature) {
      return FeatureResponseDTO.builder()
              .id(feature.getProperties().getId())
              .timestamp(feature.getProperties().getTimestamp())
              .beginViewingDate(feature.getProperties()
                      .getAcquisition()
                      .getBeginViewingDate())
              .endViewingDate(feature.getProperties()
                      .getAcquisition()
                      .getEndViewingDate())
              .missionName(feature.getProperties()
                      .getAcquisition()
                      .getMissionName())
              .build();
    }
  }
}
