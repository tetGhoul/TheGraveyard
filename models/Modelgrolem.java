// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelgrolem extends EntityModel<Entity> {
	private final ModelRenderer RightArm;
	private final ModelRenderer LowerLeftArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LowerArm;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modelgrolem() {
		textureWidth = 16;
		textureHeight = 16;

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(12.75F, -22.25F, 0.75F);
		RightArm.setTextureOffset(0, 0).addBox(0.25F, -0.75F, -5.25F, 8.0F, 19.0F, 10.0F, 0.0F, false);

		LowerLeftArm = new ModelRenderer(this);
		LowerLeftArm.setRotationPoint(-11.5164F, 42.25F, -0.045F);
		RightArm.addChild(LowerLeftArm);
		LowerLeftArm.setTextureOffset(0, 0).addBox(12.2664F, -28.0F, -3.705F, 5.0F, 19.0F, 7.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(-1.0F, 18.75F, 1.0F);
		LeftArm.setTextureOffset(0, 0).addBox(-22.0F, -41.75F, -5.5F, 8.0F, 19.0F, 10.0F, 0.0F, true);

		LowerArm = new ModelRenderer(this);
		LowerArm.setRotationPoint(-0.2336F, 1.25F, -0.295F);
		LeftArm.addChild(LowerArm);
		LowerArm.setTextureOffset(0, 0).addBox(-19.2664F, -28.0F, -3.705F, 5.0F, 19.0F, 7.0F, 0.0F, true);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-2.0F, -48.0F, 0.0F, 2.0F, -5.0F, 1.0F, 6.0F, false);
		Head.setTextureOffset(0, 0).addBox(1.0F, -57.0F, -3.0F, 2.0F, 3.0F, 2.0F, 1.0F, false);
		Head.setTextureOffset(0, 0).addBox(-5.0F, -57.0F, -3.0F, 2.0F, 3.0F, 2.0F, 1.0F, true);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-7.0F, -39.0F, -2.0F, 12.0F, 12.0F, 5.0F, 8.0F, false);
		Body.setTextureOffset(0, 0).addBox(-5.5F, -15.0F, -1.0F, 9.0F, -5.0F, 3.0F, 8.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-0.75F, 21.75F, 1.0F);
		RightLeg.setTextureOffset(0, 0).addBox(6.75F, -7.75F, -1.0F, 1.0F, 6.0F, 1.0F, 3.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(0.75F, 21.75F, 1.0F);
		LeftLeg.setTextureOffset(0, 0).addBox(-9.75F, -7.75F, -1.0F, 1.0F, 6.0F, 1.0F, 3.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}