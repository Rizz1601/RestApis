package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String name;
		private String dpt;
		private String email;
		private int sal;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDpt() {
			return dpt;
		}
		public void setDpt(String dpt) {
			this.dpt = dpt;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getSal() {
			return sal;
		}
		public void setSal(int sal) {
			this.sal = sal;
		}
		
}
