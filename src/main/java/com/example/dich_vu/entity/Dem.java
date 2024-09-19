package com.example.dich_vu.entity;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Dem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "ten")
    private String ten;

    @Column(name = "anh")
    private String anh;

}
