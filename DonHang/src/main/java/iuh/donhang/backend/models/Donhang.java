package iuh.donhang.backend.models;

import iuh.donhang.backend.enums.Trangthai;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "donhang")
public class Donhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "madonhang", nullable = false, length = 50)
    private String madonhang;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("'0'")
    @Column(name = "tenkhachhang", nullable = false, length = 50)
    private String tenkhachhang;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @NotNull
    @Column(name = "ngaydathang", nullable = false)
    private LocalDate ngaydathang;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "tensanpham", nullable = false, length = 50)
    private String tensanpham;

    @NotNull
    @Column(name = "trangthai", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Trangthai trangthai;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "macuahang", nullable = false)
    private Cuahang macuahang;

}