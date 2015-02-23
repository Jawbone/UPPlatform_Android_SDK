package com.jawbone.upplatformsdk.endpointModels.body;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.endpointModels.Endpoint;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class Body extends Endpoint {

    @SerializedName("data")
    BodyData data;

    public Body() {
    }

    public BodyData getData() {
        return data;
    }

    public void setData(BodyData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
