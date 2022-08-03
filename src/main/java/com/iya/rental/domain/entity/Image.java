package com.iya.rental.domain.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BaseEntity{
	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

    @Column(name = "category")
	private String category;

	@Column(name = "image", unique = false, nullable = false, length = 100000)
	private byte[] image;
}