package com.krasaev.suburbpost.postcode.service;

import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodeDto;
import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodePage;

import java.util.List;

public interface SuburbPostcodeService {

    List<SuburbPostcodeDto> save(List<SuburbPostcodeDto> suburbPostcodeDtos);

    SuburbPostcodePage findByRange(String from, String to);

}
