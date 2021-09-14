package com.netology.daohib.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person implements Serializable {
	@EmbeddedId
	private ComposeId composeId;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "cityOfLiving")
	private String cityOfLiving;
}
