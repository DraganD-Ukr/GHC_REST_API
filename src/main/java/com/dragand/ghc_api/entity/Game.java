package com.dragand.ghc_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message =  "Title can not be blank")
    @Column(name = "title", nullable = false)
    @NonNull
    private String title;


    @NotBlank(message =  "Description cannot be blank")
    @Column(name = "description", nullable = false)
    @NonNull
    private String description;


    @Column(name = "rating", nullable = false)
    @NotNull(message = "Rating can not be null")
    @Min(0)
    @Max(5)
    private Double rating;


    @NotBlank(message =  "Image link cannot be blank")
    @Column(name = "img_link", nullable = false)
    @NonNull
    private String img_link;

}
