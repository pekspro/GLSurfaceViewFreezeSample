package com.example.glsurfaceviewfreezesample;

import android.opengl.GLSurfaceView.Renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGLRenderer implements Renderer
{
	public void onSurfaceCreated(GL10 gl, EGLConfig config)
	{
	}

	public void onSurfaceChanged(GL10 gl, int w, int h) {
		gl.glViewport(0, 0, w, h);
	}

	float color = 0.2f;

	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		color += 0.01f;

		if (color > 0.7) {
			color = 0.02f;
		}

		for(int i = 0; i < 500000; i++) {
			gl.glClearColor(color * 0.8f, 0.0f, color, 1.0f);
		}
	}
}