package de.up42.services.featureservice.service;

import de.up42.services.featureservice.entity.Collection;
import de.up42.services.featureservice.entity.Feature;
import de.up42.services.featureservice.error.FeatureNotFoundException;
import de.up42.services.featureservice.repository.JsonFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeatureLookupService {

  final JsonFileRepository fileRepository;
  final String DATA_SOURCE = "source-data.json";

  public List<Collection> getAllFeatures() {
    return fileRepository.getAllFeatures(DATA_SOURCE);
  }

  public Feature getFeatureById(String id) {
    List<Collection> featuresCollection = fileRepository.getAllFeatures(DATA_SOURCE);
    return featuresCollection.stream()
            .flatMap(collection -> collection.getFeatures().stream()
                    .filter(feature -> feature.getProperties().getId().equalsIgnoreCase(id)))
            .findFirst()
            .orElseThrow(FeatureNotFoundException::new);
  }
}
