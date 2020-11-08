
package net.mcreator.hantainotengoku.item;

@HantaiNoTengokuModElements.ModElement.Tag
public class DemonDwellerBladeItem extends HantaiNoTengokuModElements.ModElement {

	@ObjectHolder("hantai_no_tengoku:demon_dweller_blade")
	public static final Item block = null;

	public DemonDwellerBladeItem(HantaiNoTengokuModElements instance) {
		super(instance, 38);
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
