#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#define _USE_MATH_DEFINES
#include <math.h>

float x = M_PI / 3;

float angle1 = 5.0, angle2 = 5.0;

int mode = GL_FILL;
int face = GL_FRONT;

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

void drawCone(float radius, float height, int slices, int stacks){
	float angle = (2*M_PI)/slices;
    float tmp1, tmp2, fraction_height;

    glBegin(GL_TRIANGLES);

    for(int i = 0; i < stacks; i++){
        for(int j = 0; j < slices; j++){
            tmp1 = (radius - (radius/stacks)*i);
            tmp2 = (radius - (radius/stacks)*(i+1));
            fraction_height = (height/stacks)*i;

            if(i == 0){ //  a base tem que ser voltada para baixo
                glVertex3f(tmp1*sin(angle*j),  fraction_height, tmp1*cos(angle*j));
                glVertex3f(0.0,  (height/stacks)*i, 0.0);
                glVertex3f(tmp1*sin(angle*(j+1)),  fraction_height, tmp1*cos(angle*(j+1)));
            }/*else{
                glVertex3f(tmp1*sin(angle*(j+1)),  fraction_height, tmp1*cos(angle*(j+1)));
                glVertex3f(0.0,  (height/stacks)*i, 0.0);
                glVertex3f(tmp1*sin(angle*j),  fraction_height, tmp1*cos(angle*j));
            }*/

            //  para não desenhar os triângulos interiores basta comentar as 3 linhas acima do else

            glVertex3f(tmp1*sin(angle*(j+1)),  fraction_height, tmp1*cos(angle*(j+1)));
            glVertex3f(tmp2*sin(angle*(j+1)), fraction_height+((height/stacks)), tmp2*cos(angle*(j+1)));
            glVertex3f(tmp1*sin(angle*j),  fraction_height, tmp1*cos(angle*j));

            glVertex3f(tmp2*sin(angle*(j+1)), fraction_height+((height/stacks)), tmp2*cos(angle*(j+1)));
            glVertex3f(tmp2*sin(angle*j), fraction_height+((height/stacks)), tmp2*cos(angle*j));
            glVertex3f(tmp1*sin(angle*j),  fraction_height, tmp1*cos(angle*j));
        }
    }
    glEnd();
}


void drawCylinder(float radius, float height, int slices) {

// put code to draw cylinder in here

	//function drawCylinder(float radius, float height, int slices)
	
	glBegin(GL_TRIANGLES);

		float ang = 2*M_PI/slices;

		//base

		for(int i = 0; i < slices; i++){
			/*if(i % 2 == 0)
				glColor3f(200,0,10);
			else
				glColor3f(0,10,100);
			*/

			glColor3f(200,0,10);
			
			glVertex3f(radius*sin(ang*i),  0.0, radius*cos(ang*i));
			glVertex3f(0.0,  0.0, 0.0);
			glVertex3f(radius*sin(ang*(i+1)),  0.0, radius*cos(ang*(i+1)));

			/*if(i % 2 != 0)
				glColor3f(40,50,0);
			else
				glColor3f(10,0,180);
			*/

			glColor3f(20,100,0);

			glVertex3f(radius*sin(ang*i),  0.0, radius*cos(ang*i));
			glVertex3f(radius*sin(ang*(i+1)),  0.0, radius*cos(ang*(i+1)));
			glVertex3f(radius*sin(ang*(i+1)),  height, radius*cos(ang*(i+1)));

			/*if(i % 2 == 0)
				glColor3f(55,0,0);
			else
				glColor3f(0,0,44);
			*/

			glColor3f(0,200,10);

			glVertex3f(radius*sin(ang*i),  height, radius*cos(ang*i));
			glVertex3f(radius*sin(ang*(i+1)),  height, radius*cos(ang*(i+1)));
			glVertex3f(0.0,  height, 0.0);

			/*if(i % 2 == 0)
				glColor3f(0,55,0);
			else
				glColor3f(0,44,0);
			*/

			glColor3f(20,100,0);

			glVertex3f(radius*sin(ang*i),  0.0, radius*cos(ang*i));
			glVertex3f(radius*sin(ang*(i+1)),  height, radius*cos(ang*(i+1)));
			glVertex3f(radius*sin(ang*i),  height , radius*cos(ang*i));
		}
    glEnd();

}


void renderScene(void) {

	// clear buffers
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	// set the camera
	glLoadIdentity();
	gluLookAt(50.0,50.0,50.0, 
		      0.0,0.0,0.0,
			  0.0f,0.1f,0.0f);

	glRotatef(angle1, 1,0,0);
	glRotatef(angle2, 0,0,1);

	//drawCylinder(10,2,42);

	drawCone(20,50,10,10);

	// End of frame
	glutSwapBuffers();
}


void processKeys(unsigned char c, int xx, int yy) {

// put code to process regular keys in here
    switch(c){
    	case 'q':
    		mode = GL_FILL;
    		break;
    	case 'w':
    		mode = GL_LINE;
    		break;
    	case 'e':
    		mode = GL_POINT;
    		break;
    	case 'a':
    		face = GL_FRONT;
    		break;
    	case 's':
    		face = GL_BACK;
    		break;
    	case 'd':
    		face = GL_FRONT_AND_BACK;
    		break;
		case 'j':
			angle1 += 5.0f;
			break;
		case 'l':
			angle1 -= 5.0f;
			break;
		case 'k':
			angle2 += 5.0f;
			break;
		case 'i':
			angle2 -= 5.0f;
			break;
		default:
			break;
	}

    glPolygonMode(face,mode);
    glutPostRedisplay();
}


void processSpecialKeys(int key, int xx, int yy) {

// put code to process special keys in here

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
	glEnable(GL_CULL_FACE);
	
// enter GLUT's main cycle
	glutMainLoop();
	
	return 1;
}
