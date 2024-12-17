package iuh.huynhhoangphuc_21036541_dienthoai.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "phone_name", nullable = false)
    private String phoneName;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "cost_price", nullable = false)
    private Double costPrice;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("0")
    @JoinColumn(name = "category", nullable = false)
    private Loaiphone category;

    @Size(max = 255)
    @NotNull
    @Column(name = "supplier", nullable = false)
    private String supplier;

}