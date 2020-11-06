package net.mcreator.hantainotengoku.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.ResourceLocation;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.FunctionObject;
import net.minecraft.command.CommandSource;

import net.mcreator.hantainotengoku.HantaiNoTengokuModElements;

import java.util.Optional;
import java.util.Map;

@HantaiNoTengokuModElements.ModElement.Tag
public class LimboPlayerEntersDimensionProcedure extends HantaiNoTengokuModElements.ModElement {
	public LimboPlayerEntersDimensionProcedure(HantaiNoTengokuModElements instance) {
		super(instance, 9);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure LimboPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure LimboPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure LimboPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure LimboPlayerEntersDimension!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			Optional<FunctionObject> _fopt = world.getWorld().getServer().getFunctionManager()
					.get(new ResourceLocation("You hear the screams and whispers as you enter, they disturb you"));
			if (_fopt.isPresent()) {
				FunctionObject _fobj = _fopt.get();
				world.getWorld().getServer().getFunctionManager().execute(_fobj, new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z),
						Vec2f.ZERO, (ServerWorld) world.getWorld(), 4, "", new StringTextComponent(""), world.getWorld().getServer(), null));
			}
		}
	}
}
