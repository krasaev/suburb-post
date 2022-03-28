package com.krasaev.suburbpost.postcode.controller;

import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodeCreateRequest;
import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodeDto;
import com.krasaev.suburbpost.postcode.domain.dto.SuburbPostcodePage;
import com.krasaev.suburbpost.postcode.validation.Postcode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("postcode/suburb")
public interface SuburbPostcodeApi {

    @Operation(
            summary = "Save suburb postcodes",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = SuburbPostcodeDto.class)))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "application/json",
                            schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json",
                            schema = @Schema(hidden = true)))
            }
    )
    @PostMapping
    ResponseEntity<List<SuburbPostcodeDto>> createSuburbPostcodes(
            @RequestBody SuburbPostcodeCreateRequest suburbPostcodeCreateRequest
    );

    @Operation(
            summary = "Fetch suburb postcodes within given range",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation"),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "application/json",
                            schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json",
                            schema = @Schema(hidden = true)))
            },
            parameters = {
                    @Parameter(in = ParameterIn.QUERY, name = "rangeFrom",
                            example = "2000", schema = @Schema(type = "number"),
                            description = "Range from"),
                    @Parameter(in = ParameterIn.QUERY, name = "rangeTo",
                            example = "2010", schema = @Schema(type = "number"),
                            description = "Range to")
            }
    )
    @GetMapping
    SuburbPostcodePage fetchSuburbPostcodes(@RequestParam("rangeFrom") @Postcode String rangeFrom,
                                            @RequestParam("rangeTo") @Postcode String rangeTo);
}
