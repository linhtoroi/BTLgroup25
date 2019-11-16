import javafx.stage.Stage;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/8/19
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameStage extends Stage {
    private final int height = 500;
    private final int width = 500;
    public GameStage(){
        this.setWidth(width);
        this.setHeight(height);
        this.setTitle("Tower Defense");
    }
}
