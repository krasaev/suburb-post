package com.krasaev.suburbpost.postcode.controller;

import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodeCreateRequest;
import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodeDto;
import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodePage;
import com.krasaev.suburbpost.postcode.service.SuburbPostcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class SuburbPostcodeController implements SuburbPostcodeApi {

    private final SuburbPostcodeService suburbPostcodeService;

    @Override
    public ResponseEntity<List<SuburbPostcodeDto>> createSuburbPostcodes(
            SuburbPostcodeCreateRequest suburbPostcodeCreateRequest) {
        List<SuburbPostcodeDto> dtos = suburbPostcodeService.save(suburbPostcodeCreateRequest.suburbPostcodes());
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }

    @Override
    public SuburbPostcodePage fetchSuburbPostcodes(String rangeFrom, String rangeTo) {
        return suburbPostcodeService.findByRange(rangeFrom, rangeTo);
    }
}
