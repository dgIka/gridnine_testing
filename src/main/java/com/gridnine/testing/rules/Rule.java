package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

public interface Rule {
    boolean execute(Flight flight);
}
