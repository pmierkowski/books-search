
package pl.pmierkowski.bookssearch.model.google;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PanelizationSummary {

    @Expose
    private Boolean containsEpubBubbles;
    @Expose
    private Boolean containsImageBubbles;

    public Boolean getContainsEpubBubbles() {
        return containsEpubBubbles;
    }

    public void setContainsEpubBubbles(Boolean containsEpubBubbles) {
        this.containsEpubBubbles = containsEpubBubbles;
    }

    public Boolean getContainsImageBubbles() {
        return containsImageBubbles;
    }

    public void setContainsImageBubbles(Boolean containsImageBubbles) {
        this.containsImageBubbles = containsImageBubbles;
    }

}
