package org.yuanding.springbootauth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 20)
	private String userName;

	@Column(nullable = false)
	@JsonIgnore
	private String password;

	@Column(nullable = false, unique = true, length = 30)
	private String email;

	@Column(nullable = true, unique = true, length = 30)
	private String nickName;

	@Column(nullable = false)
	private LocalDateTime regTime;

	@Enumerated(EnumType.STRING)
	private Role role;

	public enum Role {
		ADMIN,
		USER,
		VIP_USER
	}
}