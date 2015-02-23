package com.jawbone.upplatformsdk.endpointModels.body;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.endpointModels.EndpointData;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

import java.util.List;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class BodyData extends EndpointData {

    @SerializedName("items")
    List<BodyItem> bodyItems;

    public BodyData() {
    }

    public List<BodyItem> getBodyItems() {
        return bodyItems;
    }

    public void setBodyItems(List<BodyItem> bodyItems) {
        this.bodyItems = bodyItems;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
