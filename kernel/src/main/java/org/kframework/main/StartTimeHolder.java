// Copyright (c) 2015-2018 K Team. All Rights Reserved.
package org.kframework.main;

import org.kframework.utils.inject.RequestScoped;

/**
 * @author Denis Bogdanas
 * Created on 27-Jul-18.
 */
@RequestScoped
public class StartTimeHolder {
    private long startTime = System.currentTimeMillis();

    public long getStartTime() {
        return startTime;
    }
}
