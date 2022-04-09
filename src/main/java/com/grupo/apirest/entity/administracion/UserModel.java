package com.grupo.apirest.entity.administracion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="USUARIO")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<RolesModel> roles = new ArrayList<>();

}