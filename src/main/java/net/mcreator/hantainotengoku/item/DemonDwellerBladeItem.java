
package net.mcreator.hantainotengoku.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.hantainotengoku.procedures.DemonDwellerBladeLivingEntityIsHitWithToolProcedure;
import net.mcreator.hantainotengoku.itemgroup.HantaiNoTengokuItemGroup;
import net.mcreator.hantainotengoku.HantaiNoTengokuModElements;

import java.util.Map;
import java.util.HashMap;

@HantaiNoTengokuModElements.ModElement.Tag
public class DemonDwellerBladeItem extends HantaiNoTengokuModElements.ModElement {
	@ObjectHolder("hantai_no_tengoku:demon_dweller_blade")
	public static final Item block = null;
	public DemonDwellerBladeItem(HantaiNoTengokuModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 12f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DemonEssenceItem.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(HantaiNoTengokuItemGroup.tab)) {
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
					DemonDwellerBladeLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("demon_dweller_blade"));
	}
}
