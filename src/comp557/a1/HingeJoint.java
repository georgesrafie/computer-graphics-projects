package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

import mintools.parameters.DoubleParameter;
//import javax.vecmath.Vector3d;

/**
 * @author Georges Rafie - 260677196
 */

public class HingeJoint extends DAGNode {

	private final double tx;
	private final double ty;
	private final double tz;
	private final double rx;
	private final double ry;
	private final double rz;
	private double ax; //specified axis x coord.
	private double ay; //specified axis y coord.
	private double az; //specified axis z coord.
	DoubleParameter r; //angle adjustable parameter
		
	public HingeJoint(  String name, double rmin, double rmax,
						double atx, double aty, double atz,
						double arx, double ary, double arz,
						double aax, double aay, double aaz ) {
		super(name);
		this.tx = atx;
		this.ty = aty;
		this.tz = atz;
		this.rx = arx;
		this.ry = ary;
		this.rz = arz;
		this.ax = aax;
		this.ay = aay;
		this.az = aaz;
		dofs.add( r = new DoubleParameter( name+" angle", 0, rmin, rmax ) );
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		// TODO: Objective 2: implement the HingeJoint display method

		gl.glPushMatrix();
		
		//specified pos. rot. during HingeJoint construction
		gl.glTranslated(tx, ty, tz);
		gl.glRotated(rx, 1, 0, 0);
		gl.glRotated(ry, 0, 1, 0);
		gl.glRotated(rz, 0, 0, 1);
		
		//DoubleParameter-specific rotation
		gl.glRotated(r.getValue(), ax, ay, az);
		
		for ( DAGNode n : children ) {
			super.display(drawable);
		}

		gl.glPopMatrix();

	}

	
}
