package net.mcreator.hantainotengoku.procedures;

@HantaiNoTengokuModElements.ModElement.Tag
public class DemonBombBulletHitsPlayerProcedure extends HantaiNoTengokuModElements.ModElement {

	public DemonBombBulletHitsPlayerProcedure(HantaiNoTengokuModElements instance) {
		super(instance, 25);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DemonBombBulletHitsPlayer!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 1);

	}

}
