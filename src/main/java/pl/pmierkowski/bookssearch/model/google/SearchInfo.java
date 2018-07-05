
package pl.pmierkowski.bookssearch.model.google;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchInfo {

    @Expose
    private String textSnippet;

    public String getTextSnippet() {
        return textSnippet;
    }

    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }

}
