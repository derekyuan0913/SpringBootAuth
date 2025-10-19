package org.yuanding.springbootauth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Roles name;

    @Column
    @JsonIgnore
    private String description;

    public String toString() {
        return this.name.toString();
    }

    	public enum Roles {
		ADMIN,
		USER,
		VIP_USER
	}

}

