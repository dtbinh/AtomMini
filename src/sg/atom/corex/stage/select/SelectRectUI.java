package sg.atom.corex.stage.select;

import com.jme3.app.Application;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial.CullHint;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.ui.Picture;
import java.util.List;
import sg.atom.corex.stage.select.SelectManager.SelectOperationUI;

/**
 *
 * @author atomix
 */
public class SelectRectUI implements SelectOperationUI{

    protected Picture p1, p2;
    public float x = 0, y = 0, width = 0, height = 0;
    protected Material blackMat;
    protected final Material greenMat;
    protected Geometry l1, l2, l3, l4;
    protected Geometry c1, c2;
    protected float lineWidth = 0.5f;
    protected boolean visible = false;
    public boolean dragging = false;
    protected Node toolNode;
    private final Vector4f sourceBound;
    private Vector3f origin;

    public SelectRectUI(Application app, Vector4f bound) {
        AssetManager assetManager = app.getAssetManager();
        this.origin = new Vector3f();
        this.sourceBound = bound;
        
        toolNode = new Node("SelectRectUIToolNode");

        blackMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        blackMat.setColor("Color", ColorRGBA.Black);

        Box box = new Box(1, 1, 1);
        l1 = new Geometry("l1", box);

        greenMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        greenMat.setColor("Color", ColorRGBA.Green);

        l1.setMaterial(greenMat);
        l1.setLocalTranslation(0, 0, 1);

        l2 = l1.clone(true);
        l3 = l1.clone(true);
        l4 = l1.clone(true);
        /*
         l2.getMaterial().setColor("Color", ColorRGBA.Blue);
         l3.getMaterial().setColor("Color", ColorRGBA.Brown);
         l4.getMaterial().setColor("Color", ColorRGBA.Cyan);
         */


        l2.getMaterial().setColor("Color", ColorRGBA.Green);
        l3.getMaterial().setColor("Color", ColorRGBA.Green);
        l4.getMaterial().setColor("Color", ColorRGBA.Green);

        toolNode.attachChild(l1);
        toolNode.attachChild(l2);
        toolNode.attachChild(l3);
        toolNode.attachChild(l4);
        //Cylinder cyl = new Cylinder(1, 16, 2, 1);
        Sphere sp = new Sphere(6, 6, 2);
        c1 = new Geometry("c1", sp);
        c1.setMaterial(greenMat);
        c2 = c1.clone(true);

        c1.getMaterial().setColor("Color", ColorRGBA.Yellow);
        c2.getMaterial().setColor("Color", ColorRGBA.Orange);

        toolNode.attachChild(c1);
        toolNode.attachChild(c2);

        setVisible(false);
    }

    public void updateRect(Vector4f sourceBound) {
        updateRect(sourceBound.x, sourceBound.y, sourceBound.z, sourceBound.w);
    }

    public void updateRect(float x, float y, float width, float height) {

        l1.setLocalScale(width / 2, 1 * lineWidth, 1);
        l2.setLocalScale(1 * lineWidth, height / 2, 1);
        l3.setLocalScale(width / 2, 1 * lineWidth, 1);
        l4.setLocalScale(1 * lineWidth, height / 2, 1);

        l1.setLocalTranslation(x + width / 2, y, 0);
        l2.setLocalTranslation(x, y + height / 2, 0);
        l3.setLocalTranslation(x + width / 2, y + height, 0);
        l4.setLocalTranslation(x + width, y + height / 2, 0);

        c1.setLocalTranslation(x, y, 0);
        c2.setLocalTranslation(x + width, y + height, 0);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setHoldPoint(float px, float py) {
        x = px;
        y = py;
        width = 0;
        height = 0;
    }

    public void setDynamicPoint(float px, float py) {
        width = px - x;
        height = py - y;

    }

    public void setVisible(boolean b) {
        visible = b;
        if (!visible) {
            this.getToolNode().setCullHint(CullHint.Always);
        } else {
            this.getToolNode().setCullHint(CullHint.Never);
        }
    }

    public boolean isVisible() {
        return visible;
    }

//    @Override
    public Node getToolNode() {
        return toolNode;
    }

    public void update(float tpf) {
        updateRect(sourceBound);
    }

    public void setOriginPoint(Vector3f point) {
        this.origin.set(point);
        setHoldPoint(point.x, point.y);
    }

    public void addDynamicPoint(Vector3f point) {
        setDynamicPoint(point.x, point.y);
    }

    public Vector4f getBound() {
        return sourceBound;
    }

    public List<Vector3f> getPolygon() {
        return null;
    }

    public boolean isClosed() {
        return true;
    }

    public boolean isFinished() {
        return !dragging;
    }

    public void setFinished(boolean finish) {
        dragging = !finish;
    }

    public Vector3f getOriginPoint() {
        return origin;
    }
}
