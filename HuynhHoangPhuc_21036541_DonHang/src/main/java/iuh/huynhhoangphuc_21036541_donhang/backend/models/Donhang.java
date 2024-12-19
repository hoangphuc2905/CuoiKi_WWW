package iuh.huynhhoangphuc_21036541_donhang.backend.models;

import iuh.huynhhoangphuc_21036541_donhang.backend.enums.Trangthai;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "donhang")
public class Donhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "MADONHANG", nullable = false)
    private String madonhang;

    @Size(max = 255)
    @NotNull
    @Column(name = "TENKHACHHANG", nullable = false)
    private String tenkhachhang;

    @Size(max = 255)
    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotNull
    @Column(name = "NGAYDATHANG", nullable = false)
    private LocalDate ngaydathang;

    @Size(max = 255)
    @NotNull
    @Column(name = "TENSP", nullable = false)
    private String tensp;

    @Column(name = "TRANGTHAI", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Trangthai trangthai;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MACUAHANG")
    private Cuahang macuahang;


    @Override
    public String toString() {
        return "Donhang{" +
                "id=" + id +
                ", madonhang='" + madonhang + '\'' +
                ", tenkhachhang='" + tenkhachhang + '\'' +
                ", email='" + email + '\'' +
                ", ngaydathang=" + ngaydathang +
                ", tensp='" + tensp + '\'' +
                ", trangthai=" + trangthai +
                ", macuahang=" + macuahang +
                '}';
    }

}