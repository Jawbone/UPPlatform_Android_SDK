package com.jawbone.upplatformsdk.endpointModels.move;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.endpointModels.DefaultItem;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class MoveItem extends DefaultItem {


    @SerializedName("snapshot_image")
    String snapshotImage;

    @SerializedName("details")
    MoveDetails details;

    public MoveItem() {
    }

    public String getSnapshotImage() {
        return snapshotImage;
    }

    public void setSnapshotImage(String snapshotImage) {
        this.snapshotImage = snapshotImage;
    }

    public MoveDetails getDetails() {
        return details;
    }

    public void setDetails(MoveDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
