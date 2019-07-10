package designPattern.builder;

import java.util.StringJoiner;

public class Hero {
	private String profession;
	private String name;
	private Integer hairType;
	private Integer hairColor;
	private String armor;
	private String weapon;
	
	public Hero(String profession, String name, Integer hairType, Integer hairColor, String armor, String weapon) {
		this.profession = profession;
		this.name = name;
		this.hairType = hairType;
		this.hairColor = hairColor;
		this.armor = armor;
		this.weapon = weapon;
	}
	
	public Hero() {
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	@Override
	public String toString() {
		return new StringJoiner(", ", Hero.class.getSimpleName() + "[", "]")
			.add("profession='" + profession + "'")
			.add("name='" + name + "'")
			.add("hairType=" + hairType)
			.add("hairColor=" + hairColor)
			.add("armor='" + armor + "'")
			.add("weapon='" + weapon + "'")
			.toString();
	}
	
	public static class Builder {
		private String profession;
		private String name;
		private Integer hairType;
		private Integer hairColor;
		private String armor;
		private String weapon;
		
		public Builder setProfession(String profession) {
			this.profession = profession;
			return this;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setHairType(Integer hairType) {
			this.hairType = hairType;
			return this;
		}
		
		public Builder setHairColor(Integer hairColor) {
			this.hairColor = hairColor;
			return this;
		}
		
		public Builder setArmor(String armor) {
			this.armor = armor;
			return this;
		}
		
		public Builder setWeapon(String weapon) {
			this.weapon = weapon;
			return this;
		}
		
		public Hero build() {
			return new Hero(this.profession, this.name, this.hairType, this.hairColor, this.armor, this.weapon);
		}
	}
	
}
