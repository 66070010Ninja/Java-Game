// Package
package Game_Object;

public class Key {

    private boolean key_up;
    private boolean key_down;
    private boolean key_right;
    private boolean key_left;

    public boolean get_Key_Up() {
        return key_up;
    }
    public boolean get_Key_Down() {
        return key_down;
    }
    public boolean get_Key_Right() {
        return key_right;
    }
    public boolean get_Key_Left() {
        return key_left;
    }

    public void set_Key_Up(boolean key) {
        key_up = key;
    }
    public void set_Key_Down(boolean key) {
        key_down = key;
    }
    public void set_Key_Right(boolean key) {
        key_right = key;
    }
    public void set_Key_Left(boolean key) {
        key_left = key;
    }
}
