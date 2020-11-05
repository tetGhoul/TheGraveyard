// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelEnderman extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer RendLeg_r1;
	private final ModelRenderer leftLeg;
	private final ModelRenderer LendLeg_r1;

	public ModelEnderman() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -24.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.1F, false);
		head.setTextureOffset(0, 16).addBox(-4.0F, -22.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.1F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -14.0F, 0.0F);
		body.setTextureOffset(32, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-3.0F, -12.0F, 0.0F);
		rightArm.setTextureOffset(56, 0).addBox(-3.0F, -2.0F, -1.0F, 2.0F, 23.0F, 2.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.0F, -12.0F, 0.0F);
		leftArm.setTextureOffset(56, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 23.0F, 2.0F, 0.0F, true);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-2.0F, -2.0F, 0.0F);
		rightLeg.setTextureOffset(56, 0).addBox(-1.0F, -0.4F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, false);

		RendLeg_r1 = new ModelRenderer(this);
		RendLeg_r1.setRotationPoint(2.0F, 15.6F, 2.0F);
		rightLeg.addChild(RendLeg_r1);
		setRotationAngle(RendLeg_r1, -0.5672F, 0.0F, 0.0F);
		RendLeg_r1.setTextureOffset(56, 0).addBox(-3.0F, -16.0F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(2.0F, -2.0F, 0.0F);
		leftLeg.setTextureOffset(56, 0).addBox(-1.0F, -0.4F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, true);

		LendLeg_r1 = new ModelRenderer(this);
		LendLeg_r1.setRotationPoint(-2.0F, 15.6F, 2.0F);
		leftLeg.addChild(LendLeg_r1);
		setRotationAngle(LendLeg_r1, -0.5672F, 0.0F, 0.0F);
		LendLeg_r1.setTextureOffset(56, 0).addBox(1.0F, -16.0F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftArm.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
	}
}