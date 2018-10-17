package com.yzcloud.alpha.amp.nm.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table( name = "alpha_node")
public class Node implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "node_name")
	private String name;
	
	@NotNull
	@Column(name = "node_ip")
	private String ipAddr;
	
	/**
	 * NodeRepository login user
	 */
	@Column(name = "node_user")
	private String user;
	
	/**
	 * NodeRepository login user's password
	 */
	@Column(name = "node_pwd")
	private String password;
	
	@Column(name = "node_location")
	private String location;
	
	@Column(name = "node_status")
	private String status;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIpAddr() {
		return ipAddr;
	}
	
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "NodeRepository{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", ip='" + ipAddr + '\'' +
			", status='" + status + '\'' +
			", user='" + user + '\'' +
			", password='" + password + '\'' +
			", location='" + location + '\'' +
			"}";
	}
}
