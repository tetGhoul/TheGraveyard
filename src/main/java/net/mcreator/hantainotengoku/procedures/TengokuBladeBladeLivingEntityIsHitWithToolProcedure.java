package net.mcreator.hantainotengoku.procedures;

@HantaiNoTengokuModElements.ModElement.Tag
public class TengokuBladeBladeLivingEntityIsHitWithToolProcedure extends HantaiNoTengokuModElements.ModElement {

	public TengokuBladeBladeLivingEntityIsHitWithToolProcedure(HantaiNoTengokuModElements instance) {
		super(instance, 32);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TengokuBladeBladeLivingEntityIsHitWithTool!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 10, (int) 4));

	}

}
