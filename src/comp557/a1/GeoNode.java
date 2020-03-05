package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

import mintools.parameters.DoubleParameter;
//import javax.vecmath.Vector3d;
/**
 * @author Georges Rafie - 260677196
 */
public abstract class GeoNode extends DAGNode {

	protected final double tx;
	protected final double ty;
	protected final double tz;
	protected final double rx;
	protected final double ry;
	protected final double rz;
	protected final double sx;
	protected final double sy;
	protected final double sz;

		
	public GeoNode(  String name,
						double atx, double aty, double atz,
						double arx, double ary, double arz,
						double asx, double asy, double asz ) {
		super(name);
		this.tx = atx;
		this.ty = aty;
		this.tz = atz;
		this.rx = arx;
		this.ry = ary;
		this.rz = arz;
		this.sx = asx;
		this.sy = asy;
		this.sz = asz;
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		// TODO: Objective 2: implement the HingeJoint display method

		gl.glPushMatrix();

		for ( DAGNode n : children ) {
			super.display(drawable);
		}

		gl.glPopMatrix();

	
	}

	
}
