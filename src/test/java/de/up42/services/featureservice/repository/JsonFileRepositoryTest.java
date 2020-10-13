package de.up42.services.featureservice.repository;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JsonFileRepositoryTest {

  @Test
  @Tag("repository")
  public void shouldReturnNonEmptyFeatureListIfFileExist() {
    var repository = new JsonFileRepository();
    var features = repository.getAllFeatures("source-with-data.json");
    assertThat(features.size()).isEqualTo(1);
  }

  @Test
  @Tag("repository")
  public void shouldReturnEmptyFeatureListIfJsonDataFileNotExist() {
    var repository = new JsonFileRepository();
    var features = repository.getAllFeatures("not-present.json");
    assertThat(features.size()).isEqualTo(0);
  }

  @Test
  @Tag("repository")
  public void shouldReturnEmptyFeatureListIfJsonDataFileIsEmpty() {
    var repository = new JsonFileRepository();
    var features = repository.getAllFeatures("source-without-data.json");
    assertThat(features.size()).isEqualTo(0);
  }
}
