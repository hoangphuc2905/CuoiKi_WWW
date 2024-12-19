package iuh.huynhhoangphuc_21036541_donhang.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cuahang")
public class Cuahang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MACUAHANG", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "TEN", nullable = false)
    private String ten;

    @OneToMany(mappedBy = "macuahang")
    private Set<Donhang> donhangs = new LinkedHashSet<>();

}