package com.jawbone.upplatformsdk.endpointModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class Link {

    @SerializedName("next")
    String next;

    public Link() {
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Link{" +
                "next='" + next + '\'' +
                '}';
    }
}
