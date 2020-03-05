package comp557.a1;

import javax.swing.JTextField;

import comp557.a1.DAGNode;
import comp557.a1.Parser;
import mintools.parameters.BooleanParameter;

/**
 * @author Georges Rafie - 260677196
 */

public class CharacterCreator {

	static public String name = "AT-ST - GEORGES RAFIE 260677196";
	
	// TODO: Objective 6: change default of load from file to true once you start working with xml
	static BooleanParameter loadFromFile = new BooleanParameter( "Load from file (otherwise by procedure)", false );
	static JTextField baseFileName = new JTextField("a1data/character");
	static { baseFileName.setName("what is this?"); }
	
	/**
	 * Creates a character, either procedurally, or by loading from an xml file
	 * @return root node
	 */
	static public DAGNode create() {
		
		if ( loadFromFile.getValue() ) {
			// TODO: Objectives 6: create your character in the character.xml file 
			return Parser.load( baseFileName.getText() + ".xml");
		} else {
			// TODO: Objective 1,2,3,4: test DAG nodes by creating a small DAG in the CharacterCreator.create() method 
			// Use this for testing, but ultimately it will be more interesting
			// to create your character with an xml description (see example).
			
			// Geometry construction of the whole character
			FreeJoint root = new FreeJoint("root");
			CubeGeoNode head1 = new CubeGeoNode("head1", 0, 10, 0, -15, 0, 0, 3, 4, 2.7);
			CubeGeoNode head2 = new CubeGeoNode("head2", 0, 10.7, -1.5, 5, 0, 0, 3.3, 3.5, 4);
			SphereGeoNode head3 = new SphereGeoNode("head3", 0, 10.6, -1, 5, 0, 0, 2.2, 2, 2);
			CubeGeoNode nose = new CubeGeoNode("nose", 0, 10, .1, -15, 0, 0, 2.7, 2.5, 2.7);
			CubeGeoNode mouth = new CubeGeoNode("mouth", 0, 0, 0, 0, 0, 0, 1, 1, 1);
			CylinderGeoNode lTooth = new CylinderGeoNode("lTooth", -.2, .1, 0, 0, 0, 0, .15, .15, 1.5);
			CylinderGeoNode rTooth = new CylinderGeoNode("rTooth", .2, .1, 0, 0, 0, 0, .15, .15, 1.5);
			CubeGeoNode lEye = new CubeGeoNode("lEye", -.8, 12, 1, 5, 0, 0, 1, .1, 1);
			CubeGeoNode rEye = new CubeGeoNode("rEye",  .8, 12, 1, 5, 0, 0, 1, .1, 1);
			HingeJoint mouthH = new HingeJoint("mouthH", -45, 45, 0, 8.5, 1.6, 0, 0, 0, 1, 0, 0);
			BallJoint ballNeck = new BallJoint("ballNeck", 0, 9.5, -1.5);
			HingeJoint hingeNeck = new HingeJoint("neck", -90, 90, 0, 0, 0, 0, 0, 0, 0, 1, 0);
			CylinderGeoNode neck = new CylinderGeoNode("neck", 0, 0, 0, 90, 0, 0, 1, 1, 2);
			HingeJoint shoulder = new HingeJoint("shoulder", -45, 45, 0, 10.6, -1, 0, 0, 0, 1, 0, 0);
			CylinderGeoNode shoulders = new CylinderGeoNode("shoulders", -2.25, 0, 0, 0, 90, 0, .5, .5, 4.5);
			CylinderGeoNode shoulderss = new CylinderGeoNode("shoulders", -2.75, 0, 0, 0, 90, 0, .2, .2, 5.5);
			CubeGeoNode rShoulder = new CubeGeoNode("rShoulder", -2.75, 0, 0, 0, 0, 0, .5, .8, 1);
			CylinderGeoNode rArm1 = new CylinderGeoNode("rArm1", -2.75, .2, 0, 0, 0, 0, .1, .1, 2);
			CylinderGeoNode rArm2 = new CylinderGeoNode("rArm2", -2.75, -.2, 0, 0, 0, 0, .1, .1, 2);
			CubeGeoNode lShoulder = new CubeGeoNode("lShoulder", 2.75, 0, 0, 0, 0, 0, .5, .8, 1);
			CylinderGeoNode lArm1 = new CylinderGeoNode("lArm1", 2.75, 0, 0, 0, 0, 0, .2, .2, 2);
			DodGeoNode torso = new DodGeoNode("torso", 0, -2, 0, 0, 0, 0, 1, .4, 1);
			CubeGeoNode stomach = new CubeGeoNode("stomach", 0, -2, -2, 0, 0, 0, 3, 1, 4);
			DodGeoNode hips = new DodGeoNode("hips", 0, -2, -2.5, 0, 0, 0, 1.3, .6, .93);
			BallJoint rHip = new BallJoint("rHip", -1.5, -2, -2.5);
			CubeGeoNode rHipp = new CubeGeoNode("rHipp", -.6, -.2, 1, 15, -10, 0, .75, .8, 2);
			HingeJoint rThighH = new HingeJoint("rThighH", -45, 20, -.5, -.5, 1, 0, 0, 0, 1, 0, 0);
			CubeGeoNode rThigh = new CubeGeoNode("rThigh", -.25, -.5, -.7, -15, 0, 0, 1, 1.5, 3);
			CylinderGeoNode rThighC = new CylinderGeoNode("rThighC", -.9, -.18, .6, 0, 90, 0, .8, .8, 1.3);
			HingeJoint rLegH = new HingeJoint("rLegH", -45, 45, 0, -.75, -2.75, 0, 0, 0, 1, 0, 0);
			CubeGeoNode rLeg = new CubeGeoNode("rLeg", -.25, -2.75, .75, 75, 0, 0, .9, 1, 6.5);
			CylinderGeoNode rLegC = new CylinderGeoNode("rLegC", -.9, -.18, .1, -20, 90, 0, .72, 1.1, 1.3);
			HingeJoint rAnkleH = new HingeJoint("rAnkleH", -20, 20, 0, -5.5, 2, 0, 0, 0, 1, 0, 0);
			CubeGeoNode rAnkle = new CubeGeoNode("rAnkle", -.2, -.5, 0, 50, 0, 0, .5, .5, 2);
			HingeJoint rFootH = new HingeJoint("rFootH", -20, 20, 0, -1, .75, 0, 0, 0, 1, 0, 0);
			DodGeoNode rFoot = new DodGeoNode("rFoot", -.2, 0, 0, 0, 0, 0, 1, .3, 1);
			BallJoint lHip = new BallJoint("lHip", 1.5, -2, -2.5);
			CubeGeoNode lHipp = new CubeGeoNode("lHipp", .6, -.2, 1, 15, 10, 0, .75, .8, 2);
			HingeJoint lThighH = new HingeJoint("lThighH", -45, 20, .5, -.5, 1, 0, 0, 0, 1, 0, 0);
			CubeGeoNode lThigh = new CubeGeoNode("lThigh", .25, -.5, -.7, -15, 0, 0, 1, 1.5, 3);
			CylinderGeoNode lThighC = new CylinderGeoNode("lThighC", -.4, -.18, .6, 0, 90, 0, .8, .8, 1.3);
			HingeJoint lLegH = new HingeJoint("lLegH", -45, 45, .5, -.75, -2.75, 0, 0, 0, 1, 0, 0);
			CubeGeoNode lLeg = new CubeGeoNode("lLeg", -.25, -2.75, .75, 75, 0, 0, .9, 1, 6.5);
			CylinderGeoNode lLegC = new CylinderGeoNode("lLegC", -.9, -.18, .1, -20, 90, 0, .72, 1.1, 1.3);
			HingeJoint lAnkleH = new HingeJoint("lAnkleH", -20, 20, 0, -5.5, 2, 0, 0, 0, 1, 0, 0);
			CubeGeoNode lAnkle = new CubeGeoNode("lAnkle", -.2, -.5, 0, 50, 0, 0, .5, .5, 2);
			HingeJoint lFootH = new HingeJoint("lFootH", -20, 20, 0, -1, .75, 0, 0, 0, 1, 0, 0);
			DodGeoNode lFoot = new DodGeoNode("lFoot", -.2, 0, 0, 0, 0, 0, 1, .3, 1);
			
			
			root.add(ballNeck);
			ballNeck.add(neck);
			ballNeck.add(hingeNeck);
			root.add(head1);
			root.add(head2);
			root.add(head3);
			root.add(lEye);
			root.add(rEye);
			root.add(mouthH);
			root.add(nose);
			mouthH.add(mouth);
			mouthH.add(lTooth);
			mouthH.add(rTooth);
			root.add(shoulder);
			shoulder.add(shoulders);
			shoulder.add(shoulderss);
			shoulder.add(rShoulder);
			shoulder.add(rArm1);
			shoulder.add(rArm2);
			shoulder.add(lShoulder);
			shoulder.add(lArm1);
			hingeNeck.add(torso);
			hingeNeck.add(stomach);
			hingeNeck.add(hips);
			hingeNeck.add(rHip);
			rHip.add(rHipp);
			rHip.add(rThighH);
			rThighH.add(rThigh);
			rThighH.add(rThighC);
			rThighH.add(rLegH);
			rLegH.add(rLeg);
			rLegH.add(rLegC);
			rLegH.add(rAnkleH);
			rAnkleH.add(rAnkle);
			rAnkleH.add(rFootH);
			rFootH.add(rFoot);
			hingeNeck.add(lHip);
			lHip.add(lHipp);
			lHip.add(lThighH);
			lThighH.add(lThigh);
			lThighH.add(lThighC);
			lThighH.add(lLegH);
			lLegH.add(lLeg);
			lLegH.add(lLegC);
			lLegH.add(lAnkleH);
			lAnkleH.add(lAnkle);
			lAnkleH.add(lFootH);
			lFootH.add(lFoot);
			
			//child.add(lFoot);
			
			
			
			
			
			// Here we just return null, which will not be very interesting, so write
			// some code to create a test or partial charcter and return the root node.

			return root;
		}
	}
}
