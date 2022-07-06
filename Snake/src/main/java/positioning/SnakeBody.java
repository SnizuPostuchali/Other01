package positioning;

import java.util.ArrayList;
import java.util.List;

import static positioning.Parameters.INITIAL_BODY;

public class SnakeBody {

    private int bodyParts = INITIAL_BODY;
    List<Position> body;

    public SnakeBody(){
        this.body = new ArrayList<>();
        initiateSnakeBody();
    }

    public void initiateSnakeBody(){
        for(int i = 0; i<bodyParts; i++){
            this.body.add(new Position(0, 0));
        }
    }

    public int getBodyParts() {
        return bodyParts;
    }

    public void addBodyParts() {
        this.bodyParts++;
        body.add(Position.clone(body.get(body.size()-1)));
    }

    public List<Position> getBody() {
        return body;
    }
}
