package com.example.petcare.entity;

import com.example.petcare.entity.enums.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String avatar;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PetOwner owner;

    @ManyToOne
    @JoinColumn(name = "breed_id")
    private PetBreed breed;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String age;

    @Column(name = "is_sterilized")
    private boolean isSterilized;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "pet_to_characteristics",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "characteristic_id")
    )
    private List<PetCharacteristic> characteristics = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<PetEmergencyAction> emergencyActions = new ArrayList<>();
}
