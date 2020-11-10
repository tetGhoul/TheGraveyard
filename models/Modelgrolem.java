// Made with Blockbench 3.6.6

public static class Modelgrolem extends AnimatedEntityModel {

	private final AnimatedModelRenderer Grolem;
	private final AnimatedModelRenderer LeftLeg;
	private final AnimatedModelRenderer RightLeg;
	private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer RightArm;
	private final AnimatedModelRenderer LowerRightArm;
	private final AnimatedModelRenderer LeftArm;
	private final AnimatedModelRenderer LowerLeftArm;
	private final AnimatedModelRenderer Head;
	private final AnimatedModelRenderer Waist;

	public Modelgrolem() {
		textureWidth = 16;
		textureHeight = 16;
		Grolem = new AnimatedModelRenderer(this);
		Grolem.setRotationPoint(0.0F, 25.3F, 0.0F);

		Grolem.setModelRendererName("Grolem");
		this.registerModelRenderer(Grolem);

		LeftLeg = new AnimatedModelRenderer(this);
		LeftLeg.setRotationPoint(-4.03F, -5.645F, -0.18F);
		Grolem.addChild(LeftLeg);
		LeftLeg.setTextureOffset(0, 0).addBox(1.99F, 1.345F, 1.92F, -4.0F, 0.0F, -4.0F, 3.0F, true);
		LeftLeg.setModelRendererName("LeftLeg");
		this.registerModelRenderer(LeftLeg);

		RightLeg = new AnimatedModelRenderer(this);
		RightLeg.setRotationPoint(2.375F, -5.895F, -0.28F);
		Grolem.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 0).addBox(1.885F, 1.595F, 2.02F, -4.0F, 0.0F, -4.0F, 3.0F, false);
		RightLeg.setModelRendererName("RightLeg");
		this.registerModelRenderer(RightLeg);

		Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(-0.63F, -13.335F, 0.0F);
		Grolem.addChild(Body);
		Body.setTextureOffset(0, 0).addBox(2.33F, 1.595F, 3.8F, -5.0F, -5.0F, -8.0F, 8.0F, false);
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		RightArm = new AnimatedModelRenderer(this);
		RightArm.setRotationPoint(-5.5F, -6.405F, 0.22F);
		Body.addChild(RightArm);
		RightArm.setTextureOffset(0, 0).addBox(-3.18F, 0.0F, -2.11F, 3.0F, 7.0F, 4.0F, 0.0F, true);
		RightArm.setModelRendererName("RightArm");
		this.registerModelRenderer(RightArm);

		LowerRightArm = new AnimatedModelRenderer(this);
		LowerRightArm.setRotationPoint(-1.1781F, 6.87F, -0.2239F);
		RightArm.addChild(LowerRightArm);
		LowerRightArm.setTextureOffset(0, 0).addBox(-0.9519F, -0.57F, -0.9561F, 2.0F, 7.0F, 2.0F, 0.0F, true);
		LowerRightArm.setModelRendererName("LowerRightArm");
		this.registerModelRenderer(LowerRightArm);

		LeftArm = new AnimatedModelRenderer(this);
		LeftArm.setRotationPoint(5.185F, -6.09F, 0.215F);
		Body.addChild(LeftArm);
		LeftArm.setTextureOffset(0, 0).addBox(0.105F, -0.315F, -2.105F, 3.0F, 7.0F, 4.0F, 0.0F, false);
		LeftArm.setModelRendererName("LeftArm");
		this.registerModelRenderer(LeftArm);

		LowerLeftArm = new AnimatedModelRenderer(this);
		LowerLeftArm.setRotationPoint(1.4631F, 6.66F, -0.0189F);
		LeftArm.addChild(LowerLeftArm);
		LowerLeftArm.setTextureOffset(0, 0).addBox(-1.1481F, -0.675F, -1.0561F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		LowerLeftArm.setModelRendererName("LowerLeftArm");
		this.registerModelRenderer(LowerLeftArm);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(-1.0F, 5.675F, -0.475F);
		Head.setTextureOffset(0, 0).addBox(3.64F, 3.945F, 3.955F, -7.0F, 0.0F, -7.0F, 6.0F, false);
		Head.setTextureOffset(0, 0).addBox(2.0F, -2.735F, -0.205F, -1.0F, 0.0F, -1.0F, 1.0F, false);
		Head.setTextureOffset(0, 0).addBox(-0.52F, -2.735F, -0.205F, -1.0F, 0.0F, -1.0F, 1.0F, true);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

		Waist = new AnimatedModelRenderer(this);
		Waist.setRotationPoint(-0.65F, 16.5F, 0.0F);
		Waist.setTextureOffset(0, 0).addBox(2.98F, 7.14F, 4.22F, -6.0F, -12.0F, -9.0F, 8.0F, false);
		Waist.setModelRendererName("Waist");
		this.registerModelRenderer(Waist);

		this.rootBones.add(Grolem);
		this.rootBones.add(Head);
		this.rootBones.add(Waist);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation("grolemmob", "animations/grolemanimations.json");
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}