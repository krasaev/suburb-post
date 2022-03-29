package com.krasaev.suburbpost.postcode.service;

import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodeDto;
import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodePage;
import com.krasaev.suburbpost.postcode.domain.entity.SuburbPostcode;
import com.krasaev.suburbpost.postcode.domain.mapper.SuburbPostcodeMapper;
import com.krasaev.suburbpost.postcode.repository.SuburbPostcodeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuburbPostcodeServiceImpl implements SuburbPostcodeService {

    private final SuburbPostcodeMapper suburbPostcodeMapper;
    private final SuburbPostcodeRepository suburbPostcodeRepository;

    @Override
    @Transactional
    public List<SuburbPostcodeDto> save(@NonNull List<SuburbPostcodeDto> suburbPostcodeDtos) {
        log.debug("About to save [{}] suburb postcodes", suburbPostcodeDtos.size());

        List<SuburbPostcode> suburbPostcodes = suburbPostcodeDtos.stream()
                .map(suburbPostcodeMapper::map)
                .toList();

        suburbPostcodeRepository.saveAll(suburbPostcodes);
        return suburbPostcodeDtos;
    }

    @Override
    public SuburbPostcodePage findByRange(@NonNull String from, @NonNull String to) {
        log.debug("About to fetch all suburb postcodes in range {}..{}", from, to);

        List<SuburbPostcode> suburbPostcodes =
                suburbPostcodeRepository.findAllByPostcodeBetweenOrderByLocalityAsc(from, to);
        List<SuburbPostcodeDto> suburbPostcodeDtos = suburbPostcodes.stream().map(suburbPostcodeMapper::map).toList();
        return new SuburbPostcodePage(suburbPostcodeDtos, countCharacters(suburbPostcodeDtos));
    }

    private long countCharacters(List<SuburbPostcodeDto> suburbPostcodeDtos) {
        return suburbPostcodeDtos.stream()
                .mapToLong(value -> value.locality().length())
                .sum();
    }
}
