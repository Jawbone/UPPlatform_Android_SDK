package com.jawbone.upplatformsdk.endpointModels.move;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.datamodel.Meta;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class Move {

    @SerializedName("meta")
    Meta meta;

    @SerializedName("data")
    MoveData moveData;

    public Move() {
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public MoveData getMoveData() {
        return moveData;
    }

    public void setMoveData(MoveData moveData) {
        this.moveData = moveData;
    }

    @Override
    public String toString() {
        return "Move{" +
                "meta=" + meta.toString() +
                ", moveData=" + moveData +
                '}';
    }
}
