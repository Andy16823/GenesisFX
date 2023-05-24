package gfx.math;

import java.util.Vector;

import gfx.math.*;

public class PerlinNoise {
	
	private static float noise(int x, int y, int seed) {
        int n = x + y * 57 + seed;
        n = (n << 13) ^ n;
        return (1.0f - ((n * (n * n * 15731 + 789221) + seed) & 0x7fffffff) / 1073741824.0f);
    }

    private static float smoothedNoise(float x, float y, int seed) {
        int integer_X = (int) x;
        float fractional_X = x - integer_X;

        int integer_Y = (int) y;
        float fractional_Y = y - integer_Y;

        float v1 = noise(integer_X, integer_Y, seed);
        float v2 = noise(integer_X + 1, integer_Y, seed);
        float v3 = noise(integer_X, integer_Y + 1, seed);
        float v4 = noise(integer_X + 1, integer_Y + 1, seed);

        float i1 = interpolate(v1, v2, fractional_X);
        float i2 = interpolate(v3, v4, fractional_X);

        return interpolate(i1, i2, fractional_Y);
    }

    private static float interpolate(float a, float b, float x) {
        float ft = x * 3.1415927f;
        float f = (1 - (float) Math.cos(ft)) * 0.5f;
        return a * (1 - f) + b * f;
    }

    public static float perlinNoise(float x, float y, float persistence, int octaves, int seed) {
        float total = 0;
        float frequency = 0.1f;
        float amplitude = 1;
        float maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            total += smoothedNoise(x * frequency, y * frequency, seed) * amplitude;
            maxValue += amplitude;
            amplitude *= persistence;
            frequency *= 2;
        }

        return total / maxValue;
    }
	
    public Vector<NoisePoint> generateNoiseMap(int width, int height, int seed) {
    	Vector<NoisePoint> noiseMap = new Vector<>();

		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				float noiseVal = perlinNoise((float)x,(float)y,0.5f, 4, seed);
				noiseMap.add(new NoisePoint(x,y,noiseVal));
			}
		}
    	
    	return noiseMap;
    }
    
}

