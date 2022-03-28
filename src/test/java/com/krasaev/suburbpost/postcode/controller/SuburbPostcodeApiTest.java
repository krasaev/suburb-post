package com.krasaev.suburbpost.postcode.controller;

import com.krasaev.suburbpost.AbstractComponentTest;
import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodeCreateRequest;
import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodeDto;
import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodePage;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SuburbPostcodeApiTest extends AbstractComponentTest {

    @Test
    void postSuburb() throws Exception {
        SuburbPostcodeCreateRequest req =
                new SuburbPostcodeCreateRequest(List.of(new SuburbPostcodeDto("3022", "Test")));
        mockMvc.perform(post("/postcode/suburb")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$[0].postcode").value("3022"));
    }

    @Test
    void getSuburb() throws Exception {
        suburbPostcodeService.save(List.of(
                new SuburbPostcodeDto("2022", "Test"),
                new SuburbPostcodeDto("2002", "bTest"),
                new SuburbPostcodeDto("2001", "bTest2"),
                new SuburbPostcodeDto("2007", "aTest")
        ));

        mockMvc.perform(get("/postcode/suburb")
                        .queryParam("rangeFrom", "2002")
                        .queryParam("rangeTo", "2010"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(
                        new SuburbPostcodePage(
                                List.of(
                                        new SuburbPostcodeDto("2007", "aTest"),
                                        new SuburbPostcodeDto("2002", "bTest")
                                ),
                                10L
                        )
                )));
    }
}