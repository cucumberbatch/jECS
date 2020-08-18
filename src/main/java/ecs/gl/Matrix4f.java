package ecs.gl;

import ecs.math.Vector3f;
import ecs.utils.BufferUtils;

import java.nio.FloatBuffer;

public class Matrix4f {

    private static final int SIZE = 4 * 4;
    public float[] elements = new float[SIZE];

    public Matrix4f() {

    }

    public static Matrix4f identity() {
        Matrix4f result = new Matrix4f();
        for (int i = 0; i < SIZE; i++) {
            result.elements[i] = 0.0f;
        }
        result.elements[0 + 0 * 4] = 1.0f;
        result.elements[1 + 1 * 4] = 1.0f;
        result.elements[2 + 2 * 4] = 1.0f;
        result.elements[3 + 3 * 4] = 1.0f;
        return result;
    }

    public static Matrix4f orthographic(float left, float right, float top, float bottom, float near, float far) {
        Matrix4f result = identity();
        result.elements[0 + 0 * 4] = 2.0f / (right - left);
        result.elements[1 + 1 * 4] = 2.0f / (top - bottom);
        result.elements[2 + 2 * 4] = 2.0f / (far - near);
        result.elements[3 + 0 * 4] = -(right + left) / (right - left);
        result.elements[3 + 1 * 4] = -(top + bottom) / (top - bottom);
        result.elements[3 + 2 * 4] = -(far + near) / (far - near);
        return result;
    }

    public static Matrix4f translate(Vector3f vector3) {
        Matrix4f result = identity();
        result.elements[3 + 0 * 4] = vector3.x;
        result.elements[3 + 1 * 4] = vector3.y;
        result.elements[3 + 2 * 4] = vector3.z;
        return result;
    }

    public static Matrix4f rotate(float angle) {
        Matrix4f result = identity();
        float r = (float) Math.toRadians(angle);
        float sin = (float) Math.sin(r);
        float cos = (float) Math.cos(r);

        result.elements[0 + 0 * 4] = cos;
        result.elements[1 + 0 * 4] = sin;

        result.elements[0 + 1 * 4] = -sin;
        result.elements[1 + 1 * 4] = cos;

        return result;
    }

    public Matrix4f multiply(Matrix4f matrix4) {
        Matrix4f result = new Matrix4f();
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                float sum = 0.0f;
                for (int e = 0; e < 4; e++) {
                    sum += this.elements[x + e * 4] * matrix4.elements[e + y * 4];
                }
                result.elements[x + y * 4] = sum;
            }
        }
        return result;
    }

    public FloatBuffer toFloatBuffer() {
        return BufferUtils.createFloatBuffer(elements);
    }

}
