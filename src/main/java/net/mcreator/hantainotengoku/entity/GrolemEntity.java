
package net.mcreator.hantainotengoku.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;

import net.mcreator.hantainotengoku.itemgroup.HantaiNoTengokuItemGroup;
import net.mcreator.hantainotengoku.HantaiNoTengokuModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

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
			return new MobRenderer(renderManager, new Modelgrolem(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("hantai_no_tengoku:textures/brown.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
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

	// Made with Blockbench 3.7.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelgrolem extends EntityModel<Entity> {
		private final ModelRenderer UpperLeftArm;
		private final ModelRenderer LowerLeftArm;
		private final ModelRenderer UpperRightArm;
		private final ModelRenderer LowerRightArm;
		private final ModelRenderer Head;
		private final ModelRenderer Body;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		public Modelgrolem() {
			textureWidth = 16;
			textureHeight = 16;
			UpperLeftArm = new ModelRenderer(this);
			UpperLeftArm.setRotationPoint(1.0F, 18.75F, 1.0F);
			UpperLeftArm.setTextureOffset(0, 1).addBox(-0.05F, 0.0F, -0.35F, 0.0F, 1.0F, 0.0F, 0.0F, false);
			LowerLeftArm = new ModelRenderer(this);
			LowerLeftArm.setRotationPoint(0.2336F, 1.25F, -0.295F);
			UpperLeftArm.addChild(LowerLeftArm);
			LowerLeftArm.setTextureOffset(0, 1).addBox(-0.1431F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, false);
			UpperRightArm = new ModelRenderer(this);
			UpperRightArm.setRotationPoint(-0.75F, 19.0F, 1.0F);
			UpperRightArm.setTextureOffset(0, 1).addBox(-0.8F, -0.25F, -0.35F, 0.0F, 1.0F, 0.0F, 0.0F, true);
			LowerRightArm = new ModelRenderer(this);
			LowerRightArm.setRotationPoint(2.0F, 1.0F, 0.0F);
			UpperRightArm.addChild(LowerRightArm);
			LowerRightArm.setTextureOffset(0, 1).addBox(-2.7336F, 0.0F, -0.295F, 0.0F, 1.0F, 0.0F, 0.0F, true);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 24.0F, 0.0F);
			Head.setTextureOffset(0, 1).addBox(-0.5F, -6.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(0, 1).addBox(0.0896F, -6.2501F, 0.55F, 0.0F, 1.0F, 0.0F, 0.0F, false);
			Head.setTextureOffset(0, 1).addBox(-0.35F, -6.2501F, 0.55F, 0.0F, 1.0F, 0.0F, 0.0F, true);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 24.0F, 0.0F);
			Body.setTextureOffset(0, 2).addBox(-1.05F, -5.25F, 0.25F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-0.75F, 21.75F, 1.0F);
			RightLeg.setTextureOffset(0, 1).addBox(-0.25F, -0.75F, -0.25F, 0.0F, 2.0F, 0.0F, 0.0F, true);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(0.75F, 21.75F, 1.0F);
			LeftLeg.setTextureOffset(0, 1).addBox(-0.25F, -0.75F, -0.25F, 0.0F, 2.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			UpperLeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
			UpperRightArm.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
