package com.sample.servicename.repository;

import java.util.Date;

public class Sample {

  private int sample_id;
  private String description;
  private Date created_date;

  public int getSample_id() {
    return sample_id;
  }

  public void setSample_id(int sample_id) {
    this.sample_id = sample_id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreated_date() {
    return created_date;
  }

  public void setCreated_date(Date created_date) {
    this.created_date = created_date;
  }
}
