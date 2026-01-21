package com.ust.springbootmodularbackend.book.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="books")
@JsonPropertyOrder({
    "id",
        "title",
        "author"
})
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private int id;
    @NotBlank @Size(min = 3)
    @JsonProperty
    private String title;
    @NotBlank
    @JsonProperty
    private String author;

}
