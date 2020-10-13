package de.up42.services.featureservice.service;

import de.up42.services.featureservice.entity.Collection;
import de.up42.services.featureservice.repository.JsonFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeatureLookupService {

  final JsonFileRepository fileRepository;

  public List<Collection> getAllFeatures(){
    var DATA_SOURCE = "source-data.json" ;
    List<Collection> features;
      features = fileRepository.getAllFeatures(DATA_SOURCE);
    return features;
  }
}
