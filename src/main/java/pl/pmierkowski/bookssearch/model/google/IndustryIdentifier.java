
package pl.pmierkowski.bookssearch.model.google;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndustryIdentifier {

    @Expose
    private String identifier;
    @Expose
    private String type;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
