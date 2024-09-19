
package com.example.dich_vu.entity;
        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

@Entity
@Table(name = "chan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chan {
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
