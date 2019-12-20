#include <stdlib.h>
#include <stdio.h>

#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glew.h>
#include <GL/glut.h>
#endif

#include <math.h>

#define _PI_ 3.14159

float alfa = 0.0f, beta = 0.0f, radius = 5.0f;
float camX, camY, camZ;

GLuint vertexCount, vertices;

int timebase = 0, frame = 0;

float *vertexB, *normalB; 
GLuint buffers[2];



void sphericalToCartesian() {

	camX = radius * cos(beta) * sin(alfa);
	camY = radius * sin(beta);
	camZ = radius * cos(beta) * cos(alfa);
}


void changeSize(int w, int h) {

	// Prevent a divide by zero, when window is too short
	// (you cant make a window with zero width).
	if(h == 0)
		h = 1;

	// compute window's aspect ratio 
	float ratio = w * 1.0 / h;

	// Reset the coordinate system before modifying
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	
	// Set the viewport to be the entire window
    glViewport(0, 0, w, h);

	// Set the correct perspective
	gluPerspective(45,ratio,1,1000);

	// return to the model view matrix mode
	glMatrixMode(GL_MODELVIEW);
}



void prepareCilinder(float height, float radius, int sides) {

	float *v;

	v = (float *)malloc(sizeof(float) * 4 * 3 * 3 * sides);

	/*	meu código	-----------------------------------------------------------------------------------------------------*/

	vertexB = (float*)malloc(4*3*sides*sizeof(float));
	normalB = (float*)malloc(4*3*3*sides*sizeof(float));

	/*	fim do meu código	---------------------------------------------------------------------------------------------*/

	int vertex = 0, indexNormal = 0;
	float delta = 2.0f * _PI_ / sides;

	for (int i = 0; i < sides; ++i) {
		// top
		// central point

		/*	meu código	-----------------------------------------------------------------------------------------------------*/
		//	uma normal por cada vértice
		normalB[indexNormal++] = 0;
		normalB[indexNormal++] = 1;
		normalB[indexNormal++] = 0;

		normalB[indexNormal++] = 0;
		normalB[indexNormal++] = 1;
		normalB[indexNormal++] = 0;

		normalB[indexNormal++] = 0;
		normalB[indexNormal++] = 1;
		normalB[indexNormal++] = 0;

		/*	fim do meu código	---------------------------------------------------------------------------------------------*/


		v[vertex*3 + 0] = 0.0f; 
		v[vertex*3 + 1] = height /2.0f;
		v[vertex*3 + 2] = 0.0f;

		vertex++;
		v[vertex*3 + 0] = radius * sin( i * delta);
		v[vertex*3 + 1] = height /2.0f;
		v[vertex*3 + 2] = radius * cos( i * delta);

		vertex++;
		v[vertex*3 + 0] = radius * sin( (i+1) * delta);
		v[vertex*3 + 1] = height /2.0f;
		v[vertex*3 + 2] = radius * cos( (i+1) * delta);

		// body
		// triângulo 1

		/*	meu código	-----------------------------------------------------------------------------------------------------*/
		//	uma normal por cada vértice
		normalB[indexNormal++] = sin( (i+1) * delta);
		normalB[indexNormal++] = 0;
		normalB[indexNormal++] = cos( (i+1) * delta);

		normalB[indexNormal++] = sin( (i+1) * delta);
		normalB[indexNormal++] = 0;
		normalB[indexNormal++] = cos( (i+1) * delta);

		normalB[indexNormal++] = sin( (i+1) * delta);
		normalB[indexNormal++] = 0;
		normalB[indexNormal++] = cos( (i+1) * delta);

		/*	fim do meu código	---------------------------------------------------------------------------------------------*/

		vertex++;
		v[vertex*3 + 0] = radius * sin( (i+1) * delta);
		v[vertex*3 + 1] = height /2.0f;
		v[vertex*3 + 2] = radius * cos( (i+1) * delta);

		vertex++;
		v[vertex*3 + 0] = radius * sin( i * delta);
		v[vertex*3 + 1] = height /2.0f;
		v[vertex*3 + 2] = radius * cos( i * delta);

		vertex++;
		v[vertex*3 + 0] = radius * sin( i * delta);
		v[vertex*3 + 1] = -height /2.0f;
		v[vertex*3 + 2] = radius * cos( i * delta);

		// triangle 2
		vertex++;
		v[vertex*3 + 0] = radius * sin( (i+1) * delta);
		v[vertex*3 + 1] = -height /2.0f;
		v[vertex*3 + 2] = radius * cos( (i+1) * delta);

		vertex++;
		v[vertex*3 + 0] = radius * sin( (i+1) * delta);
		v[vertex*3 + 1] = height /2.0f;
		v[vertex*3 + 2] = radius * cos( (i+1) * delta);

		vertex++;
		v[vertex*3 + 0] = radius * sin( i * delta);
		v[vertex*3 + 1] = -height /2.0f;
		v[vertex*3 + 2] = radius * cos( i * delta);

		// base
		// central point

		/*	meu código	-----------------------------------------------------------------------------------------------------*/
		//	uma normal por cada vértice
		normalB[indexNormal++] = 0;
		normalB[indexNormal++] = -1;
		normalB[indexNormal++] = 0;

		normalB[indexNormal++] = 0;
		normalB[indexNormal++] = -1;
		normalB[indexNormal++] = 0;

		normalB[indexNormal++] = 0;
		normalB[indexNormal++] = -1;
		normalB[indexNormal++] = 0;

		/*	fim do meu código	---------------------------------------------------------------------------------------------*/

		vertex++;
		v[vertex*3 + 0] = 0.0f; 
		v[vertex*3 + 1] = -height /2.0f;
		v[vertex*3 + 2] = 0.0f;

		vertex++;
		v[vertex*3 + 0] = radius * sin( (i+1) * delta);
		v[vertex*3 + 1] = -height /2.0f;
		v[vertex*3 + 2] = radius * cos( (i+1) * delta);

		vertex++;
		v[vertex*3 + 0] = radius * sin( i * delta);
		v[vertex*3 + 1] = -height /2.0f;
		v[vertex*3 + 2] = radius * cos( i * delta);

		vertex++;
	}

	vertexCount = vertex;

	glGenBuffers(2, buffers);

	glNormal3f(0,1,0);
	glGenBuffers(1, &vertices);
	glBindBuffer(GL_ARRAY_BUFFER,vertices);
	glBufferData(GL_ARRAY_BUFFER, sizeof(float) * vertexCount * 3, v,     GL_STATIC_DRAW);

	glBindBuffer(GL_ARRAY_BUFFER,buffers[0]);
	glBufferData(GL_ARRAY_BUFFER,vertexCount, vertexB, GL_STATIC_DRAW);
	
	glBindBuffer(GL_ARRAY_BUFFER,buffers[1]);
	glBufferData(GL_ARRAY_BUFFER, vertexCount, normalB,GL_STATIC_DRAW);

	free(v);

}


