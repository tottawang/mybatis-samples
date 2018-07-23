package com.sample.servicename.repository;

public class SampleRepository {

  private SampleMapper sampleMapper;

  public SampleRepository(SampleMapper sampleMapper) {
    this.sampleMapper = sampleMapper;
  }

  public void save(Sample token) {
    sampleMapper.save(token.getDescription(), token.getCreated_date());
  }

  public Sample getById(int sampleId) {
    return sampleMapper.findById(sampleId);
  }

}
