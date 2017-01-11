package yzh.Generic;

public enum EnumPlanet {
	MERCURY(3.302E+23, 2.439E6), VENUS(4.869E+24, 6.052E6), EARTH(5.9, 6.3), MARS(6.4, 3.39), JUPITER(1.899,
			7.12), SATURN(5.685, 6.026), URANUS(8.68, 2.55), NEPTUNE(1.02, 2.477);
	private final double mass;
	private final double radius;
	private final double surfaceGravity;
	private static final double G = 6.67;

	Planet(double mass,double radius){
		this.mass=mass;
		this.radius=radius;
		surfaceGravity =G*mass/(radius*radius);
	}

	public double mass() {
		return mass;
	}

	public double radius() {
		return radius;
	}

	public double surfaceGravity() {
		return surfaceGravity;
	}

	public double surfaceWeight(double mass) {
		return mass * surfaceGravity;
	}
}
