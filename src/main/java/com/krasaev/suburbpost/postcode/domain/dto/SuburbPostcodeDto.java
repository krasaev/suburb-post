package com.krasaev.suburbpost.postcode.domain.dto;

import com.krasaev.suburbpost.postcode.validation.Postcode;

import javax.validation.constraints.NotBlank;

public record SuburbPostcodeDto(@Postcode String postcode, @NotBlank String locality) {

}
