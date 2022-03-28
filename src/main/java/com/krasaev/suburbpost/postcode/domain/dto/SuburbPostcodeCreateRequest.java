package com.krasaev.suburbpost.postcode.domain.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public record SuburbPostcodeCreateRequest(@Valid @NotEmpty List<SuburbPostcodeDto> suburbPostcodes) {

}