void drawCilinder() {
		
	glBindBuffer(GL_ARRAY_BUFFER,vertices);
	glVertexPointer(3,GL_FLOAT,0,0);

	glDrawArrays(GL_TRIANGLES, 0, vertexCount);
}


void renderScene(void) {

	float pos[4] = {1.0, 1.0, 1.0, 0.0};
	float fps;
	int time;
	char s[64];

	glClearColor(0.0f,0.0f,0.0f,0.0f);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	glLoadIdentity();

	gluLookAt(camX,camY,camZ, 
		      0.0,0.0,0.0,
			  0.0f,1.0f,0.0f);

	drawCilinder();

	frame++;
	time=glutGet(GLUT_ELAPSED_TIME); 
	if (time - timebase > 1000) { 
		fps = frame*1000.0/(time-timebase); 
		timebase = time; 
		frame = 0; 
		sprintf(s, "FPS: %f6.2", fps);
		glutSetWindowTitle(s);
	} 

// End of frame
	glutSwapBuffers();
}



void processKeys(int key, int xx, int yy) 
{
	switch(key) {
	
		case GLUT_KEY_RIGHT: 
						alfa -=0.1; break;

		case GLUT_KEY_LEFT: 
						alfa += 0.1; break;

		case GLUT_KEY_UP : 
						beta += 0.1f;
						if (beta > 1.5f)
							beta = 1.5f;
						break;

		case GLUT_KEY_DOWN: 
						beta -= 0.1f; 
						if (beta < -1.5f)
							beta = -1.5f;
						break;

		case GLUT_KEY_PAGE_DOWN : radius -= 0.1f; 
			if (radius < 0.1f)
				radius = 0.1f;
			break;

		case GLUT_KEY_PAGE_UP: radius += 0.1f; break;

	}
	sphericalToCartesian();

}



void initGL() {

// OpenGL settings 
	glEnable(GL_DEPTH_TEST);
	glEnable(GL_CULL_FACE);

// init
	sphericalToCartesian();
	glEnableClientState(GL_VERTEX_ARRAY);

	/*	meu código	-----------------------------------------------------------------------------------------------------*/

	glEnableClientState(GL_NORMAL_ARRAY);

	/*	fim do meu código	---------------------------------------------------------------------------------------------*/

	prepareCilinder(2,1,16);

	glDrawArrays(GL_TRIANGLES, 0, vertexCount);
}


int main(int argc, char **argv) {

// init
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DEPTH|GLUT_DOUBLE|GLUT_RGBA);
	glutInitWindowPosition(100,100);
	glutInitWindowSize(320,320);
	glutCreateWindow("CG@DI-UM");
		
// callback registration
	glutDisplayFunc(renderScene);
	glutIdleFunc(renderScene);
	glutReshapeFunc(changeSize);

// keyboard callback registration
	glutSpecialFunc(processKeys);

#ifndef __APPLE__	
// init GLEW
	glewInit();
#endif	

	initGL();

	glutMainLoop();
	
	return 1;
}

