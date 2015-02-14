package com.jawbone.upplatformsdk.endpointModels.move;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.endpointModels.Link;

import java.util.List;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class MoveData {

    @SerializedName("items")
    List<MoveItem> moveItems;

    @SerializedName("links")
    Link links;

    @SerializedName("size")
    int size;

    public MoveData() {
    }

    public List<MoveItem> getMoveItems() {
        return moveItems;
    }

    public void setMoveItems(List<MoveItem> moveItems) {
        this.moveItems = moveItems;
    }

    public Link getLinks() {
        return links;
    }

    public void setLinks(Link links) {
        this.links = links;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "MoveData{" +
                "\n\tmoveItems=" + moveItems +
                ",\n\tlinks=" + links +
                ",\n\tsize=" + size +
                "\n}\n";
    }
}
