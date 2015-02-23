package com.jawbone.upplatformsdk.endpointModels;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.datamodel.Meta;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class Endpoint {

    @SerializedName("meta")
    protected Meta meta;

    public Endpoint() {
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
