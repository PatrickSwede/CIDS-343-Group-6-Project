package io.github.CIDS_343_Group_6_Project;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Control extends InputAdapter implements InputProcessor {


    // CAMERA
    OrthographicCamera camera;

    // DIRECTIONS
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    // MOUSE
    private boolean  LMB;
    private boolean  RMB;
    private boolean  processed_click;
    private Vector2  mouse_click_pos = new Vector2();
    private Vector2  map_click_pos = new Vector2();

    // DEBUG
    private boolean debug;

    // SCREEN
    private int screen_width;
    private int screen_height;

    //------------Getter-----------------------------------------------------
    //-----------------------------------------------------------------------
    public boolean getUp (){
        return up;
    }
    public boolean getDown (){
        return down;
    }
    public boolean getLeft (){
        return left;
    }
    public boolean getRight (){
        return right;
    }
    public boolean getLMB (){
        return LMB;
    }
    public boolean getRMB (){
        return RMB;
    }
    public boolean getProcessed_click (){
        return processed_click;
    }
    public Vector2 getmouse_click_pos (){
        return mouse_click_pos;
    }
    public Vector2 getmap_click_pos (){
        return map_click_pos;
    }
    public boolean getDebug (){
        return debug;
    }
    public int getScreen_width (){
        return screen_width;
    }
    public int getScreen_height (){
        return screen_height;
    }
    //------------Setter-----------------------------------------------------
    //-----------------------------------------------------------------------
    public void setUp ( boolean up ){
        this.up = up;
    }
    public void setDown (boolean down){
        this.down = down;
    }
    public void setLeft ( boolean left ){
        this.left = left;
    }
    public void setRight (boolean right){
            this.right = right;
    }
    public void setLMB (boolean LMB){
        this.LMB = LMB;
    }
    public void setRMB (boolean RMB){
        this.RMB = RMB;
    }
    public void setProcessed_click (boolean processed_click){
        this.processed_click = processed_click;
    }
    public void getmouse_click_pos ( Vector2 pos ){
        this.mouse_click_pos = pos;
    }
    public void getmap_click_pos ( Vector2 pos ){
        this.map_click_pos = pos;
    }
    public void setDebug ( boolean debug ){
        this.debug = debug;
    }
    public void setScreen_width ( int screen_width ){
        this.screen_width = screen_width;
    }
    public void setScreen_height ( int screen_height ){
        this.screen_height = screen_height;
    }

    public Control(int screen_width, int screen_height, OrthographicCamera camera){
        this.camera = camera;
        this.screen_width = screen_width;
        this.screen_height = screen_height;
    }

    private void setMouseClickedPos(int screenX, int screenY){
        // Set mouse position (flip screen Y)
        mouse_click_pos.set(screenX, screen_height - screenY);
        map_click_pos.set(get_map_coords(mouse_click_pos));
    }

    public Vector2 get_map_coords(Vector2 mouse_coords){
        Vector3 v3 = new Vector3(mouse_coords.x, screen_height - mouse_coords.y, 0);
        this.camera.unproject(v3);
        return new Vector2(v3.x,v3.y);
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.DOWN: down = true; break;
            case Keys.UP: up = true; break;
            case Keys.LEFT: left = true; break;
            case Keys.RIGHT: right = true; break;
            case Keys.W: up = true; break;
            case Keys.A: left = true; break;
            case Keys.S: down = true; break;
            case Keys.D: right = true; break;
            case Keys.ESCAPE: PauseManager.togglePause(); break; // ADD THIS LINE
            case Keys.BACKSPACE: debug = !debug; break;
        }
        return false;
    }


    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.DOWN:
                down = false;
                break;
            case Keys.UP:
                up = false;
                break;
            case Keys.LEFT:
                left = false;
                break;
            case Keys.RIGHT:
                right = false;
                break;
            case Keys.W:
                up = false;
                break;
            case Keys.A:
                left = false;
                break;
            case Keys.S:
                down = false;
                break;
            case Keys.D:
                right = false;
                break;
            case Keys.ESCAPE:
                Gdx.app.exit();
                break;
            case Keys.BACKSPACE:
                debug = !debug;
                break;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(pointer == 0 && button == 0){
            LMB = true;
        } else if (pointer == 0 && button == 0){
            RMB = true;
        }

        setMouseClickedPos(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(pointer == 0 && button == 0){
            LMB = false;
            processed_click = false;
        } else if (pointer == 0 && button == 0){
            RMB = false;
        }

        setMouseClickedPos(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        setMouseClickedPos(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }



}
/**
Notes on how to use class
-- from tutorial game on lib gdx with this class
-- Integration with this class in the driver for tutorial game
if (keyPress.getRight()) {
    bucketSprite.translateX(speed * delta);
    }
    private void input() {

        float speed = 4f;
        float delta = Gdx.graphics.getDeltaTime();
        //Gdx.input.isKeyPressed(Input.Keys.RIGHT)
        if (keyPress.getRight()) {
            bucketSprite.translateX(speed * delta);

            //Gdx.input.isKeyPressed((Keys.LEFT))
        } else if (keyPress.getLeft()) {
            bucketSprite.translateX((-speed * delta));
        }
        else if (keyPress.getUp()){
            bucketSprite.translateY(speed * delta);
        }
        else if (keyPress.getDown()){
            bucketSprite.translateY((-speed * delta));
        }
        * did not get integrated
        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            viewport.unproject(touchPos);
            bucketSprite.setCenterX(touchPos.x);
        }
    }
 */
