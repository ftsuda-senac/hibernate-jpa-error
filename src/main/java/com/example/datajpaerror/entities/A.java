package com.example.datajpaerror.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "a_table")
@Getter
@Setter
@NoArgsConstructor
public class A {

    @EmbeddedId
    private AId id;

    // primary side of relationship
    @OneToOne(mappedBy = "a_R1", fetch = FetchType.LAZY, targetEntity = B.class)
    private B b_R1;

    public A(String aOne, String aTwo) {
        this.id = new AId(aOne, aTwo);
    }

}
