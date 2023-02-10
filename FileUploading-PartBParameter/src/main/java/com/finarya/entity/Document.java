package com.finarya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "uploaded_files")
@Setter @Getter @ToString @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer fId;
	@Column(name = "name")
	private String fName;
	@Column(name = "file_data", columnDefinition = "LONGBLOB")
	@Lob
	private byte[] docOb;
}
