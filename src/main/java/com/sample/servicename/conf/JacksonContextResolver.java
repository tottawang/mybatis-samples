package com.sample.servicename.conf;

import javax.ws.rs.ext.ContextResolver;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonContextResolver implements ContextResolver<ObjectMapper> {
  private ObjectMapper objectMapper;

  public JacksonContextResolver() {
    this.objectMapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
        .configure(DeserializationFeature.WRAP_EXCEPTIONS, false)
        .configure(SerializationFeature.INDENT_OUTPUT, true)
        .configure(SerializationFeature.WRAP_EXCEPTIONS, false)
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

  @Override
  public ObjectMapper getContext(Class<?> arg0) {
    return objectMapper;
  }

}
