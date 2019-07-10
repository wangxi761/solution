package designPattern.builder;

import org.junit.Test;

public class HeroTest {
	
	@Test
	public void test() {
		Hero hero = Hero.builder().setArmor("a").setHairColor(1).setHairType(1).setName("b").setProfession("c").setWeapon("d").build();
		System.out.println(hero.toString());
	}
}