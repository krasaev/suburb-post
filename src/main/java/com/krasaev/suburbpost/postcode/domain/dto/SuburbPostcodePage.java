package com.krasaev.suburbpost.postcode.domain.dto;

import java.util.List;

public record SuburbPostcodePage(List<SuburbPostcodeDto> content, long totalCharacters) {

}
