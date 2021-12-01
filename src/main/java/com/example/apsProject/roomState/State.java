package com.example.apsProject.roomState;
import java.io.IOException;

public interface State {
    public String doAction(Context context) throws IOException;
}
