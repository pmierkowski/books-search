package pl.pmierkowski.bookssearch.model.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBooksItemsWrapper {
    private GoogleBooksVolumeInfoWrapper volumeInfo;

    public GoogleBooksVolumeInfoWrapper getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(GoogleBooksVolumeInfoWrapper volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    @Override
    public String toString() {
        return "GoogleBooksItemsWrapper{" +
                "volumeInfo=" + volumeInfo +
                '}';
    }
}
