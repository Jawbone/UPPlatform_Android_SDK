/**
 * @author Omer Muhammed on 03/16/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jawbone.upplatformsdk.datamodel.Links;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCollection {

    @JsonProperty("links")
    public Links links;

    @JsonProperty("size")
    public int size;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
