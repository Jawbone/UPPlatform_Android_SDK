package com.jawbone.upplatformsdk.endpointModels;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.datamodel.Links;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class EndpointData {

    @SerializedName("links")
    protected Links links;

    @SerializedName("size")
    protected Integer size;

    public EndpointData() {
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
