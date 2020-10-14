package de.up42.services.featureservice.error;

import me.alidg.errors.annotation.ExceptionMapping;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.NOT_FOUND, errorCode = "feature.not_found")
public class FeatureNotFoundException extends RuntimeException{
}
