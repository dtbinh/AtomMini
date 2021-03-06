package sg.atom.corex.ui.nifty.effects;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.TextBuilder;
import de.lessvoid.nifty.effects.EffectImpl;
import de.lessvoid.nifty.effects.EffectProperties;
import de.lessvoid.nifty.effects.Falloff;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.render.NiftyRenderEngine;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.tools.SizeValue;
import de.lessvoid.nifty.tools.TargetElementResolver;

/**
 *
 * @author hungcuong
 */
public class CustomHint implements EffectImpl {

    private Nifty nifty;
    private Element targetElement;
    private String hintText;
    private String longText;

    public void activate(final Nifty niftyParam, final Element element, final EffectProperties parameter) {
        this.nifty = niftyParam;

        TargetElementResolver resolver = new TargetElementResolver(nifty.getCurrentScreen(), element);
        targetElement = resolver.resolve(parameter.getProperty("targetElement"));

        String text = parameter.getProperty("hintText");
        if (text != null) {
            this.hintText = text;
        }
        String text2 = parameter.getProperty("longText");
        if (text2 != null) {
            this.longText = text2;
        }
    }

    public void execute(final Element element, final float normalizedTime, final Falloff falloff, final NiftyRenderEngine r) {
        if (targetElement != null) {
            if (hintText != null) {
                targetElement.findElementById("hintTitle").getRenderer(TextRenderer.class).setText(hintText);
            }
            if (longText != null) {
                targetElement.findElementById("hintLongInfo").getRenderer(TextRenderer.class).setText(longText);
            }
            targetElement.setConstraintX(new SizeValue(element.getX() + element.getWidth() - 20 - targetElement.getWidth() + "px"));
            targetElement.setConstraintY(new SizeValue(element.getY() + element.getHeight() - 20 - targetElement.getHeight() + "px"));
            targetElement.show();
            nifty.getCurrentScreen().layoutLayers();
        }
    }

    public void deactivate() {
        if (targetElement != null) {
            targetElement.hide();
        }
    }

}
