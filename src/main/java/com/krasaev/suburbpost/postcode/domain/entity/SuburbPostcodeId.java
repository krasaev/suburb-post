package com.krasaev.suburbpost.postcode.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuburbPostcodeId implements Serializable {

    private String postcode;
    private String locality;
}
