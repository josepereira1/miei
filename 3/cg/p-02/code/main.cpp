	#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <math.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

float angle1 = 5.0f;
float angle2 = 5.0f;
float xx = 1.0f,yy = 1.0f,zz = 1.0f;
float sx = 1.0f, sy = 1.0f, sz = 1.0f;

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




void renderScene(void) {

	// clear buffers
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	// set the camera
	glLoadIdentity();
	gluLookAt(5.0,5.0,5.0, 
		      0.0,0.0,0.0,
			  0.0f,1.0f,0.0f);

// put the geometric transformations here

	glRotatef(angle1, 0,1,0);
	glRotatef(angle2, 1,0,0);
	glTranslatef(1,1,1);
	glScalef(sx,sy,sz);


// put drawing instructions here

	glBegin(GL_TRIANGLES);
		glColor3f(0,255,0);

		//	a ordem dos pontos importa, temos que ter em conta a regra da mão direita

		glVertex3f(2.0f,  0.0f, 2.0f);
		glVertex3f(0.0f, 3.0f, 0.0f);
        glVertex3f(-2.0f, 0.0f, 2.0f);

        glColor3f(255,0,0);


		glVertex3f(2.0f,  0.0f, -2.0f);
		glVertex3f(0.0f, 3.0f, 0.0f);
        glVertex3f(2.0f, 0.0f, 2.0f);

        glColor3f(0,0,255);

        glVertex3f(-2.0f,  0.0f, -2.0f);
		glVertex3f(0.0f, 3.0f, 0.0f);
        glVertex3f(2.0f, 0.0f, -2.0f);

        glColor3f(255,0,255);

        glVertex3f(-2.0f,  0.0f, 2.0f);
		glVertex3f(0.0f, 3.0f, 0.0f);
        glVertex3f(-2.0f, 0.0f, -2.0f);

        glColor3f(0,255,255);

        glVertex3f(2.0f,  0.0f, 2.0f);
		glVertex3f(-2.0f, 0.0f, 2.0f);
        glVertex3f(-2.0f, 0.0f, -2.0f);

        glColor3f(255,255,255);

        glVertex3f(-2.0f,  0.0f, -2.0f);
		glVertex3f(2.0f, 0.0f, -2.0f);
        glVertex3f(2.0f, 0.0f, 2.0f);

	glEnd();

	// End of frame
	glutSwapBuffers();
}

// write function to process keyboard events

void controler(unsigned char key, int x, int y){

	switch(key){
		case 'a':
			angle1 += 5.0f;
			break;
		case 'd':
			angle1 -= 5.0f;
			break;
		case 's':
			angle2 += 5.0f;
			break;
		case 'w':
			angle2 -= 5.0f;
			break;
		case 'i':
			yy += 0.3;
			break;
		case 'k':
			yy -= 0.3;
			break;
		case 'j':
			xx -= 0.3;
			break;
		case 'l':
			xx += 0.3;
			break;
		case 'y':
			sx += 0.005;
			sy += 0.005;
			sz += 0.005;
			break;
		case 'h':
			sx -= 0.005;
			sy -= 0.005;
			sz -= 0.005;
			break;
		default:
			break;
	}
	glutPostRedisplay();
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

	
// put here the registration of the keyboard callbacks

	glutKeyboardFunc(controler);


//  OpenGL settings
	glEnable(GL_DEPTH_TEST);
	glEnable(GL_CULL_FACE);
	
// enter GLUT's main cycle
	glutMainLoop();
	
	return 1;
}
