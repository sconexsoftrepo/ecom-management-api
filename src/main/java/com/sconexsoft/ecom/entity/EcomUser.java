package com.sconexsoft.ecom.entity;

import java.util.Objects;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_table")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class EcomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId; // EcomUser ID
    
    private String firstName; // First Name
    private String lastName; // Last Name
    private String mobile; // Phone Number
    private String mailId; // Email Address
    private String password; // Password
    
    @Enumerated(EnumType.STRING)
    private Role role; // Enum for Roles

    // Enum for roles
    public enum Role {
        DEALER, ADMIN, OPERATOR
    }

    // Default Constructor
    public EcomUser() {
    }

    //parameterized Constructor
    public EcomUser(int userId, String firstName, String lastName, String mobile, String mailId, String password,
			Role role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.mailId = mailId;
		this.password = password;
		this.role = role;
	}

    //setters and getters
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getMailId() {
		return mailId;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "EcomUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile="
				+ mobile + ", mailId=" + mailId + ", password=" + password + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, mailId, mobile, password, role, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EcomUser other = (EcomUser) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(mailId, other.mailId) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(password, other.password) && role == other.role && userId == other.userId;
	}
}
