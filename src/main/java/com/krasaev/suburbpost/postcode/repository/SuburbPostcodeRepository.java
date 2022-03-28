package com.krasaev.suburbpost.postcode.repository;

import com.krasaev.suburbpost.postcode.domain.entity.SuburbPostcode;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuburbPostcodeRepository extends PagingAndSortingRepository<SuburbPostcode, String> {

    List<SuburbPostcode> findAllByPostcodeBetween(String from, String to);
}
