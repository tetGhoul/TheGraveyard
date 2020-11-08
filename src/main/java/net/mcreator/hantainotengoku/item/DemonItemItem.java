
package net.mcreator.hantainotengoku.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.mcreator.hantainotengoku.procedures.DemonBombBulletHitsPlayerProcedure;
import net.mcreator.hantainotengoku.itemgroup.HantaiNoTengokuItemGroup;
import net.mcreator.hantainotengoku.HantaiNoTengokuModElements;

import java.util.Map;
import java.util.HashMap;

@HantaiNoTengokuModElements.ModElement.Tag
public class DemonItemItem extends HantaiNoTengokuModElements.ModElement {
	@ObjectHolder("hantai_no_tengoku:demon_item")
	public static final Item block = null;
	public DemonItemItem(HantaiNoTengokuModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(HantaiNoTengokuItemGroup.tab).maxStackSize(64));
			setRegistryName("demon_item");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
			boolean retval = super.hitEntity(itemstack, entity, sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DemonBombBulletHitsPlayerProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
