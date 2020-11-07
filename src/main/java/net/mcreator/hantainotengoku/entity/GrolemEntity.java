
package net.mcreator.hantainotengoku.entity;

import net.minecraft.block.material.Material;

@HantaiNoTengokuModElements.ModElement.Tag
public class GrolemEntity extends HantaiNoTengokuModElements.ModElement {

	public static EntityType entity = null;

	public GrolemEntity(HantaiNoTengokuModElements instance) {
		super(instance, 21);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(50).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.8f, 0.8f)).build("grolem")
						.setRegistryName("grolem");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -10066330, -3355444, new Item.Properties().group(HantaiNoTengokuItemGroup.tab))
				.setRegistryName("grolem"));

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 13, 2, 6));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("hantai_no_tengoku:textures/brown.png");
				}
			};
			customRender.addLayer(new BipedArmorLayer(customRender, new BipedModel(0.5f), new BipedModel(1)));

			return customRender;
		});

	}

	public static class CustomEntity extends CreatureEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 10;
			setNoAI(false);

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new TemptGoal(this, 1, Ingredient.fromItems(new ItemStack(Items.CHICKEN, (int) (1)).getItem()), false));
			this.goalSelector.addGoal(2, new AvoidEntityGoal(this, FlyingEntity.class, (float) 17, 1, 1.2));
			this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, (float) 0.5));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, MobEntity.class, true, true));
			this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(6, new LookAtGoal(this, LivingEntity.class, (float) 6));
			this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(8, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(9, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(10, new SwimGoal(this));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.pant"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.fall")),
					0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.break"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);

		}

	}

}
