package de.up42.services.featureservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

  @JsonProperty("type")
  String type;

  @JsonProperty("bbox")
  List<Double> bbox;

  @JsonProperty("geometry")
  Geometry geometry;

  @JsonProperty("properties")
  Properties properties;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder(toBuilder = true)
  public static class Geometry {

    @JsonProperty("type")
    String type;

    @JsonProperty("coordinates")
    List<List<List<Double>>> coordinates;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder(toBuilder = true)
  public static class Properties {

    @JsonProperty("id")
    String id;

    @JsonProperty("timestamp")
    BigInteger timestamp;

    @JsonProperty("centroid")
    Centroid centroid;

    @JsonProperty("visibility")
    Visibility visibility;

    @JsonProperty("illumination")
    Illumination illumination;

    @JsonProperty("production")
    Production production;

    @JsonProperty("archive")
    Archive archive;

    @JsonProperty("spatialCoverage")
    SpatialCoverage spatialCoverage;

    @JsonProperty("quality")
    Quality quality;

    @JsonProperty("target")
    Target target;

    @JsonProperty("timeStamp")
    BigInteger timestamp1;

    @JsonProperty("uid")
    String uuid;

    @JsonProperty("enrichment")
    Enrichment enrichment;

    @JsonProperty("identification")
    Identification identification;

    @JsonProperty("transmission")
    Transmission transmission;

    @JsonProperty("contentDescription")
    ContentDescription contentDescription;

    @JsonProperty("provider")
    Provider provider;

    @JsonProperty("acquisition")
    Acquisition acquisition;

    @JsonProperty("orbit")
    Orbit orbit;

    @JsonProperty("state")
    State state;

    @JsonProperty("attitude")
    Attitude attitude;

    @JsonProperty("quicklook")
    String quicklook;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class Centroid {

      @JsonProperty("type")
      String type;

      @JsonProperty("coordinates")
      List<Double> coordinates;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class Visibility {

      @JsonProperty("deleted")
      Boolean deleted;
    }

    @Data
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class Illumination { }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class Production {

      @JsonProperty("levelCode")
      String levelCode;

      @JsonProperty("ongoing")
      Boolean ongoing;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class Archive {

      @JsonProperty("offLine")
      Boolean offLine;

      @JsonProperty("size")
      Integer size;

      @JsonProperty("onLine")
      Boolean onLine;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class SpatialCoverage {

      @JsonProperty("verticality")
      Verticality verticality;

      @JsonProperty("geometry")
      Geometry geometry;

      @Data
      @AllArgsConstructor
      @Builder(toBuilder = true)
      public static class Verticality { }

      @Data
      @AllArgsConstructor
      @NoArgsConstructor
      @Builder(toBuilder = true)
      public static class Geometry {

        @JsonProperty("geographicBoundingPolygon")
        GeographicBoundingPolygon geographicBoundingPolygon;

        @JsonProperty("global")
        Boolean global;

        @JsonProperty("centerPoint")
        CentrePoint centerPoint;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder(toBuilder = true)
        public static class GeographicBoundingPolygon {

          @JsonProperty("coordinates")
          List<List<List<Double>>> coordinates;

          @JsonProperty("type")
          String type;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder(toBuilder = true)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "lon",
                "lat"
        })
        public static class CentrePoint {

          @JsonProperty("lon")
          Double lon;

          @JsonProperty("lat")
          Double lat;
        }
      }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class Quality {

      @JsonProperty("qualified")
      Boolean qualified;
    }

    @Data
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class Target { }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class Enrichment {

      @JsonProperty("geonames")
      List<GeoName> geonames;

      @JsonProperty("naturallanguage")
      NaturalLanguage naturallanguage;

      @Data
      @AllArgsConstructor
      @NoArgsConstructor
      @Builder(toBuilder = true)
      public static class NaturalLanguage {

        @JsonProperty("search_date_string")
        String searchDateString;

        @JsonProperty("search_quality_string")
        String searchQualityString;

        @JsonProperty("search_cloud_string")
        String searchCloudString;

        @JsonProperty("search_incidence_angle_string")
        String searchIncidenceAngleString;
      }

      @Data
      @AllArgsConstructor
      @NoArgsConstructor
      @Builder(toBuilder = true)
      public static class GeoName{

        @JsonProperty("name")
        String name;

        @JsonProperty("states")
        List<State> states;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder(toBuilder = true)
        public static class State {

          @JsonProperty("name")
          String name;

          @JsonProperty
          List<County> counties;

          @Data
          @AllArgsConstructor
          @NoArgsConstructor
          @Builder(toBuilder = true)
          public static class County{

            @JsonProperty("name")
            String name;
          }
        }
      }

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class Identification {

      String profile;
      String externalId;
      String collection;
      String type;
      Dataset dataset;

      @Data
      @AllArgsConstructor
      @Builder(toBuilder = true)
      public static class Dataset {
      }
    }

    @Data
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class Transmission {
    }

    @Data
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class ContentDescription {
    }

    @Data
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class Provider { }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class Acquisition {

      @JsonProperty("endViewingDate")
      BigInteger endViewingDate;

      @JsonProperty("mission")
      String mission;

      @JsonProperty("missionId")
      String missionId;

      @JsonProperty("missionCode")
      String missionCode;

      @JsonProperty("beginViewingDate")
      BigInteger beginViewingDate;

      @JsonProperty("missionName")
      String missionName;

      @JsonProperty("polarization")
      String polarization;

      @JsonProperty("sensorMode")
      String sensorMode;

      @JsonProperty("sensorId")
      String sensorId;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class Orbit {

      @JsonProperty("relativeNumber")
      Integer relativeNumber;

      @JsonProperty("direction")
      String direction;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class State {

      @JsonProperty("resources")
      Resources resources;

      @JsonProperty("services")
      Services services;

      @JsonProperty("insertionDate")
      BigInteger insertionDate;

      @Data
      @AllArgsConstructor
      @NoArgsConstructor
      @Builder(toBuilder = true)
      public static class Resources {

        @JsonProperty("thumbnail")
        Boolean thumbnail;

        @JsonProperty("quicklook")
        Boolean quicklook;
      }

      @Data
      @AllArgsConstructor
      @NoArgsConstructor
      @Builder(toBuilder = true)
      public static class Services {

        @JsonProperty("wmts")
        Boolean wmts;

        @JsonProperty("download")
        String download;

        @JsonProperty("wcs")
        Boolean wcs;

        @JsonProperty("wms")
        Boolean wms;

      }
    }

    @Data
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class Attitude { }
  }
}
