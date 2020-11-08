package net.mcreator.hantainotengoku.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.hantainotengoku.entity.GrolemEntity;
import net.mcreator.hantainotengoku.HantaiNoTengokuModElements;

import java.util.Map;
import java.util.HashMap;

@HantaiNoTengokuModElements.ModElement.Tag
public class GrolemWalkProcedure extends HantaiNoTengokuModElements.ModElement {
	public GrolemWalkProcedure(HantaiNoTengokuModElements instance) {
		super(instance, 28);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GrolemWalk!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof GrolemEntity.CustomEntity)) {
		}
	}

	@SubscribeEvent
	public void onEntitySpawned(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = event.getWorld().getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
