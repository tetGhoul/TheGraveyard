// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelgrolem extends EntityModel<Entity> {
	private final ModelRenderer Grolem;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer RightArm;
	private final ModelRenderer LowerRightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LowerLeftArm;

	public Modelgrolem() {
		textureWidth = 16;
		textureHeight = 16;

		Grolem = new ModelRenderer(this);
		Grolem.setRotationPoint(0.0F, 24.0F, 0.0F);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(-3.78F, -5.145F, 0.42F);
		Grolem.addChild(LeftLeg);
		LeftLeg.setTextureOffset(0, 0).addBox(1.74F, 1.845F, 1.32F, -4.0F, -1.0F, -4.0F, 3.0F, true);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(2.625F, -5.145F, 0.42F);
		Grolem.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 0).addBox(1.635F, 1.845F, 1.32F, -4.0F, -1.0F, -4.0F, 3.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(-0.63F, -13.335F, 0.0F);
		Grolem.addChild(Body);
		Body.setTextureOffset(0, 0).addBox(2.33F, 1.595F, 3.8F, -5.0F, -5.0F, -8.0F, 8.0F, false);
		Body.setTextureOffset(0, 0).addBox(2.96F, 11.675F, 4.22F, -6.0F, -12.0F, -9.0F, 8.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -19.425F, 0.525F);
		Grolem.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(2.64F, 2.745F, 2.955F, -7.0F, -10.0F, -7.0F, 6.0F, false);
		Head.setTextureOffset(0, 0).addBox(1.0F, -3.935F, -1.205F, -1.0F, 0.0F, -1.0F, 1.0F, false);
		Head.setTextureOffset(0, 0).addBox(-1.52F, -3.935F, -1.205F, -1.0F, 0.0F, -1.0F, 1.0F, true);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.88F, -19.74F, 0.42F);
		Grolem.addChild(RightArm);
		RightArm.setTextureOffset(0, 0).addBox(-3.78F, 0.0F, -2.31F, 3.0F, 7.0F, 4.0F, 0.0F, true);

		LowerRightArm = new ModelRenderer(this);
		LowerRightArm.setRotationPoint(-1.7781F, 7.77F, -0.1239F);
		RightArm.addChild(LowerRightArm);
		LowerRightArm.setTextureOffset(0, 0).addBox(-0.9519F, -1.47F, -1.5561F, 2.0F, 7.0F, 2.0F, 0.0F, true);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.355F, -19.425F, 0.315F);
		Grolem.addChild(LeftArm);
		LeftArm.setTextureOffset(0, 0).addBox(0.105F, -0.315F, -2.205F, 3.0F, 7.0F, 4.0F, 0.0F, false);

		LowerLeftArm = new ModelRenderer(this);
		LowerLeftArm.setRotationPoint(1.4631F, 7.56F, -0.0189F);
		LeftArm.addChild(LowerLeftArm);
		LowerLeftArm.setTextureOffset(0, 0).addBox(-1.1481F, -1.575F, -1.5561F, 2.0F, 7.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Grolem.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}