package com.krasaev.suburbpost.postcode.domain.mapper;

import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodeDto;
import com.krasaev.suburbpost.postcode.domain.entity.SuburbPostcode;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface SuburbPostcodeMapper {

    SuburbPostcode map(SuburbPostcodeDto suburbPostcodeDto);

    SuburbPostcodeDto map(SuburbPostcode suburbPostcode);
}
