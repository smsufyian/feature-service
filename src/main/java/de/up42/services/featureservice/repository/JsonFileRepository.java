package de.up42.services.featureservice.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.up42.services.featureservice.entity.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class JsonFileRepository {

  final static ObjectMapper objectMapper = new ObjectMapper();

  List<Collection> features;

  public List<Collection> getAllFeatures(String datasource) {
    if (loaded()) {
      return features;
    }
    else
      load(datasource);
    return features;
  }

  private Boolean loaded() {
    return features != null;
  }

  private void load(String datasource) {
    if (exist(datasource)) {
      read(datasource);
    }
    else
      features = List.of();
  }

  private Boolean exist(String datasource) {
    boolean isPresent = true;
    try {
      ResourceUtils.getFile("classpath:" + datasource);
    } catch (FileNotFoundException e) {
      isPresent = false;
    }
    return isPresent;
  }

  private void read(String datasource) {
    var input = this.getClass().getResourceAsStream("/" + datasource);
    TypeReference<List<Collection>> mapType = new TypeReference<>() {
    };
    try {
      features = objectMapper.readValue(input, mapType);
    } catch (IOException exception) {
      features = List.of();
    }
  }

}
