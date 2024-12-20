package iuh.donhang.backend.models;

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
@Table(name = "cuahang")
public class Cuahang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "macuahang", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "ten", nullable = false, length = 50)
    private String ten;

    @OneToMany(mappedBy = "macuahang")
    private Set<Donhang> donhangs = new LinkedHashSet<>();

}