package net.mcreator.hantainotengoku.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.hantainotengoku.HantaiNoTengokuModElements;

import java.util.Map;

@HantaiNoTengokuModElements.ModElement.Tag
public class DemonBombTestBulletHitsLivingEntityProcedure extends HantaiNoTengokuModElements.ModElement {
	public DemonBombTestBulletHitsLivingEntityProcedure(HantaiNoTengokuModElements instance) {
		super(instance, 50);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DemonBombTestBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 15);
	}
}
