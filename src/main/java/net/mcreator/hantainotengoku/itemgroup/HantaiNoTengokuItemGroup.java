
package net.mcreator.hantainotengoku.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.hantainotengoku.item.TengokuIngotItem;
import net.mcreator.hantainotengoku.HantaiNoTengokuModElements;

@HantaiNoTengokuModElements.ModElement.Tag
public class HantaiNoTengokuItemGroup extends HantaiNoTengokuModElements.ModElement {
	public HantaiNoTengokuItemGroup(HantaiNoTengokuModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabhantai_no_tengoku") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TengokuIngotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
