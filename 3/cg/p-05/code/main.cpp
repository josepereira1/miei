#include <stdio.h>

#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#define _USE_MATH_DEFINES
#include <math.h>
#include <stdlib.h>

float alfa = 0.0f, beta = 0.5f, radius = 100.0f;
float camX, camY, camZ;

float tmp1 = 0, tmp2 = 0;

int isCenter(int x, int z);

void spherical2Cartesian() {

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

	// Set the projection matrix as current
	glMatrixMode(GL_PROJECTION);
	// Load Identity Matrix
	glLoadIdentity();
	
	// Set the viewport to be the entire window
    glViewport(0, 0, w, h);

	// Set perspective
	gluPerspective(45.0f ,ratio, 1.0f ,1000.0f);

	// return to the model view matrix mode
	glMatrixMode(GL_MODELVIEW);
}

void drawTree(){

	glPushMatrix();
	glColor3f(0.1f, 0.1f, 0.1f);
	glRotatef(-90.0, 1,0,0);
	glutSolidCone(1,10,10,10);
	glTranslatef(0,0,3);
	glColor3f(0.2f, 0.5f, 0.2f);
	glutSolidCone(6,15,5,10);
	glPopMatrix();
}

void drawTrees(){
	float x, z;

	srand(100);

	for(int i = 0; i < 200; i++){
		x = ((float)rand() / RAND_MAX * 200.0f - 100.0f);
		z = ((float)rand() / RAND_MAX * 200.0f - 100.0f);
		if(isCenter(x,z) == 0){
			glPushMatrix();
			glTranslatef(x,0,z);
			drawTree();
			glPopMatrix();
		}

	}
}

void drawIndians1(int slices, float radius, float dim){

	float a1 = (2*M_PI) / slices;

	for(int i = 0; i < slices; i++){
		glPushMatrix();
		glTranslatef(radius*sin(a1*i + tmp1), 2, radius*cos(a1*i+tmp1));
		glutSolidTeapot(dim);
		glPopMatrix();
	}

}

void drawIndians2(int slices, float radius, float dim){

	float a1 = (2*M_PI) / slices;

	for(int i = 0; i < slices; i++){
		glPushMatrix();
		glTranslatef(radius*sin(a1*i + tmp2), 2, radius*cos(a1*i+tmp2));
		glutSolidTeapot(dim);
		glPopMatrix();
	}

}

int isCenter(int x, int z){
	float hip = 0;
	if(x > 0 && z > 0){
		hip = sqrt(pow(x,2) + pow(z,2));
	}else{
		if(x > 0 && z < 0){
			hip = sqrt(pow(x,2) + pow(z*(-1),2));
		}else{
			if( x < 0 && z > 0){
				hip = sqrt(pow(x*(-1),2) + pow(z,2));
			}else{
				if( x < 0 && z < 0){
					hip = sqrt(pow(x*(-1),2) + pow(z*(-1),2));
				}
			}
		}
	}

	if(hip < 50)return 1;
	else return 0;
}

void renderScene(void) {

	// clear buffers
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	// set the camera
	glLoadIdentity();
	gluLookAt(camX, camY, camZ,
		0.0, 0.0, 0.0,
		0.0f, 1.0f, 0.0f);

	drawTrees();

	tmp1 = tmp1 + 0.055;
	tmp2 = tmp2 + 0.020;
	
	glColor3f(255, 0.0f, 0.0f);
	glutSolidTorus(1, 2.5, 10, 10);

	glColor3f(0, 0, 255);
	glutSolidTeapot(1);

	glColor3f(255, 0.0f, 0.0f);
	drawIndians1(6,15,1);

	glColor3f(0,0,255);
	drawIndians2(10,35,2);

	glColor3f(0.2f, 0.8f, 0.2f);
	glBegin(GL_TRIANGLES);
		glVertex3f(100.0f, 0, -100.0f);
		glVertex3f(-100.0f, 0, -100.0f);
		glVertex3f(-100.0f, 0, 100.0f);

		glVertex3f(100.0f, 0, -100.0f);
		glVertex3f(-100.0f, 0, 100.0f);
		glVertex3f(100.0f, 0, 100.0f);
	glEnd();
	// End of frame
	glutSwapBuffers();
}


void processKeys(unsigned char c, int xx, int yy) {

// put code to process regular keys in here

	switch(c){
		case 'k':
			tmp1 = tmp1 + 0.055;
			tmp2 = tmp2 + 0.020;
			break;
	}
	glutPostRedisplay();

}


void processSpecialKeys(int key, int xx, int yy) {

	switch (key) {

	case GLUT_KEY_RIGHT:
		alfa -= 0.1; break;

	case GLUT_KEY_LEFT:
		alfa += 0.1; break;

	case GLUT_KEY_UP:
		beta += 0.1f;
		if (beta > 1.5f)
			beta = 1.5f;
		break;

	case GLUT_KEY_DOWN:
		beta -= 0.1f;
		if (beta < -1.5f)
			beta = -1.5f;
		break;

	case GLUT_KEY_PAGE_DOWN: radius -= 1.0f;
		if (radius < 1.0f)
			radius = 1.0f;
		break;

	case GLUT_KEY_PAGE_UP: radius += 1.0f; break;
	}
	spherical2Cartesian();
	glutPostRedisplay();

}


void printInfo() {

	printf("%c", GLUT_KEY_PAGE_UP);

	printf("Vendor: %s\n", glGetString(GL_VENDOR));
	printf("Renderer: %s\n", glGetString(GL_RENDERER));
	printf("Version: %s\n", glGetString(GL_VERSION));

	printf("\nUse Arrows to move the camera up/down and left/right\n");
	printf("Home and End control the distance from the camera to the origin");
}


int main(int argc, char **argv) {

// init GLUT and the window
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DEPTH|GLUT_DOUBLE|GLUT_RGBA);
	glutInitWindowPosition(100,100);
	glutInitWindowSize(800,800);
	glutCreateWindow("CG@DI-UM");
		
// Required callback registry 
	glutDisplayFunc(renderScene);
	glutReshapeFunc(changeSize);
	
// Callback registration for keyboard processing
	glutKeyboardFunc(processKeys);
	glutSpecialFunc(processSpecialKeys);

//  OpenGL settings
	glEnable(GL_DEPTH_TEST);
	//glEnable(GL_CULL_FACE);

	spherical2Cartesian();

	printInfo();

// enter GLUT's main cycle
	glutMainLoop();
	
	return 1;
}
