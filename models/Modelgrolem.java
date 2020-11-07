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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}