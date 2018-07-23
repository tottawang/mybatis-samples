package com.sample.servicename.repository;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleMapper {

  @Insert("INSERT INTO sample(description, created_date) values (#{description}, #{created_date}) ")
  void save(@Param("description") String description, @Param("created_date") Date created_date);

  @Select("SELECT * FROM sample WHERE sample_id = #{sample_id}")
  @Results({@Result(property = "sample_id", column = "sample_id")})
  Sample findById(@Param("sample_id") int sample_id);

}
