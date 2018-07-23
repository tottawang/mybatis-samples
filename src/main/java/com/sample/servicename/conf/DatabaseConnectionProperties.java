package com.sample.servicename.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db")
public class DatabaseConnectionProperties {

  private String name;
  private String password;
  private String url;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "DatabaseConnectionProperties{" + "name='" + name + '\'' + ", password='" + password
        + '\'' + ", url='" + url + '\'' + '}';
  }
}
