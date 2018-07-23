package com.sample.servicename.resources;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.servicename.repository.Sample;
import com.sample.servicename.repository.SampleRepository;

@Path("/sample")
@Produces("application/json")
@Consumes("application/json")
public class SampleResource {

  @Autowired
  private SampleRepository sampleRepository;

  @POST
  public void createSample() {
    Sample sample = new Sample();
    Date createdDate = Date.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant());
    sample.setCreated_date(createdDate);
    sample.setDescription("desc");
    sampleRepository.save(sample);
  }

  @GET
  public Sample getSample() {
    return sampleRepository.getById(1);
  }

}
