
package net.mcreator.hantainotengoku.item;

@HantaiNoTengokuModElements.ModElement.Tag
public class DemonEssenceItem extends HantaiNoTengokuModElements.ModElement {

	@ObjectHolder("hantai_no_tengoku:demon_essence")
	public static final Item block = null;

	public DemonEssenceItem(HantaiNoTengokuModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(HantaiNoTengokuItemGroup.tab).maxStackSize(64));
			setRegistryName("demon_essence");
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
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}
