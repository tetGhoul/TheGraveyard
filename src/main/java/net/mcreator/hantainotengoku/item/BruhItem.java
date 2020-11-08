
package net.mcreator.hantainotengoku.item;

@HantaiNoTengokuModElements.ModElement.Tag
public class BruhItem extends HantaiNoTengokuModElements.ModElement {

	@ObjectHolder("hantai_no_tengoku:bruh")
	public static final Item block = null;

	public BruhItem(HantaiNoTengokuModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, HantaiNoTengokuModElements.sounds.get(new ResourceLocation("hantai_no_tengoku:bruh")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("bruh");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("bruh"));
		}

	}

}
