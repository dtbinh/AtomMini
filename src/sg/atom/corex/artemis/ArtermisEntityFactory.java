/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.atom.corex.artemis;

import com.artemis.Entity;
import sg.atom.corex.managers.StageManager;
import sg.atom.corex.managers.WorldManager;

/**
 * EntityFactory to procedure Entity.
 *
 * (CommonImplementation) Consider as Suggestion to use the Factory pattern
 * along with EntitySystem.
 * <ul>
 * <li>It has a Cache implementation of original entities beside of one in
 * AssetManager.
 *
 * <li>It can compose any "free bunch" (no-order, no dependencies) of
 * Components. As in ComponentSet like an Entity!
 *
 * <li>Also support dependency injection to create (compose) Entity as a
 * Composite of Fragment (like in Qi4j).
 *
 * <li>
 *
 * </ul>
 *
 * @author atomix
 */
public class ArtermisEntityFactory {

    protected ArtermisEntityManager entityManager;
    protected StageManager stageManager;
    protected WorldManager worldManager;

    public ArtermisEntityFactory(ArtermisEntityManager entityManager) {
        this.entityManager = entityManager;
//        this.stageManager = stageManager;
    }

    public Entity create(Object param) {
        return null;
    }

    public Entity create(Object... params) {
        return null;
    }

    public Entity cloneObject(Entity orginal) {
        return null;
    }

    public Entity get() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void buildEntityFromComponents(Object... components) {
    }

    public static void decorate(Entity entity, Object component) {
    }

    public Object cloneComponent(Object component) {
        return null;
    }
}
