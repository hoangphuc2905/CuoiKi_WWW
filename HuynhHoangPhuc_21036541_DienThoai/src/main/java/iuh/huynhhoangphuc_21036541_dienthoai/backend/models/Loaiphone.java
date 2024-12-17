package iuh.huynhhoangphuc_21036541_dienthoai.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "loaiphones")
public class Loaiphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("'0'")
    @Column(name = "tenloai", nullable = false, length = 50)
    private String tenloai;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("'0'")
    @Column(name = "mota", nullable = false, length = 50)
    private String mota;

    @OneToMany(mappedBy = "category")
    private Set<Phone> phones = new LinkedHashSet<>();

}