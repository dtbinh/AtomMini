/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.atom.gameplay.managers;

import com.google.common.base.Function;
import com.jme3.math.Vector2f;
import com.jme3.scene.Spatial;
import java.util.ArrayList;
import org.apache.commons.configuration.Configuration;
import sg.atom.AtomMain;
import sg.atom.core.lifecycle.AbstractManager;
import sg.atom.gameplay.CommonGameCharacter;
import sg.atom.gameplay.Skill;
import sg.atom.corex.managers.StageManager;

/**
 *
 * @author CuongNguyen
 */
public class SkillManager extends AbstractManager {

    private ArrayList<Skill> skills;
    private int gid = 0;
    public static String IMAGE_DIR = "Interface/Images/Icons/Skills/";

    public SkillManager(AtomMain app) {
        super(app);
    }

    public void loadSkills() {
        this.skills = new ArrayList<Skill>();
        skills.add(new Skill(gid++, "Skill-001", 40, IMAGE_DIR + "beam-jade-1.png"));
        skills.add(new Skill(gid++, "Skill-002", 40, IMAGE_DIR + "beam-jade-2.png"));
        skills.add(new Skill(gid++, "Skill-003", 40, IMAGE_DIR + "beam-jade-3.png"));
        skills.add(new Skill(gid++, "Skill-004", 40, IMAGE_DIR + "haste-sky-1.png"));
        skills.add(new Skill(gid++, "Skill-005", 40, IMAGE_DIR + "haste-sky-2.png"));
        skills.add(new Skill(gid++, "Skill-006", 40, IMAGE_DIR + "haste-sky-3.png"));
        skills.add(new Skill(gid++, "Skill-007", 40, IMAGE_DIR + "ice-jade-1.png"));
        skills.add(new Skill(gid++, "Skill-008", 40, IMAGE_DIR + "ice-jade-2.png"));
        skills.add(new Skill(gid++, "Skill-009", 40, IMAGE_DIR + "ice-jade-3.png"));
        skills.add(new Skill(gid++, "Skill-010", 40, IMAGE_DIR + "vines-acid-1.png"));
        skills.add(new Skill(gid++, "Skill-011", 40, IMAGE_DIR + "vines-acid-2.png"));
        skills.add(new Skill(gid++, "Skill-012", 40, IMAGE_DIR + "vines-acid-3.png"));

    }

    public Skill getSkillByName(String itemName) {
        for (Skill skill : skills) {
            if (skill.getName().equals(itemName)) {
                return skill;
            }
        }
        return null;
    }

    public void addSkill(Skill skill) {
    }

    public void upgrade(CommonGameCharacter character, Skill skill) {
    }

    public static class ShowSkillDamageFunction implements Function<Spatial, Void> {

        public ShowSkillDamageFunction(Skill skill, Vector2f pos) {
//            InGameState currentState = AtomMain.getInstance().getStateManager().getState(InGameState.class);
//            UIInGameScreen screenController = currentState.getScreenController();

            //screenController.showSkillDamage(skill.damage, pos);
        }

        public Void apply(Spatial input) {
            //input.getLocalTranslation();
            return null;
        }
    };
}
