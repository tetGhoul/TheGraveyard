
package net.mcreator.hantainotengoku.item;

@HantaiNoTengokuModElements.ModElement.Tag
public class ScytheItem extends HantaiNoTengokuModElements.ModElement {

	@ObjectHolder("hantai_no_tengoku:scythe")
	public static final Item block = null;

	public ScytheItem(HantaiNoTengokuModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 210;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 3.300000000000001f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT, (int) (1)));
			}
		}, 3, -2.2999999999999998f, new Item.Properties().group(HantaiNoTengokuItemGroup.tab)) {

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent(
						"A special tool mad efor the specific purpose of harvesting the souls of the living. Can be upgraded and augmented to be used for other things."));
			}

		}.setRegistryName("scythe"));
	}

}
