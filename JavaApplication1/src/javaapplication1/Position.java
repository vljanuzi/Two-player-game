package javaapplication1;
public class Position {
	private int position;
        private int limit;

    public Position(int position,int limit) {
		this.position = position;
                this.limit = limit;

    }
		

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        
        if((position+newPosition)<=limit)
        this.position += newPosition;
        else {
            this.position=limit;
        }
    }	

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

}
