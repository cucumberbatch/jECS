package ecs.util;

import ecs.math.Vector3;

public class Physics {
    public static float gravityFactor = 9.81f;
    public static Vector3 gravityVector = Vector3.mul(Vector3.down(), gravityFactor);
}
