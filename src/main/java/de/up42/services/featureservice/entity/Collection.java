package de.up42.services.featureservice.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "features"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Collection {
  @JsonProperty("type")
  String type;
  @JsonProperty("features")
  List<Feature> features;

}
