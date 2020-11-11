package net.mcreator.hantainotengoku.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.hantainotengoku.HantaiNoTengokuModElements;

import java.util.Map;

@HantaiNoTengokuModElements.ModElement.Tag
public class SummonHellhoundsCommandProcedure extends HantaiNoTengokuModElements.ModElement {
	public SummonHellhoundsCommandProcedure(HantaiNoTengokuModElements instance) {
		super(instance, 65);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SummonHellhoundsCommand!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/summon hantai_no_tengoku:hellhound");
			}
		}
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 8);
	}
}
