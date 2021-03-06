/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.atom.corex.artemis;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;
import sg.atom.corex.managers.WorldManager;

/**
 *
 * @author atomix
 */
/**
 * <code>SpatialEntityControl</code> (Common Implementation) keep the link from
 * the
 * <code>Spatial</code> to the appropriate
 * <code>Entity</code>.</br>
 *
 * It's basiclly the low level control in the Atom architecture.
 *
 * <p>It uses Animation and Character control and should be use by
 * <code>SpatialSelectControl</code>,
 * <code>AIControl</code> etc...
 */
public class ArtermisSpatialEntityControl extends AbstractControl {

    protected WorldManager worldManager;
    protected ArtermisSpatialEntity spatialEntity;

    public ArtermisSpatialEntityControl(WorldManager worldManager, ArtermisSpatialEntity spatialEntity) {
        this.worldManager = worldManager;
        this.spatialEntity = spatialEntity;
    }

    @Override
    protected void controlUpdate(float tpf) {
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }

    public Control cloneForSpatial(Spatial spatial) {
        return null;
    }

    public ArtermisSpatialEntity getEntity() {
        return spatialEntity;
    }
}
