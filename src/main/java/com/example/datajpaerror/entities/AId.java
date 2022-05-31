package com.example.datajpaerror.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class AId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "a_one", nullable = false, length = 4096)
    private String aOne;

    @Column(name = "a_two", nullable = false, length = 4096)
    private String aTwo;

    public AId(String aOne, String aTwo) {
        this.aOne = aOne;
        this.aTwo = aTwo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aOne, aTwo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AId other = (AId) obj;
        return Objects.equals(aOne, other.aOne) && Objects.equals(aTwo, other.aTwo);
    }

}
