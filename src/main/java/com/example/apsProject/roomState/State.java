package com.example.apsProject.roomState;

import java.io.IOException;

public interface State {
    public void doAction(Context context);

    public String getKey() throws IOException;
}
