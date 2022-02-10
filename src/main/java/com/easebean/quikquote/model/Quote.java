package com.easebean.quikquote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    @Id
    private Long id;
    private String text;
    private String authorName;
    private String category;
    private String size;
    private String imgURL;
}
