package org.flst.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Playlist> playlists;
	
	
	public User(String password, String email) {
		super();
		this.password 	= password;
		this.email 		= email;
	}

	public User() {
	}
	
	
	public boolean equals(User  u){
		boolean returnValue = true;
		
		if ((u != null) && (this.email != null) 
				&& (this.password != null) && (this.id != null) ){
			if ((!this.email.equals(u.getEmail()))
				|| (!this.password.equals(u.getPassword()))
				|| (!this.id.equals(u.getId()))){
					returnValue = false;
				}
		}
		else
				returnValue = false;
			
		return returnValue;
		
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	
    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
        if (playlist.getUser() != this) {
        	playlist.setUser(this);
        }
    }
	
}
