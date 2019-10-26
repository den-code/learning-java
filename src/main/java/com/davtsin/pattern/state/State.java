package com.davtsin.pattern.state;

interface State {
    String getName();

    void freeze(StateContext context);

    void heat(StateContext context);
}
