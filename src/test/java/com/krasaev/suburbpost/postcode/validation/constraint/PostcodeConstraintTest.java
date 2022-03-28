package com.krasaev.suburbpost.postcode.validation.constraint;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PostcodeConstraintTest {

    private final PostcodeConstraint postcodeConstraint = new PostcodeConstraint();

    private static Stream<Arguments> isValid() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of("", false),
                Arguments.of("  ", false),
                Arguments.of("123a", false),
                Arguments.of("21232", false),
                Arguments.of("-232", false),
                Arguments.of("+232", false),
                Arguments.of("1001", true),
                Arguments.of("0001", true)
        );
    }

    @MethodSource
    @ParameterizedTest
    void isValid(String value, boolean valid) {
        assertThat(postcodeConstraint.isValid(value, null)).isEqualTo(valid);
    }
}