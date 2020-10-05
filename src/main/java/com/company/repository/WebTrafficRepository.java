package com.company.repository;

import com.company.entity.WebTraffic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WebTrafficRepository extends CrudRepository<WebTraffic, Long> {
    WebTraffic getByDate(Date date);
}
