package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

import mintools.parameters.DoubleParameter;
//import javax.vecmath.Vector3d;

/**
 * @author Georges Rafie - 260677196
 */

public class BallJoint extends DAGNode {

	private final double tx;
	private final double ty;
	private final double tz;
	DoubleParameter rx;
	DoubleParameter ry;
	DoubleParameter rz;
		
	public BallJoint(  String name, double atx, double aty, double atz) {
		super(name);
		this.tx = atx;
		this.ty = aty;
		this.tz = atz;
		dofs.add( rx = new DoubleParameter( name+" rx", 0, -180, 180 ) );
		dofs.add( ry = new DoubleParameter( name+" ry", 0, -180, 180 ) );
		dofs.add( rz = new DoubleParameter( name+" rz", 0, -180, 180 ) );
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		// TODO: Objective 3: implement the BallJoint display method

		gl.glPushMatrix();
		
		//specified pos. rot. during BallJoint construction
		gl.glTranslated(tx, ty, tz);
		
		//DoubleParameter-specific rotations
		gl.glRotated(rx.getValue(), 1, 0, 0);
		gl.glRotated(ry.getValue(), 0, 1, 0);
		gl.glRotated(rz.getValue(), 0, 0, 1);
		
		for ( DAGNode n : children ) {
			super.display(drawable);
		}
		
		gl.glPopMatrix();
		
        //gl.glLoadIdentity();

	}

	
}
