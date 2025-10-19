package org.yuanding.springbootauth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class User implements Serializable {

	@Serial
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

	@Column(unique = true, length = 30)
	private String nickName;

	@Column(nullable = false)
	private LocalDateTime regTime;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonSerialize(using = RoleToStringSerializer.class)
	private Role role;

}

class RoleToStringSerializer extends JsonSerializer<Role> {
	@Override
	public void serialize(Role value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(String.valueOf(value == null ? null : value.getName()));
	}
}