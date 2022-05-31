package com.example.datajpaerror.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "b_table")
@Getter
@Setter
@NoArgsConstructor
public class B {

    @EmbeddedId
    private BId id;
    // secondary side of relationship
    @OneToOne(targetEntity = A.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "b_a_two", referencedColumnName = "a_two", nullable = true, insertable = true,
                    updatable = true),
            @JoinColumn(name = "b_a_one", referencedColumnName = "a_one", nullable = true, insertable = true,
            updatable = true)})
    private A a_R1;

    public B(String bOne, String bTwo) {
        this.id = new BId(bOne, bTwo);
    }

}
