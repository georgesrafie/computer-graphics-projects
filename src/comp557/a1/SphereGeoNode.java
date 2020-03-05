package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

import mintools.parameters.DoubleParameter;
//import javax.vecmath.Vector3d;

/**
 * @author Georges Rafie - 260677196
 */

public class SphereGeoNode extends GeoNode {

		
	public SphereGeoNode(  String name,
						double atx, double aty, double atz,
						double arx, double ary, double arz,
						double asx, double asy, double asz ) {
		super(name, atx, aty, atz, arx, ary, arz, asx, asy, asz);
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		super.display(drawable);
		
		gl.glPushMatrix();

		//specified pos. rot. during construction
		gl.glTranslated(tx, ty, tz);
		gl.glRotated(rx, 1, 0, 0);
		gl.glRotated(ry, 0, 1, 0);
		gl.glRotated(rz, 0, 0, 1);
		gl.glScaled(sx, sy, sz);
		
		glut.glutSolidSphere(1, 10, 10);
				
		for ( DAGNode n : children ) {
			super.display(drawable);
		}
		
		gl.glPopMatrix();
		
	}

	
}
