package Iceland.Tech.Test.iceland.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Timi Ogunkeye
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadUrlResponse {
    private Object url; //optional

    public UploadUrlResponse(Object url) {
        this.url = url;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UploadUrlResponse{" + "url=" + url + '}';
    }
    
    
}
