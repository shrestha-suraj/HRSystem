package com.hrsystem.service;

import java.util.ArrayList;
import java.util.List;

import com.hrsystem.domain.Role;

public class RoleFixture {
	
	public static List<Role> createRoles(){
		Role manager=new Role(1,"Manager");
		Role cook=new Role(1,"Cook");
		List<Role> roles=new ArrayList<>();
		roles.add(manager);
		roles.add(cook);
		return roles;
	}
}
