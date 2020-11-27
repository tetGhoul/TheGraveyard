
package net.mcreator.hantainotengoku.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.hantainotengoku.itemgroup.HantaiNoTengokuItemGroup;
import net.mcreator.hantainotengoku.HantaiNoTengokuModElements;

import java.util.List;

@HantaiNoTengokuModElements.ModElement.Tag
public class BookOfAshItem extends HantaiNoTengokuModElements.ModElement {
	@ObjectHolder("hantai_no_tengoku:book_of_ash")
	public static final Item block = null;
	public BookOfAshItem(HantaiNoTengokuModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(HantaiNoTengokuItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("book_of_ash");
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
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("a burned book"));
		}
	}
}
