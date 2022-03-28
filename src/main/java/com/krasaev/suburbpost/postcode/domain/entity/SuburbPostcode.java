package com.krasaev.suburbpost.postcode.domain.entity;

import com.krasaev.suburbpost.postcode.validation.Postcode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "suburb_postcode")
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SuburbPostcodeId.class)
public class SuburbPostcode {

    @Id
    @Postcode
    private String postcode;

    @Id
    @NotBlank
    private String locality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuburbPostcode that = (SuburbPostcode) o;
        return postcode.equals(that.postcode) && locality.equals(that.locality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postcode, locality);
    }
}

