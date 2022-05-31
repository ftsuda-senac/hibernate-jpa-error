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
public class BId implements Serializable {

    private static final long serialVersionUID = 8029001084381374220L;

    @Column(name = "b_one", nullable = false, length = 4096)
    private String bOne = new String("");

    @Column(name = "b_two", nullable = false, length = 4096)
    private String bTwo = new String("");

    public BId(String bOne, String bTwo) {
        this.bOne = bOne;
        this.bTwo = bTwo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bOne, bTwo);
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
        BId other = (BId) obj;
        return Objects.equals(bOne, other.bOne) && Objects.equals(bTwo, other.bTwo);
    }

}
