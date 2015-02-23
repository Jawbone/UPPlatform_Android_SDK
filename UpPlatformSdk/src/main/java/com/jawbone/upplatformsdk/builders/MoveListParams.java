package com.jawbone.upplatformsdk.builders;

import java.util.HashMap;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class MoveListParams extends Params {

    private HashMap<String, Integer> moveListParams;
    private Builder mBuilder;

    public MoveListParams(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }

    public HashMap<String, Integer> getMoveListParams() {
        return mBuilder.build();
    }
}
