// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelDevil extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Torso_r1;
	private final ModelRenderer Arms;
	private final ModelRenderer Bones;
	private final ModelRenderer Legs;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer Leftleg_r1;

	public ModelDevil() {
		textureWidth = 32;
		textureHeight = 32;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(2.0F, 13.0F, 0.0F);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(-3.0F, 0.0F, 3.0F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0436F, 0.0F, 0.0F);
		Head_r1.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -2.0F, 7.0F, 5.0F, 5.0F, 0.0F, false);

		Torso_r1 = new ModelRenderer(this);
		Torso_r1.setRotationPoint(-3.0F, 19.0F, -1.0F);
		setRotationAngle(Torso_r1, -0.3927F, 0.0F, 0.0F);
		Torso_r1.setTextureOffset(0, 0).addBox(5.0F, -8.0F, 0.0F, -5.0F, 8.0F, 3.0F, 0.0F, false);

		Arms = new ModelRenderer(this);
		Arms.setRotationPoint(4.0F, 22.5F, -1.5F);
		setRotationAngle(Arms, -0.3927F, 0.0F, 0.0F);
		Arms.setTextureOffset(4, 10).addBox(-2.0F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		Arms.setTextureOffset(0, 10).addBox(-8.0F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		Bones = new ModelRenderer(this);
		Bones.setRotationPoint(-1.5F, 21.4F, 0.0F);
		setRotationAngle(Bones, -0.3927F, 0.0F, 0.0F);
		Bones.setTextureOffset(0, 0).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Bones.setTextureOffset(16, 16).addBox(1.75F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(3.0F, 11.0F, -3.0F);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setRotationPoint(-5.55F, 9.5F, 4.0F);
		Legs.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 2.2253F, 0.0F, -3.1416F);
		RightLeg_r1.setTextureOffset(8, 10).addBox(-1.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		Leftleg_r1 = new ModelRenderer(this);
		Leftleg_r1.setRotationPoint(-2.75F, 9.5F, 4.0F);
		Legs.addChild(Leftleg_r1);
		setRotationAngle(Leftleg_r1, 2.2253F, 0.0F, -3.1416F);
		Leftleg_r1.setTextureOffset(12, 12).addBox(-1.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Torso_r1.render(matrixStack, buffer, packedLight, packedOverlay);
		Arms.render(matrixStack, buffer, packedLight, packedOverlay);
		Bones.render(matrixStack, buffer, packedLight, packedOverlay);
		Legs.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}